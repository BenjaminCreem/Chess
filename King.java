package chess;

public class King extends Piece{
	public King(char t)
	{
		team = t;
		rep = t + "K";
	}
	
	public King(char t, Cell c)
	{
		team = t;
		rep = t + "K";
		file = c.file();
		rank = c.rank();
	}
	
	public boolean validMove(Cell test, Board b)
	{
		//Probably doesn't make sense to check if we are castling every time but its fine for now 
		if(hasMoved || !isPathOccupied(test, b))
		{
			if(test.isOccupied() && test.occupiedBy().team() == team)
			{
				return false;
			}
			else
			{
				//Can only move up down left right and diagonal 1 square at a time
				if(test.rank() > rank + 1 || test.rank() < rank-1 || test.file() > file+1 || test.file() < file-1)
				{
					return false;
				}
				else
				{
					//Check if new position would put the king in check
					Board testBoard = b;
					//Can't use move method here or else we'd be stuck for ever. So manually
					//move the piece on the board and then check if that causes the king to be in check
					//Tell current cell we are no longer there
					testBoard.board()[file-97][rank-1].remove();
					//Make sure this piece knows where it is
					file = test.file();
					rank = test.rank();
					//Make sure the board knows where this piece is
					testBoard.board()[test.file()-97][test.rank()-1].remove();
					testBoard.board()[test.file()-97][test.rank()-1].occupy(this);
					if(checkTest(testBoard))
					{
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	boolean isPathOccupied(Cell test, Board b) {
		//Only time this matter is if we are castling. 
		//Need to check if we've moved and the rook has moved, and if
		//there are any pieces in between. 
		if(!hasMoved)
		{
			if(team == 'W')
			{
				//Castling Kings Side
				if(test.file() == 'G' && test.rank() == 0 && b.board()[7][0].isOccupied() && !b.board()[7][0].occupiedBy().hasMoved())
				{
					if(b.board()[5][0].isOccupied() || b.board()[6][0].isOccupied())
					{
						return true;
					}
				}
				//Castling Queen Side
				else if(test.file() == 'B' && test.rank() == 0 && b.board()[0][0].isOccupied() && !b.board()[0][0].occupiedBy().hasMoved())
				{
					if(b.board()[1][0].isOccupied() || b.board()[2][0].isOccupied() || b.board()[3][0].isOccupied())
					{
						return true;
					}
				}
			}
			else
			{
				//Castling Queen Side
				if(test.file() == 'G' && test.rank() == 7 && b.board()[7][7].isOccupied() && !b.board()[7][7].occupiedBy().hasMoved())
				{
					if(b.board()[7][4].isOccupied() || b.board()[7][5].isOccupied() || b.board()[7][6].isOccupied())
					{
						return true;
					}
				}
				//Castling King Side
				else if(test.file() == 'B' && test.rank() == 7 && b.board()[7][0].isOccupied() && !b.board()[7][0].occupiedBy().hasMoved())
				{
					if(b.board()[7][1].isOccupied() || b.board()[7][2].isOccupied())
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//Lots of optimization to do here. This is n^2 which doesn't matter much 
	//because n^2 is only 64, but could be faster if we had a list of all pieces
	//on the board for each team and only had to look through that instead of the whole board
	public boolean checkTest(Board b)
	{
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(b.board()[i][j].isOccupied() && b.board()[i][j].occupiedBy().team() != team)
				{
					if(b.board()[i][j].occupiedBy().validMove(new Cell(file, rank), b))
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}

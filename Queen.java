package chess;

public class Queen extends Piece{
	public Queen(char t)
	{
		team = t;
		rep = t + "Q";
	}
	
	public Queen(char t, Cell c)
	{
		team = t;
		rep = t + "Q";
		file = c.file();
		rank = c.rank();
	}
	
	public boolean validMove(Cell test, Board b)
	{
		if(test.isOccupied() && !isPathOccupied(test, b))
		{
			//Can't move to a space occupied by your own team
			if(test.occupiedBy().team() == this.team())
			{
				System.out.println("Cannot move to a space occupied by one of your own pieces");
				return false;
			}
			//Forwards and Backwards or Side to Side
			else if(test.rank() == this.rank() || test.file() == this.file())
			{
				return true;
			}
			//Diagonal 
			else if((test.file()+test.rank() == file + rank) || test.file()-test.rank() == file - rank)
			{
				return true;
			}
			else
			{
				System.out.println("Invalid move for this piece");
			}
		}
		else if(!isPathOccupied(test, b))
		{
			//Forwards and Backwards or Side to Side
			if(test.rank() == this.rank() || test.file() == this.file())
			{
				return true;
			}
			//Diagonal 
			else if((test.file()+test.rank() == file + rank) || test.file()-test.rank() == file - rank)
			{
				return true;
			}
			else
			{
				System.out.println("Invalid move for this piece");
			}
		}
		return false;
	}

	
	
	
	
	@Override
	public boolean isPathOccupied(Cell test, Board b) {
		//Case piece is up and to the left
		if(test.file() < file && test.rank() > rank)
		{
			int testRank = test.rank()-1;
			for(int i = test.file()+1; i < file-1; i++)
			{
				if(i >= 97 && b.board()[file-97][testRank-1].isOccupied())
				{
					return true;
				}
				testRank--;
			}
		}
		//Case piece is up and to the right
		else if(test.file() > file && test.rank() > rank)
		{
			int testRank = test.rank()-1;
			for(int i = test.file()-1; i > file; i--)
			{
				if(i <= 104 && b.board()[file-97][testRank-1].isOccupied())
				{
					return true;
				}
				testRank--;
			}		
		}
		//Case piece is down and to the left
		else if(test.file() < file && test.rank() < rank)
		{
			int testRank = test.rank()+1;
			for(int i = test.file()-1; i < file-1; i++)
			{
				if(i >= 97 && b.board()[file-97][testRank-1].isOccupied())
				{
					return true;
				}
				testRank++;
			}
		}
		//Case piece is down and to the right
		else if(test.file() > file && test.rank() < rank)
		{
			int testRank = test.rank()+1;
			for(int i = test.file()-1; i < file-1; i--)
			{
				if(i <= 104 && b.board()[file-97][testRank-1].isOccupied())
				{
					return true;
				}
				testRank++;
			}
		}
		//Starts forward/backward/side to side conditions
		else if(test.rank() > rank)
		{
			for(int i = test.rank(); i > rank; i--)
			{
				if(b.board()[file-97][i-1].isOccupied() && b.board()[file-97][i-1].occupiedBy().team() == team)
				{
					System.out.println("There is another piece blocking the path");
					return true;
				}
			}
		}
		else if(test.rank() < rank)
		{
			for(int i = test.rank(); i < rank; i++)
			{
				if(b.board()[file-97][i-1].isOccupied() && b.board()[file-97][i-1].occupiedBy().team() == team)
				{
					System.out.println("There is another piece blocking the path");
					return true;
				}
			}
		}
		else if(test.file() > file)
		{
			for(int i = test.file(); i > file; i--)
			{
				if(b.board()[i-97][rank-1].isOccupied() && b.board()[i-97][rank-1].occupiedBy().team() == team)
				{
					System.out.println("There is another piece blocking the path");
					return true;
				}
			}
		}
		else if(test.file() < file)
		{
			for(int i = test.file(); i > file; i++)
			{
				if(b.board()[i-97][rank-1].isOccupied() && b.board()[i-97][rank-1].occupiedBy().team() == team)
				{
					System.out.println("There is another piece blocking the path");
					return true;
				}
			}
		}
		else
		{
			System.out.println("Can't move to the space this piece is already in");
			return false;
		}
		return false;
	}
}

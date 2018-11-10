package chess;

public class Rook extends Piece{
	public Rook(char t)
	{
		team = t;
		rep = t + "R";
	}
	public Rook(char t, Cell c)
	{
		team = t;
		rep = t + "R";
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
			//Can only move forward and backwards or side to side
			else if(test.rank() == this.rank() || test.file() == this.file())
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
			//Can only move forward and backwards or side to side
			if(test.rank() == this.rank() || test.file() == this.file())
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
	public boolean isPathOccupied(Cell test, Board b)
	{
		if(test.rank() > rank)
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
				if(b.board()[i-97][rank-1].isOccupied() && b.board()[i-97][rank-1].occupiedBy().team() != team)
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
				if(b.board()[i-97][rank-1].isOccupied() && b.board()[i-97][rank-1].occupiedBy().team() != team)
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

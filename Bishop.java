package chess;

public class Bishop extends Piece{
	public Bishop(char t)
	{
		team = t;
		rep = t + "B";
	}
	
	public Bishop(char t, Cell c)
	{
		team = t;
		rep = t + "B";
		file = c.file();
		rank = c.rank();
	}

	@Override
	public boolean validMove(Cell test, Board b) {
		if(test.isOccupied())
		{
			if(test.occupiedBy().team() == team)
			{
				System.out.println("Cannot move to a space occupied by one of your own pieces");
				return false;
			}
			else if(!isPathOccupied(test, b))
			{
				if(Math.abs(test.file()-test.rank()) == Math.abs(file - rank))
				{
					return true;
				}
			}
		}
		else if(!isPathOccupied(test, b))
		{
			System.out.println("Bishop 1");
			if(Math.abs(test.file()-test.rank()) == Math.abs(file - rank))
			{
				System.out.println("Bishop 2");
				return true;
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
				if(b.board()[file-97][testRank-1].isOccupied())
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
				if(b.board()[file-97][testRank-1].isOccupied())
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
				if(b.board()[file-97][testRank-1].isOccupied())
				{
					return true;
				}
				testRank++;
			}
		}
		else if(test.file() > file && test.rank() < rank)
		{
			int testRank = test.rank()+1;
			for(int i = test.file()-1; i < file-1; i--)
			{
				if(b.board()[file-97][testRank-1].isOccupied())
				{
					return true;
				}
				testRank++;
			}
		}
		
		return false;
	}
}

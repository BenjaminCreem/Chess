

public class Knight extends Piece{
	public Knight(char t)
	{
		team = t;
		rep = t + "N";
	}
	
	public Knight(char t, Cell c)
	{
		team = t;
		rep = t + "N";
		file = c.file();
		rank = c.rank();
	}

	@Override
	public boolean validMove(Cell test, Board b) {
		if(test.isOccupied() && test.occupiedBy().team() == team)
		{
			return false;
		}
		else
		{
			if(test.file() == file-1)
			{
				if(test.rank() == rank+2 || test.rank() == rank-2)
				{
					return true;
				}
			}
			else if(test.file() == file-2)
			{
				if(test.rank() == rank+1 || test.rank() == rank-1)
				{
					return true;
				}
			}
			else if(test.file() == file+1)
			{
				if(test.rank() == rank+2 || test.rank() == rank-2)
				{
					return true;
				}
			}
			else if(test.file() == file+2)
			{
				if(test.rank() == rank+1 || test.rank() == rank-1)
				{
					return true;
				}
			}
		}
		return false;
	}

	@Override
	boolean isPathOccupied(Cell test, Board b) {
		//Knights can just move whenever they want so this doesnt matter
		return false;
	}
}

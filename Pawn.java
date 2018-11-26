

public class Pawn extends Piece{
	public Pawn(char t)
	{
		team = t;
		rep = t + "P";
	}
	
	public Pawn(char t, Cell c)
	{
		team = t;
		rep = t + "P";
		file = c.file();
		rank = c.rank();
	}
	
	//Returns true if test represents a valid move, false otherwise
	public boolean validMove(Cell test, Board b)
	{
		if(test.isOccupied() && !isPathOccupied(test, b))
		{
			if(test.occupiedBy().team() == team)
			{
				return false;
			}
			else
			{
				//Rules for taking a piece if on white team
				if(team == 'W')
				{
					//Must be 1 rank ahead
					if(test.rank() == rank + 1)
					{
						//Must be in a a file that is directly next to this file
						if(test.file() == file - 1 || test.file() == file + 1)
						{
							return true;
						}
					}
				}
				else
				{
					//Must be 1 rank ahead
					if(test.rank() == rank - 1)
					{
						//Must be in a a file that is directly next to this file
						//This check is the same for both. May be easier to change this later 
						//to reduce the number of lines of code that are not needed. 
						if(test.file() == file - 98 || test.file() == file - 96) 
						{
							return true;
						}
					}
				}
			}
		}
		else if(!isPathOccupied(test, b))
		{
			if(test.file() == file)
			{
				if(!hasMoved)
				{
					if(team == 'W' && (test.rank() == rank + 1 || test.rank() == rank + 2))
					{
						return true;
					}
					else if(team == 'B' && (test.rank() == rank - 1 || test.rank() == rank - 2))
					{
						return true;
					}
				}
				else if(team == 'W' && test.rank() == rank + 1)
				{
					return true;
				}
				else if(team == 'B' && test.rank() == rank - 1)
				{
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isPathOccupied(Cell test, Board b) {
		if(team == 'W')
		{
			for(int i = test.rank(); i > rank; i--)
			{
				if(b.board()[file-97][i-1].isOccupied())
				{
					return true;
				}
			}
		}
		else
		{
			for(int i = test.rank(); i < rank; i++)
			{
				if(b.board()[file-97][i-1].isOccupied())
				{
					return true;
				}
			}
		}
		return false;
	}
}

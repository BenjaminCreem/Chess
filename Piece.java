

public abstract class Piece {
	protected char team;
	protected char file;
	protected int rank;
	protected String rep = "";
	protected boolean hasMoved = false;
	
	public char file()
	{
		return file;
	}
	
	public int rank()
	{
		return rank;
	}
	
	public void file(char f)
	{
		file = f;
	}
	
	public void rank(int r)
	{
		rank = r;
	}
	
	public String toString()
	{
		return rep;
	}
	
	public char team()
	{
		return team;
	}
	
	public boolean move(Board b, Cell c)
	{
		if(!validMove(c, b) || c.file() > 'h' || c.file() < 'a' || c.rank() < 0 || c.rank() > 7)
		{
			return false;
		}
		//Tell current cell we are no longer there
		b.board()[file-97][rank-1].remove();
		//Make sure this piece knows where it is
		file = c.file();
		rank = c.rank();
		//Make sure the board knows where this piece is
		b.board()[c.file()-97][c.rank()-1].remove();
		b.board()[c.file()-97][c.rank()-1].occupy(this);
		hasMoved = true;
		return true;
	}
	
	//Ignore everything just move
	public void forceMove(Cell c)
	{
		file = c.file();
		rank = c.rank();
		hasMoved = true;
	}


	
	public boolean hasMoved()
	{
		return hasMoved;
	}
	
	abstract boolean validMove(Cell test, Board b);
	abstract boolean isPathOccupied(Cell test, Board b);

}

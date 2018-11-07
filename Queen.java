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
		return false;
	}

	@Override
	boolean isPathOccupied(Cell test, Board b) {
		// TODO Auto-generated method stub
		return false;
	}
}

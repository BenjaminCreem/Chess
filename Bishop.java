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
	boolean validMove(Cell test, Board b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean isPathOccupied(Cell test, Board b) {
		// TODO Auto-generated method stub
		return false;
	}
}

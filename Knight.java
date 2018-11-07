package chess;

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

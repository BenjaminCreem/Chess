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
		//Things that determine a valid move are as follows:
		//Color, occupied Status, if occupied which team occupies it, Direction, Has moved yet or not (castle)
		return false;
	}

	@Override
	boolean isPathOccupied(Cell test, Board b) {
		// TODO Auto-generated method stub
		return false;
	}
}

package chess;

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
		//Things that determine a valid move are as follows:
		//Color, occupied Status, if occupied which team occupies it, Direction, Has moved yet or not
		
		return false;
	}

	@Override
	boolean isPathOccupied(Cell test, Board b) {
		// TODO Auto-generated method stub
		return false;
	}
}

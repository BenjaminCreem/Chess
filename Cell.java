package chess;

import javax.swing.*;

public class Cell {
	private char file;
	private int rank;
	private int spaceColor;
	private boolean isOccupied;
	private Piece occupiedBy;

	public Cell(char f, int r)
	{
		file = f;
		rank = r;
		if(((int) file / rank) % 2 == 0)
		{
			spaceColor = 0;
		}
		else
		{
			spaceColor = 1;
		}
		occupiedBy = null;
	}
	
	public char file()
	{
		return file;
	}
	
	public int rank()
	{
		return rank;
	}
	
	public boolean isOccupied()
	{
		return isOccupied;
	}
	
	public void occupy(Piece piece)
	{
		isOccupied = true;
		occupiedBy = piece;
	}
	
	public Piece occupiedBy()
	{
		return occupiedBy;
	}

	//Removes whatever piece is currently on top of it
	public void remove() {
		isOccupied = false;
		occupiedBy = null;
	}
}

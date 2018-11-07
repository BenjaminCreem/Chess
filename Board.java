package chess;

public class Board {
	private Cell board[][] = new Cell[8][8];
	
	public Board()
	{
		for(int i = 97; i < 105; i++)
		{
			for(int j = 8; j > 0; j--)
			{
				board[i-97][j-1] = new Cell((char) i, j);
			}
		}
	}
	
	public void populate()
	{
		//White Pieces
		//Pawns
		for(int i = 0; i < 8; i++)
		{
			board[i][1].occupy(new Pawn('W'));
		}
		//Rooks
		board[0][0].occupy(new Rook('W', board[0][0]));
		board[7][0].occupy(new Rook('W', board[7][0]));
		//Knights
		board[1][0].occupy(new Knight('W', board[1][0]));
		board[6][0].occupy(new Knight('W', board[6][0]));
		//Bishops
		board[2][0].occupy(new Bishop('W', board[2][0]));
		board[5][0].occupy(new Bishop('W', board[5][0]));
		//King&Queen
		board[3][0].occupy(new Queen('W', board[3][0]));
		board[4][0].occupy(new King('W', board[4][0]));
		
		//Black Pieces
		for(int i = 0; i < 8; i++)
		{
			board[i][6].occupy(new Pawn('B', board[i][6]));
		}
		//Rooks
		board[7][7].occupy(new Rook('B', board[7][7]));
		board[0][7].occupy(new Rook('B', board[0][7]));
		//Knights
		board[1][7].occupy(new Knight('B', board[1][7]));
		board[6][7].occupy(new Knight('B', board[6][7]));
		//Bishops
		board[2][7].occupy(new Bishop('B', board[2][7]));
		board[5][7].occupy(new Bishop('B', board[5][7]));
		//King&Queen
		board[3][7].occupy(new King('B', board[3][7]));
		board[4][7].occupy(new Queen('B', board[4][7]));
	}
	
	public Cell[][] board()
	{
		return board;
	}
	
	public void print()
	{
		System.out.println("\tA\tB\tC\tD\tE\tF\tG\tH");
		for(int i = 8; i > 0; i--)
		{
			System.out.print(i);
			for(int j = 97; j < 105; j++)
			{
				Cell c = board[j-97][i-1];
				if(c.isOccupied())
				{
					System.out.print("\t" + board[j-97][i-1].occupiedBy());
				}
				else
				{
					System.out.print("\t-");
				}
			}
			System.out.println("\n");
		}
	}
}

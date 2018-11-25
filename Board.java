import java.util.ArrayList;


public class Board {
	private Cell board[][] = new Cell[8][8];
	private ArrayList<Piece> whitePieces = new ArrayList<Piece>();
	private ArrayList<Piece> blackPieces = new ArrayList<Piece>();
	
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

	public ArrayList<Piece> whitePieces()
	{
		return whitePieces;
	}

	public ArrayList<Piece> blackPieces()
	{
		return blackPieces;
	}
	
	public void populate()
	{
		//White Pieces
		//Pawns
		for(int i = 0; i < 8; i++)
		{
			board[i][1].occupy(new Pawn('W', board[i][1]));
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
		//King first to make it the 0th element in the array list
		whitePieces.add(board[4][0].occupiedBy());
		for(int i = 0; i < 8; i++)
		{
			whitePieces.add(board[i][1].occupiedBy());
		}
		for(int i = 0; i < 4; i++)
		{
			whitePieces.add(board[i][0].occupiedBy());
		}
		for(int i = 5; i < 9; i++)
		{
			whitePieces.add(board[i][0].occupiedBy());
		}
		
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

		blackPieces.add(board[4][0].occupiedBy());
		for(int i = 0; i < 8; i++)
		{
			blackPieces.add(board[i][1].occupiedBy());
		}
		for(int i = 0; i < 4; i++)
		{
			blackPieces.add(board[i][0].occupiedBy());
		}
		for(int i = 5; i < 9; i++)
		{
			blackPieces.add(board[i][0].occupiedBy());
		}
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

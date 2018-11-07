package chess;

public class Game{
	public static void main(String[] args)
	{
		Board board = new Board();
		board.populate();
		board.print();
		boolean test = board.board()[0][0].occupiedBy().move(board, board.board()[0][2]);
		System.out.println("\n\n\n");
		board.print();
	}
}

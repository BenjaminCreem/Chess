package chess;

public class Game{
	public static void main(String[] args)
	{
		Board board = new Board();
		board.populate();
		board.print();
		boolean test = board.board()[0][0].occupiedBy().move(board, board.board()[0][2]);
		test = board.board()[1][1].occupiedBy().move(board, board.board()[1][3]);
		test = board.board()[2][6].occupiedBy().move(board, board.board()[2][4]);
		test = board.board()[1][3].occupiedBy().move(board, board.board()[2][4]);
		System.out.println("\n\n\n");
		board.print();
	}
}

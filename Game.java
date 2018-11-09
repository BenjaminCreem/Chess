package chess;

public class Game{
	public static void main(String[] args)
	{
		Board board = new Board();
		board.populate();
		//board.print();
		//boolean test = board.board()[3][1].occupiedBy().move(board, board.board()[3][2]);
		boolean test = board.board()[2][0].occupiedBy().move(board, board.board()[6][4]);
		//board.print();
		//test = board.board()[6][4].occupiedBy().move(board, board.board()[5][5]);
		board.print();
	}
}

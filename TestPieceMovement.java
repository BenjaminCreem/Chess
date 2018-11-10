package chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPieceMovement {

	@Test
	public void test() {
		Board board = new Board();
		board.populate();
		//Test Pawn Forward Movement
		assertTrue(board.board()[0][1].occupiedBy().move(board, board.board()[0][3]));
		assertTrue(board.board()[1][1].occupiedBy().move(board, board.board()[1][2]));
		assertFalse(board.board()[2][1].occupiedBy().move(board, board.board()[2][4]));
		//Test Pawn Backward Movement
		assertFalse(board.board()[0][3].occupiedBy().move(board, board.board()[0][2]));
		//Test pawn side movement
		assertFalse(board.board()[1][2].occupiedBy().move(board, board.board()[2][2]));
		//Test Pawn Capture
		assertTrue(board.board()[1][6].occupiedBy().move(board, board.board()[1][4]));
		assertTrue(board.board()[0][3].occupiedBy().move(board, board.board()[1][4]));
		
		
		//Test Rook Forward Movement
		assertTrue(board.board()[0][0].occupiedBy().move(board, board.board()[0][5]));
		//Test Rook Capture
		assertTrue(board.board()[0][5].occupiedBy().move(board, board.board()[0][6]));
		//Move back to test Rook Side Movement
		assertTrue(board.board()[0][6].occupiedBy().move(board, board.board()[0][5]));
		//Test Rook Side Movement
		assertTrue(board.board()[0][5].occupiedBy().move(board, board.board()[7][5]));
		//Test Rook Diagonal Movement
		assertFalse(board.board()[7][5].occupiedBy().move(board, board.board()[6][4]));
		//Test move to spot occupied by own team
		assertFalse(board.board()[7][5].occupiedBy().move(board, board.board()[7][1]));
		
		//Test Bishop Up Left movement
		//assertTrue(board.board()[2][0].occupiedBy().move(board, board.board()[1][1]));
		
		board.print();
	}

}

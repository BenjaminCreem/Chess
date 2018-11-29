import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
		assertTrue(board.board()[2][0].occupiedBy().move(board, board.board()[1][1]));
		//Test Bishop Down Left movement
		assertTrue(board.board()[1][1].occupiedBy().move(board, board.board()[0][0]));
		//Test Bishop Up Right Movement
		assertTrue(board.board()[0][0].occupiedBy().move(board, board.board()[4][4]));
		//Test Bishop Down Right movement
		assertTrue(board.board()[4][4].occupiedBy().move(board, board.board()[6][2]));
		//Test Bishop Forward movement
		assertFalse(board.board()[6][2].occupiedBy().move(board, board.board()[6][4]));
		//Test Bishop Side movement
		assertFalse(board.board()[6][2].occupiedBy().move(board, board.board()[4][2]));
		//Test Bishop Capture
		assertTrue(board.board()[6][2].occupiedBy().move(board, board.board()[2][6]));
		//Test Bishop Backwards Movement
		assertFalse(board.board()[2][6].occupiedBy().move(board, board.board()[2][2]));
		
		//Test Knight Up 2 Left 1
		assertTrue(board.board()[6][0].occupiedBy().move(board, board.board()[5][2]));
		//Test Knight Up 2 Right 1
		assertTrue(board.board()[5][2].occupiedBy().move(board, board.board()[6][4]));
		//Test Knight Up 1 Left 2
		assertTrue(board.board()[6][4].occupiedBy().move(board, board.board()[4][5]));
		//Test Knight Up 1 Right 2 and capture
		assertTrue(board.board()[4][5].occupiedBy().move(board, board.board()[6][6]));
		//Test Knight Down 1 Left 2
		assertTrue(board.board()[6][6].occupiedBy().move(board, board.board()[4][5]));
		//Test Knight Down 1 Right 2
		assertTrue(board.board()[4][5].occupiedBy().move(board, board.board()[6][4]));
		//Test Knight Down 2 Left 1
		assertTrue(board.board()[6][4].occupiedBy().move(board, board.board()[5][2]));
		//Test Knight Down 2 Right 1 (want knight in H3 which requires 1 extra move)
		assertTrue(board.board()[5][2].occupiedBy().move(board, board.board()[6][4]));
		assertTrue(board.board()[6][4].occupiedBy().move(board, board.board()[7][2]));
		//Test Knight Forward Movement
		assertFalse(board.board()[7][2].occupiedBy().move(board, board.board()[7][3]));
		//Test Knight Diagonal Movement
		assertFalse(board.board()[7][2].occupiedBy().move(board, board.board()[6][3]));
		
		//Test Queen sideways left movement
		assertTrue(board.board()[3][0].occupiedBy().move(board, board.board()[2][0]));
		//Test Queen up left movement
		assertTrue(board.board()[2][0].occupiedBy().move(board, board.board()[1][1]));
		//Test Queen down Left movement
		assertTrue(board.board()[1][1].occupiedBy().move(board, board.board()[0][0]));
		//Test Queen forward movement and capture
		board.print();
		assertTrue(board.board()[0][0].occupiedBy().move(board, board.board()[0][7]));
		//Test Queen backward movement
		assertTrue(board.board()[0][7].occupiedBy().move(board, board.board()[0][5]));
		//Test Queen right movement
		assertTrue(board.board()[0][5].occupiedBy().move(board, board.board()[4][5]));
		//Test Queen down right movement
		assertTrue(board.board()[4][5].occupiedBy().move(board, board.board()[6][3]));
		//Test Queen up right movement
		assertTrue(board.board()[6][3].occupiedBy().move(board, board.board()[7][4]));
		
		//Going to test King movement. Move pawns out of the way first
        assertTrue(board.board()[3][1].occupiedBy().move(board, board.board()[3][3]));
        assertTrue(board.board()[4][1].occupiedBy().move(board, board.board()[4][3]));
        assertTrue(board.board()[5][1].occupiedBy().move(board, board.board()[5][3]));
        //Move Bishop out of the way
        assertTrue(board.board()[5][0].occupiedBy().move(board, board.board()[2][3]));
        //Test King Forward Movement
        assertTrue(board.board()[4][0].occupiedBy().move(board, board.board()[4][1]));
        //Test King Forward Left
        assertTrue(board.board()[4][1].occupiedBy().move(board, board.board()[3][2]));
        //Test King Backwards Right
        assertTrue(board.board()[3][2].occupiedBy().move(board, board.board()[4][1]));
        //Test King Forward Right
        assertTrue(board.board()[4][1].occupiedBy().move(board, board.board()[5][2]));
        //Test King Backwards Left
        assertTrue(board.board()[5][2].occupiedBy().move(board, board.board()[4][1]));
        //Test King Backwards
        assertTrue(board.board()[4][1].occupiedBy().move(board, board.board()[4][0]));
		board.print();
	}

}

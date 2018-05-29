import org.junit.*;
import static org.junit.Assert.*;
public class BoardTesT {

	public BoardTesT(String name){
		super(name);
	}



	@Test()
	public void testGetBoard() {
		Board boardObject = new Board();

		char[][] boardChar = new char[8][7]
		boardChar[0][0] = '1';
		boardChar[1][0] = '3';
		boardChar[3][0] = '1';
		boardChar[4][0] = '3';
		boardChar[6][0] = '1';
		boardChar[7][0] = '3';

		boardChar[0][6] = '3';
		boardChar[1][6] = '1';
		boardChar[3][6] = '3';
		boardChar[4][6] = '1';
		boardChar[6][6] = '3';
		boardChar[7][6] = '1';

		assertEquals(boardObject.getBoard(), board);
	}

	@Test()
	public void testGetSize_X() {
		Board board = new Board();

		assertEquals(board.getSize_X(), 8);
	}

	@Test()
	public void testGetSize_Y() {
		Board board = new Board();

		assertEquals(board.getSize_Y(), 7);
	}

	@Test()
	public void testToString() {

	}

	@Test()
	public void testClone() {
		Board board = new Board();
		Board cloneBoard = board.clone();

		assertEquals(board, cloneBoard);
		assertFalse(board == cloneBoard);
	}


}

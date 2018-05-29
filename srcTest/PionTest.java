import org.junit.*;
import static org.junit.Assert.*;
public class PionTest {

	public PionTest(String name){
		super(name);
	}

	@Test()
	public void testGetValue() {
		Pion pion = new Pion(1,0,0);

		assertEquals(pion.getValue(), 1);
	}

	@Test()
	public void testSetValue() {
		Pion pion = new Pion(1,0,0);
		pion.setValue(2);
		assertEquals(pion.getValue(), 2);
	}

	@Test()
	public void testGetPosX() {
		Pion pion = new Pion(1,2,0);

		assertEquals(pion.getPosX(), 2);
	}

	@Test()
	public void testGetPosY() {
		Pion pion = new Pion(1,0,3);

		assertEquals(pion.getPosY(), 3);
	}

  TODO
	@Test()
	public void testPosPossible() {
		Pion pion = new Pion(2,0,3);
		Pion pion = new Pion(1,0,3)
	}

	@Test()
	public void testChangePos() {
		char[][] board = new char[8][7];
		Pion pion = new Pion(1,0,0);
		pion.changePos(board, 1, 1);

		assertEquals(pion, new Pion(1,1,1));
	}

	@Test()
	public void testGetAMange() {
		Pion pion = new Pion(1,0,0);

		assertNull(pion.getAMange());
	}

	@Test()
	public void testSetAMange() {
		Pion pion = new Pion(1,0,0);
		Pion pionMange = new Pion(2,1,0)
		pion.setAMange(pionMange);

		assertEquals(pion.getAMange(), pionMange);
	}

  @Test()
	public void testGetEstMange() {
		Pion pion = new Pion(1,0,0);
    Pion pionMange = new Pion(2,1,0)
    pion.setAMange(pionMange);

		assertTrue(pionMange.getEstMange());
    assertFalse(pion.getEstMange());
	}

  @Test()
	public void testSetEstMange() {
		Pion pion = new Pion(1,0,0);
    Pion pionMange = new Pion(2,1,0)
    pion.setEstMange(true);

		assertFalse(pionMange.getEstMange());
    assertTrue(pion.getEstMange());
	}

	@Test()
	public void testClone() {
		Pion pion = new Pion();
		Pion clonePion = Pion.clone();

		assertEquals(pion, clonePion);
		assertFalse(pion == clonePion);
	}


}

import org.junit.*;
import static org.junit.Assert.*;

public class HumanPlayerTest {

	public HumanPlayerTest(String name){
		super(name);
	}

  @Test()
	public void testGetNom() {
		HumanPlayer player = new HumanPlayer("Player1",PionColor.BLACK,0);

		assertEquals(player.getNom(), "Player1");
	}

	@Test()
	public void testSetNom() {
		HumanPlayer player = new HumanPlayer("Player2",PionColor.BLACK,0);
		player.setNom("Player1")

		assertEquals(player.getNom(), "Player1");
	}

	@Test()
	public void testGetTeam() {
		HumanPlayer player = new HumanPlayer("Toto",PionColor.BLACK,0);

		assertEquals(player.getTeam(), PionColor.BLACK);
	}

	@Test()
	public void testSetTeam() {
		HumanPlayer player = new HumanPlayer("Toto",PionColor.BLACK,0);
		player.setTeam(PionColor.WHITE;

		assertEquals(player.getTeam(), PionColor.WHITE);
	}

  @Test()
	public void testAddPoint() {
		HumanPlayer player = new HumanPlayer("Toto",PionColor.BLACK,0);
    assertEquals(player.getPoint(),0);
    player.addPoint(12);
		assertEquals(player.getPoint(),12);
	}

	@Test()
	public void testCheckWin() {
		HumanPlayer player = new HumanPlayer("Toto",PionColor.BLACK,0);
		player.addPoint(12);
		assertTrue(player.checkWin());
	}

	@Test()
	public void testClone() {
		HumanPlayer player = new HumanPlayer('joueur 1','1','0');
		HumanPlayer clonePlayer = player.clone();

		assertEquals(player, clonePlayer);
		assertFalse(player == clonePlayer);
	}

}

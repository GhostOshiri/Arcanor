import org.junit.*;
import static org.junit.Assert.*;

public class IAPlayerTest {

	public IAPlayerTest(String name){
		super(name);
	}

  @Test()
	public void testGetNom() {
		IAPlayer player = new IAPlayer("Player1",PionColor.BLACK,0);

		assertEquals(player.getNom(), "Player1");
	}

	@Test()
	public void testSetNom() {
		IAPlayer player = new IAPlayer("Player2",PionColor.BLACK,0);
		player.setNom("Player1")

		assertEquals(player.getNom(), "Player1");
	}

	@Test()
	public void testGetTeam() {
		IAPlayer player = new IAPlayer("Toto",PionColor.BLACK,0);

		assertEquals(player.getTeam(), PionColor.BLACK);
	}

	@Test()
	public void testSetTeam() {
		IAPlayer player = new IAPlayer("Toto",PionColor.BLACK,0);
		player.setTeam(PionColor.WHITE;

		assertEquals(player.getTeam(), PionColor.WHITE);
	}

  @Test()
	public void testAddPoint() {
		IAPlayer player = new IAPlayer("Toto",PionColor.BLACK,0);
    assertEquals(player.getPoint(),0);
    player.addPoint(12);
		assertEquals(player.getPoint(),12);
	}

	@Test()
	public void testCheckWin() {
		IAPlayer player = new IAPlayer("Toto",PionColor.BLACK,0);
		player.addPoint(12);
		assertTrue(player.checkWin());
	}

	@Test()
	public void testClone() {
		IAPlayer player = new IAPlayer('joueur 1','1','0');
		IAPlayer clonePlayer = player.clone();

		assertEquals(player, clonePlayer);
		assertFalse(player == clonePlayer);
	}

}

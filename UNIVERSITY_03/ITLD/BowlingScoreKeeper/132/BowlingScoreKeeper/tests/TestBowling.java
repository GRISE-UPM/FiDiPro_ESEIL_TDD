import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void testiranje_skora() {
		BowlingGame game= new BowlingGame();
		new Frame(5,3);
		assertEquals("Greska pri sabiranju poena", 8, game.score());
	}

}

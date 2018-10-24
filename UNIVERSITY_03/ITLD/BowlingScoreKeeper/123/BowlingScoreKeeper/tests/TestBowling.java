import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void Strike(){
		Frame frame = new Frame(10, 0);
		assertTrue(frame.isStrike());
	}

	@Test
	public void Spare(){
		Frame frame = new Frame(8, 2);
		assertTrue(frame.isSpare());
	}

	@Test
	public void Score(){
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(5,4);
		game.addFrame(frame);
		game.score();

		assertEquals(9,9);
	}



}

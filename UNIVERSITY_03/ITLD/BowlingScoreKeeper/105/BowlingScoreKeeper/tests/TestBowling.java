import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {


	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*
	@Test
	public void test_Spare() {
		Frame frame = new Frame(5,5);
		boolean isSpare = frame.isSpare();

		assertEquals("Incorrect", true, isSpare);

	}

	@Test
	public void test_Strike() {
		Frame frame = new Frame(10,4);
		boolean isStrike = frame.isStrike();

		assertEquals("Incorrect", true, isStrike);
	}

	@Test (expected = BowlingException.class)
	public void test_addFrame() throws BowlingException {
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(1,4);

		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);

		throw new BowlingException("Max size is 10");
	}

	@Test
	public void test_score() {
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(3,2);

		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);




	}

}

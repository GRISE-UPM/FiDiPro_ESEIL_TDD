import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test_firstThrow_secondThrow_isSpare() throws BowlingException {

		Frame frame = new Frame(5,5);

		assertTrue(frame.isSpare());
	}

	@Test
	public void test_firstThrow_secontThrow_notSpare() throws BowlingException {

		Frame frame = new Frame(2,5);
		assertFalse(frame.isSpare());

	}

	@Test
	public void test_firstThrow_isStrike() throws BowlingException {

		Frame frame = new Frame(10,0);
		assertTrue(frame.isStrike());
	}

	@Test
	public void test_firstThrow_isNotStrike() throws BowlingException {

		Frame frame = new Frame(0,10);
		assertFalse(frame.isStrike());
	}

	@Test
	public void test_firstThrow_SecondScore_frameStrake() throws BowlingException {

		Frame frame = new Frame(7,3);
		assertEquals("Incorect score", 10, frame.score());
	}
	@Test
	public void test_nineStrike() throws BowlingException {

		Frame frame = new Frame(10,0);
		Frame frame1 = new Frame(5,4);
		BowlingGame game = new BowlingGame();
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
		assertEquals ("First throw and second throw", 117 , frame);
	}



}

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void testFrame1()  throws BowlingException  {
		Frame fr = new Frame(1, 4);
		int expected = 5;
		assertEquals(expected, fr.score());
	}

	@Test
	public void testFrame2()  throws BowlingException  {
		Frame fr = new Frame(4, 5);
		int expected = 9;
		assertEquals(expected, fr.score());
	}
	@Test
	public void testFrame3()  throws BowlingException  {
		Frame fr = new Frame(5, 5);
		int expected = 10;
		assertEquals(expected, fr.score());
	}

	@Test
	public void testGameFrame1() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1, 4));
		int expected = 5;
		assertEquals(expected, game.score());
	}
	@Test
	public void testGameFrame2() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,4));
		game.addFrame(new Frame(4,5));
		int expected = 14;
		assertEquals(expected, game.score());
	}
	@Test
	public void testGameFrame3() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,4));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(6,4));
		game.addFrame(new Frame(5,5));
		int expected = 29;
		assertEquals(expected, game.score());
	}
	@Test (expected = BowlingException.class)
	public void testFrameException1()  throws BowlingException {
		Frame fr = new Frame(10, 11);
	}
	@Test (expected = BowlingException.class)
	public void testFrameException2()  throws BowlingException {
		Frame fr = new Frame(11, 10);
	}

}

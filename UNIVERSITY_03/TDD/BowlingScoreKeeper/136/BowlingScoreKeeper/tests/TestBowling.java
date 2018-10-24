import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	Frame fr;
	BowlingGame bg;

	@Test
	public void testIfScoreForOneFrameIsLessThan10() throws BowlingException{
		fr = new Frame(2,3);
		assertEquals(5, fr.score());
	}

	@Test(expected=BowlingException.class)
	public void testIfScoreForOneFrameIsMoreThan10() throws BowlingException {
		fr = new Frame(2,14);
		fr.score();
	}

	@Test
	public void testIfFrameIsStrike() {
		fr = new Frame(10,0);
		assertTrue(fr.isStrike());
	}

	@Test
	public void testIfFrameIsNotStrike() {
		fr = new Frame(4,0);
		assertFalse(fr.isStrike());
	}

	@Test
	public void testIfFrameIsSpare() {
		fr = new Frame(2,8);
		assertTrue(fr.isSpare());
	}

	@Test
	public void testIfFrameIsNotSpare() {
		fr = new Frame(2,3);
		assertFalse(fr.isSpare());
	}

	@Test
	public void testIsLessThan10FramesAreAdded() throws BowlingException{
		bg = new BowlingGame();
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		assertEquals(8, bg.getFrames().size());
	}

	@Test
	public void testIf10FramesAreAdded() throws BowlingException {
		bg = new BowlingGame();
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		assertEquals(10, bg.getFrames().size());
	}

	@Test(expected = BowlingException.class)
	public void testIfMoreThan10FramesAreAdded() throws BowlingException {
		bg = new BowlingGame();
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
	}

	@Test
	public void testGameScore() throws BowlingException{
		bg = new BowlingGame();
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		assertEquals(50, bg.score());
	}

	@Test
	public void testScoreWhenLastFrameIsStrike () throws BowlingException{
		bg = new BowlingGame();
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(10,0));
		bg.setBonus(2,3);
		assertEquals(60, bg.score());
	}

	@Test
	public void testScoreWhenLastFrameIsSpare() throws BowlingException{
		bg = new BowlingGame();
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(2,3));
		bg.addFrame(new Frame(5,5));
		bg.setBonus(2,3);
		assertEquals(57, bg.score());
	}
}

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {
	Frame fr;
	BowlingGame bg;

	@Test
	public void testIfScoreIsProperlyReturned() throws BowlingException {
		fr = new Frame(3, 4);
		assertEquals(7, fr.score());
	}

	@Test(expected = BowlingException.class)
	public void testWhenScoreInFrameIsHigherThan10() throws BowlingException {
		fr = new Frame(5, 6);
	}

	@Test
	public void testIfFrameIsSpare() throws BowlingException {
		fr = new Frame(5, 5);
		assertTrue(fr.isSpare());
	}

	@Test
	public void testIfFrameIsStrike() throws BowlingException {
		fr = new Frame(10, 0);
		assertTrue(fr.isStrike());
	}

	@Test
	public void testIfFramesAreAddedCorrectly() throws BowlingException {
		bg = new BowlingGame();
		bg.addFrame(new Frame(5, 3));
		assertEquals(1, bg.getFrames().size());
	}

	@Test(expected = BowlingException.class)
	public void testIfThereAreMoreThan10Frames() throws BowlingException {
		bg = new BowlingGame();
		helperAddAllFrames(bg, 15);
	}

	@Test
	public void testSetBonusThrowsFrameAtTheEndOfTheGame() throws BowlingException {
		bg = new BowlingGame();
		bg.setBonus(2, 4);
		boolean expectedResult = bg.getBonus().getFirstThrow() == 2 && bg.getBonus().getSecondThrow() == 4;
		assertTrue(expectedResult);
	}

	@Test(expected = BowlingException.class)
	public void testWhenBonusScoreIsHigherThan10() throws BowlingException {
		bg = new BowlingGame();
		bg.setBonus(5, 6);
	}

	@Test
	public void testScoreWhenLastFrameIsSpare() throws BowlingException {
		bg = new BowlingGame();

		helperAddAllFramesExact(bg, 9, new Frame(1, 1));
		bg.addFrame(new Frame(5, 5));
		bg.setBonus(3, 3);
		assertEquals(31, bg.score());
	}

	@Test
	public void testScoreWhenLastFrameIsStrike() throws BowlingException {
		bg = new BowlingGame();

		helperAddAllFramesExact(bg, 9, new Frame(1, 1));
		bg.addFrame(new Frame(10, 0));
		bg.setBonus(3, 3);
		assertEquals(34, bg.score());
	}



	public void helperAddAllFrames(BowlingGame bg, int count) throws BowlingException {
		for (int i = 0; i < count; ++i) {
			bg.addFrame(new Frame((int) Math.random() * 5, (int) Math.random() * 5));
		}
	}



	public void helperAddAllFramesExact(BowlingGame bg, int count, Frame fr) throws BowlingException {
		for (int i = 0; i < count; ++i) {
			bg.addFrame(fr);
		}
	}
}

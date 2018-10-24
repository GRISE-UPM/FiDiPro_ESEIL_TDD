import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	BowlingGame game;
	Frame frame;

	@Test
	public void test_addingFrame() throws BowlingException {
		game = new BowlingGame();
		frame = new Frame(0, 0);
		game.addFrame(frame);

		assertEquals(1, game.getFrames().size());
	}

	@Test(expected = BowlingException.class)
	public void test_addingMoreThan10Frames() throws BowlingException {
		game = new BowlingGame();
		frame = new Frame(0, 0);
		game.addFrame(frame);
		Frame frame2 = new Frame(0,0);
		Frame frame3 = new Frame(0,0);
		Frame frame4 = new Frame(0,0);
		Frame frame5 = new Frame(0,0);
		Frame frame6 = new Frame(0,0);
		Frame frame7 = new Frame(0,0);
		Frame frame8 = new Frame(0,0);
		Frame frame9 = new Frame(0,0);
		Frame frame10 = new Frame(0,0);
		Frame frame11 = new Frame(0,0);
		game.addFrame(frame2);
		game.addFrame(frame3);
		game.addFrame(frame4);
		game.addFrame(frame5);
		game.addFrame(frame6);
		game.addFrame(frame7);
		game.addFrame(frame8);
		game.addFrame(frame9);
		game.addFrame(frame10);
		game.addFrame(frame11);
	}

	@Test
	public void test_scoreInOneFrame() throws BowlingException{
		game = new BowlingGame();
		frame = new Frame(3, 4);

		assertEquals(7, frame.score());
	}

	@Test
	public void test_scoreIfStrikeOneFrame() throws BowlingException{
		game = new BowlingGame();
		frame = new Frame(10, 0);

		assertTrue(frame.isStrike());
	}

	@Test
	public void test_scoreIfSpareOneFrame() throws BowlingException{
		game = new BowlingGame();
		frame = new Frame(4, 6);

		assertTrue(frame.isSpare());
	}

	@Test(expected = BowlingException.class)
	public void test_scoreIfStrikeOneFrameException() throws BowlingException{
		game = new BowlingGame();
		frame = new Frame(11, 0);

		assertTrue(frame.isStrike());
	}

	@Test(expected = BowlingException.class)
	public void test_scoreIfSpareOneFrameException() throws BowlingException{
		game = new BowlingGame();
		frame = new Frame(4, 8);

		assertTrue(frame.isSpare());
	}

	@Test(expected = BowlingException.class)
	public void test_ExceptionIfScoreIsGreaterThan10() throws BowlingException{
		game = new BowlingGame();
		frame = new Frame(7, 5);
		frame.score();
	}

	@Test
	public void test_StrikesInOneThrow() throws BowlingException{
		game = new BowlingGame();
		frame = new Frame(10, 0);
		Frame frame2 = new Frame(3, 3);
		game.addFrame(frame);
		game.addFrame(frame2);

		assertEquals(22, game.score());

	}

	@Test
	public void test_SpareInOneThrow() throws BowlingException{
		game = new BowlingGame();
		frame = new Frame(5, 5);
		Frame frame2 = new Frame(3, 3);
		game.addFrame(frame);
		game.addFrame(frame2);

		assertEquals(19, game.score());

	}

	@Test
	public void test_TwoStrikesInRow() throws BowlingException{
		game = new BowlingGame();
		frame = new Frame(10, 0);
		Frame frame1 = new Frame(10, 0);
		Frame frame2 = new Frame(3, 3);

		Frame frame4 = new Frame(3, 3);
		Frame frame5 = new Frame(3, 3);
		Frame frame6 = new Frame(3, 3);
		Frame frame7 = new Frame(3, 3);
		Frame frame8 = new Frame(3, 3);
		Frame frame9 = new Frame(3, 3);*		game.addFrame(frame1);
		game.addFrame(frame);
		game.addFrame(frame2);

		game.addFrame(frame4);
		game.addFrame(frame5);
		game.addFrame(frame6);
		game.addFrame(frame7);
		game.addFrame(frame8);
		game.addFrame(frame9);*
		assertEquals(45, game.score());

	}

	@Test
	public void test_ScoreThreeFrames() throws BowlingException{
		game = new BowlingGame();
		frame = new Frame(5, 0);
		Frame frame1 = new Frame(3, 0);
		Frame frame2 = new Frame(3, 3);
		game.addFrame(frame1);
		game.addFrame(frame);
		game.addFrame(frame2);

		assertEquals(14, game.score());

	}

	@Test
	public void test_strikeIn10thFrame() throws BowlingException {
		game = new BowlingGame();
		frame = new Frame(3, 3);
		Frame frame1 = new Frame(3, 3);
		Frame frame2 = new Frame(3, 3);
		Frame frame3 = new Frame(3, 3);
		Frame frame4 = new Frame(3, 3);
		Frame frame5 = new Frame(3, 3);
		Frame frame6 = new Frame(3, 3);
		Frame frame7 = new Frame(3, 3);
		Frame frame8 = new Frame(3, 3);
		Frame frame9 = new Frame(10, 0);
		game.addFrame(frame1);
		game.addFrame(frame);
		game.addFrame(frame2);
		game.addFrame(frame3);
		game.addFrame(frame4);
		game.addFrame(frame5);
		game.addFrame(frame6);
		game.addFrame(frame7);
		game.addFrame(frame8);
		game.addFrame(frame9);

		game.setBonus(6, 0);

		assertEquals(70, game.score());
	}

	@Test
	public void test_spareIn10thFrame() throws BowlingException {
		game = new BowlingGame();
		frame = new Frame(3, 3);
		Frame frame1 = new Frame(3, 3);
		Frame frame2 = new Frame(3, 3);
		Frame frame3 = new Frame(3, 3);
		Frame frame4 = new Frame(3, 3);
		Frame frame5 = new Frame(3, 3);
		Frame frame6 = new Frame(3, 3);
		Frame frame7 = new Frame(3, 3);
		Frame frame8 = new Frame(3, 3);
		Frame frame9 = new Frame(4, 6);
		game.addFrame(frame1);
		game.addFrame(frame);
		game.addFrame(frame2);
		game.addFrame(frame3);
		game.addFrame(frame4);
		game.addFrame(frame5);
		game.addFrame(frame6);
		game.addFrame(frame7);
		game.addFrame(frame8);
		game.addFrame(frame9);

		game.setBonus(6, 0);

		assertEquals(70, game.score());
	}
	@Test(expected = BowlingException.class)
	public void test_bonusIn10thFrameExceptionFirst() throws BowlingException {
		game = new BowlingGame();
		frame = new Frame(3, 3);
		Frame frame1 = new Frame(3, 3);
		Frame frame2 = new Frame(3, 3);
		Frame frame3 = new Frame(3, 3);
		Frame frame4 = new Frame(3, 3);
		Frame frame5 = new Frame(3, 3);
		Frame frame6 = new Frame(3, 3);
		Frame frame7 = new Frame(3, 3);
		Frame frame8 = new Frame(3, 3);
		Frame frame9 = new Frame(4, 6);
		game.addFrame(frame1);
		game.addFrame(frame);
		game.addFrame(frame2);
		game.addFrame(frame3);
		game.addFrame(frame4);
		game.addFrame(frame5);
		game.addFrame(frame6);
		game.addFrame(frame7);
		game.addFrame(frame8);
		game.addFrame(frame9);

		game.setBonus(11, 0);
	}

	@Test(expected = BowlingException.class)
	public void test_bonusIn10thFrameExceptionSecond() throws BowlingException {
		game = new BowlingGame();
		frame = new Frame(3, 3);
		Frame frame1 = new Frame(3, 3);
		Frame frame2 = new Frame(3, 3);
		Frame frame3 = new Frame(3, 3);
		Frame frame4 = new Frame(3, 3);
		Frame frame5 = new Frame(3, 3);
		Frame frame6 = new Frame(3, 3);
		Frame frame7 = new Frame(3, 3);
		Frame frame8 = new Frame(3, 3);
		Frame frame9 = new Frame(4, 6);
		game.addFrame(frame1);
		game.addFrame(frame);
		game.addFrame(frame2);
		game.addFrame(frame3);
		game.addFrame(frame4);
		game.addFrame(frame5);
		game.addFrame(frame6);
		game.addFrame(frame7);
		game.addFrame(frame8);
		game.addFrame(frame9);

		game.setBonus(0, 12);
	}

}

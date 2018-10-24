import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	BowlingGame bowlingGame;
	@Test
	public void test_InitBowlingGame(){
		bowlingGame = new BowlingGame();
		assertNotNull(bowlingGame);
	}

	@Test
	public void test_frameScore() throws BowlingException{
		Frame frame = new Frame(1, 1);

		assertEquals(2, frame.score());
	}

	@Test
	public void test_frameIsStrike() throws BowlingException{
		Frame frame = new Frame(10, 0);

		assertTrue(frame.isStrike());
	}

	@Test
	public void test_frameIsSpare() throws BowlingException{
		Frame frame = new Frame(5,5);

		assertTrue(frame.isSpare());
	}

	@Test
	public void test_BowlingGameFirstThrow() throws BowlingException{
		bowlingGame = new BowlingGame();

		bowlingGame.addFrame(new Frame(1, 4));

		assertEquals(5, bowlingGame.score());
	}
	@Test
	public void test_BowlingGameThrowSpare() throws BowlingException{
		bowlingGame = new BowlingGame();

		bowlingGame.addFrame(new Frame(6, 4));
		bowlingGame.addFrame(new Frame(4, 3));

		assertEquals(21, bowlingGame.score());
	}

	@Test
	public void test_BowlingGameThrowStrike() throws BowlingException{
		bowlingGame = new BowlingGame();

		bowlingGame.addFrame(new Frame(10, 0));
		bowlingGame.addFrame(new Frame(4, 3));

		assertEquals(24, bowlingGame.score());
	}

	@Test
	public void test_BowlingGameGetScoreWithBonus() throws BowlingException{
		bowlingGame = new BowlingGame();
		bowlingHelper(bowlingGame, 9);
		bowlingGame.addFrame(new Frame(4, 6));
		bowlingGame.setBonus(5, 0);
		assertEquals(33, bowlingGame.score());
	}
	@Test
	public void test_BowlingGameFullSimulation() throws BowlingException{
		bowlingGame = new BowlingGame();
		bowlingSimulationHelper(bowlingGame);
		assertEquals(133, bowlingGame.score());
	}

	public void bowlingSimulationHelper(BowlingGame bowlingGame) throws BowlingException{
		bowlingGame.addFrame(new Frame(1,4));
		bowlingGame.addFrame(new Frame(4,5));
		bowlingGame.addFrame(new Frame(6,4));
		bowlingGame.addFrame(new Frame(5,5));




		bowlingGame.addFrame(new Frame(10,0));
		bowlingGame.addFrame(new Frame(0,1));
		bowlingGame.addFrame(new Frame(7,3));
		bowlingGame.addFrame(new Frame(6,4));
		bowlingGame.addFrame(new Frame(10,0));
		bowlingGame.addFrame(new Frame(2,8));
		bowlingGame.setBonus(6,0);
	}

	public void bowlingHelper(BowlingGame bowlingGame, int repeat) throws BowlingException{
		for (int i = 0; i < repeat; i++){
			bowlingGame.addFrame(new Frame(1, 1));
		}
	}

	@Test
	public void test_bonusFrameNotNull() throws BowlingException{
		bowlingGame = new BowlingGame();

		bowlingHelper(bowlingGame, 9);
		bowlingGame.addFrame(new Frame(5, 5));
		bowlingGame.setBonus(5, 0);

		assertNotNull(bowlingGame.getBonusFrame());
	}

	@Test(expected=BowlingException.class)
	public void test_bowlingGameEndedException() throws BowlingException{
		bowlingGame = new BowlingGame();
		bowlingHelper(bowlingGame, 15);
	}

	@Test(expected=BowlingException.class)
	public void test_bowlingInvalidFrameException() throws BowlingException{
		Frame frame = new Frame(11, 0);
	}

	@Test(expected=BowlingException.class)
	public void test_invalidBonusException() throws BowlingException{
		bowlingGame = new BowlingGame();
		bowlingGame.setBonus(10, 0);
	}

}

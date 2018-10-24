import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {


	@Test
	public void TestIfScoreIsCorrect() {
		Frame frame = new Frame(3,5);
		int actual = frame.score();
		int expected = 8; 			assertEquals(actual, expected);
	}

	@Test
	public void TestIfItIsASpare() {
		Frame frame = new Frame(9,1);
		boolean check = frame.isSpare();
		assertTrue(check);
	}

	@Test
	public void TestIfItIsAStrike() {
		Frame frame = new Frame(10,0);
		boolean check = frame.isStrike();
		assertTrue(check);
	}





	@Test(expected=BowlingException.class)
	public void AddingTheFrameTest() throws BowlingException {
		BowlingGame bowlingGame = new BowlingGame();
		Frame frame = new Frame();	
		addFrames(bowlingGame, frame, 15);
	}

	@Test
	public void TestIfTheScoreIsCalculatedCorrectly() throws BowlingException {
		BowlingGame bowlingGame = new BowlingGame();
		Frame frame = new Frame(0,2);	
		addFrames(bowlingGame, frame, 10);
		int actual = bowlingGame.score();
		int expected = 20; 				assertEquals(actual, expected);
	}

	@Test
	public void TestIfTheFramesScoreIsReturnedProperly() throws BowlingException {
		BowlingGame bowlingGame = new BowlingGame();
		Frame frame = new Frame(0,2);	
		addFrames(bowlingGame, frame, 9);
		Frame frame1 = new Frame (10,0);
		bowlingGame.addFrame(frame1);
		int actual = bowlingGame.getFramesScore(9);
		int expected = 10; 				assertEquals(actual, expected);
	}

	@Test
	public void TestIfTheFrameIsReturnedProperly() throws BowlingException {
		BowlingGame bowlingGame = new BowlingGame();
		Frame frame = new Frame(0,2);	
		addFrames(bowlingGame, frame, 9);
		Frame frame1 = new Frame (5,5);
		bowlingGame.addFrame(frame1);
		Frame testFrame = bowlingGame.getFrame(9);  		int actual = testFrame.score();						int expected = 10;									assertEquals(actual, expected);					}

	@Test
	public void TestIfThereIsABonusThrow_Spare() throws BowlingException {
		BowlingGame bowlingGame = new BowlingGame();
		Frame frame = new Frame(0,2);	
		addFrames(bowlingGame, frame, 9);
		Frame frame1 = new Frame(6,4);
		bowlingGame.addFrame(frame1);
		boolean check = bowlingGame.getFrame(9).isSpare();			assertTrue(check);										}

	@Test
	public void TestIfThereIsABonusThrow_Strike() throws BowlingException {
		BowlingGame bowlingGame = new BowlingGame();
		Frame frame = new Frame(0,2);	
		addFrames(bowlingGame, frame, 9);
		Frame frame1 = new Frame(10, 0);
		bowlingGame.addFrame(frame1);
		boolean check = bowlingGame.getFrame(9).isStrike(); 		assertTrue(check);										}












	public void addFrames(BowlingGame bowlingGame, Frame frame, int count) throws BowlingException
	{
		for (int i=0; i<count; i++)
		{
			bowlingGame.addFrame(frame);
		}
	}
}

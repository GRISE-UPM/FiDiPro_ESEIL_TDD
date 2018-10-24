import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {
	BowlingGame testGame;
	Frame testFrame;
	@Test
	public void testFrameScore() {
		testFrame=new Frame(2,3);
		assertEquals(5,testFrame.score());
	}
	@Test
	public void testStrike() {
		testFrame=new Frame(10,0);
		assertTrue(testFrame.isStrike());

	}
	@Test
	public void testSpare() {
		testFrame=new Frame(5,5);
		assertTrue(testFrame.isSpare());

	}
	@Test
	public void testSpareForStrike() {
		testFrame=new Frame(10,0);
		assertFalse(testFrame.isSpare());

	}
	@Test
	public void testScoreFrameWithBonus() {
		testFrame=new Frame(10,0);
		testFrame.setBonus(2);
		assertEquals(12,testFrame.scoreWithBonus());

	}
	@Test
	public void testAddFrame() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(4,3));

		assertEquals(1,testGame.getFrames().size());

	}
	@Test
	public void testGameScore() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(4,3));

		assertEquals(7,testGame.score());

	}
	@Test
	public void testGameMultipleFrameScore() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));

		assertEquals(14,testGame.score());	
	}
	@Test(expected=BowlingException.class)
	public void testGameAdd11Frame() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));

	}
	@Test
	public void testGameSpare() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(5,5));
		testGame.addFrame(new Frame(4,3));

		assertEquals(21,testGame.scoreWithBonus());	
	}
	@Test
	public void testGameStrike() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(4,3));

		assertEquals(24,testGame.scoreWithBonus());	
	}
	@Test
	public void testGameStrikeMultiple() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(4,3));

		assertEquals(48,testGame.scoreWithBonus());	
	}
	@Test
	public void testGameBonusThrows() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(5,5));
		testGame.setBonus(5, 0);

		assertEquals(105,testGame.scoreWithBonus());	
	}
	@Test(expected=BowlingException.class)
	public void testGameBonusThrowsInWrongTime() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));


		testGame.setBonus(5, 0);


	}
	@Test
	public void testGameBonusThrowsStrike() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(10,0));
		testGame.setBonus(5, 5);

		assertEquals(110,testGame.scoreWithBonus());	
	}
	@Test
	public void testGameBonusThrowsStrikeOn9And10() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.setBonus(5, 5);

		assertEquals(128,testGame.scoreWithBonus());	
	}
	@Test(expected=BowlingException.class)
	public void testGameBonusThrowsSpareSecondThrowNotZero() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(5,5));
		testGame.setBonus(5, 2);		
	}
	@Test(expected=BowlingException.class)
	public void testGameBonusThrowsSpareFirstThrowGreaterThan10() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(5,5));
		testGame.setBonus(11, 0);		
	}
	@Test(expected=BowlingException.class)
	public void testGameFrameThrowsGreaterThan10() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(11,0));

	}
	@Test(expected=BowlingException.class)
	public void testGameFrameThrowsLowerThan0() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(-1,0));

	}
	@Test(expected=BowlingException.class)
	public void testGameBonusThrowsLowerThan0() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(5,5));
		testGame.setBonus(-2, 0);

	}
	@Test(expected=BowlingException.class)
	public void testGameBonusThrowsStrikeException() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(4,3));
		testGame.addFrame(new Frame(10,0));
		testGame.setBonus(11, 11);

	}
	@Test
	public void testGameMaximum() throws BowlingException {
		testGame=new BowlingGame();
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));		testGame.addFrame(new Frame(10,0));
		testGame.addFrame(new Frame(10,0));
		testGame.setBonus(10, 10);
		assertEquals(300,testGame.scoreWithBonus());

	}


}

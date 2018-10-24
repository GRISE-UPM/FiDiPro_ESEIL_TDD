import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test() throws BowlingException{

		Frame fr = new Frame(1,4);
		assertEquals(5,fr.score());	
	}
	@Test 
	public void testSpare() throws BowlingException {
		Frame fr = new Frame(6,4);
		assertEquals(true,fr.isSpare());
	}
	@Test 
	public void testSpare2() throws BowlingException {
		Frame fr = new Frame(6,3);
		assertEquals(false,fr.isSpare());
	}
	@Test 
	public void testStrike() throws BowlingException {
		Frame fr = new Frame(10,0);
		assertEquals(true,fr.isStrike());
	}
	@Test(expected = BowlingException.class)
	public void testFrameIsHigherThan10() throws BowlingException {
		Frame fr = new Frame(5, 6);
	}


	@Test 
	public void testScore() throws BowlingException {
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(5,3));

		assertEquals(8,bg.score());
	}
	@Test
	public void testIAddFrame() throws BowlingException {
		BowlingGame bg = new BowlingGame();
		 bg.addFrame(new Frame(5, 3));
		assertEquals(1, bg.getFrames().size());
	}
	@Test(expected = BowlingException.class)
	public void testFrameover() throws BowlingException {
		BowlingGame bg = new BowlingGame();
		for(int i=0 ; i<11;i++)
		{
			bg.addFrame(new Frame(5, 3));
		}
		assertEquals(11, bg.getFrames().size());
	}





	@Test 
	public void testBonus() throws BowlingException {
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(10,0));



	}









}

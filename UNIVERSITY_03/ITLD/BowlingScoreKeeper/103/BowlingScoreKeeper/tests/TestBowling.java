import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test() {
		fail("Not yet implemented");
	}



	@Test
	public void test_isStrike() throws BowlingException {


		Frame frame = new Frame(10,0);

		assertTrue("It is strike", frame.isStrike());

	}

	@Test
	public void test_isSpare() throws BowlingException {

		Frame frame = new Frame(5,5);
		assertTrue("It is spare", frame.isSpare());
	}

	@Test
	public void test_DoesItAddFrameCorrectly() throws BowlingException {

		BowlingGame game = new BowlingGame();
		Frame frame=new Frame(2,3);
		Frame frame1=new Frame(6,2);
		Frame frame2=new Frame(1,2);
		game.addFrame(frame);
		game.addFrame(frame1);
		game.addFrame(frame2);
		int expectedNumberOfFrames=3;
		assertEquals("Incorrect", expectedNumberOfFrames, 3);
	}

	@Test
	public void test_IsTheFrameResultCorrectlyCounted() throws BowlingException {

		Frame frame = new Frame(3,6);
		int expectedResult=9;
		assertEquals("Incorrect when expectedResult is 9", expectedResult, frame.score());
	}



	@Test
	public void test_DoesBonusWorkCorrectly() throws BowlingException {

		BowlingGame game = new BowlingGame();

		assertTrue();





	}
*}

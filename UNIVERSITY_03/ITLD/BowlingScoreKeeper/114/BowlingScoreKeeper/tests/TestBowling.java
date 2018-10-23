import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test_isStrike() throws BowlingException {
		Frame frame=new Frame(10,4);
		assertTrue(frame.isStrike());
	}

	@Test
	public void test_isSpare() throws BowlingException {
		Frame frame=new Frame(6,4);
		assertTrue(frame.isSpare());
	}

	@Test
	public void test_isNotStrike() throws BowlingException {
		Frame frame=new Frame(9,5);
		assertFalse(frame.isStrike());
	}

	@Test
	public void test_NotSpare() throws BowlingException {
		Frame frame=new Frame(6,5);
		assertFalse(frame.isSpare());
	}

	@Test
	public void test_score() throws BowlingException {
		Frame frame=new Frame(6,5);
		assertEquals(11,frame.score());
	}


	public void test_bonus_isSpare() throws BowlingException {
		BowlingGame g= new BowlingGame();
		Frame frame1=new Frame(1,4);
		Frame frame2=new Frame(4,5);
		Frame frame3=new Frame(6,4);
		Frame frame4=new Frame(5,5);


		g.addFrame(frame1);
		g.addFrame(frame2);
		g.addFrame(frame3);
		g.addFrame(frame4);
		assertEquals();*	}



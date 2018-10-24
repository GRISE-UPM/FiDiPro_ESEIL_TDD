import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestBowling {

	@Test
	public void testFrameScore() throws Exception {

		Frame f = new Frame(3,5);
		assertEquals(f.score(), 8);
	}

	@Test
	public void testFrameScore1() throws Exception {

		Frame f = new Frame(1,1);
		assertEquals(f.score(), 2);
	}

	@Test
	public void testStrike() throws Exception {

		Frame f = new Frame(10,0);
		assertEquals(f.isStrike(), true);

	}

	@Test
	public void testSpare() throws Exception {

		Frame f = new Frame(5,5);
		assertEquals(f.isSpare(), true);

	}

	@Test
	public void testTotalScore1() throws Exception {
		BowlingGame bg = new BowlingGame();
		Frame f1 = new Frame(1,7);
		Frame f2 = new Frame(10,0);
		Frame f3 = new Frame(1,1);
		bg.addFrame(f1);
		bg.addFrame(f2);
		bg.addFrame(f3);
		assertEquals(bg.score(),22);

	}

	@Test
	public void testTotalScoreFinal() throws Exception {
		BowlingGame bg = new BowlingGame();
		Frame f1 = new Frame(1,4);
		Frame f2 = new Frame(4,5);
		Frame f3 = new Frame(6,4);
		Frame f4 = new Frame(5,5);
		Frame f5 = new Frame(10,0);
		Frame f6 = new Frame(0,1);
		Frame f7 = new Frame(7,3);
		Frame f8 = new Frame(6,4);
		bg.addFrame(f1);
		bg.addFrame(f2);
		bg.addFrame(f3);
		bg.addFrame(f4);
		bg.addFrame(f5);
		bg.addFrame(f6);
		bg.addFrame(f7);
		bg.addFrame(f8);
		assertEquals(bg.score(),97);

	}


}

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import jdk.nashorn.internal.ir.ThrowNode;

public class TestBowling {

	BowlingGame bg;
	Frame fr;

	@Test
	public void testingIfStrikeIsWorking() {
		fr = new Frame(10,0);
		assertTrue(fr.isStrike());
	}

	@Test
	public void testingIfSpareIsWorking() {
		fr = new Frame(5,5);
		assertTrue(fr.isSpare());
	}

	@Test
	public void testingIfFrameReturnsScore(){
		fr = new Frame(4,3);
		assertEquals(7, fr.score());
	}

	@Test
	public void testIfAddingFrameIsWorking() throws BowlingException{
		fr = new Frame(4,3);
		bg = new BowlingGame();
		bg.addFrame(fr);
		assertEquals(1, bg.getFrames());
	}

	@Test(expected = BowlingException.class)
	public void testIfAddingMoreThan10FramesThrowsException() throws BowlingException{
		Frame fr1 = new Frame(1,1);
		Frame fr2 = new Frame(1,1);
		Frame fr3 = new Frame(1,1);
		Frame fr4 = new Frame(1,1);
		Frame fr5 = new Frame(1,1);
		Frame fr6 = new Frame(1,1);
		Frame fr7 = new Frame(1,1);
		Frame fr8 = new Frame(1,1);
		Frame fr9 = new Frame(1,1);
		Frame fr10 = new Frame(1,1);
		Frame fr11 = new Frame(1,1);
		bg = new BowlingGame();
		bg.addFrame(fr1);bg.addFrame(fr2);bg.addFrame(fr3);bg.addFrame(fr4);bg.addFrame(fr5);bg.addFrame(fr6);
		bg.addFrame(fr7);bg.addFrame(fr8);bg.addFrame(fr9);bg.addFrame(fr10);bg.addFrame(fr11);
	}

	@Test
	public void testIfBowlingGameReturnsScore() throws BowlingException{
		fr = new Frame(5,4);
		bg = new BowlingGame();
		bg.addFrame(fr);
		assertEquals(9, bg.score());
	}

	@Test
	public void testIfScoreIsReturnedWithBonus() throws BowlingException{
		fr = new Frame(10,0);
		Frame fr1 = new Frame(5,4);
		bg = new BowlingGame();
		bg.addFrame(fr);
		bg.addFrame(fr1);
		assertEquals(28, bg.scoreBonus());
	}

	@Test
	public void testIfBonusIsReturnedWhenSpare() throws BowlingException{
		fr = new Frame(6,4);
		Frame fr1 = new Frame(3,4);
		bg = new BowlingGame();
		bg.addFrame(fr);
		bg.addFrame(fr1);
		assertEquals(20, bg.scoreBonus());
	}

	@Test
	public void testIfLastFrameWhenStrikeGivesThirdThrow() throws BowlingException{
		Frame fr1 = new Frame(1,1);
		Frame fr2 = new Frame(1,1);
		Frame fr3 = new Frame(1,1);
		Frame fr4 = new Frame(1,1);
		Frame fr5 = new Frame(1,1);
		Frame fr6 = new Frame(1,1);
		Frame fr7 = new Frame(1,1);
		Frame fr8 = new Frame(1,1);
		Frame fr9 = new Frame(1,1);
		Frame fr10 = new Frame(10,0,6);
		bg = new BowlingGame();
		bg.addFrame(fr1);bg.addFrame(fr2);bg.addFrame(fr3);bg.addFrame(fr4);bg.addFrame(fr5);bg.addFrame(fr6);
		bg.addFrame(fr7);bg.addFrame(fr8);bg.addFrame(fr9);bg.addFrame(fr10);
		assertEquals(34, bg.scoreBonus());
	}


}

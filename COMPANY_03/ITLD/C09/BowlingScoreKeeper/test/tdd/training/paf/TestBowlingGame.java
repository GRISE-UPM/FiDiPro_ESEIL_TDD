package tdd.training.paf;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TestBowlingGame {

	@Test
	public void testBowlingGameFor10Frames() {
		BowlingGame bowlingGame = new BowlingGame();
		Frame f1 = new Frame(1,4);
		bowlingGame.addFrame(f1);
		Frame f2 = new Frame(4,5);
		bowlingGame.addFrame(f2);
		Frame f3 = new Frame(6,4);
		bowlingGame.addFrame(f3);
		Frame f4 = new Frame(5,5);
	    bowlingGame.addFrame(f4);
		Frame f5 = new Frame(10,0);
	    bowlingGame.addFrame(f5);
		Frame f6 = new Frame(0,1);
	    bowlingGame.addFrame(f6);
		Frame f7 = new Frame(7,3);
	    bowlingGame.addFrame(f7);
		Frame f8 = new Frame(6,4);
	    bowlingGame.addFrame(f8);
		Frame f9 = new Frame(10,0);
	    bowlingGame.addFrame(f9);
		Frame f10 = new Frame(2,8);
	    bowlingGame.addFrame(f10);
		Frame f11 = new Frame(6,0);
	    bowlingGame.addFrame(f11);
		Assert.assertEquals("Score after adding frame-10 is not correct",133,bowlingGame.score());
		bowlingGame.printScores();
	}

}

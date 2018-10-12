package upm.tdd.training.tests;

import static org.junit.Assert.*;

import java.awt.Frame;

import org.junit.Test;

import upm.tdd.training.BowlingGame;
import upm.tdd.training.FrameBowling;

public class TestBowlingScoreKeeper {
	
	FrameBowling frameTest= new FrameBowling();
	BowlingGame gameTest= new BowlingGame();
	
	@Test
	public void testThrowsByFrame() {
			frameTest.setThrowsByFrame(2,4);
			assertTrue(frameTest.getThrowsByFrame());
			frameTest.setThrowsByFrame(0,0);
			assertTrue(frameTest.getThrowsByFrame());
	}
	
	@Test
	public void testScoreByEachFrame(){
			frameTest.setThrowsByFrame(5, 3);
			assertEquals(8,frameTest.scoreByFrame());
			frameTest.setThrowsByFrame(0,10);
			assertEquals(10,frameTest.scoreByFrame());
	}
	
	@Test 
	public void testConstructGame(){
			frameTest.setThrowsByFrame(5, 3);
			gameTest.frames.add(frameTest);
			frameTest.setThrowsByFrame(0, 8);
			gameTest.frames.add(frameTest);
			frameTest.setThrowsByFrame(9, 9);
			gameTest.frames.add(frameTest);
			frameTest.setThrowsByFrame(8, 7);
			gameTest.frames.add(frameTest);
			frameTest.setThrowsByFrame(2, 3);
			gameTest.frames.add(frameTest);
			frameTest.setThrowsByFrame(10, 0);
			gameTest.frames.add(frameTest);
			frameTest.setThrowsByFrame(7, 0);
			gameTest.frames.add(frameTest);
			frameTest.setThrowsByFrame(0, 0);
			gameTest.frames.add(frameTest);
			frameTest.setThrowsByFrame(9, 1);
			gameTest.frames.add(frameTest);
			frameTest.setThrowsByFrame(7, 5);
			gameTest.frames.add(frameTest);
			assertEquals(true, gameTest.getFullFramesByGame());
	}
	
	@Test
	public void testScoreGame(){
		frameTest.setThrowsByFrame(5, 3);
		gameTest.frames.add(frameTest);
		frameTest.setThrowsByFrame(0, 8);
		gameTest.frames.add(frameTest);
		frameTest.setThrowsByFrame(9, 9);
		gameTest.frames.add(frameTest);
		frameTest.setThrowsByFrame(8, 7);
		gameTest.frames.add(frameTest);
		frameTest.setThrowsByFrame(2, 3);
		gameTest.frames.add(frameTest);
		frameTest.setThrowsByFrame(10, 0);
		gameTest.frames.add(frameTest);
		frameTest.setThrowsByFrame(7, 0);
		gameTest.frames.add(frameTest);
		frameTest.setThrowsByFrame(0, 0);
		gameTest.frames.add(frameTest);
		frameTest.setThrowsByFrame(9, 1);
		gameTest.frames.add(frameTest);
		frameTest.setThrowsByFrame(7, 5);
		gameTest.frames.add(frameTest);
		assertEquals(93,gameTest.score());
	
	}
	
}

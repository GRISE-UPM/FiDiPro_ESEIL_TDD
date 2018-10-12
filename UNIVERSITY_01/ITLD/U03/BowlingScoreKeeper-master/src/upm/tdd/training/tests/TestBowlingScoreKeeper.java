package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import upm.tdd.training.BowlingGame;
import upm.tdd.training.Frame;

public class TestBowlingScoreKeeper {

	@Test
	public void testFrameFirtPin() {
		Frame frame = new Frame(2,8);
		assertEquals(2,frame.getFirstPin());
	}
	
	@Test
	public void testFrameSecondPin() {
		Frame frame = new Frame(2,8);
		assertEquals(8,frame.getSecondPin());
	}
	
	@Test
	public void testFrameScore() {
		Frame frame = new Frame(2,8);
		assertEquals(10,frame.score());
	}
	
	@Test
	public void testGameScore() {
		Frame frame1 = new Frame(1,5);
		Frame frame2 = new Frame(3,6);
		Frame frame3 = new Frame(7,2);
		Frame frame4 = new Frame(3,6);
		Frame frame5 = new Frame(4,4);
		Frame frame6 = new Frame(5,3);
		Frame frame7 = new Frame(3,3);
		Frame frame8 = new Frame(4,5);
		Frame frame9 = new Frame(8,1);
		Frame frame10 = new Frame(2,6);
		BowlingGame bowling = new BowlingGame(frame1,frame2, frame3, frame4, frame5,frame6,frame7,frame8,frame9,frame10);
		assertEquals(81,bowling.score());
	}

	@Test
	public void isStrike() {
		Frame frame1 = new Frame(10,0);
		assertEquals(true,frame1.isStrike());
	}
	
	@Test
	public void testGameScoreWithStrike() {
		Frame frame1 = new Frame(10,0);
		Frame frame2 = new Frame(3,6);
		Frame frame3 = new Frame(7,2);
		Frame frame4 = new Frame(3,6);
		Frame frame5 = new Frame(4,4);
		Frame frame6 = new Frame(5,3);
		Frame frame7 = new Frame(3,3);
		Frame frame8 = new Frame(4,5);
		Frame frame9 = new Frame(8,1);
		Frame frame10 = new Frame(2,6);
		BowlingGame bowling = new BowlingGame(frame1,frame2, frame3, frame4, frame5,frame6,frame7,frame8,frame9,frame10);
		assertEquals(94,bowling.score());
	}
	
	@Test
	public void isSpare() {
		Frame frame1 = new Frame(1,9);
		assertEquals(true,frame1.isSpare());
	}
	
	@Test
	public void testGameScoreWithSpare() {
		Frame frame1 = new Frame(1,9);
		Frame frame2 = new Frame(3,6);
		Frame frame3 = new Frame(7,2);
		Frame frame4 = new Frame(3,6);
		Frame frame5 = new Frame(4,4);
		Frame frame6 = new Frame(5,3);
		Frame frame7 = new Frame(3,3);
		Frame frame8 = new Frame(4,5);
		Frame frame9 = new Frame(8,1);
		Frame frame10 = new Frame(2,6);
		BowlingGame bowling = new BowlingGame(frame1,frame2, frame3, frame4, frame5,frame6,frame7,frame8,frame9,frame10);
		assertEquals(88,bowling.score());
	}
	
	@Test
	public void testGameScoreWhenStrikeFollowSpare() {
		Frame frame1 = new Frame(10,0);
		Frame frame2 = new Frame(4,6);
		Frame frame3 = new Frame(7,2);
		Frame frame4 = new Frame(3,6);
		Frame frame5 = new Frame(4,4);
		Frame frame6 = new Frame(5,3);
		Frame frame7 = new Frame(3,3);
		Frame frame8 = new Frame(4,5);
		Frame frame9 = new Frame(8,1);
		Frame frame10 = new Frame(2,6);
		BowlingGame bowling = new BowlingGame(frame1,frame2, frame3, frame4, frame5,frame6,frame7,frame8,frame9,frame10);
		assertEquals(103,bowling.score());
	}
	
	@Test
	public void testGameScoreWhenStrikeFollowStike() {
		Frame frame1 = new Frame(10,0);
		Frame frame2 = new Frame(10,0);
		Frame frame3 = new Frame(7,2);
		Frame frame4 = new Frame(3,6);
		Frame frame5 = new Frame(4,4);
		Frame frame6 = new Frame(5,3);
		Frame frame7 = new Frame(3,3);
		Frame frame8 = new Frame(4,5);
		Frame frame9 = new Frame(8,1);
		Frame frame10 = new Frame(2,6);
		BowlingGame bowling = new BowlingGame(frame1,frame2, frame3, frame4, frame5,frame6,frame7,frame8,frame9,frame10);
		assertEquals(112,bowling.score());
	}
	
	@Test
	public void testGameScoreWhenMultipleSpares() {
		Frame frame1 = new Frame(8,2);
		Frame frame2 = new Frame(5,5);
		Frame frame3 = new Frame(7,2);
		Frame frame4 = new Frame(3,6);
		Frame frame5 = new Frame(4,4);
		Frame frame6 = new Frame(5,3);
		Frame frame7 = new Frame(3,3);
		Frame frame8 = new Frame(4,5);
		Frame frame9 = new Frame(8,1);
		Frame frame10 = new Frame(2,6);
		BowlingGame bowling = new BowlingGame(frame1,frame2, frame3, frame4, frame5,frame6,frame7,frame8,frame9,frame10);
		assertEquals(98,bowling.score());
	}
	
	@Test
	public void testGameScoreWhenSpareAsTheLastFrame() {
		Frame frame1 = new Frame(1,5);
		Frame frame2 = new Frame(3,6);
		Frame frame3 = new Frame(7,2);
		Frame frame4 = new Frame(3,6);
		Frame frame5 = new Frame(4,4);
		Frame frame6 = new Frame(5,3);
		Frame frame7 = new Frame(3,3);
		Frame frame8 = new Frame(4,5);
		Frame frame9 = new Frame(8,1);
		Frame frame10 = new Frame(2,8);
		BowlingGame bowling = new BowlingGame(frame1,frame2, frame3, frame4, frame5,frame6,frame7,frame8,frame9,frame10);
		bowling.setBonus(7, 0);
		assertEquals(90,bowling.score());
	}
	
	@Test
	public void testGameScoreWhenStrikeAsTheLastFrame() {
		Frame frame1 = new Frame(1,5);
		Frame frame2 = new Frame(3,6);
		Frame frame3 = new Frame(7,2);
		Frame frame4 = new Frame(3,6);
		Frame frame5 = new Frame(4,4);
		Frame frame6 = new Frame(5,3);
		Frame frame7 = new Frame(3,3);
		Frame frame8 = new Frame(4,5);
		Frame frame9 = new Frame(8,1);
		Frame frame10 = new Frame(10,0);
		BowlingGame bowling = new BowlingGame(frame1,frame2, frame3, frame4, frame5,frame6,frame7,frame8,frame9,frame10);
		bowling.setBonus(7, 2);
		assertEquals(92,bowling.score());
	}
	
	@Test
	public void testGameScoreWhenSpareAsTheLastFrame1() {
		Frame frame1 = new Frame(1,5);
		Frame frame2 = new Frame(3,6);
		Frame frame3 = new Frame(7,2);
		Frame frame4 = new Frame(3,6);
		Frame frame5 = new Frame(4,4);
		Frame frame6 = new Frame(5,3);
		Frame frame7 = new Frame(3,3);
		Frame frame8 = new Frame(4,5);
		Frame frame9 = new Frame(8,1);
		Frame frame10 = new Frame(2,8);
		BowlingGame bowling = new BowlingGame(frame1,frame2, frame3, frame4, frame5,frame6,frame7,frame8,frame9,frame10);
		bowling.setBonus(10, 0);
		assertEquals(93,bowling.score());
	}
	
	@Test
	public void testPerfectGame() {
		Frame frame1 = new Frame(10,0);
		Frame frame2 = new Frame(10,0);
		Frame frame3 = new Frame(10,0);
		Frame frame4 = new Frame(10,0);
		Frame frame5 = new Frame(10,0);
		Frame frame6 = new Frame(10,0);
		Frame frame7 = new Frame(10,0);
		Frame frame8 = new Frame(10,0);
		Frame frame9 = new Frame(10,0);
		Frame frame10 = new Frame(10,0);
		BowlingGame bowling = new BowlingGame(frame1,frame2, frame3, frame4, frame5,frame6,frame7,frame8,frame9,frame10);
		bowling.setBonus(10, 10);
		assertEquals(300,bowling.score());
	}
	
	@Test
	public void testRealGame() {
		Frame frame1 = new Frame(6,3);
		Frame frame2 = new Frame(7,1);
		Frame frame3 = new Frame(8,2);
		Frame frame4 = new Frame(7,2);
		Frame frame5 = new Frame(10,0);
		Frame frame6 = new Frame(6,2);
		Frame frame7 = new Frame(7,3);
		Frame frame8 = new Frame(10,0);
		Frame frame9 = new Frame(8,0);
		Frame frame10 = new Frame(7,3);
		BowlingGame bowling = new BowlingGame(frame1,frame2, frame3, frame4, frame5,frame6,frame7,frame8,frame9,frame10);
		bowling.setBonus(10, 0);
		assertEquals(135,bowling.score());
	}
}

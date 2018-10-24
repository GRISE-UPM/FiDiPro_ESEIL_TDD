import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void testIfStrike() {

		Frame frame=new Frame(10,0);
		assertTrue(frame.isStrike());

	}

	@Test
	public void testIfSpare() {

		Frame frame=new Frame(2,8);
		assertTrue(frame.isSpare());
	}

	@Test
	public void testScore() {

		Frame frame=new Frame(2,4);
		int x=6;
		assertEquals(x,frame.score());

	}

	@Test
	public void testGame1() {

		BowlingGame game=new BowlingGame();
		Frame frame1=new Frame(2,4);
		game.addFrame(frame1);
		assertEquals(6,game.score());

	}

	@Test
	public void testGame2Spare() {

		BowlingGame game=new BowlingGame();
		Frame frame1=new Frame(6,4);
		game.addFrame(frame1);
		game.setBonus(5, 0);
		assertEquals(15,game.score());

	}

	@Test
	public void testGame3Strike() {

		BowlingGame game=new BowlingGame();
		Frame frame1=new Frame(10,0);
		game.addFrame(frame1);
		game.setBonus(5, 2);
		assertEquals(17,game.score());

	}

	@Test
	public void testGame4() {

		BowlingGame game=new BowlingGame();
		Frame frame1=new Frame(1,5); 		game.addFrame(frame1);
		Frame frame2=new Frame(2,8);			game.addFrame(frame2);
		Frame frame3=new Frame(1,7);			game.addFrame(frame3);	

		assertEquals(25,game.score());

	}

	@Test
	public void testGame5() {

		BowlingGame game=new BowlingGame();
		Frame frame1=new Frame(1,5); 		game.addFrame(frame1);
		Frame frame2=new Frame(10,0);			game.addFrame(frame2);
		Frame frame3=new Frame(1,7);			game.addFrame(frame3);	

		assertEquals(32,game.score());

	}

	@Test
	public void testGame6() {

		BowlingGame game=new BowlingGame();
		Frame frame1=new Frame(1,4); 
		game.addFrame(frame1);
		Frame frame2=new Frame(4,5);	
		game.addFrame(frame2);
		Frame frame3=new Frame(6,4);	
		game.addFrame(frame3);	
		Frame frame4=new Frame(5,5);	
		game.addFrame(frame4);	
		Frame frame5=new Frame(10,0);	
		game.addFrame(frame5);	
		Frame frame6=new Frame(0,1);	
		game.addFrame(frame6);	
		Frame frame7=new Frame(7,3);	
		game.addFrame(frame7);	
		Frame frame8=new Frame(6,4);	
		game.addFrame(frame8);	
		Frame frame9=new Frame(10,0);	
		game.addFrame(frame9);	
		Frame frame10=new Frame(2,8);	
		game.addFrame(frame10);
		game.setBonus(6, 0);
		assertEquals(133,game.score());



	}










}

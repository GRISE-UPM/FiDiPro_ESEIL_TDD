import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test() {

		Frame frame = new Frame();
		assertNotNull(frame);
	}

	@Test
	public void testFrame1(){

		Frame frame = new Frame(2,3);
		assertEquals(5,frame.score());
	}

	@Test
	public void testFrame2(){

		Frame frame = new Frame(10,0);
		assertTrue(frame.isStrike());
	}

	@Test
	public void testFrame3(){

		Frame frame = new Frame(5,5);
		assertTrue(frame.isSpare());
	}

	@Test
	public void testGame(){

		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(5,3);
		game.addFrame(frame);
		assertEquals(8, game.score());
	}

	@Test
	public void testGame1(){

		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(1,4);
		Frame frame1 = new Frame(4,5);
		game.addFrame(frame);
		game.addFrame(frame1);
		assertEquals(14,game.score());
	}

	@Test
	public void testGameStrike(){

		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(10,0);
		Frame frame1 = new Frame(5,4);
		game.addFrame(frame);
		game.addFrame(frame1);
		assertEquals(28, game.score());

	}

	@Test
	public void testGameStrike1(){

		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(10,0);
		Frame frame1 = new Frame(10,0);
		Frame frame2 = new Frame(1,1);
		game.addFrame(frame);
		game.addFrame(frame1); 
		game.addFrame(frame2);
		assertEquals(35, game.score());

	}

	@Test
	public void testGameSpare(){

		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(5,5);
		Frame frame1 = new Frame(2,3);
		game.addFrame(frame);
		game.addFrame(frame1);
		assertEquals(17, game.score());


	}



		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(5,5);
		Frame frame1 = new Frame(5,5);
		Frame frame2 = new Frame(2,2);
		game.addFrame(frame);
		game.addFrame(frame1);
		game.addFrame(frame2);
		assertEquals(31, game.score());

	}*
	@Test(expected=BowlingException.class)
	public void testException() throws BowlingException{

		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(2,5,3);

	}

	@Test
	public void testBonus(){

		BowlingGame game = new BowlingGame();

		for(int i = 0; i<9; i++){

			game.addFrame(new Frame(1,1));

		}

		Frame frame10 = new Frame(10,0);
		game.addFrame(frame10);
		game.setBonus(10,0);
		game.getBonus().setFirstThrow(2);
		game.getBonus().setSecondThrow(2);
		assertEquals(36,game.score());

	}

	@Test
	public void testBonus1(){

		BowlingGame game = new BowlingGame();

		for(int i = 0; i<9; i++){

			game.addFrame(new Frame(1,1));

		}
		Frame frame10 = new Frame(5,5);
		game.addFrame(frame10);
		game.setBonus(5,5);
		game.getBonus().setFirstThrow(2);
		game.getBonus().setSecondThrow(2);
		assertEquals(34, game.score());


	}







}

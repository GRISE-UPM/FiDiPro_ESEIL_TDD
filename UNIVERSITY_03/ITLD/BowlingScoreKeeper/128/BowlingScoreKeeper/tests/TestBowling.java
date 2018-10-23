import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*
	@Test
	public void test_check_isStrike_true(){
		Frame frame = new Frame(10, 0);

		assertTrue(frame.isStrike());
	}

	@Test
	public void test_check_isStrike_false(){
		Frame frame = new Frame(9, 0);

		assertFalse(frame.isStrike());
	}


	@Test
	public void test_check_isSpare_true(){
		Frame frame = new Frame(8, 2);

		assertTrue(frame.isSpare());
	}

	@Test
	public void test_check_isSpare_false(){
		Frame frame = new Frame(8, 3);

		assertFalse(frame.isSpare());

	}
	@Test(expected= BowlingException.class) 
	public void test_add_11_frame_in_list_frames()throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,4));
		game.addFrame(new Frame(2,4));
		game.addFrame(new Frame(3,4));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,4));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,7));
		game.addFrame(new Frame(1,8));
		game.addFrame(new Frame(1,9));
	}

	@Test
	public void test_Frame_One()throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,4));
		int expected = 5;
		assertEquals(expected, game.score());
	}

	@Test
	public void test_Frame_Two()throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,4));
		game.addFrame(new Frame(4,5));
		int expected = 14;
		assertEquals(expected, game.score());
	}

	@Test
	public void test_Frame_Three()throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,4));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(6,4));
		game.addFrame(new Frame(5,5));
		int expected = 29;
		assertEquals(expected, game.score());
	}

	@Test
	public void test_Frame_Fore()throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,4));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(6,4));
		game.addFrame(new Frame(5,5));
		int expected = 29;
		assertEquals(expected, game.score());
	}

	@Test
	public void test_Frame_Six()throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,4));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(6,4));
		game.addFrame(new Frame(5,5));
		game.addFrame(new Frame(0,10));
		game.addFrame(new Frame(0,1));
		int expected = 61;
		assertEquals(expected, game.score());
	}















}

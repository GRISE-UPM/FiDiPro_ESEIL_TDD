import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test_spare_true() throws BowlingException{
		Frame frame = new Frame(6,4);

		boolean result = true;

		assertEquals(result, frame.isSpare());
	}

	@Test
	public void test_spare_false() throws BowlingException{
		Frame frame = new Frame(3,5);

		boolean result = false;

		assertEquals(result, frame.isSpare());
	}

	@Test(expected = BowlingException.class)
	public void test_spare() throws BowlingException{
		Frame frame = new Frame(3,9);

	}

	@Test
	public void test_strike_true() throws BowlingException{
		Frame frame = new Frame(10, 0);

		boolean result = true;

		assertEquals(result, frame.isStrike());
	}

	@Test
	public void test_strike_false() throws BowlingException{
		Frame frame = new Frame(8, 2);

		boolean result = false;

		assertEquals(result, frame.isStrike());
	}

	@Test(expected = BowlingException.class)
	public void test_strike() throws BowlingException{
		Frame frame = new Frame(8, 3);

	}

	@Test
	public void test_score() throws BowlingException{
		Frame frame = new Frame(5, 3);

		int score = 8;

		assertEquals(score, frame.score());
	}

	@Test(expected = BowlingException.class)
	public void test_invalid_frame() throws BowlingException{
		Frame frame = new Frame(5, 6);

	}


	@Test(expected = BowlingException.class)
	public void test_frames() throws BowlingException{
		BowlingGame game = new BowlingGame();

		game.addFrame(new Frame(5,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(5,2));
		game.addFrame(new Frame(5,1));
		game.addFrame(new Frame(3,4));
		game.addFrame(new Frame(2,4));
		game.addFrame(new Frame(1,4));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(0,9));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,3));

	}

	@Test
	public void test_game_score_with_spare() throws BowlingException{
		BowlingGame game = new BowlingGame();

		game.addFrame(new Frame(6, 4));
		game.addFrame(new Frame(5, 2));

		int score = 22;

		assertEquals(score, game.score());


	}

	@Test
	public void test_game_score_with_strike() throws BowlingException{
		BowlingGame game = new BowlingGame();

		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(5, 2));

		int score = 24;

		assertEquals(score, game.score());


	}

	@Test
	public void test_third_frame_if_spare() throws BowlingException{
		BowlingGame game = new BowlingGame();

		game.addFrame(new Frame(10, 0));		game.addFrame(new Frame(5, 2)); 		game.addFrame(new Frame(10, 0));		game.addFrame(new Frame(5, 2));			game.addFrame(new Frame(10, 0));		game.addFrame(new Frame(5, 2)); 		game.addFrame(new Frame(10, 0));		game.addFrame(new Frame(5, 2)); 		game.addFrame(new Frame(5, 3)); 		game.addFrame(new Frame(7, 3)); 		game.addFrame(new Frame(4, 2)); 
		int score = 116;

		assertEquals(score, game.score());
	}

	@Test(expected = BowlingException.class)
	public void test_third_frame_if_not_available() throws BowlingException{
		BowlingGame game = new BowlingGame();

		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(5, 2));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(5, 2));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(5, 2));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(5, 2));
		game.addFrame(new Frame(5, 3));
		game.addFrame(new Frame(7, 2)); 
		game.addFrame(new Frame(4, 2)); 

	}

}

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test(expected=BowlingException.class)
	public void test_of_limits() throws BowlingException{
		BowlingGame game= new BowlingGame();
		game.addFrame(new Frame(0.0));
		game.addFrame(new Frame(0.0));
		game.addFrame(new Frame(0.0));
		game.addFrame(new Frame(0.0));
		game.addFrame(new Frame(0.0));
		game.addFrame(new Frame(0.0));
		game.addFrame(new Frame(0.0));

	}

	@Test
	public void test_if_frame_spare_works() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5,5));
		Frame f = new Frame(10,0);
		assertEquals(true,f.isSpare());
	}

	@Test
	public void test_if_frame_strike_works() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10,0));

		Frame f = new Frame(10,0);
		assertEquals(true,f.isStrike());
	}

	@Test
	public void check_if_frame_score_works() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5,2));
		Frame f = new Frame(10,0);
		assertEquals(true,f.score());
	}

	@Test
	public void check_if_single_frame_score_is_inside_bounds() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5,6));
	}

	@Test
	public void check_if_game_score_works() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,4));
		game.addFrame(new Frame(1,10));
		game.addFrame(new Frame(1,3));
	    String score = Integer.toString(game.score());
	    assertEquals("Rezultat se ne poklapa","20",score);
	}







}

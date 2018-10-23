import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {






	@Test(expected = BowlingException.class)
	public void test_if_frame_out_of_limit() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
	}

	@Test
	public void test_if_frame_spare_works() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5,5));
		String check = Boolean.toString(game.getFrames().get(0).isSpare()) ;
		assertEquals("Greska neocekivani ishod.Ocekivao se spare","true",check);
	}

	@Test
	public void test_if_frame_strike_works() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10,0));
		String check = Boolean.toString(game.getFrames().get(0).isStrike()) ;
		assertEquals("Greska neocekivani ishod.Ocekivao se strike","true",check);
	}

	@Test
	public void check_if_frame_score_works() throws BowlingException{
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5,2));
		String score = Integer.toString(game.getFrames().get(0).score());
		assertEquals("Greska skor frejma se ne poklapa sa ocekivanim","7",score);
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
	    assertEquals("Rezultat igre se ne poklapa sa ocekivanim","20",score);
	}
}

package tdd.training.paf;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBowlingGame {

	private BowlingGame game;

	@Before
	public void setup(){
		game = new BowlingGame();
	}

	@Test
	public void test_game_no_strikes_or_spares() {
		for (int i = 0; i < 10; i++) {
			game.addFrame(new Frame(1,0));
			assertFalse(game.isNextFrameBonus());
			assertEquals(i + 1, game.score());
		}
		assertEquals(10, game.score());
	}

	// Verify bonus frame for last frame
	@Test
	public void test_game_bonus_round(){
		for (int i = 0; i < 9; i++) {
			game.addFrame(new Frame(1,0));
		}
		// 9 points so far
		Frame frame10 = new Frame(10, 0);
		game.addFrame(frame10);
		assertTrue(game.isNextFrameBonus());
		game.setBonus(1,2);
		// 13 points for 10th frame -> 22 total
		assertEquals(22, game.score());
	}

	@Test
	public void test_example_game(){
		game.addFrame(new Frame(1,4));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(6,4)); // spare
		game.addFrame(new Frame(5,5)); // spare
		game.addFrame(new Frame(10,0)); // strike
		game.addFrame(new Frame(0,1));
		game.addFrame(new Frame(7,3)); // spare
		game.addFrame(new Frame(6,4)); // spare
		game.addFrame(new Frame(10,0)); // strike
		game.addFrame(new Frame(2,8)); // spare
		assertTrue(game.isNextFrameBonus());
		game.setBonus(6, 0);
		assertEquals(133, game.score());
	}

	@Test
	public void test_last_frame(){
		// Verify that after 10 frames are added then the last is marked as last frame of the game
		for (int i = 0; i < 9; i++) {
			Frame frame = new Frame(1, 0);
			game.addFrame(frame);
			assertFalse(frame.isLastFrame());
		}
		Frame frame10 = new Frame(1,0);
		game.addFrame(frame10);
		assertTrue(frame10.isLastFrame());

		// adding any more frames should not be possible
		try {
			game.addFrame(new Frame(0,0));
			fail("Expected exception when adding more than 10 frames");
		} catch (IllegalStateException e){

		}
	}

}

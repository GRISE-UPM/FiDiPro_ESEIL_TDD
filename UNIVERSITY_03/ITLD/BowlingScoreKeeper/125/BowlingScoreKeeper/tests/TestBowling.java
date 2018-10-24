import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test_firstframeScored() {
		BowlingGame game = new BowlingGame();

		game.addFrame(new Frame(2, 3));

		boolean gameWon = false;
		if(game.score() == 5)
			gameWon = true;

		System.out.println(game.score());

		assertEquals(true, gameWon);
	}

	@Test
	public void test_secondframeScored() {
		BowlingGame game = new BowlingGame();

		game.addFrame(new Frame(2, 3));
		game.addFrame(new Frame(2, 3));

		boolean gameWon = false;
		if(game.score() == 10)
			gameWon = true;

		System.out.println(game.score());

		assertEquals(true, gameWon);
	}

	@Test
	public void test_Strike() {
		BowlingGame game = new BowlingGame();

		game.addFrame(new Frame(1, 4));
		game.addFrame(new Frame(4, 6));
		game.addFrame(new Frame(4, 2));

		boolean gameWon = false;
		if(game.score() == 24)
			gameWon = true;

		System.out.println(game.score());

		assertEquals(true, gameWon);
	}
}

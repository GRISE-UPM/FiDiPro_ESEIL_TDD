import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test_isFirstThrowStrike() throws BowlingException {
		Frame fr = new Frame(10, 0);
		assertTrue(fr.isStrike());
	}

	@Test
	public void test_isNotFirstThrowStrike() throws BowlingException {
		Frame fr = new Frame(2, 0);
		assertFalse(fr.isStrike());
	}

	@Test
	public void test_isSpare() throws BowlingException {
		Frame fr = new Frame(5, 5);
		assertTrue(fr.isSpare());
	}

	@Test
	public void test_isNotSpare() throws BowlingException {
		Frame fr = new Frame(5, 3);
		assertFalse(fr.isSpare());
	}

	@Test
	public void test_isScore() throws BowlingException {
		Frame fr = new Frame(5, 3);
		assertEquals("Is score: ", 8, fr.score());
	}

	@Test
	public void test_isNotScore() throws BowlingException {
		Frame fr = new Frame(5, 3);
		assertNotEquals("Is not score: ", 9, fr.score());
	}

	@Test
	public void test_First1_Second4Score() throws BowlingException {
		BowlingGame game = new BowlingGame();

		game.score();

		assertEquals(5, game.score());
	}


	@Test
	public void test_First2_Second4Score() throws BowlingException {
		BowlingGame game = new BowlingGame();
		game.score();


		assertEquals(6, game.score());
	}


	@Test
	public void test_First4_Second5Score() throws BowlingException {
		BowlingGame game = new BowlingGame();

		game.score();

		assertEquals(9, game.score());
	}











}

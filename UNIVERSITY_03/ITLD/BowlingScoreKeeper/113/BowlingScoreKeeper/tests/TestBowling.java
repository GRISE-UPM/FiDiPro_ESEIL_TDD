import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void testDoesReturnScore() {
		Frame partija = new Frame(2,7);

		int rez = partija.score();

		assertEquals(9, rez);
	}

	@Test
	public void testIsStrike() {
		Frame partija = new Frame(10, 0);

		int prvoBacanje = partija.getFirstThrow();

		assertEquals(10, prvoBacanje);
	}

	@Test
	public void testIsStrikeB() {
		Frame partija = new Frame(10, 0);

		boolean strike = partija.isStrike();

		assertEquals(true, strike);
	}

	@Test
	public void testIsSpareB() {
		Frame partija = new Frame(7, 3);

		boolean spare = partija.isSpare();

		assertEquals(true, spare);
	}

	@Test
	public void testUkupanRezultat() {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1, 4));
		game.addFrame(new Frame(4, 5));


		game.addFrame(new Frame(5, 5));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(0, 1));
		game.addFrame(new Frame(7, 3));
		game.addFrame(new Frame(6, 4));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(2, 8));*
		int rezultat = game.score();
		assertEquals(14,rezultat);
	}


	@Test
	public void testBonusRezultat() {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1, 4));
		game.addFrame(new Frame(4, 5));


		int bonusRezultat = game.setBonus();
		assertEquals(14,bonusRezultat);
	}*
}

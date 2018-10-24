import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*	@Test
	public void test_strike(){
		boolean provera = true;

		assertEquals("Greska", true, provera);
	}

	@Test
	public void test_spare(){
		boolean provera = true;

		assertEquals("Greska", true, provera);
	}

	@Test
	public void test_score() throws BowlingException{
		Frame fr = new Frame(5, 3);
		int skor = fr.getFirstThrow() + fr.getSecondThrow();

		assertEquals("Greska", 8, skor);
	}

	@Test(expected = BowlingException.class)
	public void test_bowling_exception() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(0,0));
		bg.addFrame(new Frame(0,0));
		bg.addFrame(new Frame(0,0));
		bg.addFrame(new Frame(0,0));
		bg.addFrame(new Frame(0,0));
		bg.addFrame(new Frame(0,0));
		bg.addFrame(new Frame(0,0));
		bg.addFrame(new Frame(0,0));
		bg.addFrame(new Frame(0,0));
		bg.addFrame(new Frame(0,0));
		bg.addFrame(new Frame(0,0));
	}

	@Test
	public void test_score_bowling_game() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(4,0));
		bg.addFrame(new Frame(0,5));
		bg.addFrame(new Frame(3,0));
		int score = bg.score();

		assertEquals("Greska", 9, score);
	}

}

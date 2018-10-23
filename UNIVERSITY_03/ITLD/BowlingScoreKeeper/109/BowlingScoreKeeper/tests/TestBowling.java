import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void testStrike() {
		Frame f = new Frame(10,0);
		assertTrue(f.isStrike());

	}

	@Test
	public void testSpare() {
		Frame f = new Frame(5,5);
		assertTrue(f.isSpare());

	}

	@Test
	public void testScore() {
		Frame f = new Frame(3,5);
		assertEquals(8, f.score());

	}

	@Test
	public void testScoreBonus() {
		Frame f = new Frame(3,5);
		f.addBonus(5);
		assertEquals(13, f.scoreWithBonus());

	}

	@Test
	public void testScoreOnGame() {
		BowlingGame game = new BowlingGame();
		Frame f1 = new Frame(3,5);
		Frame f2 = new Frame(1,2);
		game.addFrame(f1);
		game.addFrame(f2);
		assertEquals(11, game.score());

	}

	@Test
	public void testScoreOnGameWithSpare() {
		BowlingGame game = new BowlingGame();
		Frame f1 = new Frame(5,5);
		Frame f2 = new Frame(2,2);
		game.addFrame(f1);
		game.addFrame(f2);

		assertEquals(16, game.scoreWithBonus());

	}

	@Test
	public void testScoreOnGameWithStrike() {
		BowlingGame game = new BowlingGame();
		Frame f1 = new Frame(10,0);
		Frame f2 = new Frame(1,4);
		game.addFrame(f1);
		game.addFrame(f2);
		assertEquals(20, game.scoreWithBonus());

	}

	@Test(expected=BowlingException.class)
	public void testPokusajDodavanjaBonusaNa2Frejm() throws BowlingException{
		BowlingGame game = new BowlingGame();
		Frame f1 = new Frame(10,0);
		Frame f2 = new Frame(1,4);
		game.addFrame(f1);
		game.addFrame(f2);
		game.setBonus(f2, 5);		
	}

	@Test
	public void testDodavanjeBonusaNa10Frejm() throws BowlingException{
		BowlingGame game = new BowlingGame();
		Frame f1 = new Frame(10,0);
		Frame f2 = new Frame(1,4);
		Frame f3 = new Frame(1,4);
		Frame f4 = new Frame(1,4);
		Frame f5 = new Frame(1,4);
		Frame f6 = new Frame(1,4);
		Frame f7 = new Frame(1,4);
		Frame f8 = new Frame(1,4);
		Frame f9 = new Frame(1,4);
		Frame f10 = new Frame(10,10);

		game.addFrame(f1);
		game.addFrame(f2);
		game.addFrame(f3);
		game.addFrame(f4);
		game.addFrame(f5);
		game.addFrame(f6);
		game.addFrame(f7);
		game.addFrame(f8);
		game.addFrame(f9);
		game.addFrame(f10);
		game.setBonus(f10, 10);	

		assertEquals(30, f10.scoreWithBonus());
	}


	@Test
	public void testPartije() throws BowlingException{
		BowlingGame game = new BowlingGame();
		Frame f1 = new Frame(1,4);
		Frame f2 = new Frame(4,5);
		Frame f3 = new Frame(6,4);
		Frame f4 = new Frame(5,5);
		Frame f5 = new Frame(10,0);
		Frame f6 = new Frame(0,1);
		Frame f7 = new Frame(7,3);
		Frame f8 = new Frame(6,4);
		Frame f9 = new Frame(10,0);
		Frame f10 = new Frame(2,8);

		game.addFrame(f1);
		game.addFrame(f2);
		game.addFrame(f3);
		game.addFrame(f4);
		game.addFrame(f5);
		game.addFrame(f6);
		game.addFrame(f7);
		game.addFrame(f8);
		game.addFrame(f9);
		game.addFrame(f10);
		game.setBonus(f10, 6);	

		assertEquals(133, game.scoreWithBonus());
	}



}

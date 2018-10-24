import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {
	BowlingGame game;
	Frame frame;
	@Test
	public void test_ScoreFrame(){
		frame = new Frame(3,2);
		assertEquals(5, frame.score());

	}
	@Test
	public void test_PartijaBezBonusa() throws BowlingException {
		game = new BowlingGame();
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		assertEquals(50,game.score());
	}
	@Test
	public void test_isStrike(){
		frame = new Frame(10,0);
		assertTrue(frame.isStrike());
	}
	@Test
	public void test_isSpare(){
		frame = new Frame(4,6);
		assertTrue(frame.isSpare());
	}
	@Test
	public void test_isStrike_notSpare(){
		frame = new Frame(10,0);
		assertFalse(frame.isSpare());
	}
	@Test(expected=BowlingException.class)
	public void test_DodajViseOd10Pogodaka() throws BowlingException{
		game = new BowlingGame();
		game.addFrame(new Frame(10,20));
	}
	@Test(expected=BowlingException.class)
	public void test_AkoImaViseOd10Frameova() throws BowlingException{
		game = new BowlingGame();
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));

	}
	@Test(expected=BowlingException.class)
	public void test_SetBonus() throws BowlingException{
		game = new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(3,2));
		game.setBonus(3, 2);
	}
	@Test
	public void test_DodajBonusBacanjeZaStrike() throws BowlingException{
		game = new BowlingGame();
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));
		game.addFrame(new Frame(3,2));


		game.addFrame(new Frame(10,0));
		game.setBonus(3, 0);
		assertEquals(58, game.score());
	}
	@Test(expected=BowlingException.class)
	public void test_DodajBonusPogresno() throws BowlingException {
		game = new BowlingGame();
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(1,1));

		game.addFrame(new Frame(10,0));
		game.setBonus(3,2);
	}
	@Test
	public void test_StrikeBonus() throws BowlingException{
		game = new BowlingGame();
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		assertEquals(40, game.score());
	}
	@Test
	public void test_SpareBonuses() throws BowlingException{
		game = new BowlingGame();
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(6,4));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		assertEquals(38, game.score());
	}
	@Test
	public void test_2StrikeBonuses() throws BowlingException{
		game = new BowlingGame();
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(1,2));
		assertEquals(50, game.score());
	}



}

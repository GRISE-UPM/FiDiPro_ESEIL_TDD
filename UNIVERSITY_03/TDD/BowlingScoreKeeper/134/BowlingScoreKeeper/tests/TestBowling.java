import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void testZaKonstruktor1() {
		Frame f=new Frame(5,2);
		assertEquals(5,f.getFirstThrow());
	}

	@Test
	public void testZaKonstruktor2() {
		Frame f=new Frame(5,2);
		assertEquals(2,f.getSecondThrow());
	}

	@Test
	public void testZaScore() throws BowlingException{
		Frame f=new Frame(5,2);
		int expected=5+2;
		assertEquals(expected,f.score());
	}

	@Test(expected=BowlingException.class)
	public void testZaScoreSaGreskom() throws BowlingException {
		Frame f=new Frame(5,10);
		int expected=5+10;
		assertEquals(expected,f.score());
	}

	@Test
	public void testAkojeSpare() {
		Frame f=new Frame(5,5);
		assertTrue(f.isSpare());
	}

	@Test
	public void testAkoNijeSpare() {
		Frame f=new Frame(3,5);
		assertFalse(f.isSpare());
	}

	@Test
	public void testAkojeStrike() {
		Frame f=new Frame(10,0);
		assertTrue(f.isStrike());
	}

	@Test
	public void testAkoNijeStrike() {
		Frame f=new Frame(5,5);
		assertFalse(f.isStrike());
	}

	@Test(expected=BowlingException.class)
	public void testPrilikomUnosaViseOdDozvoljenogBrojaFramova() throws BowlingException {
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
	}

	@Test
	public void testPrilikomUnosaFramova() throws BowlingException {
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
	}

	@Test
	public void testZaSetovanjeBonusa1() {
		BowlingGame game=new BowlingGame();
		game.setBonus(5, 0);
		assertEquals(5,game.getBonus().getFirstThrow());	
	}

	@Test
	public void testZaSetovanjeBonusa2() {
		BowlingGame game=new BowlingGame();
		game.setBonus(5, 7);
		assertEquals(7,game.getBonus().getSecondThrow());	
	}

	@Test
	public void testZaRacunanjeKrajnjegRezultata() throws BowlingException{
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		int exception=10*2*2;
		assertEquals(exception,game.score());	
	}

	@Test
	public void testZaRacunanjeKrajnjegRezultataAkoSeDesioSpareNaPocetku() throws BowlingException{
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(5,5));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));

		int exception=5+5+2+9*4;
		assertEquals(exception,game.score());	
	}
	@Test
	public void testZaRacunanjeKrajnjegRezultataAkoSeDesioSpareUSredini() throws BowlingException{
		BowlingGame game=new BowlingGame();

		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(5,5));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));

		int exception=4*4+10+2+5*4;
		assertEquals(exception,game.score());	
	}
	@Test
	public void testZaRacunanjeKrajnjegRezultataAkoSeDesioSpareNaKraju() throws BowlingException{
		BowlingGame game=new BowlingGame();

		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(5,5));
		game.setBonus(2, 0);
		int exception=9*4+10+2;
		assertEquals(exception,game.score());	
	}

	@Test
	public void testZaRacunanjeKrajnjegRezultataAkoSeDesioStrikeNaPocetku() throws BowlingException{
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));

		int exception=10+4+9*4;
		assertEquals(exception,game.score());	
	}

	@Test
	public void testZaRacunanjeKrajnjegRezultataAkoSeDesioStrikeUSredini() throws BowlingException{
		BowlingGame game=new BowlingGame();


		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));

		int exception=5*4+10+4+4*4;
		assertEquals(exception,game.score());	
	}
	@Test
	public void testZaRacunanjeKrajnjegRezultataAkoSeDesioStrikeNaKraju() throws BowlingException{
		BowlingGame game=new BowlingGame();

		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(10,0));
		game.setBonus(2, 5);
		int exception=9*4+10+7;
		assertEquals(exception,game.score());	
	}


}

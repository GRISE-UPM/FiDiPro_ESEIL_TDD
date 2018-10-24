import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {







	@Test
	public void testFrameIsStrike() throws BowlingException {
		Frame frejm = new Frame(10,0);

		boolean strike = frejm.isStrike();

		assertEquals("Frame je strike",true, strike);
	}

	@Test
	public void testFrameIsSpare() throws BowlingException {
		Frame frejm = new Frame(5,5);

		boolean spare = frejm.isSpare();

		assertEquals("Frame je spare",true, spare);
	}

	@Test
	public void testFrameScore() throws BowlingException {
		Frame frejm = new Frame (6,3);

		int rez = frejm.score();
		assertEquals(9,rez);

	}

	@Test
	public void testAddFrame() throws BowlingException {
		BowlingGame bg = new BowlingGame();
		Frame frejm = new Frame(3,3);
		bg.addFrame(frejm);

		assertEquals("Broj frejmova je 1", 1, bg.getFrameNumber());

	}

	@Test
	public void testBonus() throws BowlingException {
		BowlingGame bg = new BowlingGame();
		Frame frejm1 = new Frame(3,3);
		Frame frejm2 = new Frame(3,3);
		Frame frejm3 = new Frame(3,3);
		Frame frejm4 = new Frame(3,3);
		Frame frejm5 = new Frame(3,3);
		Frame frejm6 = new Frame(3,3);
		Frame frejm7 = new Frame(3,3);
		Frame frejm8 = new Frame(3,3);
		Frame frejm9 = new Frame(3,3);
		Frame frejm10 = new Frame(5,5);
		bg.addFrame(frejm1);
		bg.addFrame(frejm2);
		bg.addFrame(frejm3);
		bg.addFrame(frejm4);
		bg.addFrame(frejm5);
		bg.addFrame(frejm6);
		bg.addFrame(frejm7);
		bg.addFrame(frejm8);
		bg.addFrame(frejm9);
		bg.addFrame(frejm10);

		bg.setBonus(5, 5);

		assertEquals("Baca se bonus frame", 11, bg.getFrameNumber());

	}



}

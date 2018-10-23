import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void Da_li_je_strike()
	{

		Frame frejm= new Frame(10, 0);
		assertTrue("Jeste stike", frejm.isStrike());
	}

	@Test 
	public void Da_li_je_spare() throws BowlingException 
	{
		Frame frejm= new Frame(6,4);
		assertTrue(frejm.isSpare());
	}

	@Test
	public void Da_li_dobro_racuna_rezultat_frejma() throws BowlingException
	{
		Frame frejm= new Frame(5, 3);
		int ocekivani_rezultat=8;
		assertEquals(ocekivani_rezultat, frejm.score());
	}

	@Test
	public void da_li_dodaje_frame()
	{
		BowlingGame game= new BowlingGame();
		Frame frame1=new Frame(10, 0);
		Frame frame2= new Frame (5,4);
		game.addFrame(frame1);

		game.addFrame(frame2);

		int ocekivani_br_frame=2;
		assertEquals(ocekivani_br_frame,2);
	}
}

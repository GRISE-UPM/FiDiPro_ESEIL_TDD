import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	BowlingException be = new BowlingException();

	public void test() {
		fail("Not yet implemented");
	}*
	@Test
	public void test_prvi_Spare(){
		Frame f = new Frame(6,4);
		assertTrue(f.isSpare());
	}

	@Test 
	public void test_drugi_Strike(){
		Frame f = new Frame(10,0);
		assertTrue(f.isStrike());
	}



	public void test_treci_score_bez_bonusa(){
		Frame f = new Frame(4,3);
		int ocekivano = 7;
		assertEquals(ocekivano, f.score());
	}*
	@Test
	public void test_cetvrti_score_sa_bonusom_Spare(){
		Frame f = new Frame(6,4);
		assertEquals(14, f.score());
	}


	public void test_pet_score_sa_bonusom_Strike(){
		Frame f = new Frame(10,0);
		assertEquals(expected, actual);
	}*

	public void test_sesti_greskaUunosBacanja(){
		Frame f = new Frame(10,12);
		assertEquals("Greska", "Greska");
	}*
	@Test
	public void test_sedam_score_za_2_frame(){
		BowlingGame bg = new BowlingGame();
		Frame f1 = new Frame(1,4);
		Frame f2 = new Frame(4,5);
		bg.addFrame(f1);
		bg.addFrame(f2);
		assertEquals(14, f1.score()+f2.score());
	}

	@Test 
	public void test_osam_score_za_5_frame(){
		BowlingGame bg = new BowlingGame();
		Frame f1 = new Frame(1,4);
		Frame f2 = new Frame(4,5);
		Frame f3 = new Frame(2,3);
		Frame f4= new Frame(1,1);
		Frame f5 = new Frame(6,4);
		bg.addFrame(f1);
		bg.addFrame(f2);
		bg.addFrame(f3);
		bg.addFrame(f4);
		bg.addFrame(f5);
		int x = f1.score()+f2.score()+f3.score()+f4.score()+f5.score();
		assertEquals(35, x);
	}

	@Test
	public void test_devet_score_za_4_frame_sa_Strike(){
		BowlingGame bg = new BowlingGame();
		Frame f1 = new Frame(1,4);
		Frame f2 = new Frame(4,5);
		Frame f3 = new Frame(10,0);
		Frame f4 = new Frame(1,3);

		bg.addFrame(f1);
		bg.addFrame(f2);
		bg.addFrame(f3);
		bg.addFrame(f4);

		int x = f1.score()+f2.score()+f3.score()+f4.score();
		assertEquals(32, x);
	}

	@Test
	public void test_igra(){
		BowlingGame bg = new BowlingGame();
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

		bg.addFrame(f1);
		bg.addFrame(f2);
		bg.addFrame(f3);
		bg.addFrame(f4);
		bg.addFrame(f5);
		bg.addFrame(f6);
		bg.addFrame(f7);
		bg.addFrame(f8);
		bg.addFrame(f9);
		bg.addFrame(f10);

		assertEquals(133, bg.score());


	}


}

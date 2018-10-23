import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {


	public void test() {
		fail("Not yet implemented");
	}*
	@Test
	public void test_Frame_Score(){
		Frame f = new Frame(3, 4);

		assertEquals("Greska ako nije dobijen ocekivan zbir", 7, f.score());
	}

	@Test
	public void test_isStrike_true(){
		Frame f = new Frame(10, 0);

		assertEquals("Greska ako nije dobijen ispravan izlaz", true, f.isStrike());
	}

	@Test
	public void test_isStrike_false(){
		Frame f = new Frame(2, 3);

		assertEquals("Greska ako nije dobijen ispravan izlaz", false, f.isStrike());
	}

	@Test
	public void test_isSpare_true(){
		Frame f = new Frame(2, 8);

		assertEquals("Greska ako nije dobijen ispravan izlaz", true, f.isSpare());
	}

	@Test
	public void test_isSpare_false(){
		Frame f = new Frame(2, 5);

		assertEquals("Greska ako nije dobijen ispravan izlaz", false, f.isSpare());
	}

	@Test (expected = BowlingException.class)
	public void test_Add_Frame() throws BowlingException{
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
	public void test_Game_Score() throws BowlingException{
		BowlingGame bg = new BowlingGame();
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(10,0));
		bg.addFrame(new Frame(5,5));
		bg.addFrame(new Frame(5,5));
		bg.addFrame(new Frame(2,2));

		assertEquals("Greska ako nije dobijen ocekivani rezultat", 76, bg.score());
	}

}

import static org.junit.Assert.*;

import org.junit.Test;


public class TestBowling {

	@Test
	public void testIsStrike() {
		Frame f=new Frame(10,0);
		assertTrue(f.isStrike());
	}

	@Test
	public void testIsSpare(){
		Frame f=new Frame(6,4);
		assertTrue(f.isSpare());
	}

	@Test
	public void testFirstFrame(){
		Frame f=new Frame(1,4);
		int s=f.score();
		assertEquals("Ocekivani rezultat",5,s);

	}

	@Test
	public void testSecondFrame(){
		Frame f=new Frame(4,5);
		int s=f.score();
		assertEquals("Ocekivani rezultat",9,s);
	}

	@Test
	public void testFrameIsStrike(){
		Frame f=new Frame(2,8);
		assertTrue(f.isSpare());
	}

	@Test
	public void testGame() throws BowlingException{
		BowlingGame b=new BowlingGame();
		Frame f=new Frame(1,4);
		b.addFrame(f);
		Frame f1=new Frame(4,5);
		b.addFrame(f1);
		Frame f2=new Frame(6,4);
		b.addFrame(f2);
		Frame f3=new Frame(5,5);
		b.addFrame(f3);
		Frame f4=new Frame(10,0);
		b.addFrame(f4);
		Frame f5=new Frame(0,1);
		b.addFrame(f5);
		Frame f6=new Frame(7,0);
		b.addFrame(f6);
		Frame f7=new Frame(6,0);
		b.addFrame(f7);
		Frame f8=new Frame(10,0);
		b.addFrame(f8);
		Frame f9=new Frame(2,6);
		b.addFrame(f9);

		int s=b.score();

		assertEquals(133,s);
	}


	@Test(expected=BowlingException.class)
	public void testException() throws BowlingException{
		BowlingGame b=new BowlingGame();
		Frame f=new Frame(1,1);
		b.addFrame(f);
		b.addFrame(f);
		b.addFrame(f);
		b.addFrame(f);
		b.addFrame(f);
		b.addFrame(f);
		b.addFrame(f);
		b.addFrame(f);
		b.addFrame(f);
		b.addFrame(f);
		b.addFrame(f);
		b.addFrame(f);

	}
}

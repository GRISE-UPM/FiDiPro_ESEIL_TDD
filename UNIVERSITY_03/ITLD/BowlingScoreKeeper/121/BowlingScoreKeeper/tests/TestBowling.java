import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void testToCheckScore() {
		Frame f = new Frame(1,4);
		assertEquals(5, f.score());
	}

	@Test
	public void testToCheckIfStrike(){
		Frame f = new Frame(10,0);
		assertTrue(f.isStrike());
	}

	@Test
	public void testToCheckIfSpare(){
		Frame f = new Frame(5,5);
		assertTrue(f.isSpare());
	}


	public void testToChexkException(){
		Frame f = new Frame(10,0);

	}*
	@Test
	public void testForThirdFrame() throws BowlingException{
		Frame f0 = new Frame(6,4);
		Frame f1 = new Frame(5,5);
		assertTrue(f0.isSpare());
	}
	 @Test
	 public void testForWholeGame(){
		 Frame f0 = new Frame(1,4);
		 Frame f1 = new Frame(4,5);
		 Frame f2 = new Frame(6,4);
		 Frame f3 = new Frame(5,5);
		 Frame f4 = new Frame(10,0);



	 }
}

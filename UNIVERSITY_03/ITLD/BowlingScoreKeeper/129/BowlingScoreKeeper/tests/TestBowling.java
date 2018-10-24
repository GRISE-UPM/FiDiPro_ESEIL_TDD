import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {


	public void test() {
		fail("Not yet implemented");
	}*	@Test
	public void testScore(){
		Frame frame = new Frame(5,4);
		assertEquals(9, frame.score());
	}
	@Test
	public void testIsStrike(){
		Frame frame = new Frame(10,1);
		assertTrue(frame.isStrike());
	}
	@Test
	public void testIsSpare(){
		Frame frame = new Frame (5,5);
		assertTrue(frame.isSpare());
	}


	public void testSetBonus(){
		Frame frame = new Frame (5,5);
		Frame frame1 = new Frame (1,5);
		addFrame(frame);
		addFrame(frame1)
		assertEquals(17, )
	}*}

package tdd.training.paf;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFrame {
	Frame m_Frame;
	
	@Before
	public void setup()
	{
		m_Frame = new Frame(0, 0);
	}
	
	@After
	public void tearDown()
	{
		m_Frame = null;
	}
	
	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testScore0() {
		assertEquals(m_Frame.score(), 0);
	}
	
	@Test
	public void testScore1() {
		Frame frame = new Frame(1,0);
		assertEquals(frame.score(), 1);
	}
	
	@Test
	public void testScore2() {
		Frame frame = new Frame(1,1);
		assertEquals(frame.score(), 2);
	}
	
	@Test
	public void testSpare() {
		Frame frame = new Frame(3,7);
		assertEquals(frame.isSpare(), true);
	}
	
	@Test
	public void testNotSpare() {
		Frame frame = new Frame(3,3);
		assertEquals(frame.isSpare(), false);
	}
	
	@Test
	public void testIsStrike() {
		Frame frame = new Frame(10,0);
		assertEquals(frame.isStrike(), true);
	}

	@Test
	public void testIsLastFrame() {
		fail("Not yet implemented");
	}
	
}

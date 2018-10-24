import static org.junit.Assert.*;

import org.junit.Test;

public class TestUtil {

	@Test
	public void test_cycleDirectionToLeft(){
		assertEquals("W", Util.cycleDirectionLeft("N"));
	}

	@Test
	public void test_cycleDirectionToRight(){
		assertEquals("E", Util.cycleDirectionRight("N"));
	}

	@Test
	public void test_countOfMovement(){
		assertEquals(4,Util.countNumOfMovement("llrr", "llrrf"));
	}

	@Test
	public void test_positionOutput() {
		assertEquals("(1,2)",Util.formatPosition(1, 2));
	}

	@Test
	public void test_positionOutputWithDir() {
		assertEquals("(1,2,E)",Util.formatPositionWithDir(1, 2,"E"));
	}

	@Test
	public void test_isInteger() {
		assertTrue(Util.isInteger("2"));
	}
}

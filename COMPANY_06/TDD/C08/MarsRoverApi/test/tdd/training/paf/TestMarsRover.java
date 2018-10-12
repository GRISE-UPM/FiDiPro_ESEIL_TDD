package tdd.training.paf;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMarsRover {

	@Test
	public void testMR2() throws Exception {
		String str = MarsRover.executeCommand("ffrf", 2, 2, "");
		assertEquals("(1,2,E)", str);
	}

	@Test
	public void testMR2withObstacles() throws Exception {
		String str = MarsRover.executeCommand("ffrf", 2, 2, "(0,2)");
		assertEquals("(1,1,E)(0,2)", str);
	}

	@Test
	public void testMR3() throws Exception {
		String str = MarsRover.executeCommand("brfblfb", 3, 3, "");
		assertEquals("(0,3,N)", str);
	}

	@Test
	public void testMR3withObstacles() throws Exception {
		String str = MarsRover.executeCommand("brfblfb", 3, 3, "(0,2),(2,3)");
		assertEquals("(0,3,N)(0,2),(2,3)", str);
	}

	@Test
	public void testMR3withObstacles2() throws Exception {
		String str = MarsRover.executeCommand("ffrffrl", 3, 3, "(0,2),(2,3)");
		assertEquals("(2,1,E)(0,2),(2,3)", str);
	}

	@Test
	public void testMR5() throws Exception {
		String str = MarsRover.executeCommand("ffflffrbffrl", 5, 5, "");
		assertEquals("(4,4,N)", str);
	}

	@Test
	public void testMR5withObstacles() throws Exception {
		String str = MarsRover.executeCommand("ffflffrbffrl", 5, 5, "(0,3),(4,2)");
		assertEquals("(5,3,N)(0,3),(4,2)", str);
	}
}

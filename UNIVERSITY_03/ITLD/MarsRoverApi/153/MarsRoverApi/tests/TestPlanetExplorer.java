import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommand() {
		fail("Not yet implemented");
	}

	@Test
	public void testMovingForth() throws PlanetExplorerException
	{
		Explorer exp = new Explorer(4, 4, "");		
		exp.moveForth();
		assertEquals(1, exp.getY());
	}

	@Test
	public void testMovingBack() throws PlanetExplorerException
	{
		Explorer exp = new Explorer(4, 4, "");
		exp.moveBack();
		assertEquals(4, exp.getY());
	}

	@Test
	public void testTurnRight() throws PlanetExplorerException
	{
		Explorer exp = new Explorer();
		exp.turnRight();
		assertEquals("E", exp.getDirection());
	}

	@Test
	public void testTurnLeft() throws PlanetExplorerException
	{
		Explorer exp = new Explorer();
		exp.turnLeft();
		assertEquals("W", exp.getDirection());
	}
}

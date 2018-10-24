import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void TestPlanetExplorerMovingForth() {
		PlanetExplorer pe = new PlanetExplorer(0, 0, "(2,2)");
		String expected ="(0,1,N)";
		assertEquals(expected, pe.executeCommand("f"));
	}

	@Test 
	public void TestPlanetExplorerMovingBackwards()
	{
		PlanetExplorer pe = new PlanetExplorer(1, 1, "(2,2)");
		String expected = "(1,0,N)";
		assertEquals(expected, pe.executeCommand("b"));
	}

	@Test 
	public void TestPlanetExplorerMovingRight()
	{
		PlanetExplorer pe = new PlanetExplorer(0, 0, "(2,2)");
		String expected = "(0,0,E)";
		assertEquals(expected, pe.executeCommand("r"));
	}

	@Test 
	public void TestPlanetExplorerMovingLeft()
	{
		PlanetExplorer pe = new PlanetExplorer(0, 0, "(2,2)");
		String expected = "(0,0,W)";
		assertEquals(expected, pe.executeCommand("l"));
	}

	@Test
	public void TestPlanetExplorerMultipleCommands()
	{
		PlanetExplorer pe = new PlanetExplorer(0, 0, "(2,2)");
		String expected = "(1,2,E)";
		assertEquals(expected, pe.executeCommand("ffrf"));
	}

	@Test
	public void TestPlanetExplorerFacingObstacle()
	{
		PlanetExplorer pe = new PlanetExplorer(0, 0, "(0,1)");
		String expected = "(0,0,N)";
		assertEquals(expected, pe.executeCommand("f"));
	}


}

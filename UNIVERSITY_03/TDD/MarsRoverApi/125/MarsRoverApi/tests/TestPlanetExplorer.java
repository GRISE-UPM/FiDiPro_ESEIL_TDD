import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommand() {
		PlanetExplorer exp = new PlanetExplorer(3, 3);

		assertEquals("(1,2,E)", exp.executeCommand("ffrf"));
	}

	@Test
	public void test_roverForward() {
		PlanetExplorer exp = new PlanetExplorer(3, 3);

		assertEquals("(0,1,N)", exp.executeCommand("f"));
	}

	@Test
	public void test_roverBack() {
		PlanetExplorer exp = new PlanetExplorer(3, 3);

		assertEquals("(0,3,N)", exp.executeCommand("b"));
	}

	@Test
	public void test_roverTurnLeft() {
		PlanetExplorer exp = new PlanetExplorer(3, 3);

		assertEquals("(0,0,W)", exp.executeCommand("l"));
	}

	@Test
	public void test_roverTurnRight() {
		PlanetExplorer exp = new PlanetExplorer(3, 3);

		assertEquals("(0,0,E)", exp.executeCommand("r"));
	}

	@Test
	public void test_roverCheckObstacle() {
		PlanetExplorer exp = new PlanetExplorer(0, 0, "(0,1):(1,1)");

		assertEquals("(1,0)", exp.executeCommand("frf"));
	}

	@Test
	public void test_checkBorder() {
		PlanetExplorer exp = new PlanetExplorer(3, 3);

		assertEquals("(0,0,N)", exp.executeCommand("fff"));
	}
}

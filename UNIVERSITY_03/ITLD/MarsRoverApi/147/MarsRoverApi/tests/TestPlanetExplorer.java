import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommand() {

		PlanetExplorer planet = new PlanetExplorer(100,100, "(0,1)");
		planet.setDirection("N");
		String expected = "(0,1,N)";

		assertEquals(expected, planet.executeCommand("f"));
	}

	@Test
	public void test_executeCommand2(){

		PlanetExplorer planet = new PlanetExplorer(100,100, "(0,1)");
		planet.setDirection("E");
		String expected = "(1,0,E)";

		assertEquals(expected, planet.executeCommand("f"));
	}
	@Test
	public void test_executeCommand3(){

		PlanetExplorer planet = new PlanetExplorer(100,100, "(0,1)");
		planet.setPos_x(1);
		planet.setPos_y(1);
		planet.setDirection("S");
		String expected = "(1,0,S)";

		assertEquals(expected, planet.executeCommand("b"));
	}
	@Test
	public void test_executeCommand4(){

		PlanetExplorer planet = new PlanetExplorer(100,100, "(0,1)");
		planet.setPos_x(1);
		planet.setPos_y(1);
		planet.setDirection("N");
		String expected = "(1,1,W)";

		assertEquals(expected, planet.executeCommand("l"));
	}

}

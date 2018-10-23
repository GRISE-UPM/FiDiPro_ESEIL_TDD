import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {


	public void test_executeCommand() {
		fail("Not yet implemented");
	}*
	@Test
	public void testOnceForwardWithoutObstacles(){

		PlanetExplorer explorer = new PlanetExplorer(3,3);

		String ocekivano="(0,1,N)";
		assertEquals(ocekivano,explorer.executeCommand("f"));

	}
	@Test
	public void testOnceBackwardWithoutObstacles(){

		PlanetExplorer explorer = new PlanetExplorer(3,3);

		String ocekivano="(0,0,N)";
		explorer.executeCommand("f");
		assertEquals(ocekivano,explorer.executeCommand("b"));

	}

	@Test
	public void testOverEdgeForward(){

		PlanetExplorer explorer = new PlanetExplorer(3,3);

		String ocekivano="(0,0,N)";
		explorer.executeCommand("f");
		explorer.executeCommand("f");

		assertEquals(ocekivano,explorer.executeCommand("f"));

	}

	@Test
	public void testOverEdgeBackward(){

		PlanetExplorer explorer = new PlanetExplorer(3,3);

		String ocekivano="(0,2,N)";
		assertEquals(ocekivano,explorer.executeCommand("b"));

	}
	@Test
	public void testFacingEast(){

		PlanetExplorer explorer = new PlanetExplorer(3,3);

		String ocekivano="(0,0,E)";
		assertEquals(ocekivano,explorer.executeCommand("r"));

	}
	@Test
	public void testFacingWest(){

		PlanetExplorer explorer = new PlanetExplorer(3,3);

		String ocekivano="(0,0,W)";
		assertEquals(ocekivano,explorer.executeCommand("l"));

	}
	@Test
	public void testOverEdgeForwardX(){

		PlanetExplorer explorer = new PlanetExplorer(3,3);

		String ocekivano="(0,0,E)";
		explorer.executeCommand("r");
		explorer.executeCommand("f");
		explorer.executeCommand("f");
		assertEquals(ocekivano,explorer.executeCommand("f"));

	}
	@Test
	public void testOverEdgeBackwardX(){

		PlanetExplorer explorer = new PlanetExplorer(3,3);

		String ocekivano="(0,2,E)";
		explorer.executeCommand("r");
		assertEquals(ocekivano,explorer.executeCommand("b"));

	}

	@Test
	public void testOverEdgeBackwardX3(){

		PlanetExplorer explorer = new PlanetExplorer(3,3);

		String ocekivano="(2,0,W)";
		explorer.executeCommand("l");
		assertEquals(ocekivano,explorer.executeCommand("f"));

	}
	@Test
	public void testOverEdgeForwardX2(){

		PlanetExplorer explorer = new PlanetExplorer(3,3);

		String ocekivano="(0,0,E)";
		explorer.executeCommand("r");
		explorer.executeCommand("f");
		explorer.executeCommand("f");



		assertEquals(ocekivano,explorer.executeCommand("f"));

	}
	@Test
	public void testOverEdgeBackwardX2(){

		PlanetExplorer explorer = new PlanetExplorer(3,3);

		String ocekivano="(0,0,W)";
		explorer.executeCommand("l");
		explorer.executeCommand("b");
		explorer.executeCommand("b");
		assertEquals(ocekivano,explorer.executeCommand("b"));

	}






}

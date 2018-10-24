import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	PlanetExplorer explorer;




	@Test
	public void test_init(){
		explorer = new PlanetExplorer(5, 5, null);

		String expectedResult = "(0, 0, N)";

		assertEquals(expectedResult, explorer.toString());
	}
	@Test
	public void test_moveTwiceForward(){
		explorer = new PlanetExplorer(5, 5, null);

		String expectedResult = "(0, 2, N)";

		assertEquals(expectedResult, explorer.executeCommand("ff"));
	}
	@Test
	public void test_moveForwardThenBackward(){
		explorer = new PlanetExplorer(5, 5, null);

		String expectedResult = "(0, 0, N)";

		assertEquals(expectedResult, explorer.executeCommand("fb"));
	}
	@Test
	public void test_turnToSouth(){
		explorer = new PlanetExplorer(5, 5, null);

		String expectedResult = "(0, 0, S)";

		assertEquals(expectedResult, explorer.executeCommand("ll"));
	}
	@Test
	public void test_turnToEast(){
		explorer = new PlanetExplorer(5, 5, null);

		String expectedResult = "(0, 0, E)";

		assertEquals(expectedResult, explorer.executeCommand("r"));
	}
	@Test
	public void test_turnToEastGoingOposite(){
		explorer = new PlanetExplorer(5, 5, null);

		String expectedResult = "(0, 0, E)";

		assertEquals(expectedResult, explorer.executeCommand("lll"));
	}
	@Test
	public void test_turnToWestGoingOposite(){
		explorer = new PlanetExplorer(5, 5, null);

		String expectedResult = "(0, 0, W)";

		assertEquals(expectedResult, explorer.executeCommand("rrr"));
	}

	@Test
	public void test_exampleCommand(){
		explorer = new PlanetExplorer(5, 5, null);

		String expectedResult = "(2, 2, E)";

		assertEquals(expectedResult, explorer.executeCommand("ffrff"));
	}

	@Test
	public void test_exploreWhenMovingForthAndObstacleIsInNorth(){
		explorer = new PlanetExplorer(5, 5, "[(0,1)]");

		String expectedResult = "(0, 0, N)";

		assertEquals(expectedResult, explorer.executeCommand("f"));
	}

	@Test
	public void test_exploreWhenMovingForthAndObstacleIsInEast(){
		explorer = new PlanetExplorer(5, 5, "[(1,0)]");

		String expectedResult = "(0, 0, E)";

		assertEquals(expectedResult, explorer.executeCommand("rf")); 

	}

	@Test
	public void test_exploreArountTheOrbitForward(){
		explorer = new PlanetExplorer(5, 5, null);

		String expectedResult = "(0, 0, N)";

		assertEquals(expectedResult, explorer.executeCommand("ffffff"));
	}

	@Test
	public void test_exploreAroundTheBackward(){
		explorer = new PlanetExplorer(5, 5, null);

		String expectedResult = "(0, 0, N)";

		assertEquals(expectedResult, explorer.executeCommand("bbbbbb"));
	}




}

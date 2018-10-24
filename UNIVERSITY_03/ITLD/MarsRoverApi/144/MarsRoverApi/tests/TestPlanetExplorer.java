import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {


	public void test_executeCommand() {
		fail("Not yet implemented");
	}*

	@Test
	public void test_Initialize() throws PlanetExplorerException {
		PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

		assertEquals("Incorrect position when initialize", "(0,0,N)", plnt.executeCommand(""));
	}

	@Test
	public void test_moving_forwoard() throws PlanetExplorerException {
		PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

		assertEquals("Incorrect position when moving forwoard", "(0,1,N)", plnt.executeCommand("f"));
	}
	@Test
	public void test_moving_backwoard() throws PlanetExplorerException {
		PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

				assertEquals("Incorrect position when moving forwoard", "(0,2,N)", plnt.executeCommand("b"));
			}
	@Test
	public void test_moving_right_when_north() throws PlanetExplorerException {
		PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

		assertEquals("Incorrect position when moving forwoard", "(0,0,E)", plnt.executeCommand("r"));
	}
	@Test
public void test_moving_right_when_east() throws PlanetExplorerException {
	PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

		assertEquals("Incorrect position when moving forwoard", "(0,0,S)", plnt.executeCommand("rr"));
	}
	@Test
public void test_moving_right_when_south() throws PlanetExplorerException {
	PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

	assertEquals("Incorrect position when moving forwoard", "(0,0,W)", plnt.executeCommand("rrr"));
}
	@Test
public void test_moving_right_when_west() throws PlanetExplorerException {
	PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

	assertEquals("Incorrect position when moving forwoard", "(0,0,N)", plnt.executeCommand("rrrr"));
}
	@Test
public void test_moving_left_when_north() throws PlanetExplorerException {
	PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

	assertEquals("Incorrect position when moving forwoard", "(0,0,W)", plnt.executeCommand("l"));
}
	@Test
public void test_moving_left_when_east() throws PlanetExplorerException {
	PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

	assertEquals("Incorrect position when moving forwoard", "(0,0,N)", plnt.executeCommand("llll"));
}
	@Test
public void test_moving_left_when_south() throws PlanetExplorerException {
	PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

	assertEquals("Incorrect position when moving forwoard", "(0,0,E)", plnt.executeCommand("lll"));
}
	@Test
public void test_moving_left_when_west() throws PlanetExplorerException {
	PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

	assertEquals("Incorrect position when moving forwoard", "(0,0,S)", plnt.executeCommand("ll"));
}

	@Test
	public void test_moving_left_when_ffrf() throws PlanetExplorerException {
		PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

		assertEquals("Incorrect position when moving forwoard", "(1,2,E)", plnt.executeCommand("ffrf"));
	}

	@Test
	public void test_moving_when_crossing_over_when_moving_forwoard_when_north() throws PlanetExplorerException {
		PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

		assertEquals("Incorrect position when moving forwoard", "(0,0,N)", plnt.executeCommand("fff"));
	}
	@Test
	public void test_moving_when_crossing_over_when_moving_forwoar_when_south() throws PlanetExplorerException {
		PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

		assertEquals("Incorrect position when moving forwoard", "(0,2,S)", plnt.executeCommand("rrf"));
	}
	@Test
	public void test_moving_when_crossing_over_when_moving_backwoard_when_north() throws PlanetExplorerException {
		PlanetExplorer plnt=new PlanetExplorer(3, 3, "(2,2)");

		assertEquals("Incorrect position when moving forwoard", "(0,2,N)", plnt.executeCommand("b"));
	}



}

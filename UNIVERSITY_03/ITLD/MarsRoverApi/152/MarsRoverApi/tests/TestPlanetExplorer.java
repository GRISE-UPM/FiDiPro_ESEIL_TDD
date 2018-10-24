import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {


	public void test_executeCommand() {
		fail("Not yet implemented");
	}*
	@Test
	public void test_executeCommand_prviTest() {

		PlanetExplorer pe = new PlanetExplorer(100, 100, "(0,2)(1,2)");
		String actual = pe.executeCommand("ffrf");

		assertEquals("(1,2,E)", actual);

	}
	@Test
	public void test_executeCommand_drugiTest() {

		PlanetExplorer pe = new PlanetExplorer(100, 100, "(0,2)(1,2)");
		String actual = pe.executeCommand("rf");

		assertEquals("(1,0,E)", actual);

	}

	@Test
	public void test_executeCommand_treciTest() {

		PlanetExplorer pe = new PlanetExplorer(100, 100, "(0,2)(1,2)");
		String actual = pe.executeCommand("ffrfflf");

		assertEquals("(2,3,N)", actual);

	}

	@Test
	public void test_executeCommand_cetvrtiTest() {

		PlanetExplorer pe = new PlanetExplorer(100, 100, "(0,2)");
		String actual = pe.executeCommand("fffr");


		assertEquals("(2,3,N)", actual);

	}
}

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {


	@Test
	public void test_executeCommand() {
		fail("Not yet implemented");
	}
	*
	@Test
	public void test_PlanetExplorerConstructor() {
		PlanetExplorer vozilo = new PlanetExplorer(0,0,"(0,2)");
		assertNotNull(vozilo);
	}

	@Test
	public void test_executeF() {
		PlanetExplorer vozilo = new PlanetExplorer(0,0,"1,1");
		vozilo.executeCommand("f");
		assertEquals("0,1,(1,1)", vozilo);
	}

	@Test
	public void test_executeB() {
		PlanetExplorer vozilo = new PlanetExplorer(0,2,"1,1");
		vozilo.executeCommand("b");
		assertEquals("0,1,(1,1)", vozilo);
	}
}

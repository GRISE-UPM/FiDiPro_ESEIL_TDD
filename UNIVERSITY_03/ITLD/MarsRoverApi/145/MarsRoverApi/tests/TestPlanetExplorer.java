import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	PlanetExplorer vozilo;
	@Test
	public void test_executeCommandF()throws PlanetExplorerException {
		vozilo = new PlanetExplorer(10,10);
		String ocekivaniIspis="(0, 1, N)";

		assertEquals(ocekivaniIspis,vozilo.executeCommand("f"));

	}

	@Test
	public void test_executeCommandFBorderCase()throws PlanetExplorerException {
		vozilo = new PlanetExplorer(2,2);
		String ocekivaniIspis="(0, 0, N)";

		assertEquals(ocekivaniIspis,vozilo.executeCommand("fff"));

	}
	@Test
	public void test_executeCommandBBorderCase() throws PlanetExplorerException{
		vozilo = new PlanetExplorer(100,100);
		String ocekivaniIspis="(0, 100, N)";

		assertEquals(ocekivaniIspis,vozilo.executeCommand("b"));

	}
	@Test
	public void test_executeCommandBBorderCaseAndThenB() throws PlanetExplorerException{
		vozilo = new PlanetExplorer(100,100);
		String ocekivaniIspis="(0, 99, N)";

		assertEquals(ocekivaniIspis,vozilo.executeCommand("bb"));

	}
	@Test
	public void test_executeCommandL() throws PlanetExplorerException{
		vozilo = new PlanetExplorer(100,100);
		String ocekivaniIspis="(0, 0, W)";

		assertEquals(ocekivaniIspis,vozilo.executeCommand("l"));

	}
	@Test
	public void test_executeCommandR() throws PlanetExplorerException{
		vozilo = new PlanetExplorer(100,100);
		String ocekivaniIspis="(0, 0, E)";

		assertEquals(ocekivaniIspis,vozilo.executeCommand("r"));

	}
	@Test
	public void test_executeMoreCommands() throws PlanetExplorerException{
		vozilo = new PlanetExplorer(100,100);
		String ocekivaniIspis="(2, 2, E)";

		assertEquals(ocekivaniIspis,vozilo.executeCommand("ffrff"));

	}
	@Test(expected=PlanetExplorerException.class)
	public void test_executeCommandsEx() throws PlanetExplorerException{
		vozilo = new PlanetExplorer(100,100,"0,1");

		vozilo.executeCommand("fff");

	}

	public void test_executeCommandsWithObstacle() throws PlanetExplorerException{
		vozilo = new PlanetExplorer(100,100,"0,1");
		String ocekivaniIspis="(0, 1, E)";

		assertEquals(ocekivaniIspis,vozilo.executeCommand("f"));

	}*
}

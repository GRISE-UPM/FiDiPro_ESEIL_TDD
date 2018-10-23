import static org.junit.Assert.*;

import org.junit.Test;


public class TestPlanetExplorer {

	@Test
	public void test_executeCommand()throws PlanetExplorerException {
		PlanetExplorer pl = new PlanetExplorer(3,3, "");
		String rower = pl.executeCommand("f");
		String expected = "(0,1,N)";
		assertEquals(expected, rower);
	}
	@Test
	public void test_executeCommandBack()throws PlanetExplorerException {
		PlanetExplorer pl = new PlanetExplorer(3,3, "");
		String rower = pl.executeCommand("b");
		String expected = "(0,2,N)";
		assertEquals(expected, rower);
	}
	@Test
	public void test_executeCommandR()throws PlanetExplorerException {
		PlanetExplorer pl = new PlanetExplorer(3,3, "");
		String rower = pl.executeCommand("r");
		String expected = "(0,0,E)";
		assertEquals(expected, rower);
	}
	@Test
	public void test_executeCommandL() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3, "");
		String rower = pl.executeCommand("l");
		String expected = "(0,0,W)";
		assertEquals(expected, rower);
	}
	@Test
	public void test_executeCommandFF() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3, "");
		String rower = pl.executeCommand("ff");
		String expected = "(0,2,N)";
		assertEquals(expected, rower);
	}
	@Test
	public void test_executeCommandFFR() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3, "");
		String rower = pl.executeCommand("ffr");
		String expected = "(0,2,E)";
		assertEquals(expected, rower);
	}
	@Test
	public void test_executeCommandFFL()throws PlanetExplorerException {
		PlanetExplorer pl = new PlanetExplorer(3,3, "");
		String rower = pl.executeCommand("ffl");
		String expected = "(0,2,W)";
		assertEquals(expected, rower);
	}
	@Test
	public void test_executeCommandFFFFFL()throws PlanetExplorerException {
		PlanetExplorer pl = new PlanetExplorer(3,3, "");
		String rower = pl.executeCommand("fffffl");
		String expected = "(0,1,W)";
		assertEquals(expected, rower);
	}
	@Test
	public void test_executeCommandBL()throws PlanetExplorerException {
		PlanetExplorer pl = new PlanetExplorer(3,3, "");
		String rower = pl.executeCommand("bl");
		String expected = "(0,2,W)";
		assertEquals(expected, rower);
	}
	@Test
	(expected  = PlanetExplorerException.class)
	public void test_exceptionXnegativan() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(-3,3, "");
	}
	@Test
	(expected  = PlanetExplorerException.class)
	public void test_exceptionYnegativan() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,-3, "");
	}
}

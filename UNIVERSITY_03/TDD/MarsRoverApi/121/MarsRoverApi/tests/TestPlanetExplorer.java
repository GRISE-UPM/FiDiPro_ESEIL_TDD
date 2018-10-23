import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {


	public void test_executeCommand() {
		fail("Not yet implemented");
	}*
	@Test
	public void test_constructorTest(){
		PlanetExplorer pe = new PlanetExplorer(3,3,"");
		assertNotNull(pe);
	}

	@Test
	public void test_startPosition(){
		PlanetExplorer pe = new PlanetExplorer(3,3,"");
		assertEquals("(0,0,N)", pe.getCoordinates());
	}
	@Test
	public void test_gridInitiation(){
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(3x3)", pe.getGrid() );
	}
	@Test
	public void test_checkInitialcommandF() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(0,1,N)",pe.executeCommand("f"));
	}
	@Test
	public void test_checkInitialCommandB() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,"");
		assertEquals("(0,2,N)", pe.executeCommand("b"));
	}
	@Test
	public void test_checkInitialCommandL() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,"");
		assertEquals("(0,0,W)", pe.executeCommand("l"));
	}
	@Test
	public void test_checkInitialcommandR() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3,3,"");
		assertEquals("(0,0,E)", pe.executeCommand("r"));
	}
	@Test
	public void test_boundariescommandR() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3,3,"");
		assertEquals("(0,0,E)", pe.executeCommand("rrrr"));
	}
	@Test
	public void test_NFS1() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3,3,"");
		pe.executeCommand("f");
		pe.executeCommand("f");
		assertEquals("(0,2,N)", pe.getCoordinates());
	}
	@Test
	public void test_NFS2() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3,3,"");
		pe.executeCommand("f");
		pe.executeCommand("f");
		pe.executeCommand("r");
		pe.executeCommand("f");
		assertEquals("(1,2,E)", pe.getCoordinates());
	}

	@Test 
	public void test_obstacles1() throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3,3,"(0,2)");
		pe.executeCommand("f");
		pe.executeCommand("f");
		pe.executeCommand("r");
		pe.executeCommand("f");
		assertEquals("(1,1,E)", pe.getCoordinates());
	}



	public void test_exceptionCommand() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals(, pe.executeCommand("yolo"));
	}*

}

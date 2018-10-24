import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {


	@Test
	public void test_forth_north() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		assertEquals("Error!","(0,1,n)",rover.executeCommand("f"));
	}

	@Test
	public void test_back_north() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3, 3, null);
		rover.setRoverY(1);
		assertEquals("Error!","(0,0,n)",rover.executeCommand("b"));
	}
	@Test
	public void test_rotaton_right() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3, 3, null);
		assertEquals("Error","(0,0,e)",rover.executeCommand("r"));
	}
	@Test
	public void test_rotaton_left() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3, 3, null);
		assertEquals("Error","(0,0,w)",rover.executeCommand("l"));
	}
	@Test
	public void test_forth_east() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		assertEquals("Error!","(1,0,e)",rover.executeCommand("rf"));
	}
	@Test
	public void test_forth_south() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		rover.setRoverY(1);
		assertEquals("Error!","(0,0,s)",rover.executeCommand("rrf"));
	}
	@Test
	public void test_forth_west() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		rover.setRoverX(2);
		assertEquals("Error!","(1,0,w)",rover.executeCommand("lf"));
	}
	@Test
	public void test_back_east() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		rover.setRoverX(2);
		assertEquals("Error!","(1,0,e)",rover.executeCommand("rb"));
	}
	@Test
	public void test_back_south() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		assertEquals("Error!","(0,1,s)",rover.executeCommand("rrb"));
	}
	@Test
	public void test_back_west() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		assertEquals("Error!","(1,0,w)",rover.executeCommand("lb"));
	}
	@Test
	public void test_forth_north_boundries() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		assertEquals("Error!","(0,0,n)",rover.executeCommand("ffff"));
	}
	@Test
	public void test_forth_east_boundries() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		assertEquals("Error!","(0,0,e)",rover.executeCommand("rffff"));
	}
	@Test
	public void test_forth_south_boundries() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		assertEquals("Error!","(0,0,s)",rover.executeCommand("rrffff"));
	}
	@Test
	public void test_forth_west_boundries() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		assertEquals("Error!","(3,0,w)",rover.executeCommand("lf"));
	}
	@Test
	public void test_back_west_boundries() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		assertEquals("Error!","(0,0,w)",rover.executeCommand("lbbbb"));
	}
	@Test
	public void test_back_north_boundries() throws PlanetExplorerException {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		assertEquals("Error!","(0,0,n)",rover.executeCommand("bbbb"));
	}
	@Test
	(expected = PlanetExplorerException.class)
	public void test_exception () throws PlanetExplorerException {
	PlanetExplorer rover = new PlanetExplorer(3,3,null);
	rover.executeCommand("k");
	}

}

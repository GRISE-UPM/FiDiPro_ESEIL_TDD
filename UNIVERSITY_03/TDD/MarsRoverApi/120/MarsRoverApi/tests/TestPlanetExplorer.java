import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommand() {

	}

	@Test
	public void test_rotate_right() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);

		assertEquals("Error", "(0,0,e)", pe.executeCommand("r"));
	}

	@Test
	public void test_rotate_left() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);

		assertEquals("Error", "(0,0,w)", pe.executeCommand("l"));
	}

	@Test
	public void test_forth_north() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);

		assertEquals("Error", "(0,1,n)", pe.executeCommand("f"));
	}

	@Test
	public void test_back_north() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("f");

		assertEquals("Error", "(0,0,n)", pe.executeCommand("b"));
	}

	@Test
	public void test_forth_east() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("r");

		assertEquals("Error", "(1,0,e)", pe.executeCommand("f"));
	}

	@Test
	public void test_back_east() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("r");
		pe.executeCommand("f");

		assertEquals("Error", "(0,0,e)", pe.executeCommand("b"));
	}

	@Test
	public void test_forth_south() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("f");
		pe.executeCommand("rr");

		assertEquals("Error", "(0,0,s)", pe.executeCommand("f"));
	}

	@Test
	public void test_back_south() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("rr");

		assertEquals("Error", "(0,1,s)", pe.executeCommand("b"));
	}

	@Test
	public void test_forth_west() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("rfll");

		assertEquals("Error", "(0,0,w)", pe.executeCommand("f"));
	}

	@Test
	public void test_back_west() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("l");

		assertEquals("Error", "(1,0,w)", pe.executeCommand("b"));
	}

	@Test
	public void test_boundaries_north() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("ff");

		assertEquals("Error", "(0,0,n)", pe.executeCommand("f"));
	}

	@Test
	public void test_boundaries_south() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);

		assertEquals("Error", "(0,2,n)", pe.executeCommand("b"));
	}

	@Test
	public void test_boundaries_east() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("rff");

		assertEquals("Error", "(0,0,e)", pe.executeCommand("f"));
	}

	@Test
	public void test_boundaries_west() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("r");

		assertEquals("Error", "(2,0,e)", pe.executeCommand("b"));
	}

	@Test
	public void test_boundaries_forth_west() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("l");

		assertEquals("Error", "(2,0,w)", pe.executeCommand("f"));
	}

	@Test
	public void test_boundaries_forth_south() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("rr");

		assertEquals("Error", "(0,2,s)", pe.executeCommand("f"));
	}

	@Test
	public void test_boundaries_back_south() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("ffrr");

		assertEquals("Error", "(0,0,s)", pe.executeCommand("b"));
	}

	@Test
	public void test_boundaries_back_west() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("lbb");

		assertEquals("Error", "(0,0,w)", pe.executeCommand("b"));
	}

	@Test
	(expected = PlanetExplorerException.class)
	public void testException() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, null);
		pe.executeCommand("z");
	}

	@Test
	public void test_obstacles() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3, 3, "(0,1)");

		assertEquals("Error", "(0,0,n)(0,1)", pe.executeCommand("f"));
	}
}

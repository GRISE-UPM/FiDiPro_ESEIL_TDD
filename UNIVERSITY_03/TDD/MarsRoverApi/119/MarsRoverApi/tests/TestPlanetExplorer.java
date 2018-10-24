import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommand() {
		fail("Not yet implemented");
	}
	*	@Test
	public void test_move_forth_north() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		assertEquals("", "(0,1,n)", pe.executeCommand("f"));
	}

	@Test
	public void test_move_back_north() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);
		pe.setRoverY(2);

		assertEquals("", "(0,0,n)", pe.executeCommand("b"));
	}

	@Test
	public void test_rotate_right() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		assertEquals("", "(0,0,e)", pe.executeCommand("r"));
	}

	@Test
	public void test_rotate_left() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		assertEquals("", "(0,0,w)", pe.executeCommand("l"));
	}

	@Test
	public void test_rotate_twice_left() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		assertEquals("", "(0,0,s)", pe.executeCommand("ll"));
	}

	@Test
	public void test_rotate_3x_left() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		assertEquals("", "(0,0,e)", pe.executeCommand("lll"));
	}

	@Test
	public void test_rotate_full_cicle_left() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		assertEquals("", "(0,0,n)", pe.executeCommand("llll"));
	}

	@Test
	public void test_rotate_twice_right() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		assertEquals("", "(0,0,s)", pe.executeCommand("rr"));
	}

	@Test
	public void test_rotate_3x_right() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		assertEquals("", "(0,0,w)", pe.executeCommand("rrr"));
	}

	@Test
	public void test_rotate_full_cicle_right() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		assertEquals("", "(0,0,n)", pe.executeCommand("rrrr"));
	}

	@Test
	public void test_move_forth_east() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);
		pe.executeCommand("r");

		assertEquals("", "(1,0,e)", pe.executeCommand("f"));
	}

	@Test
	public void test_move_back_east() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);
		pe.setRoverX(1);
		pe.executeCommand("r");

		assertEquals("", "(0,0,e)", pe.executeCommand("b"));
	}

	@Test
	public void test_move_forth_south() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);
		pe.executeCommand("rr");
		pe.setRoverY(1);

		assertEquals("", "(0,0,s)", pe.executeCommand("f"));
	}

	@Test
	public void test_move_back_south() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);
		pe.setRoverY(1);
		pe.executeCommand("ll");

		assertEquals("", "(0,1,s)", pe.executeCommand("b"));
	}

	@Test
	public void test_move_forth_west() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);
		pe.executeCommand("l");
		pe.setRoverX(1);

		assertEquals("", "(0,0,w)", pe.executeCommand("f"));
	}

	@Test
	public void test_move_back_west() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);
		pe.executeCommand("rrr");

		assertEquals("", "(1,0,w)", pe.executeCommand("b"));
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_exception() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);
		pe.executeCommand("k");
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_exception_with_number() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);
		pe.executeCommand("2");
	}

}

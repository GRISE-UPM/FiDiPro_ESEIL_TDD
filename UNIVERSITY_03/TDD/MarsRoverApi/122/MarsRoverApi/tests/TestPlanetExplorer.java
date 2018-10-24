import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_rotate_right_one_time() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		assertEquals("Greska", "(0,0,e)", pe.executeCommand("r"));
	}


	@Test
	public void test_rotate_right_two_times() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.executeCommand("r");
		assertEquals("Greska", "(0,0,s)", pe.executeCommand("r"));
	}

	@Test
	public void test_rotate_right_three_times() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.executeCommand("r");
		pe.executeCommand("r");
		assertEquals("Greska", "(0,0,w)", pe.executeCommand("r"));
	}

	@Test
	public void test_rotate_right_four_times()throws PlanetExplorerException {
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.executeCommand("r");
		pe.executeCommand("r");
		pe.executeCommand("r");
		assertEquals("Greska", "(0,0,n)", pe.executeCommand("r"));
	}


	@Test
	public void test_rotate_left_one_time() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		assertEquals("Greska", "(0,0,w)", pe.executeCommand("l"));
	}

	@Test
	public void test_rotate_left_two_times() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.executeCommand("l");
		assertEquals("Greska", "(0,0,s)", pe.executeCommand("l"));
	}

	@Test
	public void test_rotate_left_three_times() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.executeCommand("l");
		pe.executeCommand("l");
		assertEquals("Greska", "(0,0,e)", pe.executeCommand("l"));
	}


	@Test
	public void test_rotate_left_four_times() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.executeCommand("l");
		pe.executeCommand("l");
		pe.executeCommand("l");
		assertEquals("Greska", "(0,0,n)", pe.executeCommand("l"));
	}

	@Test
	public void test_forward_north()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		assertEquals("Greska", "(0,1,n)", pe.executeCommand("f"));		
	}

	@Test
	public void test_forward_east()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.executeCommand("r");
		assertEquals("Greska", "(1,0,e)", pe.executeCommand("f"));		
	}


	@Test
	public void test_forward_south()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.executeCommand("r");
		pe.executeCommand("r");

		pe.setVehicleY(1);
		assertEquals("Greska", "(0,0,s)", pe.executeCommand("f"));		
	}

	@Test
	public void test_forward_west()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.executeCommand("r");
		pe.executeCommand("r");
		pe.executeCommand("r");

		pe.setVehicleX(1);
		assertEquals("Greska", "(0,0,w)", pe.executeCommand("f"));		
	}

	@Test
	public void test_back_north()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.setVehicleY(1);
		assertEquals("Greska", "(0,0,n)", pe.executeCommand("b"));		
	}

	@Test
	public void test_back_east()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.executeCommand("r");

		pe.setVehicleX(1);
		assertEquals("Greska", "(0,0,e)", pe.executeCommand("b"));		
	}

	@Test
	public void test_back_south()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.executeCommand("r");
		pe.executeCommand("r");

		assertEquals("Greska", "(0,1,s)", pe.executeCommand("b"));		
	}

	@Test
	public void test_back_west()throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.executeCommand("r");
		pe.executeCommand("r");
		pe.executeCommand("r");

		assertEquals("Greska", "(1,0,w)", pe.executeCommand("b"));		
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_exception() throws PlanetExplorerException{
		PlanetExplorer pe = new PlanetExplorer(3,3,null);

		pe.executeCommand("z");		
	}

}

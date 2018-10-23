import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {


	@Test
	public void test_Kretanje_Komanda_f()throws PlanetExplorerException{
	PlanetExplorer explorer=new PlanetExplorer(0,0,"N");
	String position=explorer.executeCommand("f");
	assertEquals("Not expected","1, 0",position);

	}

	@Test
	public void test_Kretanje_Komanda_b()throws PlanetExplorerException{
	PlanetExplorer explorer=new PlanetExplorer(0,0,"N");
	String position=explorer.executeCommand("b");
	assertEquals("Not expected position","0, -1",position);
	}

	@Test
	public void test_Komanda_fl()throws PlanetExplorerException{
		PlanetExplorer explorer=new PlanetExplorer(0,0,"N");
		String position=explorer.executeCommand("fl");
		assertEquals("Not expected position","1, 0, E", position);
	}
	@Test
	public void test_Komanda_bl()throws PlanetExplorerException{
		PlanetExplorer explorer=new PlanetExplorer(0,0,"N");
		String position=explorer.executeCommand("bl");
		assertEquals("Not expected position","0, -1, E",position);
	}
	@Test
	public void test_Komanda_r()throws PlanetExplorerException{
		PlanetExplorer explorer=new PlanetExplorer(0,0,"N");
		String position=explorer.executeCommand("r");
		assertEquals("Not expcted position","0, 0, W",position);
	}

	@Test(expected=PlanetExplorerException.class)
	public void test_Komanda_frr()throws PlanetExplorerException{
		PlanetExplorer explorer=new PlanetExplorer(0,0,"N");
		String position=explorer.executeCommand("frr");
	}

	@Test
	public void test_Prepreka_ff()throws PlanetExplorerException{
		PlanetExplorer explorer=new PlanetExplorer(0,0, "N");
		String position=explorer.executeCommand("ff");
		assertEquals("Not expectes position","(2, 0, N)(5,5)(5,7)",position);
	}

}

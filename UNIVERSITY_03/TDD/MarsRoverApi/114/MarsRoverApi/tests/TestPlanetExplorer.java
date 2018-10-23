import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {


	@Test
	public void test_executeCommand()  throws PlanetExplorerException{

		PlanetExplorer explorer= new PlanetExplorer(0,0,null);
		String expected="(0,0,N)";

		assertEquals(expected,explorer.toString());
	}

	@Test
	public void test_Napred()  throws PlanetExplorerException{

		PlanetExplorer explorer= new PlanetExplorer(0,0,"N");
		String expected="(0,1,N)";
		assertEquals(expected,explorer.executeCommand("f"));
	}
	@Test
	public void test_Nazad()  throws PlanetExplorerException{

		PlanetExplorer explorer= new PlanetExplorer(0,1,"N");
		String expected="(0,0,S)";
		assertEquals(expected,explorer.executeCommand("b"));
	}

	@Test
	public void test_Levo()  throws PlanetExplorerException{

		PlanetExplorer explorer= new PlanetExplorer(1,0,"N");
		String expected="(0,0,W)";
		assertEquals(expected,explorer.executeCommand("l"));
	}
	@Test
	public void test_Desno()  throws PlanetExplorerException{

		PlanetExplorer explorer= new PlanetExplorer(1,0,"N");
		String expected="(2,0,E)";
		assertEquals(expected,explorer.executeCommand("d"));
	}
	@Test
	public void test_ff()  throws PlanetExplorerException{

		PlanetExplorer explorer= new PlanetExplorer(1,0,"N");
		String expected="(1,2,N)";
		assertEquals(expected,explorer.executeCommand("ff"));
	}

	@Test
	public void test_desno()  throws PlanetExplorerException{

		PlanetExplorer explorer= new PlanetExplorer(0,0,"N");
		String expected="(1,2,E)";
		assertEquals(expected,explorer.executeCommand("ffd"));
	}
	@Test(expected=PlanetExplorerException.class)
	public void test_exception()  throws PlanetExplorerException{

		PlanetExplorer explorer= new PlanetExplorer(0,0,"N");
		explorer.executeCommand("dqgs");
	}

}

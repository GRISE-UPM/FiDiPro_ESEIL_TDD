import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_startnaPozicija() {
		PlanetExplorer planet = new PlanetExplorer(0, 0, "N");
		String l = planet.pozicija();
		assertEquals("Pocetne koordinate", planet, l);
	}


	@Test(expected = PlanetExplorerException.class)
	public void test_desno() throws PlanetExplorerException {

		PlanetExplorer planet = new PlanetExplorer(0, 0, "E");

		String r = planet.executeCommand("r");

		assertEquals(r, planet.pozicija());
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_desno2() throws PlanetExplorerException {

		PlanetExplorer planet = new PlanetExplorer(0, 0, "S");

		String r = planet.executeCommand("r");
		r = planet.executeCommand("r");

		assertEquals(r, planet.pozicija());
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_desno3() throws PlanetExplorerException {

		PlanetExplorer planet = new PlanetExplorer(0, 0, "W");

		String r = planet.executeCommand("r");
		r = planet.executeCommand("r");
		r = planet.executeCommand("r");

		assertEquals(r, planet.pozicija());
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_levo() throws PlanetExplorerException {

		PlanetExplorer planet = new PlanetExplorer(0, 0, "W");

		String l = planet.executeCommand("l");

		assertEquals(l, planet.pozicija());
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_levo1() throws PlanetExplorerException {

		PlanetExplorer planet = new PlanetExplorer(0, 0, "S");

		String l = planet.executeCommand("l");
		l = planet.executeCommand("l");

		assertEquals(l, planet.pozicija());
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_levo2() throws PlanetExplorerException {

		PlanetExplorer planet = new PlanetExplorer(0, 0, "E");

		String l = planet.executeCommand("l");
		l = planet.executeCommand("l");
		l = planet.executeCommand("l");

		assertEquals(l, planet.pozicija());
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_napred() throws PlanetExplorerException {

		PlanetExplorer planet = new PlanetExplorer(0, 1, "N");

		String f = planet.executeCommand("f");

		assertEquals(f, planet.pozicija());
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_napred1() throws PlanetExplorerException {

		PlanetExplorer planet = new PlanetExplorer(0, 2, "N");

		String f = planet.executeCommand("f");
		f = planet.executeCommand("f");

		assertEquals(f, planet.pozicija());
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_napred2() throws PlanetExplorerException {

		PlanetExplorer planet = new PlanetExplorer(0, 3, "N");

		String f = planet.executeCommand("f");
		f = planet.executeCommand("f");
		f = planet.executeCommand("f");

		assertEquals(f, planet.pozicija());
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_move() throws PlanetExplorerException {

		PlanetExplorer planet = new PlanetExplorer(0, 2, "E");

		String f = planet.executeCommand("f");
		f = planet.executeCommand("f");
		f = planet.executeCommand("r");
		f = planet.executeCommand("f");

		assertEquals(f, planet.pozicija());
	}
}

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_pocetnaPozicija() {

		Pozicija poz = new Pozicija();

		String izlaz = poz.trenutnaPozicija();

		assertEquals("Provera startne pozicije", izlaz, "(0, 0, N)");
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_Pomeranja() throws PlanetExplorerException{

		Pozicija poz = new Pozicija();
		poz.pomeranje("Z");
	}

	@Test
	public void test_okretanjaObrnuto() throws PlanetExplorerException{

		Pozicija poz = new Pozicija();
		poz.pomeranje("l");
		poz.pomeranje("l");

		String izlaz = poz.trenutnaPozicija();

		assertEquals("Provera startne pozicije", izlaz, "(0, 0, S)");
	}

	@Test
	public void test_okretanjaUsmeruKazalje() throws PlanetExplorerException{

		Pozicija poz = new Pozicija();
		poz.pomeranje("r");
		poz.pomeranje("r");
		poz.pomeranje("r");

		String izlaz = poz.trenutnaPozicija();

		assertEquals("Provera startne pozicije", izlaz, "(0, 0, W)");
	}

	@Test
	public void test_pomeranjaUnapred() throws PlanetExplorerException{

		Pozicija poz = new Pozicija();
		poz.pomeranje("f");
		poz.pomeranje("f");
		poz.pomeranje("f");

		String izlaz = poz.trenutnaPozicija();

		assertEquals("Provera startne pozicije", izlaz, "(0, 3, N)");
	}

	@Test
	public void test_pomeranjaUnazad() throws PlanetExplorerException{

		Pozicija poz = new Pozicija();
		poz.pomeranje("b");
		poz.pomeranje("b");

		String izlaz = poz.trenutnaPozicija();

		assertEquals("Provera startne pozicije", izlaz, "(0, -2, N)");
	}

	@Test
	public void test_postavljanjaGrida() throws PlanetExplorerException{

		PlanetExplorer grid = new PlanetExplorer(3,3,"(2,2)");

		String izlaz = grid.toString();

		assertEquals("Provera postavljanja grida", izlaz, "(3, 3, (2,2))");
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_pogresnoPostavljanjaGrida() throws PlanetExplorerException{

		PlanetExplorer grid = new PlanetExplorer(0,0, "(2,2)");
	}

	@Test
	public void test_prosledjivanjaReciNaredbe() throws PlanetExplorerException{

		PlanetExplorer grid = new PlanetExplorer(4,4, "(2,2)");
		grid.executeCommand("fff");

		String izlaz = grid.getPozicija().trenutnaPozicija();

		assertEquals("Provera startne pozicije", izlaz, "(0, 3, N)");
	}
}

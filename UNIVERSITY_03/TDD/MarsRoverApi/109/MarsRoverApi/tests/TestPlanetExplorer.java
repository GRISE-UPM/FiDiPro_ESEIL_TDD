import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommand() {
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertNotNull(p);
	}

	@Test
	public void test_dimenzijeGrida(){
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("3x3", p.getGridSize());
	}

	@Test
	public void test_pocetneKoordinate(){
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(0,0)", p.getVoziloKoor());
	}

	@Test
	public void test_pocetnaStrana(){
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("n", p.getVoziloStrana());
	}

	@Test
	public void test_pomeriNapred() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(0,1,n)", p.executeCommand("f"));
	}

	@Test
	public void test_pomeriNazad() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(0,0,n)", p.executeCommand("fb"));
	}

	@Test
	public void test_pomeriNazadSaPrebacivanjem() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(0,2,n)", p.executeCommand("b"));
	}

	@Test
	public void test_pomeriNapredSaPrebacivanjem() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(0,0,n)", p.executeCommand("fff"));
	}

	@Test
	public void test_pomeriRotirajDesno() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(0,0,e)", p.executeCommand("r"));
	}

	@Test
	public void test_pomeriRotirajLevo() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(0,0,w)", p.executeCommand("l"));
	}

	@Test
	public void test_pomeriRotirajDesnoPunKrug() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(0,0,n)", p.executeCommand("rrrr"));
	}

	@Test
	public void test_pomeriRotirajLevoPunKrug() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(0,0,n)", p.executeCommand("llll"));
	}

	@Test
	public void test_pomeriRotirajDesnoIdiNapred() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(1,0,e)", p.executeCommand("rf"));
	}

	@Test
	public void test_pomeriRotirajLevoIdiNapred() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(2,0,w)", p.executeCommand("lf"));
	}

	@Test
	public void test_pomeriRotirajDesnoIdiNazad() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(2,0,e)", p.executeCommand("rb"));
	}

	@Test
	public void test_pomeriRotirajLevoIdiNazad() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(1,0,w)", p.executeCommand("lb"));
	}

	@Test
	public void test_pomeriRotirajDesnoDesnoIdiNapred() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(0,2,s)", p.executeCommand("rrf"));
	}


	@Test
	public void test_pomeriRotirajDesnoDesnoIdiNazad() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		assertEquals("(0,1,s)", p.executeCommand("rrb"));
	}

	@Test(expected = PlanetExplorerException.class)
	public void test_exceptionPogresanUnos() throws PlanetExplorerException{
		PlanetExplorer p = new PlanetExplorer(3, 3, "");
		p.executeCommand("asdw!!");
	}



}

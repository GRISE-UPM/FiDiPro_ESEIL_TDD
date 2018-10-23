import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {


	public void test_executeCommand() {
		fail("Not yet implemented");
	}*
	@Test
	public void testProveraDaLiOdeNapredJednom() throws PlanetExplorerException
	{
		PlanetExplorer planeta = new PlanetExplorer(3, 3, "(0,2)");
		String putanja ="f";
		String pozicija=planeta.executeCommand(putanja);
		assertEquals("(0,1,N)",pozicija);



	}

	@Test
	public void testProveraDaLiIdeNazadZaJedan() throws PlanetExplorerException
	{
		PlanetExplorer planeta = new PlanetExplorer(3, 3, "(0,2)");

		planeta.setxKo(0);
		planeta.setyKo(1);

		String putanja="b";
		String pozicija=planeta.executeCommand(putanja);
		assertEquals("(0,0,S)", pozicija);

	}

	@Test 
	public void testProveraDaLiIdeDesnoZaJedan() throws PlanetExplorerException
	{
		PlanetExplorer planeta = new PlanetExplorer(3, 3, "(0,2)");

		planeta.setxKo(0);
		planeta.setyKo(0);

		String putanja="r";

		String pozicija=planeta.executeCommand(putanja);
		assertEquals("(1,0,E)", pozicija);
	}

	@Test
	public void testPorveraDaLiIdeJedanLevo() throws PlanetExplorerException
	{
		PlanetExplorer planeta = new PlanetExplorer(3, 3, "(0,2)");

		planeta.setxKo(1);
		planeta.setyKo(0);

		String putanja="l";

		String pozicija=planeta.executeCommand(putanja);
		assertEquals("(0,0,W)", pozicija);
	}

	@Test(expected=PlanetExplorerException.class)
	public void testDaLiOdeUNedozvoljenuPoziciju() throws PlanetExplorerException
	{
		PlanetExplorer planeta = new PlanetExplorer(3, 3, "(0,2)");

		planeta.setxKo(0);
		planeta.setyKo(0);

		String putanja="l";

		String pozicija=planeta.executeCommand(putanja); 

	}

	@Test
	public void testDaLiIdeViseKorakaNapred() throws PlanetExplorerException
	{
		PlanetExplorer planeta = new PlanetExplorer(3, 3, "(0,2)");

		planeta.setxKo(0);
		planeta.setyKo(0);

		String putanja="f,f";

		String pozicija=planeta.executeCommand(putanja);

		assertEquals("(0,2,N)", pozicija);
	}

	@Test(expected=PlanetExplorerException.class)
	public void testDaLiOdeUNedozvoljenuPozicijuNaDruguStranu() throws PlanetExplorerException
	{
		PlanetExplorer planeta = new PlanetExplorer(3, 3, "(0,2)");

		planeta.setxKo(2);
		planeta.setyKo(0);

		String putanja="r";

		String pozicija=planeta.executeCommand(putanja); 

	}

}

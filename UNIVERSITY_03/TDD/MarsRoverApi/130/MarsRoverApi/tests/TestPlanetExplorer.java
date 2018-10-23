import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_ProveraStartnePozicije() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("");
		assertEquals("(0,0,N)",rezultat);
	}

	@Test
	public void test_StartnaPozicijaIKretanjeForward() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("f");
		assertEquals("(0,1,N)",rezultat);
	}

	@Test
	public void test_StartnaPozicijaIKretanjeForward2Puta() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("ff");
		assertEquals("(0,2,N)",rezultat);
	}

	@Test
	public void test_StartnaPozicijaIKretanjeBack() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("fb");
		assertEquals("(0,0,N)",rezultat);
	}

	@Test
	public void test_OkretanjeLevo() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("l");
		assertEquals("(0,0,W)",rezultat);
	}

	@Test
	public void test_OkretanjeLevo2Puta() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("ll");
		assertEquals("(0,0,S)",rezultat);
	}

	@Test
	public void test_OkretanjeLevo3Puta() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("lll");
		assertEquals("(0,0,E)",rezultat);
	}
	@Test
	public void test_OkretanjeLevo4Puta() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("llll");
		assertEquals("(0,0,N)",rezultat);
	}

	@Test
	public void test_OkretanjeDesno() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("r");
		assertEquals("(0,0,E)",rezultat);
	}

	@Test
	public void test_OkretanjeDesno2Puta() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("rr");
		assertEquals("(0,0,S)",rezultat);
	}

	@Test
	public void test_OkretanjeDesno3Puta() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("rrr");
		assertEquals("(0,0,W)",rezultat);
	}
	@Test
	public void test_OkretanjeDesno4Puta() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("rrrr");
		assertEquals("(0,0,N)",rezultat);
	}

	@Test
	public void test_KretanjeEastF() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("rf");
		assertEquals("(1,0,E)",rezultat);
	}

	@Test
	public void test_KretanjeEast2PutaF() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("rff");
		assertEquals("(2,0,E)",rezultat);
	}

	@Test
	public void test_KretanjeEastB() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("rffb");
		assertEquals("(1,0,E)",rezultat);
	}

	@Test
	public void test_KretanjeEast2PutaB() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("rffbb");
		assertEquals("(0,0,E)",rezultat);
	}

	@Test
	public void test_KretanjeWestF() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("rffllf");
		assertEquals("(1,0,W)",rezultat);
	}

	@Test
	public void test_KretanjeWest2PutaF() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("rffllff");
		assertEquals("(0,0,W)",rezultat);
	}

	@Test
	public void test_KretanjeWestB() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("lb");
		assertEquals("(1,0,W)",rezultat);
	}

	@Test
	public void test_KretanjeWest2PutaB() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("lbb");
		assertEquals("(2,0,W)",rezultat);
	}

	@Test
	public void test_KretanjeForwardNorth3PutaU3x3Matrici() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("fff");
		assertEquals("(0,0,N)",rezultat);
	}

	@Test
	public void test_KretanjeForwardSouthU3x3Matrici() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("rrf");
		assertEquals("(0,2,S)",rezultat);
	}

	@Test
	public void test_KretanjeForwardSouth3PutaU3x3Matrici() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("rrfff");
		assertEquals("(0,0,S)",rezultat);
	}

	@Test
	public void test_KretanjeForwardEast3PutaU3x3Matrici() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("rfff");
		assertEquals("(0,0,E)",rezultat);
	}

	@Test
	public void test_KretanjeForwardWestU3x3Matrici() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("lf");
		assertEquals("(2,0,W)",rezultat);
	}

	@Test
	public void test_KretanjeForwardWest3PutaU3x3Matrici() throws PlanetExplorerException{
		PlanetExplorer explorer = new PlanetExplorer(3,3,null);
		String rezultat = explorer.executeCommand("lfff");
		assertEquals("(0,0,W)",rezultat);
	}
}

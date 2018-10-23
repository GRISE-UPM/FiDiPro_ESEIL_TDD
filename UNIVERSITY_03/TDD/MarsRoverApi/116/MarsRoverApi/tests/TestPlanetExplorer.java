import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void testNLimit1() {
		PlanetExplorer planet = new PlanetExplorer(3,3,null);
		planet.executeCommand("ff");
		assertEquals("(0,0,N)", planet.executeCommand("f"));
	}

	@Test
	public void testNLimit2(){
		PlanetExplorer planet = new PlanetExplorer(3,3,null);
		assertEquals("(0,0,N)", planet.executeCommand("f"));
	}

	@Test
	public void testN1(){
		PlanetExplorer planet = new PlanetExplorer(3,3,null);
		assertEquals("(0,1,N)", planet.executeCommand("f"));

	}
	@Test
	public void testSLimit1(){
		PlanetExplorer planet = new PlanetExplorer(3,3,null);
		planet.executeCommand("lff");
		assertEquals("(0,0,S)", planet.executeCommand("f"));

	}

	@Test
	public void testSLimit2(){
		PlanetExplorer planet = new PlanetExplorer(3,3,null);
		planet.executeCommand("lff");
		assertEquals("(0,2,S)", planet.executeCommand("llb"));

	}
	@Test
	public void testS(){
		PlanetExplorer planet = new PlanetExplorer(3,3,null);
		planet.executeCommand("lff");
		assertEquals("(0,2,S)", planet.executeCommand("lf"));

	}



}



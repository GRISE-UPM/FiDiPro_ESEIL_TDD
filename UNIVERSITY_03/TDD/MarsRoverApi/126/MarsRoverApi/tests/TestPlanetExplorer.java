import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void testConstructor() {
		PlanetExplorer pe = new PlanetExplorer(5,5,"2,2");
		assertNotNull(pe);
	}

	@Test
	public void testMoveForwardNorth() {
		PlanetExplorer pe = new PlanetExplorer(5,5,"");
		String explorer = pe.executeCommand("f");
		assertEquals("(0,1,N)",explorer);
	}

	@Test
	public void testMoveForwardNorthTwice() {
		PlanetExplorer pe = new PlanetExplorer(5,5,"");
		String explorer = pe.executeCommand("ff");
		assertEquals("(0,2,N)",explorer);
	}

	@Test
	public void testMoveBackwardFacedNorth() {
		PlanetExplorer pe = new PlanetExplorer(5,5,"");
		String explorer = pe.executeCommand("b");
		assertEquals("(0,5,N)",explorer);
	}

	@Test
	public void testMoveBackwardFacedNorthTwice() {
		PlanetExplorer pe = new PlanetExplorer(5,5,"");
		String explorer = pe.executeCommand("bb");
		assertEquals("(0,4,N)",explorer);
	}

	@Test
	public void testFromNorthToEast() {
		PlanetExplorer pe = new PlanetExplorer(5,5,"");
		String explorer = pe.executeCommand("r");
		assertEquals("(0,0,E)",explorer);
	}

	@Test 
	public void testFromNorthToWest(){
		PlanetExplorer pe = new PlanetExplorer(5,5,"");
		String explorer = pe.executeCommand("l");
		assertEquals("(0,0,W)",explorer);
	}

	@Test
	public void testDoubleRight(){
		PlanetExplorer pe = new PlanetExplorer(5,5,"");
		String explorer = pe.executeCommand("rr");
		assertEquals("(0,0,S)",explorer);
	}

	@Test 
	public void testForwardThenRight(){
		PlanetExplorer pe = new PlanetExplorer(5,5,"");
		String explorer = pe.executeCommand("fr");
		assertEquals("(0,1,E)",explorer);
	}

	@Test 
	public void testEastThenForward(){
		PlanetExplorer pe = new PlanetExplorer(5,5,"");
		String explorer = pe.executeCommand("rf");
		assertEquals("(1,0,E)",explorer);
	}

	@Test
	public void testWestThenForward(){
		PlanetExplorer pe = new PlanetExplorer(5,5,"");
		String explorer = pe.executeCommand("lf");
		assertEquals("(5,0,W)",explorer);
	}

	@Test
	public void testDoubleLeftForward(){
		PlanetExplorer pe = new PlanetExplorer(5,5,"");
		String explorer = pe.executeCommand("llf");
		assertEquals("(0,5,S)",explorer);
	}

	@Test
	public void testRightForwardLeft(){
		PlanetExplorer pe = new PlanetExplorer(5,5,"");
		String explorer = pe.executeCommand("rfl");
		assertEquals("(1,0,N)",explorer);
	}





}

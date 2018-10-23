import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {


	public void test_executeCommand() {
		fail("Not yet implemented");
	}*
	@Test 
	public void testcomf () throws Exception 
	{
		PlanetExplorer plex = new PlanetExplorer(10, 10, null);
		assertEquals("(0,1,N)",plex.executeCommand("f"));
	}
	@Test
	public void testcomb ()
	{
		PlanetExplorer  plex = new PlanetExplorer(10,10,null);
		plex.executeCommand("f");
		assertEquals("(0,0,N)",plex.executeCommand("b"));
	}
	@Test
	public void testcoml ()
	{
		PlanetExplorer  plex = new PlanetExplorer(10,10,null);

		assertEquals("(0,0,W)",plex.executeCommand("l"));
	}
	@Test
	public void testcomr ()
	{
		PlanetExplorer  plex = new PlanetExplorer(10,10,null);

		assertEquals("(0,0,E)",plex.executeCommand("r"));
	}




}

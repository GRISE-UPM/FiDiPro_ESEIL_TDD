import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {


	@Test
	public void test_movingForthOnce() throws PlanetExplorerException{
		PlanetExplorer planeta = new PlanetExplorer(3,3);
		String result = planeta.executeCommand("f");

		assertEquals("Not moving forth", "(0,1,N)", result);

	}

	@Test
	public void test_MovingBack() throws PlanetExplorerException{

		PlanetExplorer planeta = new PlanetExplorer(3,3);
		planeta.setxExplorer(0);
		planeta.setyExplorer(1);
		String result = planeta.executeCommand("b");

		assertEquals("Not moving back", "(0,0,N)", result);
	}

	@Test (expected = PlanetExplorerException.class)
	public void test_exception_errorCommand() throws PlanetExplorerException
	{
		PlanetExplorer planeta = new PlanetExplorer(3,3);
		String result = planeta.executeCommand("a");
	}

	@Test 
	public void test_changingPositionRight() throws PlanetExplorerException
	{
		PlanetExplorer planeta = new PlanetExplorer(3,3);
		String result = planeta.executeCommand("r");

		assertEquals("Not changing the position when the command is right", "(0,0,E)", result);


	}

	@Test
	public void test_changingPositionLeft() throws PlanetExplorerException
	{
		PlanetExplorer planeta = new PlanetExplorer(3,3);
		String result = planeta.executeCommand("l");

		assertEquals("Not changing position when the command is left", "(0,0,W)", result);
	}

	@Test 
	public void test_theEndOfGrid() throws PlanetExplorerException
	{
		PlanetExplorer planeta = new PlanetExplorer(3, 3);
		planeta.setxExplorer(2);
		planeta.setyExplorer(2);
		planeta.setPosition('N');

		String result = planeta.executeCommand("f");

		assertEquals("End of grid error" , "(2,0,N)", result);


	}
	@Test
	public void test_theEndOfGridd() throws PlanetExplorerException
	{
		PlanetExplorer planeta = new PlanetExplorer(3, 3);
		planeta.setxExplorer(2);
		planeta.setyExplorer(2);
		planeta.setPosition('E');

		String result = planeta.executeCommand("f");

		assertEquals("End of grid error" , "(0,2,E)", result);

	}



}

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {



	@Test
	public void consturctorTest(){
		PlanetExplorer pe = new PlanetExplorer(1,1, "");
		assertNotNull(pe);

	}

	@Test
	public void obstacles(){
		int gridX=3;
		int gridY=3;
		String obstacles = "(1,1)";

		PlanetExplorer pe = new PlanetExplorer(gridX,gridY, obstacles);
		assertNotNull(pe);


	}

	@Test
	public void positionsForward(){
		int gridX=3;
		int gridY=3;
		String obstacles = "(2,2)";

		PlanetExplorer pe = new PlanetExplorer(gridX,gridY, obstacles);

		assertEquals("(0,1,N)",pe.executeCommand("f") );
	}


	@Test
	public void positionsBackward(){
		int gridX=3;
		int gridY=3;
		String obstacles = "(2,2)";

		PlanetExplorer pe = new PlanetExplorer(gridX,gridY, obstacles);

		assertEquals("(0,0,N)",pe.executeCommand("b") );
	}

	@Test
	public void positionsRight(){
		int gridX=3;
		int gridY=3;
		String obstacles = "(2,2)";

		PlanetExplorer pe = new PlanetExplorer(gridX,gridY, obstacles);

		assertEquals("(0,0,E)",pe.executeCommand("r") );
	}

	@Test
	public void positionsLeft(){
		int gridX=3;
		int gridY=3;
		String obstacles = "(2,2)";

		PlanetExplorer pe = new PlanetExplorer(gridX,gridY, obstacles);

		assertEquals("(0,0,E)",pe.executeCommand("r") );
	}

	@Test
	public void sphericForward(){
		int gridX=3;
		int gridY=3;

		PlanetExplorer pe = new PlanetExplorer(gridX,gridY, "");
		assertEquals("(0,1,N)",pe.executeCommand("f") );
		assertEquals("(0,2,N)",pe.executeCommand("f") );
		assertEquals("(0,3,N)",pe.executeCommand("f") );
		assertEquals("(0,0,N)",pe.executeCommand("f") );


	}

	@Test
	public void sphericBackward(){
		int gridX=3;
		int gridY=3;

		PlanetExplorer pe = new PlanetExplorer(gridX,gridY, "");
		assertEquals("(0,3,N)",pe.executeCommand("b") );



	}

	@Test
	public void positionsForwardEast(){
		int gridX=3;
		int gridY=3;
		String obstacles = "(2,2)";

		PlanetExplorer pe = new PlanetExplorer(gridX,gridY, obstacles);

		assertEquals("(0,1,N)",pe.executeCommand("f") );
		assertEquals("(0,1,E)",pe.executeCommand("r") );
	}

	@Test
	public void positionsForwardWest(){
		int gridX=3;
		int gridY=3;
		String obstacles = "(2,2)";

		PlanetExplorer pe = new PlanetExplorer(gridX,gridY, obstacles);

		assertEquals("(0,1,N)",pe.executeCommand("f") );
		assertEquals("(0,1,W)",pe.executeCommand("l") );
	}

	@Test
	public void positionsBackwardEast(){
		int gridX=3;
		int gridY=3;
		String obstacles = "(2,2)";

		PlanetExplorer pe = new PlanetExplorer(gridX,gridY, obstacles);

		assertEquals("(0,3,N)",pe.executeCommand("b") );
		assertEquals("(0,3,E)",pe.executeCommand("r") );
	}

	@Test
	public void positionsBackwardWest(){
		int gridX=3;
		int gridY=3;
		String obstacles = "(2,2)";

		PlanetExplorer pe = new PlanetExplorer(gridX,gridY, obstacles);

		assertEquals("(0,3,N)",pe.executeCommand("b") );
		assertEquals("(0,3,W)",pe.executeCommand("l") );
	}

	@Test
	public void positionsForwardx2(){
		int gridX=3;
		int gridY=3;
		String obstacles = "(2,2)";

		PlanetExplorer pe = new PlanetExplorer(gridX,gridY, obstacles);

		assertEquals("(0,2,N)",pe.executeCommand("ff") );
	}

	@Test
	public void positionsBackwardx2(){
		int gridX=3;
		int gridY=3;
		String obstacles = "(2,2)";

		PlanetExplorer pe = new PlanetExplorer(gridX,gridY, obstacles);

		assertEquals("(0,2,N)",pe.executeCommand("bb") );
	}


}

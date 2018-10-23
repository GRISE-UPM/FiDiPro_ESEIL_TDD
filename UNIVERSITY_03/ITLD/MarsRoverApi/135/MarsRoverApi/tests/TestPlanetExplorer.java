import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	PlanetExplorer plntexp;


	@Test
	public void test_spawnExplorerWithObstacles() throws PlanetExplorerException{
		plntexp = new PlanetExplorer(100, 100, "(1,2)(2,3)");
		boolean spawnResults = (plntexp.getGrid().getX() == 100) && 
							   (plntexp.getGrid().getY() == 100) &&
							   (plntexp.getObstacleList().size() == 2) &&
							   (plntexp.getObstacleList().get(0).getX() == 1) &&
							   (plntexp.getObstacleList().get(0).getY() == 2) &&
							   (plntexp.getObstacleList().get(1).getX() == 2) &&
							   (plntexp.getObstacleList().get(1).getY() == 3);
		assertTrue(spawnResults);
	}
}

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommand() {
		fail("Not yet implemented");
	}

	@Test
	public void test_moveForth() throws PlanetExplorerException
	{
		PlanetExplorer vozilo = new PlanetExplorer(3, 3, "N");
		vozilo.moveForth();
		assertEquals("Napred", "(3, 4, N)", vozilo.getFormatedCoordinates());
	}
	@Test
	public void test_moveBack() throws PlanetExplorerException
	{
		PlanetExplorer vozilo = new PlanetExplorer (3, 3, "N");
		vozilo.moveBack();
		assertEquals("Nazad", "(3, 2, N)", vozilo.getFormatedCoordinates());
	}
	@Test
	public void test_moveLeft() throws PlanetExplorerException
	{
		PlanetExplorer vozilo = new PlanetExplorer (3, 3, "N");
		vozilo.moveLeft();
		assertEquals("Levo", "(3, 3, W)", vozilo.getFormatedCoordinates());
	}
	@Test
	public void test_moveRight() throws PlanetExplorerException
	{
		PlanetExplorer vozilo = new PlanetExplorer(3, 3, "N");
		vozilo.moveRight();
		assertEquals("Desno", "(3, 3, E)", vozilo.getFormatedCoordinates());
	}
	@Test
	public void test_moveLeft_2() throws PlanetExplorerException
	{
		PlanetExplorer vozilo = new PlanetExplorer(3, 3, "N");
		vozilo.moveLeft();
		vozilo.moveLeft();
		assertEquals("Levo 180 stepeni", "(3, 3, W)", vozilo.getFormatedCoordinates());		
	}
	@Test
	public void test_moveRight_2() throws PlanetExplorerException
	{
		PlanetExplorer vozilo = new PlanetExplorer(3, 3, "N");
		vozilo.moveRight();
		vozilo.moveRight();
		assertEquals("Desno 180 stepeni", "(3, 3, E)", vozilo.getFormatedCoordinates());
	}
	@Test
	public void test_moveLeft_3() throws PlanetExplorerException
	{
		PlanetExplorer vozilo = new PlanetExplorer(3, 3, "N");
		vozilo.moveLeft();
		vozilo.moveLeft();
		vozilo.moveLeft();
		vozilo.moveLeft();
		assertEquals("Levo pun krug", "(3, 3, W)", vozilo.getFormatedCoordinates());		
	}
	@Test
	public void test_moveRight_4() throws PlanetExplorerException
	{
		PlanetExplorer vozilo = new PlanetExplorer(3, 3, "N");
		vozilo.moveRight();
		vozilo.moveRight();
		vozilo.moveRight();
		vozilo.moveRight();
		assertEquals("Desno pun krug", "(3, 3, E)", vozilo.getFormatedCoordinates());
	}









}

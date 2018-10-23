import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_mapFormation() {
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		assertEquals("Velicina mape i pozicije prepreka su:","(3, 3, N)", rover.getFormatedCoorditates());
	}

	@Test
	public void test_moveForth() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		rover.moveForth();
		assertEquals("Vozilo se pomerilo napred za 1", "(3, 4, N)", rover.getFormatedCoorditates());
	}

	@Test
	public void test_moveBack() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		rover.moveBack();
		assertEquals("Vozilo se pomerilo nazad za 1", "(3, 2, N)", rover.getFormatedCoorditates());
	}

	@Test
	public void test_changeDirectionLeft_1() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);


		rover.moveLeft();

		assertEquals("Vozilo menja smer kretanja na levo",
					 "(3, 3, W)", rover.getFormatedCoorditates());
	}

	@Test
	public void test_changeDirectionRight_1() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);


		rover.moveRight();

		assertEquals("Vozilo menja smer kretanja na desno",
					 "(3, 3, E)", rover.getFormatedCoorditates());
	}

	@Test
	public void test_changeDirectionLeft_2() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);


		rover.moveLeft();
		rover.moveLeft();

		assertEquals("Vozilo menja smer kretanja na levo",
					 "(3, 3, S)", rover.getFormatedCoorditates());
	}

	@Test
	public void test_changeDirectionRight_2() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);


		rover.moveRight();
		rover.moveRight();

		assertEquals("Vozilo menja smer kretanja na desno",
					 "(3, 3, S)", rover.getFormatedCoorditates());
	}

	@Test
	public void test_fullRotationToTheLeft() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);


		rover.moveLeft();
		rover.moveLeft();
		rover.moveLeft();
		rover.moveLeft();

		assertEquals("Vozilo pravi krug oko svoje ose na levo",
					 "(3, 3, N)", rover.getFormatedCoorditates());
	}

	@Test
	public void test_fullRotationToTheRight() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);


		rover.moveRight();
		rover.moveRight();
		rover.moveRight();
		rover.moveRight();

		assertEquals("Vozilo pravi krug oko svoje ose na desno",
					 "(3, 3, N)", rover.getFormatedCoorditates());
	}

	@Test
	public void test_fullRotationToTheLeftPlusOne() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);


		rover.moveLeft();
		rover.moveLeft();
		rover.moveLeft();
		rover.moveLeft();
		rover.moveLeft();

		assertEquals("Vozilo pravi krug oko svoje ose na levo i jos jednom na levo",
					 "(3, 3, W)", rover.getFormatedCoorditates());
	}

	@Test
	public void test_fullRotationToTheRightPlusOne() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);


		rover.moveRight();
		rover.moveRight();
		rover.moveRight();
		rover.moveRight();
		rover.moveRight();

		assertEquals("Vozilo pravi krug oko svoje ose na desno i jos jednom na desno",
					 "(3, 3, E)", rover.getFormatedCoorditates());
	}

	@Test
	public void test_RotateLeft_MoveForth() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		rover.moveLeft();
		rover.moveForth();

		assertEquals("Vozilo se rotira na zabad i pomera za 1",
				 "(4, 3, W)", rover.getFormatedCoorditates());

	}

	public void test_RotateLeft_MoveBack() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		rover.moveLeft();
		rover.moveBack();

		assertEquals("Vozilo se rotira na zabad i pomera za 1",
				 "(2, 3, W)", rover.getFormatedCoorditates());

	}

	@Test
	public void test_RotateRight_MoveForth() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		rover.moveRight();
		rover.moveForth();

		assertEquals("Vozilo se rotira na zabad i pomera za 1",
				 "(4, 3, E)", rover.getFormatedCoorditates());

	}

	@Test
	public void test_RotateRight_MoveBack() throws PlanetExplorerException
	{
		PlanetExplorer rover = new PlanetExplorer(3,3,null);
		rover.moveRight();
		rover.moveBack();

		assertEquals("Vozilo se rotira na zabad i pomera za 1",
				 "(2, 3, E)", rover.getFormatedCoorditates());

	}
}

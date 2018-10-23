import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_Constructor() {
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		assertNotNull(pl);
	}

	@Test
	public void test_MoveForwardOne() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("f");
		assertEquals("(0,1)",pozicija);
	}

	@Test
	public void test_MoveForwardTwo() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("ff");
		assertEquals("(0,2)",pozicija);
	}

	@Test
	public void test_MoveForwardAfterRightTurn() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("frf");
		assertEquals("(1,1)",pozicija);
	}

	@Test
	public void test_MoveForwardTwoAfterRightTurn() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("frff");
		assertEquals("(2,1)",pozicija);
	}

	@Test
	public void test_MoveBackafterLeft() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("lb");
		assertEquals("(1,0)",pozicija);
	}

	@Test
	public void test_TwoLeftOneRightAndBack() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("llrb");
		assertEquals("(1,0)",pozicija);
	}

	@Test
	public void test_TwoLeftAndBack() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("llb");
		assertEquals("(0,1)",pozicija);
	}

	@Test 
	public void test_Forward() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("ffff");
		assertEquals("(0,0)",pozicija);
	}

	@Test 
	public void test_TwoRightAndFor() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("rrf");
		assertEquals("(0,3)",pozicija);
	}

	@Test 
	public void test_RightAndFor() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("rffff");
		assertEquals("(0,0)",pozicija);
	}

	@Test 
	public void test_LeftAndFor() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("lf");
		assertEquals("(3,0)",pozicija);
	}

	@Test
	public void test_back() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("b");
		assertEquals("(0,3)",pozicija);
	}

	@Test
	public void test_RghtAndBack() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("rb");
		assertEquals("(3,0)",pozicija);
	}

	@Test
	public void test_BackToStart() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(2,2)(3,3)");
		String pozicija = pl.executeCommand("rfffllb");
		assertEquals("(0,0)",pozicija);
	}

	@Test(expected=PlanetExplorerException.class)
	public void test_HitOb() throws PlanetExplorerException{
		PlanetExplorer pl = new PlanetExplorer(3,3,"(1,0)");
		String pozicija = pl.executeCommand("f");
	}
}

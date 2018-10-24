import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {


	public void test_executeCommand() {
		fail("Not yet implemented");
	}*

	public void test_gettingCoordinatesIntoArrayOfIntegers(){
		PlanetExplorer ex = new PlanetExplorer(100,100,"(2,3),(3,2)");

		String expected = "2332";
		assertEquals("Cannot get coordinates from obstacles!",expected,);
	}*	@Test
	public void test_initialMoveForward(){
		PlanetExplorer ex = new PlanetExplorer(100,100,"(2,3),(3,2)");

		String expected = "0, 1, N";
		assertEquals(expected, ex.executeCommand("f"));

	}
	@Test
	public void test_initialMoveBackwardFromSomePoint(){
		PlanetExplorer ex = new PlanetExplorer(100,100,"(2,3),(3,2)");

		String expected = "2, 3, E";
		assertEquals(expected, ex.executeCommand("ffflbb"));

	}
	@Test
	public void test_initialMoveForwardFacingWest(){
		PlanetExplorer ex = new PlanetExplorer(100,100,"(2,3),(3,2)");

		String expected = "1, 0, W";
		assertEquals(expected, ex.executeCommand("rf"));

	}
	@Test
	public void test_initialMoveBackwardFacingEast(){
		PlanetExplorer ex = new PlanetExplorer(100,100,"(2,3),(3,2)");

		String expected = "1, 0, E";
		assertEquals(expected, ex.executeCommand("lb"));

	}
	@Test
	public void test_ChangingGridSideIfGrideYis100(){
		PlanetExplorer ex = new PlanetExplorer(100,100,"(2,3),(3,2)");
		String expected = "0, 0, N";
		for(int i = 0; i<100; i++){
			ex.executeCommand("f");
		}
		assertEquals(expected,ex.executeCommand("f") );
	}
	@Test
	public void test_ChangingGridSideIfGrideYis0(){
		PlanetExplorer ex = new PlanetExplorer(100,100,"(2,3),(3,2)");
		String expected = "0, 100, N";
		assertEquals(expected,ex.executeCommand("b") );
	}
	@Test
	public void test_ChangingGridSideIfGrideXis100(){
		PlanetExplorer ex = new PlanetExplorer(100,100,"(2,3),(3,2)");
		String expected = "0, 0, W";
		ex.executeCommand("r");
		for(int i = 0; i<100; i++){
			ex.executeCommand("f");
		}
		assertEquals(expected,ex.executeCommand("f") );
	}
	@Test
	public void test_ChangingGridSideIfGrideXis0(){
		PlanetExplorer ex = new PlanetExplorer(100,100,"(2,3),(3,2)");
		String expected = "100, 0, E";
		ex.executeCommand("l");
		assertEquals(expected,ex.executeCommand("f") );
	}

}

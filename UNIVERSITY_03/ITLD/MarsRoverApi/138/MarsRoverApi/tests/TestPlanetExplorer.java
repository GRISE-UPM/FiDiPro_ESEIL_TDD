import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_one(){
		PlanetExplorer PE = new PlanetExplorer(3,3);

		String expected = PE.executeCommand("f");
		assertEquals("Error", "(0,1)", expected);
	}

	@Test
	public void test_two(){
		PlanetExplorer PE = new PlanetExplorer(3,3);

		String expected = PE.executeCommand("ff");
		assertEquals("Error", "(0,2)", expected);
	}

	@Test
	public void test_three(){
		PlanetExplorer PE = new PlanetExplorer(3,3);

		String expected = PE.executeCommand("ffrf");
		assertEquals("Error", "(1,2)", expected);
	}

	@Test
	public void test_four(){
		PlanetExplorer PE = new PlanetExplorer(5,5);

		String expected = PE.executeCommand("fffrfffrff");
		assertEquals("Error", "(3,1)", expected);
	}
}

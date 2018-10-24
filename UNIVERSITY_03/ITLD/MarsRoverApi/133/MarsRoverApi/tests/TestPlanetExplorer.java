import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_moving_forward_while_N() {
		PlanetExplorer pe = new PlanetExplorer(3, 3);

		String expected = "(pos_" + 0 + ",pos_" + 1 +"," + "N" + ")";

		assertEquals(expected, pe.executeCommand("f"));
	}

	@Test
	public void test_moving_forward_while_N_and_while_at_the_edge(){
		PlanetExplorer pe = new PlanetExplorer(3,3);

		pe.executeCommand("f");
		pe.executeCommand("f");

		String expected = "(pos_" + 0 + ",pos_" + 0 +"," + "N" + ")";

		assertEquals(expected, pe.executeCommand("f"));
	}

	@Test
	public void test_moving_forward_while_S() {
		PlanetExplorer pe = new PlanetExplorer(4, 4);


		pe.executeCommand("l");
		pe.executeCommand("l");
		pe.executeCommand("f");

		String expected = "(pos_" + 0 + ",pos_" + 2 +"," + "S" + ")";

		assertEquals(expected, pe.executeCommand("f"));
	}

	@Test
	public void test_moving_forward_while_S_and_while_at_the_edge() {
		PlanetExplorer pe = new PlanetExplorer(4, 4);


		pe.executeCommand("l");
		pe.executeCommand("l");

		String expected = "(pos_" + 0 + ",pos_" + 3 +"," + "S" + ")";

		assertEquals(expected, pe.executeCommand("f"));
	}

	@Test
	public void test_moving_forward_while_W() {
		PlanetExplorer pe = new PlanetExplorer(4, 4);

		pe.executeCommand("f");
		pe.executeCommand("r");
		pe.executeCommand("f");
		pe.executeCommand("l");
		pe.executeCommand("l");


		String expected = "(pos_" + 0 + ",pos_" + 1 +"," + "W" + ")";

		assertEquals(expected, pe.executeCommand("f"));
	}

	@Test
	public void test_moving_forward_while_W_while_at_the_edge() {
		PlanetExplorer pe = new PlanetExplorer(4, 4);

		pe.executeCommand("f");
		pe.executeCommand("l");

		String expected = "(pos_" + 3 + ",pos_" + 1 +"," + "W" + ")";

		assertEquals(expected, pe.executeCommand("f"));
	}

	@Test
	public void test_moving_forward_while_E() {
		PlanetExplorer pe = new PlanetExplorer(4, 4);

		pe.executeCommand("f");
		pe.executeCommand("r");


		String expected = "(pos_" + 1 + ",pos_" + 1 +"," + "E" + ")";

		assertEquals(expected, pe.executeCommand("f"));
	}

	@Test
	public void test_moving_forward_while_E_while_at_the_edge() {
		PlanetExplorer pe = new PlanetExplorer(4, 4);

		pe.executeCommand("f");
		pe.executeCommand("r");
		pe.executeCommand("f");
		pe.executeCommand("f");
		pe.executeCommand("f");

		String expected = "(pos_" + 0 + ",pos_" + 1 +"," + "E" + ")";

		assertEquals(expected, pe.executeCommand("f"));
	}


	@Test
	public void test_rotating_left_while_N(){
		PlanetExplorer pe = new PlanetExplorer(3,3);

		String expected = "(pos_" + 0 + ",pos_" + 0 +"," + "W" + ")";

		assertEquals(expected, pe.executeCommand("l"));
	}

	@Test
	public void test_rotating_left_while_W(){
		PlanetExplorer pe = new PlanetExplorer(3,3);

		pe.executeCommand("l");

		String expected = "(pos_" + 0 + ",pos_" + 0 +"," + "S" + ")";

		assertEquals(expected, pe.executeCommand("l"));
	}

	@Test
	public void test_rotating_left_while_S(){
		PlanetExplorer pe = new PlanetExplorer(3,3);

		pe.executeCommand("l");
		pe.executeCommand("l");

		String expected = "(pos_" + 0 + ",pos_" + 0 +"," + "E" + ")";

		assertEquals(expected, pe.executeCommand("l"));
	}

	@Test
	public void test_rotating_left_while_E(){
		PlanetExplorer pe = new PlanetExplorer(3,3);

		pe.executeCommand("l");
		pe.executeCommand("l");
		pe.executeCommand("l");

		String expected = "(pos_" + 0 + ",pos_" + 0 +"," + "N" + ")";

		assertEquals(expected, pe.executeCommand("l"));
	}

	@Test
	public void test_rotating_right_while_N(){
		PlanetExplorer pe = new PlanetExplorer(3,3);

		String expected = "(pos_" + 0 + ",pos_" + 0 +"," + "E" + ")";

		assertEquals(expected, pe.executeCommand("r"));
	}

	@Test
	public void test_rotating_right_while_W(){
		PlanetExplorer pe = new PlanetExplorer(3,3);

		pe.executeCommand("r");

		String expected = "(pos_" + 0 + ",pos_" + 0 +"," + "S" + ")";

		assertEquals(expected, pe.executeCommand("r"));
	}

	@Test
	public void test_rotating_right_while_S(){
		PlanetExplorer pe = new PlanetExplorer(3,3);

		pe.executeCommand("r");
		pe.executeCommand("r");

		String expected = "(pos_" + 0 + ",pos_" + 0 +"," + "W" + ")";

		assertEquals(expected, pe.executeCommand("r"));
	}

	@Test
	public void test_rotating_right_while_E(){
		PlanetExplorer pe = new PlanetExplorer(3,3);

		pe.executeCommand("r");
		pe.executeCommand("r");
		pe.executeCommand("r");

		String expected = "(pos_" + 0 + ",pos_" + 0 +"," + "N" + ")";

		assertEquals(expected, pe.executeCommand("r"));
	}
}

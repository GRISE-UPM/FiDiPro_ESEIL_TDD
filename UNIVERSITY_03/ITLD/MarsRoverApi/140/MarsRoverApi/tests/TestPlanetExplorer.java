import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	PlanetExplorer explorer;


	public void test_creatingSpace() {
		Explorer one = new Explorer (0, 0, "N");
		explorer = new PlanetExplorer(100,100,"(5,5)(7,8)", one);

		one.movingRight();

		assertEquals("E", one.toString());

	}*
	@Test
	public void test_movingForwardOne() {
		Explorer one = new Explorer (0, 0, "E");
		explorer = new PlanetExplorer(100,100,"(5,5)(7,8)", one);

		one.movingForward(one.getDirection());

		assertEquals("(1, 0), S", one.ispis());
	}

	@Test
	public void test_movingForwardTwo() {
		Explorer one = new Explorer (0, 0, "N");
		explorer = new PlanetExplorer(100,100,"(5,5)(7,8)", one);

		one.movingForward(one.getDirection());

		assertEquals("(0, 1), N", one.ispis());
	}

	@Test
	public void test_movingForwardThree() {
		Explorer one = new Explorer (2, 2, "W");
		explorer = new PlanetExplorer(100,100,"(5,5)(7,8)", one);

		one.movingForward(one.getDirection());

		assertEquals("(1, 2), S", one.ispis());
	}

	@Test
	public void test_movingBackOne() {
		Explorer one = new Explorer (1, 0, "E");
		explorer = new PlanetExplorer(100,100,"(5,5)(7,8)", one);

		one.movingBack(one.getDirection());

		assertEquals("(0, 0), S", one.ispis());
	}

	@Test
	public void test_movingBackTwo() {
		Explorer one = new Explorer (2, 2, "N");
		explorer = new PlanetExplorer(100,100,"(5,5)(7,8)", one);

		one.movingBack(one.getDirection());

		assertEquals("(2, 1), N", one.ispis());
	}

	@Test
	public void test_movingForwardWithCommand() {
		Explorer one = new Explorer (2, 2, "N");
		explorer = new PlanetExplorer(100,100,"(5,5)(7,8)", one);

		assertEquals("(2, 3), N", explorer.executeCommand("f"));
	}

	@Test
	public void test_movingBackWithCommand() {
		Explorer one = new Explorer (2, 2, "E");
		explorer = new PlanetExplorer(100,100,"(5,5)(7,8)", one);

		assertEquals("(2, 1), E", explorer.executeCommand("b"));
	}

	@Test
	public void test_movingRightWithCommand() {
		Explorer one = new Explorer (2, 2, "E");
		explorer = new PlanetExplorer(100,100,"(5,5)(7,8)", one);

		assertEquals("(2, 2), S", explorer.executeCommand("r"));
	}

	@Test
	public void test_movingLeftWithCommand() {
		Explorer one = new Explorer (2, 2, "E");
		explorer = new PlanetExplorer(100,100,"(5,5)(7,8)", one);

		assertEquals("(2, 2), N", explorer.executeCommand("l"));
	}

}

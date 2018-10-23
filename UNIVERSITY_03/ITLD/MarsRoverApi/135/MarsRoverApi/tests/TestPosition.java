import static org.junit.Assert.*;

import org.junit.Test;

public class TestPosition {
	Position pos;
	@Test
	public void test_moveForward() {
		pos = new Position(1, 1);
		pos.moveForward("N");
		assertEquals(2, pos.getY());
	}

	@Test
	public void test_moveBackwards() {
		pos = new Position(1, 2);
		pos.moveBackwards("N");
		assertEquals(1, pos.getY());
	}

	@Test
	public void test_equal_positions(){
		pos = new Position(1,2);
		Position tmp = new Position(1,2);
		assertTrue(pos.equals(tmp));
	}
}

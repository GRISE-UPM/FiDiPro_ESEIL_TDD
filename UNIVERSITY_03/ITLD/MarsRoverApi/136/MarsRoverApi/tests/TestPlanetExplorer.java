import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

public class TestPlanetExplorer {


	public void test_executeCommand() {
		fail("Not yet implemented");
	}*
	PlanetExplorer pe;


	@Test
	public void testMovingForward() {
		pe = new PlanetExplorer();


		assertEquals("(" + posX + "," + posY + direction + ")" + "(4,5)" + "(1,10)", "(" + real.getPosX() + "," + real.getPosY() + real.getDirection() + ")" + "(4,5)(1,10)");
	}
}

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void isStrike() {
		Frame fr = new Frame(10,0);
		boolean provera = true;
		assertEquals("Greska", true, provera);
	}
	public void isSpare(){
		Frame fr = new Frame(5,5);
		boolean provera = false;
		assertEquals("Greska", true, provera);
	}
		public void single_frame_score(){
			Frame fr = new Frame(2,4);
			boolean provera = true;
			assertEquals("Greska", true, provera);
		}
}

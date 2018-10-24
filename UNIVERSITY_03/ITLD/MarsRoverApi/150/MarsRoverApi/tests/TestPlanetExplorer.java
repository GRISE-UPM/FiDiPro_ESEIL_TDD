import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	PlanetExplorer explorer = new PlanetExplorer(3,3);


	@Test
	public void test_String(){


		int x = 2;
		int y = 3; 


		String expected = "(" + x + "," + y + ")";
		assertEquals(expected,explorer.toString(x,y));
	}

	@Test
	public void test_fN(){

		explorer.getVozilo().setX(0);
		explorer.getVozilo().setY(0);

		String expected = "(" + explorer.getVozilo().getX() + "," + (explorer.getVozilo().getY()+1)  + ")";

		assertEquals(expected,explorer.executeCommand("f"));


	}

	@Test
	public void test_b(){


		explorer.getVozilo().setX(0);
		explorer.getVozilo().setY(1);


		String expected = "(" + explorer.getVozilo().getX() + "," + (explorer.getVozilo().getY()-1)  + ")";

		assertEquals(expected,explorer.executeCommand("b"));

	}

	@Test
	public void test_l(){

		explorer.getVozilo().setX(1);
		explorer.getVozilo().setY(0);

		String expected = "(" + (explorer.getVozilo().getX()-1) + "," + explorer.getVozilo().getY()  + ")";

		assertEquals(expected,explorer.executeCommand("l"));


	}


	@Test
	public void test_r(){

		explorer.getVozilo().setX(1);
		explorer.getVozilo().setY(0);

		String expected = "(" + (explorer.getVozilo().getX()+1) + "," + explorer.getVozilo().getY()  + ")";

		assertEquals(expected,explorer.executeCommand("r"));


	}


	@Test
	public void test_run(){

		explorer.getVozilo().setX(0);
		explorer.getVozilo().setY(0);

		String expected = "(" + (explorer.getVozilo().getX()+2) + "," + (explorer.getVozilo().getY()+1)  + ")";
		explorer.executeCommand("f");
		explorer.executeCommand("r");
		assertEquals(expected,explorer.executeCommand("r"));

	}


}

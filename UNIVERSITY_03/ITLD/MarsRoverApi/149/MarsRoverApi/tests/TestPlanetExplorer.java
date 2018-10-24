import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestPlanetExplorer {
	private PlanetExplorer brod;
	@Test
	public void test_executeCommand() {
		brod=new PlanetExplorer(3,3,"1,1,4,4");
		String nesto = brod.toString();
		assertEquals("Provera pocetnih pozicija", nesto , "(0,0,N)");
	}




}

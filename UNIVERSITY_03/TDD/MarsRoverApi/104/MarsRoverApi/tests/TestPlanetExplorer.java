import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void createPlanetExplorer(){
		PlanetExplorer pe=new PlanetExplorer(100,100,"(5,6),(7,8)");
		assertNotNull(pe);
	}

	@Test
	public void voziloIdeNaSever(){
		PlanetExplorer pe=new PlanetExplorer(100,100,"(5,6),(7,8)");
		String pozicija=pe.executeCommand("f");
		assertEquals("0,1,n",pozicija);
	}
	@Test
	public void voziloIdeNaJug(){
		PlanetExplorer pe=new PlanetExplorer(100,100,"(5,6),(7,8)");
		String pozicija=pe.executeCommand("fb");
		assertEquals("0,0,n",pozicija);
	}


}

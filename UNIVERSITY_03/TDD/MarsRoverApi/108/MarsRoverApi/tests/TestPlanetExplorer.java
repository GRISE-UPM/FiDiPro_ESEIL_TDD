import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void start_rover_at_0_0() {
		PlanetExplorer rover = new PlanetExplorer(0,0,"obs1_x,obs1_y");
		String coordinates = rover.returnCordinates();
		assertEquals("Unexpected rover start coordinates","x=0,y=0,N,obs1_x,obs1_y",coordinates);
	}
	@Test
	public void after_start_press_r() throws PlanetExplorerException{
		PlanetExplorer rover = new PlanetExplorer(0,0,"obs1_x,obs1_y");
		rover.executeCommand("r");
		String coordinates = rover.returnCordinates();
		assertEquals("Rover should face:","x=0,y=0,E,obs1_x,obs1_y",coordinates);
	}
	@Test
	public void after_start_press_rr() throws PlanetExplorerException{
		PlanetExplorer rover = new PlanetExplorer(0,0,"obs1_x,obs1_y");
		rover.executeCommand("rr");
		String coordinates = rover.returnCordinates();
		assertEquals("Rover should face:","x=0,y=0,S,obs1_x,obs1_y",coordinates);
	}
	@Test
	public void after_start_press_rrr() throws PlanetExplorerException{
		PlanetExplorer rover = new PlanetExplorer(0,0,"obs1_x,obs1_y");
		rover.executeCommand("rrr");
		String coordinates = rover.returnCordinates();
		assertEquals("Rover should face:","x=0,y=0,W,obs1_x,obs1_y",coordinates);
	}
	@Test
	public void turn_360() throws PlanetExplorerException{
		PlanetExplorer rover = new PlanetExplorer(0,0,"obs1_x,obs1_y");
		rover.executeCommand("rrrr");
		String coordinates = rover.returnCordinates();
		assertEquals("Rover should face:","x=0,y=0,N,obs1_x,obs1_y",coordinates);
	}
	@Test
	public void turn_360_and_one_extra_turn() throws PlanetExplorerException{
		PlanetExplorer rover = new PlanetExplorer(0,0,"obs1_x,obs1_y");
		rover.executeCommand("rrrrr");
		String coordinates = rover.returnCordinates();
		assertEquals("Rover should face:","x=0,y=0,E,obs1_x,obs1_y",coordinates);
	}
	@Test
	public void start_and_turn_left() throws PlanetExplorerException{
		PlanetExplorer rover = new PlanetExplorer(0,0,"obs1_x,obs1_y");
		rover.executeCommand("l");
		String coordinates = rover.returnCordinates();
		assertEquals("Rover should face:","x=0,y=0,W,obs1_x,obs1_y",coordinates);
	}
	@Test
	public void start_and_turn_left_twice() throws PlanetExplorerException{
		PlanetExplorer rover = new PlanetExplorer(0,0,"obs1_x,obs1_y");
		rover.executeCommand("ll");
		String coordinates = rover.returnCordinates();
		assertEquals("Rover should face:","x=0,y=0,S,obs1_x,obs1_y",coordinates);
	}
	@Test
	public void start_and_turn_left_3times() throws PlanetExplorerException{
		PlanetExplorer rover = new PlanetExplorer(0,0,"obs1_x,obs1_y");
		rover.executeCommand("lll");
		String coordinates = rover.returnCordinates();
		assertEquals("Rover should face:","x=0,y=0,E,obs1_x,obs1_y",coordinates);
	}
	@Test
	public void start_and_turn_360_left_side() throws PlanetExplorerException{
		PlanetExplorer rover = new PlanetExplorer(0,0,"obs1_x,obs1_y");
		rover.executeCommand("llll");
		String coordinates = rover.returnCordinates();
		assertEquals("Rover should face:","x=0,y=0,N,obs1_x,obs1_y",coordinates);
	}

	@Test
	public void start_and_turn_360_left_and_one_extra_turn() throws PlanetExplorerException{
		PlanetExplorer rover = new PlanetExplorer(0,0,"obs1_x,obs1_y");
		rover.executeCommand("lllll");
		String coordinates = rover.returnCordinates();
		assertEquals("Rover should face:","x=0,y=0,W,obs1_x,obs1_y",coordinates);
	}

	@Test(expected = PlanetExplorerException.class)
	public void enter_invalid_command() throws PlanetExplorerException{
		PlanetExplorer rover = new PlanetExplorer(0,0,"obs1_x,obs1_y");
		rover.executeCommand("k");
	}

	@Test
	public void move_forward_after_start() throws PlanetExplorerException{
		PlanetExplorer rover = new PlanetExplorer(10,10,"obs5_x,obs5_y");
		rover.executeCommand("f");
		String coordinates = rover.returnCordinates();
		assertEquals("Rover should face:","x=0,y=1,N,obs5_x,obs5_y",coordinates);
	}
	@Test
	public void move_foward_facing_east() throws PlanetExplorerException{
		PlanetExplorer rover = new PlanetExplorer(10,10,"obs5_x,obs5_y");
		rover.executeCommand("rf");
		String coordinates = rover.returnCordinates();
		assertEquals("Rover should face:","x=1,y=0,E,obs5_x,obs5_y",coordinates);
	}
}

package upm.tdd.training.tests;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import upm.tdd.training.MarsRover;

public class TestRover {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testForwardOnePositionWithoutObstacles_DirectionN() {
		MarsRover rover = new MarsRover(100,100,"??");
		assertEquals("(0,1,N)", rover.executeCommand("f"));
	}
	
	@Test
	public void testForwardTwoPositionWithoutObstacles_DirectionN() {
		MarsRover rover = new MarsRover(100,100,"??");
		assertEquals("(0,2,N)", rover.executeCommand("ff"));
	}
	
	@Test
	public void testBackwardOnePositionWithoutObstacles_DirectionN() {
		MarsRover rover = new MarsRover(100,100,"??");
		rover.setPosition_x(0);
		rover.setPosition_y(1);
		assertEquals("(0,0,N)", rover.executeCommand("b"));
	}
	
	@Test
	public void testTurnRight_DirectionN() {
		MarsRover rover = new MarsRover(100,100,"??");
		assertEquals("(0,0,E)", rover.executeCommand("r"));
	}
	
	@Test
	public void testTurnLeft_DirectionN() {
		MarsRover rover = new MarsRover(100,100,"??");
		assertEquals("(0,0,W)", rover.executeCommand("l"));
	}
	
	@Test
	public void testForwOnePosWObstaclesChangeDirToEast_DirectionN() {
		MarsRover rover = new MarsRover(100,100,"??");
		assertEquals("(0,1,E)", rover.executeCommand("fr"));
	}

}

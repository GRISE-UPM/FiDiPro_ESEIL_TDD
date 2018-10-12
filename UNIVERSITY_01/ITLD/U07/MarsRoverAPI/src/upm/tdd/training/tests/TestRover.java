package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import upm.tdd.training.MarsRover;

public class TestRover {

	MarsRover Rover;
	
	@Test
	public void testSetPositionAndFacing() {
		Rover.setPositionAndFacing(10, 10, 4);	
	}

	@Test
	public void testSetCommand(){
		Rover.setCommands("ffrff");
	}
	
	@Test
	public void testExecuteCommands(){
		String actual;
		actual= Rover.executeCommand("ffrff");
		assertEquals("(0,1,N)",actual);
	}
}

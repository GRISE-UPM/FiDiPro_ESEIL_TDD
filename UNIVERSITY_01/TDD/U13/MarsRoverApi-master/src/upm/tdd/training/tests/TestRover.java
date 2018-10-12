package upm.tdd.training.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import upm.tdd.training.MarsRover;

public class TestRover {

	@Test
	public void createGridTestOnInitialization(){
		MarsRover marsRover = new MarsRover(2, 3, "?(1,1)?");
	}
	
	
	@Test
	public void moveFFTest() {
		MarsRover marsRover = new MarsRover(2, 7, "?(1,1)?");
		String result = marsRover.executeCommand("ff");
		System.out.println(result);
		assertEquals("(0,2)", result);
	}

	@Test
	public void moveBBTest() {
		MarsRover marsRover = new MarsRover(2, 5, "?(1,1)?");
		String result = marsRover.executeCommand("bb");
		assertEquals("(0,4)", result);
	}

	
	@Test
	public void moveFRFTest() {
		MarsRover marsRover = new MarsRover(3, 4, "?(1,1)?");
		String result = marsRover.executeCommand("frf");
		assertEquals("(1,1)", result);
	}
	
	
	@Test
	public void moveBRBTest() {
		MarsRover marsRover = new MarsRover(3, 4, "?(1,1)?");
		String result = marsRover.executeCommand("brb");
		assertEquals("(1,2)", result);
	}

	
	
}

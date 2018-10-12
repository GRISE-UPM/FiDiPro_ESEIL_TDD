package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import upm.tdd.training.MarsRover;

public class TestRover {

	@Test
	public void testForward() {
		
		MarsRover mr = new MarsRover(10,10,"");		
		assertEquals("0,3", mr.executeCommand("fff"));
		
	}

	@Test
	public void testRight() {
		
		MarsRover mr = new MarsRover(100,100,"");		
		assertEquals("0,1", mr.executeCommand("fr"));
		
	}
	
	
	@Test	
	public void testBackward() {		
		MarsRover mr = new MarsRover(100,100,"");		
		assertEquals("0,0", mr.executeCommand("fb"));
		
	}

	@Test	
	public void testLeft() {		
		MarsRover mr = new MarsRover(100,100,"");		
		assertEquals("0,2", mr.executeCommand("ffr"));
		
	}
	
}

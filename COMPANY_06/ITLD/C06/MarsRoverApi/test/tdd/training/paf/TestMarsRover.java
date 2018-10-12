package tdd.training.paf;
import tdd.training.paf.MarsRover;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMarsRover {

	@Test
	public void test() {
		//fail("Not yet implemented");
		MarsRover mr = new MarsRover(0, 0, "");
		assertEquals(mr.executeCommand("fffr"), "(0,3,E)");
	}
	
	@Test
	public void testCreationPosFacing() {
		MarsRover mr = new MarsRover(0, 0, "");
		assertEquals(mr.executeCommand(""), "(0,0,N)");
	}
	
	@Test
	public void testEmptyExecuteCommand() {
		MarsRover mr = new MarsRover(0, 0, "");
		assertEquals(mr.executeCommand(""), "(0,0,N)");
	}
	
	//Test might go invalid.
	@Test
	public void testOneCommand() {
		MarsRover mr = new MarsRover(0, 0, "");
		assertEquals(mr.executeCommand("l"), "(0,0,W)");
	}
	
	//Test might go invalid.
	@Test
	public void testOneCommandCounterClockwiseCompleteRottation() {
		MarsRover mr = new MarsRover(0, 0, "");
		assertEquals(mr.executeCommand("l"), "(0,0,W)");
		assertEquals(mr.executeCommand("l"), "(0,0,S)");
		assertEquals(mr.executeCommand("l"), "(0,0,E)");
		assertEquals(mr.executeCommand("l"), "(0,0,N)");
	}
	
	//Test might go invalid.
	@Test
	public void testOneCommandClockwiseCompleteRottation() {
		MarsRover mr = new MarsRover(0, 0, "");
		assertEquals(mr.executeCommand("r"), "(0,0,E)");
		assertEquals(mr.executeCommand("r"), "(0,0,S)");
		assertEquals(mr.executeCommand("r"), "(0,0,W)");
		assertEquals(mr.executeCommand("r"), "(0,0,N)");
	}
	
	//Test might go invalid.
	@Test
	public void testOneCommandMovements() {
		MarsRover mr = new MarsRover(20, 20, "");
		assertEquals(mr.executeCommand("f"), "(20,21,N)");
		assertEquals(mr.executeCommand("b"), "(20,20,N)");
	}

}

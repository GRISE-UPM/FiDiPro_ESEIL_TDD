package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import upm.tdd.training.MarsRover;

public class TestRover {

	@Test
	public void test() {
		MarsRover rover = new MarsRover(5, 5, "?(5,5)?");
		assertEquals("(0,0,north)", rover.executeCommand("fb"));

		rover = new MarsRover(5, 5, "?(5,5)?");
		assertEquals("(0,1,north)", rover.executeCommand("fbf"));

		rover = new MarsRover(5, 5, "?(5,5)?");
		assertEquals("(0,1,east)", rover.executeCommand("fbfr"));

		rover = new MarsRover(5, 5, "?(5,5)?");
		assertEquals("(2,1,east)", rover.executeCommand("fbfrff"));

		rover = new MarsRover(5, 5, "?(5,5)?");
		assertEquals("(5,1,east)", rover.executeCommand("fbfrfffff"));

		rover = new MarsRover(5, 5, "?(5,5)?");
		assertEquals("(5,4,north)?(5,5)?",
				rover.executeCommand("fbfrffffflffff"));

		rover = new MarsRover(5, 5, "?(5,5)?");
		assertEquals("(0,0,north)", rover.executeCommand("llll"));

		rover = new MarsRover(100, 100, "?(5,5)?");
		assertEquals("(2,2,east)", rover.executeCommand("ffrff"));
		
		rover = new MarsRover(3, 3, "?(2,2)?");
		assertEquals("(0,0,north)", rover.executeCommand("fffrfffrfffrfffr"));
		// fail("Not yet implemented");
	}

}

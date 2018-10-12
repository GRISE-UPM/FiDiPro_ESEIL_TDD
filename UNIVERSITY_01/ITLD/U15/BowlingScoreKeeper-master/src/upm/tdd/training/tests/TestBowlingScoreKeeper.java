package upm.tdd.training.tests;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import upm.tdd.training.Frame;

public class TestBowlingScoreKeeper {

	@Test
	public void test() {
		fail("Not yet implemented");
		
	}
	
	@Test
	public void compareTwoThrows(){
		Frame frame1 = new Frame("First", "Second");
		assertEquals("First", frame1.getLanzamiento1());
		assertEquals("Second2", frame1.getLanzamiento2());
	}

}

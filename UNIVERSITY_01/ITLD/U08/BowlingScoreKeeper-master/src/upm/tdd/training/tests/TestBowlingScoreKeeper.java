package upm.tdd.training.tests;

import static org.junit.Assert.*;
import upm.tdd.training.*;

import java.awt.Frame;

import org.junit.Test;

import junit.framework.TestCase;

public class TestBowlingScoreKeeper {
	

	
	public void addscore()
	{
		assertEquals(8, new Frame().score(2, 6));
		
	}
	@Test
	public int test() {
		
		fail("Not yet implemented");
		return 0;
	}

}

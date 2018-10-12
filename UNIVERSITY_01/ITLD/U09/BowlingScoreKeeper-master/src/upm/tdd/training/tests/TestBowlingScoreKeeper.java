package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowlingScoreKeeper {

	
	@Test
	public void testScore(int score) {
		
		boolean indicador=false;
		
		if (score>=0 && score<=10)
		{
			indicador=true;
		}		
		
		assertEquals(true,indicador);
		
	}

	
	@Test
	public void testStrike(int valor1, int valor2) {
		
		boolean indicador = false;
		
				
		assertEquals(10,valor1);
		assertEquals(0,valor2);
		
	}
	
}

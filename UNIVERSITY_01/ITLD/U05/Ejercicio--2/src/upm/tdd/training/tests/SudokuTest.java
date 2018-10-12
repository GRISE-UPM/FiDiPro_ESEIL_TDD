package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import upm.tdd.training.Sudoku;

public class SudokuTest {
	Sudoku game=null;
	
	@Before
	public void initialize(){
		game=new Sudoku();	
	}
	@Test
	public void testCharacterNumbers() {
		String numbers="a2345678932165498785274196315975346281205478963254125478963215842175236987451240";
		boolean result=game.evaluateDigits(numbers);
		assertTrue(result);
	}
	@Test
	public void testDigits1To9() {
		String numbers="02345678932165498785274196315975346281215478963254125478963215842175236987451241";
		int result=game.saveDigits(numbers);
		assertEquals("It is violatin Rule #1: There should be not digit 0",-1,result);
	}
	@Test
	public void testOnceInSubGrid() {
		String numbers="12345678832165498785274196315975346281205478963254125478963215842175236987451240";
		game.saveDigits(numbers);
		int result=game.verifySubGrid();
		assertEquals("It is violatin Rule #2: Digits 1 to 9 should be only once in a SubGrid",-2,result);
	}
	@Test
	public void testOnceInRowGrid() {
		String numbers="12345678832165498785274196315975346281205478963254125478963215842175236987451240";
		game.saveDigits(numbers);
		int result=game.verifyRowGrid();
		assertEquals("It is violatin Rule #3: Digits 1 to 9 should be only once in a row of Grid",-3,result);
	}
	@Test
	public void testOnceInColumnGrid() {
		String numbers="12345678832165498785274196315975346281205478963254125478963215842175236987451240";
		game.saveDigits(numbers);
		int result=game.verifyColumnGrid();
		assertEquals("It is violatin Rule #4: Digits 1 to 9 should be only once in a row of Grid",-4,result);
	}
	public void TestAllRulers(){
		String numbers="12345678832165498785274196315975346281205478963254125478963215842175236987451240";
		int result=game.verify(numbers);
		if(result==0){
			assertEquals("It is a valid Sudoku solution",0,result);
		}else if(result==-1){
			assertEquals("It is violatin Rule #1: There should be not digit 0",-1,result);
		}else if(result==-2){
			assertEquals("It is violatin Rule #2: Digits 1 to 9 should be only once in a SubGrid",-2,result);
		}else if(result==-3){
			assertEquals("It is violatin Rule #3: Digits 1 to 9 should be only once in a row of Grid",-3,result);
		}else if(result==-4){
			assertEquals("It is violatin Rule #4: Digits 1 to 9 should be only once in a row of Grid",-4,result);
		}
	}
}
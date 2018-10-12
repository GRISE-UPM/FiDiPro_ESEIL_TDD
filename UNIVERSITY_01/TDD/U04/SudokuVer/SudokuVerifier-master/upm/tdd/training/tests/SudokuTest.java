package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import upm.tdd.training.Sudoku;

public class SudokuTest {

	/*@Test
	public void test(){
		Sudoku s=new Sudoku();
		assertEquals(-1,s.verify(""));
	}*/
	
	@Test
	public void testViolatingRuleForZero(){
		String s="123456789123456789123456789123456789123456789123456789123456789123456789123456789";
		Sudoku s1=new Sudoku();
		assertEquals(0,s1.verify(s));
	}
	
	@Test
	public void testViolatingRuleForMinusOne(){
		String s="123456789123456789123456780123456789123456789123456789123456789123456789123456789";
		Sudoku s1=new Sudoku();
		assertEquals(-1,s1.verify(s));
	}
	
	@Test
	public void testViolatingRuleForMinusTwo(){
		String s="123456789123456789123456789123456789123456789123456789123456789123456789123456789";
		Sudoku s1=new Sudoku();
		assertEquals(-3,s1.verify(s));
	}

}
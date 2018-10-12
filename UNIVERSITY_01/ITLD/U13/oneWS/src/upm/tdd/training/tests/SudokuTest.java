package upm.tdd.training.tests;

import org.junit.Test;

import upm.tdd.training.Sudoku;

public class SudokuTest {

	@Test
	public void test() {
		Sudoku sudokuTest = new Sudoku();
		int result = sudokuTest.fullValidation();
		System.out.println("Result: " + result);
	}

	
	
}
package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import upm.tdd.training.Sudoku;

public class SudokuTest {

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	@Test
	public void verifySolutionLenght() {
		Sudoku sudoku = new Sudoku();
		String solution = "987654321123456789987654321123456789987654321123456789987654321123456789987654321";
		assertTrue(sudoku.verifySolutionLength(solution));
	}

	@Test
	public void verifyRowsHasNineEntries() {
		Sudoku sudoku = new Sudoku();
		String solution = "987654321123456789987654321123456789987654321123456789987654321123456789987654321";
		assertTrue(sudoku.fillBoard(solution));

	}

	@Test
	public void verifyGeneralRowHasNotRepeatNumbers() {
		Sudoku sudoku = new Sudoku();
		int value = 9;
		int row = 1;

		String solution = "987654321123456789987654321123456789987654321123456789987654321123456789987654321";
		sudoku.fillBoard(solution);
		assertTrue(sudoku.verifyRow(value, row));

	}

	@Test
	public void verifyGeneralRowHasRepeatNumbers() {
		Sudoku sudoku = new Sudoku();
		int value = 9;
		int row = 2;

		String solution = "987654321123456789987694321123456789987654321123456789987654321123456789987654321";
		sudoku.fillBoard(solution);
		assertFalse(sudoku.verifyRow(value, row));

	}

	@Test
	public void verifyGeneralColumnHasNotRepeatNumbers() {
		Sudoku sudoku = new Sudoku();
		int value = 9;
		int column = 1;

		String solution = "987654321193456789987654321123456789987654321123456789987654321123456789987654321";
		sudoku.fillBoard(solution);
		assertTrue(sudoku.verifyColumn(value, column));

	}

	@Test
	public void verifyGeneralColumnHasRepeatNumbers() {
		Sudoku sudoku = new Sudoku();
		int value = 9;
		int column = 0;

		String solution = "997654321123456789987654321123456789987654321123456789987654321123456789987654321";
		sudoku.fillBoard(solution);
		assertFalse(sudoku.verifyColumn(value, column));

	}

	@Test
	public void checkSubGridThreeDotThreeNotRepeatNumbers() {
		/*
		 * I can´t proved it because I didn´t have a solved sudoku solution.
		 */
		Sudoku sudoku = new Sudoku();
		String solution = "987654321123456789987654321123456789987654321123456789987654321123456789987654321";
		sudoku.fillBoard(solution);
		assertTrue(sudoku.checkSubGrids());
	}

}
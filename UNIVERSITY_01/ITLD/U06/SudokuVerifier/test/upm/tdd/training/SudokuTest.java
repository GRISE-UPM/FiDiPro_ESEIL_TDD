package upm.tdd.training;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {

	@Test
	public void checkReadCandidateSolutionReturnFalseIfTheInputStringLengthIsLowerThan81() {
		Sudoku sudoku = new Sudoku();
		assertEquals(false,sudoku.readCheckLengthCandidateSolution("111"));
	}

	@Test
	public void checkReadCandidateSolutionWorksWithStringOfCharacters() {
		Sudoku sudoku = new Sudoku();
		assertEquals(true,sudoku.readCheckLengthCandidateSolution("a11111111111111111111111111111111111111111111111111111111111111111111111111111111"));
	}
	
	@Test
	public void checkReadCandidateSolutionWorksWithStringOf81Ints() {
		Sudoku sudoku = new Sudoku();
		assertEquals(true,sudoku.readCheckLengthCandidateSolution("111111111111111111111111111111111111111111111111111111111111111111111111111111111"));
	}
	
	@Test
	public void checkR1DetectsA0InTheSolution() {
		Sudoku sudoku = new Sudoku();
		sudoku.readCheckLengthCandidateSolution("011111111111111111111111111111111111111111111111111111111111111111111111111111111");
		assertEquals(false,sudoku.checkR1());
	}
	
	@Test
	public void checkR1ReturnsTrueWithCorrectDigits() {
		Sudoku sudoku = new Sudoku();
		sudoku.readCheckLengthCandidateSolution("123456789456789123789123456123456789456789123789123456123456789456789123789123456");
		assertEquals(true,sudoku.checkR1());
	}
	
	@Test
	public void checkR2DetectsARepeatedDigitInAnySubGridOfTheSolution() {
		Sudoku sudoku = new Sudoku();
		sudoku.readCheckLengthCandidateSolution("111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		assertEquals(false,sudoku.checkR2());
	}
	
	@Test
	public void checkR2ReturnsTrueWithCorrectSubGrids() {
		Sudoku sudoku = new Sudoku();
		sudoku.readCheckLengthCandidateSolution("123456789456789123789123456123456789456789123789123456123456789456789123789123456");
		assertEquals(true,sudoku.checkR2());
	}
	
	@Test
	public void checkR3DetectsARepeatedDigitInAnyRowOfTheSolution() {
		Sudoku sudoku = new Sudoku();
		sudoku.readCheckLengthCandidateSolution("111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		assertEquals(false,sudoku.checkR3());
	}
	
	@Test
	public void checkR3ReturnsTrueWithCorrectRows() {
		Sudoku sudoku = new Sudoku();
		sudoku.readCheckLengthCandidateSolution("123456789456789123789123456123456789456789123789123456123456789456789123789123456");
		assertEquals(true,sudoku.checkR3());
	}
	
	@Test
	public void checkR4DetectsARepeatedDigitInAnyColumnOfTheSolution() {
		Sudoku sudoku = new Sudoku();
		sudoku.readCheckLengthCandidateSolution("123456789456789123789123456123456789456789123789123456123456789456789123789123456");
		assertEquals(false,sudoku.checkR4());
	}
	
	@Test
	public void checkR4ReturnsTrueWithCorrectColumns() {
		Sudoku sudoku = new Sudoku();
		sudoku.readCheckLengthCandidateSolution("111111111222222222333333333444444444555555555666666666777777777888888888999999999");
		assertEquals(true,sudoku.checkR4());
	}
	
	@Test
	public void checkVerifyReturnsMinus1WithASolutionViolatingR1() {
		Sudoku sudoku = new Sudoku();
		assertEquals(-1,sudoku.verify("011111111111111111111111111111111111111111111111111111111111111111111111111111111"));
	}
	
	@Test
	public void checkVerifyReturnsMinus2WithASolutionViolatingR2() {
		Sudoku sudoku = new Sudoku();
		assertEquals(-2,sudoku.verify("111111111111111111111111111111111111111111111111111111111111111111111111111111111"));
	}
	
	@Test
	public void checkVerifyReturnsMinus3WithASolutionViolatingR3() {
		Sudoku sudoku = new Sudoku();
		assertEquals(-3,sudoku.verify("123123123456456456789789789123123123456456456789789789123123123456456456789789789"));
	}
	
	@Test
	public void checkVerifyReturnsMinus4WithASolutionViolatingR4() {
		Sudoku sudoku = new Sudoku();
		assertEquals(-4,sudoku.verify("123456789456789123789123456123456789456789123789123456123456789456789123789123456"));
	}
	
	@Test
	public void checkVerifyReturns0WithValidSolution() {
		Sudoku sudoku = new Sudoku();
		assertEquals(0,sudoku.verify("123456789456789123789123456234567891567891234891234567345678912678912345912345678"));
	}
	
}
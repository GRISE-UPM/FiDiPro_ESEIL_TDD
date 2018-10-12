package upm.tdd.training;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
	}
	@Test
	public void ReadSolution() {
		Sudoku mySudoku = new Sudoku ();
		equals(mySudoku.verify("81"));
		

	}

}
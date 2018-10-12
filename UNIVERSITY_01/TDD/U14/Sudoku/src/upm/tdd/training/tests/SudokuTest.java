package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import upm.tdd.training.Sudoku;

public class SudokuTest {

	@Test
	public void StringIsACandidateSolution() {
		String candidatesolution = "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
		Sudoku sudokugame = new Sudoku();
		int result = sudokugame.candidateSolutionIsValid(candidatesolution);
		assertEquals(1,result);
	}
	
	@Test
	public void StringIsANotCandidateSolution() {
		String candidatesolution = "456789123456789123456789123456789123456789123456789123456789123456789123456789";
		Sudoku sudokugame = new Sudoku();
		int result = sudokugame.candidateSolutionIsValid(candidatesolution);
		assertEquals(0,result);
	}
	
	@Test
	public void CandidateSolutionNotAccomplishRule1(){
		String candidatesolution = "-12345678912345678912345678912345678912345678912345678912345678912345678912345678";
		Sudoku sudokugame = new Sudoku();
		int result = sudokugame.verify(candidatesolution);
		assertEquals(-1,result);
	}
	
	@Test
	public void CandidateSolutionAccomplishRule1(){
		String candidatesolution = "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
		Sudoku sudokugame = new Sudoku();
		int result = sudokugame.verify(candidatesolution);
		assertEquals(0,result);
	}
	
	@Test
	public void CandidateSolutionNotAccomplishRule2(){
		String candidatesolution = "113456789123456789123456789123456789123456789123456789123456789123456789123456789";
		Sudoku sudokugame = new Sudoku();
		int result = sudokugame.verify(candidatesolution);
		assertEquals(-2,result);
	}
	

}
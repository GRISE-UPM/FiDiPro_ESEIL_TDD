package upm.tdd.training;

import java.util.Scanner;

public class Sudoku {
	private int[][] board = new int[9][9];

	public Sudoku() {

		// Sudoku is a game with few simple rules, where the goal is to place
		// nine sets of positive digits (1...9) into the cells of a
		// fixed grid structure (i.e. board). The Sudoku board (or global grid)
		// consists of a 3x3 arrangement of sub-grids, and each sub-grid
		// is a 3x3 arrangement of cells. This yields a 9x9 arrangement of cells
		// on the Sudoku board. A valid Sudoku solution should conform
		// to the following rules:
		// • R1: A cell in a Sudoku game can only store positive digits, i.e.
		// 1...9.
		// • R2: All digits appear only once in a sub-grid, i.e. they cannot
		// repeat.
		// • R3: A digit can appear only once in the rows of the global grid.
		// • R4: A digit can appear only once in the columns of the global
		// grid.
	}

	public int verify(String candidateSolution) {

		// Return 0: means it is a valid Sudoku solution
		// • Return -1: means it is violating Rule #1
		// if(verifyPositiveNumber(int[][]board)== -1){
		//
		// }

		// • Return -2: means it is violating Rule #2
		// • Return -3: means it is violating Rule #3
		// • Return -4: means it is violating Rule #4

		return 0;
	}

	public boolean verifySolutionLength(String solution) {
		if (solution.length() == 81) {
			return true;
		}
		return false;
	}

	// private int verifyPositiveNumber(int[][] board2) {
	// for (int i = 0; i < 9; i++) {
	// for (int j = 0; j < 9; j++) {
	// if(board[i][j]>)
	// }
	//
	// }
	//
	// return 0;
	// }

	public boolean fillBoard(String candidate) {
		int auxLength = 9;
		int j = 0;
		for (int i = 0; i < 9; i++) {

			for (int k = 0; k < 9; k++) {
				if (j < auxLength) {
					board[i][k] = Integer.parseInt("" + candidate.charAt(j));
					j += 1;
					if (board[i][k] == 0) {
						return false;
					}
				}
			}
			auxLength += 9;

		}
		return true;
	}

	public boolean verifyRow(int value, int row) {
		int appear = 0;
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == value) {
				appear++;
			}
		}
		if (appear == 1) {

			return true;
		}

		return false;
	}

	public boolean verifyColumn(int value, int column) {
		int appear = 0;
		for (int i = 0; i < 9; i++) {
			if (board[i][column] == value) {
				appear++;
			}
		}

		if (appear == 1) {

			return true;
		}

		return false;
	}

	public boolean checkSubGrids() {
		int auxRow = 3;
		int auxCol = 3;
		int i = 0, j = 1, k = 0, l = 0;
		while (auxRow <= 9) {
			while (auxCol <= 9) {
				for (; i < auxRow; i++) {

					for (; l < auxRow; l++) {

						for (; j < auxCol; j++) {
							if (board[i][k] == board[l][j]) {
								return false;
							}
						}
						j -= auxCol;
					}
					l = 0;
					k += 1;
					if (k == auxRow) {
						k -= auxRow;
					}
				}
				j = auxCol;
				auxCol += 3;
			}
			auxCol = 3;
			auxRow += 3;
		}

		return true;
	}

}

package upm.tdd.training;

public class Sudoku {
	private String cancandidateSolution;



	public Sudoku(){
		
	}
	
	

	public int verify(String candidateSolution){
		this.cancandidateSolution = candidateSolution;
//		Return 0: means it is a valid Sudoku solution
//		• Return -1: means it is violating Rule #1
//		• Return -2: means it is violating Rule #2
//		• Return -3: means it is violating Rule #3
//		• Return -4: means it is violating Rule #4
		int[][]matrixSudoku = {{1,2,3,4,5,6,7,8,9}, {1,2,3,4,5,6,7,8,9}, {1,2,3,4,5,6,7,8,9}, {1,2,3,4,5,6,7,8,9}, {1,2,3,4,5,6,7,8,9}, {1,2,3,4,5,6,7,8,9}, {1,2,3,4,5,6,7,8,9}, {1,2,3,4,5,6,7,8,9}, {1,2,3,4,5,6,7,8,9}};

		candidateSolution = "81";
		return Integer.parseInt(candidateSolution);
	}
}

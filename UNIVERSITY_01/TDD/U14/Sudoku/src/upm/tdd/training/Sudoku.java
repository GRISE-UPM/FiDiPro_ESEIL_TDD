package upm.tdd.training;

public class Sudoku {
	public Sudoku(){
	
//			Sudoku is a game with few simple rules, where the goal is to place nine sets of positive digits (1...9) into the cells of a 
//			fixed grid structure (i.e. board). The Sudoku board (or global grid) consists of a 3x3 arrangement of sub-grids, and each sub-grid 
//			is a 3x3 arrangement of cells. This yields a 9x9 arrangement of cells on the Sudoku board. A valid Sudoku solution should conform 
//			to the following rules:
//			• R1: A cell in a Sudoku game can only store positive digits, i.e. 1...9.
//			• R2: All digits appear only once in a sub-grid, i.e. they cannot repeat.
//			• R3: A digit can appear only once in the rows of the global grid.
//			• R4: A digit can appear only once in the columns of the global grid.
	}
	
	public int verify(String candidateSolution){
		int result = candidateSolutionIsValid(candidateSolution);
		int response = 1;
		int band = -1;
		String subgrid1, subgrid2, subgrid3;
		if (result == 1){
			//Rule 1
			if (!candidateSolution.matches("[1-9]+")){
				response = -1;
			}else {
				String row1 = candidateSolution.substring(0,8);
				boolean contieneRepetidos = containsReapeatCharacters(row1);
				if (contieneRepetidos)
					response = -3;
				else
					response = 0;
				
			}
				
		} else
			response = -5;
			
		return response;
		
		
	}

	public boolean containsReapeatCharacters(String str){
				
		if (str.matches("1+"))
	    	return true;
	    else
	    	return false;
	}
	
	public int candidateSolutionIsValid(String candidatesolution) {
		int candidateLenght = candidatesolution.length();
		if ( candidateLenght ==81 )	
			return 1;
		else
			return 0;
	}
}

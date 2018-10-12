package upm.tdd.training;

public class Sudoku {
	private int[][] grid;
	public Sudoku(){
	
//			Sudoku is a game with few simple rules, where the goal is to place nine sets of positive digits (1...9) into the cells of a 
//			fixed grid structure (i.e. board). The Sudoku board (or global grid) consists of a 3x3 arrangement of sub-grids, and each sub-grid 
//			is a 3x3 arrangement of cells. This yields a 9x9 arrangement of cells on the Sudoku board. A valid Sudoku solution should conform 
//			to the following rules:
//			• R1: A cell in a Sudoku game can only store positive digits, i.e. 1...9.
//			• R2: All digits appear only once in a sub-grid, i.e. they cannot repeat.
//			• R3: A digit can appear only once in the rows of the global grid.
//			• R4: A digit can appear only once in the columns of the global grid.
		grid = new int[9][9];
	}
	
	public int verify(String candidateSolution){
		
//		Return 0: means it is a valid Sudoku solution
//		• Return -1: means it is violating Rule #1
//		• Return -2: means it is violating Rule #2
//		• Return -3: means it is violating Rule #3
//		• Return -4: means it is violating Rule #4
		readCheckLengthCandidateSolution(candidateSolution);
		
		if(!checkR1()){
			return -1;
		}
		else if(!checkR2()){
			return -2;
		}
		else if(!checkR3()){
			return -3;
		}
		else if(!checkR4()){
			return -4;
		}
		
		return 0;
	}
	
	public boolean readCheckLengthCandidateSolution(String candidateSolution){
		if(candidateSolution.length()==81){
			int index=0;
			try{
				for (int i=0; i<9; i++){
					for (int j=0; j<9; j++){
						grid[i][j]=Integer.parseInt(String.valueOf(candidateSolution.charAt(index)));
						index++;
					}
				}
			}
			catch(Exception e){
				System.out.println("ERROR: Unable to transform into an integer");
			}
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean checkR1(){
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				if(grid[i][j]==0){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkR2(){
		int[] subGrid=new int[9];
		for(int colGridIndex=0;colGridIndex<9;colGridIndex=colGridIndex+3){
			for(int rowGridIndex=0;rowGridIndex<9;rowGridIndex=rowGridIndex+3){
				for(int i=colGridIndex; i<colGridIndex+3;i++){
					for(int j=rowGridIndex; j<rowGridIndex+3;j++){
						if(subGrid[grid[i][j]-1]==1){
							return false;
						}
						else{
							subGrid[grid[i][j]-1]=1;
						}
					}
				}
				subGrid=new int[9];
			}
		}
		
		return true;
	}
	
	public boolean checkR3(){
		int[] row=new int[9];
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				if(row[grid[i][j]-1]==1){
					return false;
				}
				else{
					row[grid[i][j]-1]=1;
				}
			}
			row=new int[9];
		}
		return true;
	}
	
	public boolean checkR4(){
		int[] col=new int[9];
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				if(col[grid[j][i]-1]==1){
					return false;
				}
				else{
					col[grid[j][i]-1]=1;
				}
			}
			col=new int[9];
		}
		return true;
	}

}

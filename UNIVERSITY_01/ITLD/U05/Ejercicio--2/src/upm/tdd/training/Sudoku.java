package upm.tdd.training;

public class Sudoku {
	private int [][] grid =null;
	private int[] digits={0,0,0,0,0,0,0,0,0};//each position is a digit and 0= not exist
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
	public boolean evaluateDigits(String input){
		boolean flag = true;
		if(input.length()==81){
			for(int k=0;k<81&&flag;k++){
				try{
					Integer.parseInt(input.charAt(k)+"");
				}catch(NumberFormatException ex){
					flag=false;
				}
			}
		}
		return flag;
	}

	public int saveDigits(String input){
		int k=0,digit=0;
		int flag=0;
		for(int i=0;i<9&&flag==0;i++)
			for(int j=0;j<9&&flag==0;j++){
				digit=Integer.parseInt(input.charAt(k)+"");
				if(digit>0)
					grid[i][j]=digit;
				else
					flag=-1;
			}
		return flag;
	}

	private void toZero() {
		for(int i=0;i<9;i++)
			digits[i]=0;
	}
	public int verifySubGrid(){
		int flag=0,d,k=0;
		for(int x=0;x<3;x++){
			for(int i=k;i<(k+3)&&flag==0;i++)
				for(int j=k;j<(k+3)&&flag==0;j++){
					d=grid[i][j]-1;//get a digit i.e; 2
					if(digits[d]==0){//if digit[2]==0 then only there is Once 2.
						digits[d]=1;
					}else
						flag=-2;
				}
			toZero();
			k=k+3;
		}
		return flag;
	}
	public int verifyRowGrid(){
		int flag=0,d;
		for(int i=0;i<9&&flag==0;i++){
			for(int j=0;j<9&&flag==0;j++){
				d=grid[i][j]-1;//get a digit i.e; 2
				if(digits[d]==0){//if digit[2]==0 then only there is Once 2.
					digits[d]=1;
				}else
					flag=-3;
			}
			toZero();
		}
		return flag;

	}
	public int verifyColumnGrid(){
		int flag=0,d;
		for(int j=0;j<9&&flag==0;j++){
			for(int i=0;i<9&&flag==0;i++){
				d=grid[i][j]-1;//get a digit i.e; 2
				if(digits[d]==0){//if digit[2]==0 then only there is Once 2.
					digits[d]=1;
				}else
					flag=-4;
			}
			toZero();
		}
		return flag;

	}
	public int verify(String candidateSolution){
		//		Return 0: means it is a valid Sudoku solution
		//		• Return -1: means it is violating Rule #1
		//		• Return -2: means it is violating Rule #2
		//		• Return -3: means it is violating Rule #3
		//		• Return -4: means it is violating Rule #4
		int R=0,R1=0,R2=0,R3=0,R4=0;
		if(evaluateDigits(candidateSolution)){
			R1=saveDigits(candidateSolution);
			R2=verifySubGrid();
			R3=verifyRowGrid();
			R4=verifyColumnGrid();
			if(R1==-0&&R2==0&&R3==0&&R4==0)
				R=0;
			else if(R1==-1){
				R=R1;
			}else if(R2==-2){
				R=R2;
			}else if(R3==-3){
				R=R3;
			}else if(R4==-4){
				R=R4;
			}
		}
		return R;
	}
}

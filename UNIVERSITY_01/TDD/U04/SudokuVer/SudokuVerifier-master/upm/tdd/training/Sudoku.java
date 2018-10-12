package upm.tdd.training;
	
public class Sudoku {
	
	public Sudoku(){
		//grid[][]="";
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
		int grid[][]=new int[9][9];
		int i=0,j=0,p=0,sum=0,k=0,c1=0,c2=0;
		int l=1;
		//int arr[]=new int[9];
//		Return 0: means it is a valid Sudoku solution
//		• Return -1: means it is violating Rule #1
//		• Return -2: means it is violating Rule #2
//		• Return -3: means it is violating Rule #3
//		• Return -4: means it is violating Rule #4
		int len=candidateSolution.length();
		for(i=0;i<=8;i++){
			for(j=0;j<=8;j++){
				grid[i][j]=Character.getNumericValue(candidateSolution.charAt(p));
				p++;
			}
		}
		for(i=0;i<=8;i++){
			int arr[]={0,0,0,0,0,0,0,0,0};
			for(j=0;j<=8;j++){
				arr[grid[i][j]-1]++;
				c1=c1+arr[j];
			}
		}
		for(j=0;j<=8;j++){
			int arr[]={0,0,0,0,0,0,0,0,0};
			for(i=0;i<=8;i++){
				arr[grid[i][j]-1]++;
				c2=c2+arr[j];
			}
		}
		/*String row[]=new String[9];
		String col[]=new String[9];
		String s1="";
		String s2="";
		for(i=0;i<=8;i++){
			for(j=0;j<=8;j++)
				s1=s1+grid[i][j];
			row[i]=s1;
		}
		for(j=0;j<=8;j++){
			for(i=0;i<=8;i++)
				s2=s2+grid[i][j];
			col[j]=s1;
		}*/
		for(i=0;i<=8;i++){
			for(j=0;j<=8;j++){
				k=grid[i][j];
				if(k>=1 && k<=9)
					sum=sum+1;
			}
		}
		if(len==81 || (sum==81 && c1==81))
			l=0;
		else if(sum!=81 || (len==81 && c1==81))
			l=-1;
		else if(c1!=81 ||(len==81 && sum!=81))
			l=-3;
		return l;
	}
}

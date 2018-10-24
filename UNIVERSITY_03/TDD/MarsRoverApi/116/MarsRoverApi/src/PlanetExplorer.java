




public class PlanetExplorer {
	private int[][] grid;
	private char actualFace;
	private int actualPositionX;
	private int actualPositionY;
	private int maxX;
	private int maxY;
	private String obstacles = "";
	private final static char N = 'N';
	private final static char S = 'S';
	private final static char E = 'E';
	private final static char W = 'W';

	private boolean checkOstacoles(int x, int y) {
		if (!(x > maxX || y > maxY || x < 0 || y < 0)) {
			if (grid[x][y] == -1) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public int[][] getGrid(){
		return grid;
	}


	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  


	 *		grid = new int[x][y];
		actualPositionX = 0;
		actualPositionX = 0;
		grid[actualPositionX][actualPositionY] = 1;
		actualFace = N;
		maxX = x - 1;
		maxY = y - 1;

		if (obstacles != null) {
			setObstacles(obstacles);
		}




	}
	private void setObstacles(String obstacles) {

		char[] obstaclesA = obstacles.toCharArray();
		for (int i = 0; i < obstacles.length() - 1; i++) {
			if (obstaclesA[i] == '(') {

				int x = Integer.valueOf(String.valueOf(obstaclesA[i + 1]));
				int y = Integer.valueOf(String.valueOf(obstaclesA[i + 3]));

				grid[x][y] = -1;
				this.obstacles = "(" + x + "," + y + ")";

			}
		}

	}



	public String executeCommand(String command) {


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		char commandA[] = command.toCharArray();
		for (char c : commandA) {

			if (c == 'l') {
				if (actualFace == N) {
					actualFace = S;
				} else if (actualFace == S) {
					actualFace = N;
				} else if (actualFace == E) {
					actualFace = W;
				} else if (actualFace == W) {
					actualFace = E;
				}

			}

			else if (c == 'r') {
				if (actualFace == N) {
					actualFace = E;
				} else if (actualFace == E) {
					actualFace = S;
				} else if (actualFace == S) {
					actualFace = W;
				} else if (actualFace == W) {
					actualFace = N;
				}
			}

			else if(c== 'f'){
				if(actualFace== N){

					if (actualPositionY + 1 > maxY && !checkOstacoles(actualPositionX, 0)) {
						grid[actualPositionX][actualPositionY] = 0;
						actualPositionY = 0;
						grid[actualPositionX][actualPositionY] = 1;

				}else if (!checkOstacoles(actualPositionX, actualPositionY + 1)) {
					grid[actualPositionX][actualPositionY] = 0;
					actualPositionY++;
					grid[actualPositionX][actualPositionY] = 1;
					}
				}
			}
				if(actualFace==S){
					if (actualPositionY - 1 < 0 && !checkOstacoles(actualPositionX, maxY)) {
						grid[actualPositionX][actualPositionY] = 0;
						actualPositionY = maxY;
						grid[actualPositionX][actualPositionY] = 1;
				}
					else if (!checkOstacoles(actualPositionX, actualPositionY - 1)) {
						grid[actualPositionX][actualPositionY] = 0;
						actualPositionY--;
						grid[actualPositionX][actualPositionY] = 1;
				}
				}
				return null;
}
	}}


package upm.tdd.training;

public class MarsRover {
	
	public static final String DIRECTION_N = "N";
	public static final String DIRECTION_S = "S";
	public static final String DIRECTION_E = "E";
	public static final String DIRECTION_W = "W";
	
	public static final String COMMAND_F = "f";
	public static final String COMMAND_B = "b";
	public static final String COMMAND_L = "l";
	public static final String COMMAND_R = "r";
	
	
	private Integer[][] grid;
	private Integer currentPositionX = 0;
	private Integer currentPositionY = 0;
	private String currentDirection = DIRECTION_N;
	
	public MarsRover(int x, int y, String obstacles){
		grid = new Integer[x][y];
		
		for(int i=0; i<x; i++){
			for(int j=0; j<y; j++)
				grid[i][j] = 0;
		}
		
		/*
		while(obstacles.length()==0){
			
		}*/
		
		
		//add obstacles
		
		
		
		
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: ?(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)? with no white spaces. 
	 *  
		Example use:
		MarsRover rover = new MarsRover(100,100,?(5,5)(7,8)?)  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands 
		 * "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: ?(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)?  
		 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		
		moveInGrid(command);
		
		return "(" + currentPositionX + "," + currentPositionY + ")";
	}

	private void moveInGrid(String command) {
		String movement = "";
		for(int i=0; i<command.length(); i++){
			movement = Character.toString(command.charAt(i));
			makeMovement(movement);
		}
	}

	private void makeMovement(String singleCommand) {
		int absoluteMovement = 0;
		if(singleCommand.equals(COMMAND_F)||singleCommand.equals(COMMAND_B)){
			absoluteMovement = (singleCommand.equals(COMMAND_F)) ? 1 : -1;

			if(currentDirection.equals(DIRECTION_N) || currentDirection.equals(DIRECTION_S)){
				if(currentPositionY + absoluteMovement> grid[0].length){
					currentPositionY = 0;
				}else if(currentPositionY + absoluteMovement< 0){
					currentPositionY = grid[0].length;
				}else{
					currentPositionY += absoluteMovement;
				}
			}else{
				if(currentPositionX + absoluteMovement> grid[0].length){
					currentPositionX = 0;
				}else if(currentPositionX + absoluteMovement< 0){
					currentPositionX = grid[0].length;
				}else{
					currentPositionX += absoluteMovement;
				}
			}
		}else{
			if(singleCommand.equals(COMMAND_R)){
				if(currentDirection.equals(DIRECTION_N)){
					currentDirection = DIRECTION_E;
				}else if(currentDirection.equals(DIRECTION_E)){
					currentDirection = DIRECTION_S;
				}else if(currentDirection.equals(DIRECTION_S)){
					currentDirection = DIRECTION_W;
				}else if(currentDirection.equals(DIRECTION_W)){
					currentDirection = DIRECTION_N;
				}	
			}else{
				if(currentDirection.equals(DIRECTION_N)){
					currentDirection = DIRECTION_W;
				}else if(currentDirection.equals(DIRECTION_E)){
					currentDirection = DIRECTION_N;
				}else if(currentDirection.equals(DIRECTION_S)){
					currentDirection = DIRECTION_E;
				}else if(currentDirection.equals(DIRECTION_W)){
					currentDirection = DIRECTION_S;
				}	
			}
			
		}
	}
}

package upm.tdd.training;

public class MarsRover {
	//constants
	private static final char NORTH ='N';
	private static final char EAST = 'E';
	private static final char SOUTH ='S';
	private static final char WEST = 'W';
	
	private static final char RIGHT = 'r';
	private static final char FORWARD = 'f';
	private static final char BACKWARD = 'b';
	private static final char LEFT = 'l';
	
	// grid
	int heght, width;
	// obstacles
	String obstacles;
	// current position
	int posX, posY;
	char facing; 
	
	
	public MarsRover(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: ?(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)? with no white spaces. 
	 *  
		Example use:
		MarsRover rover = new MarsRover(100,100,?(5,5)(7,8)?)  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		this.width = x;
		this.heght = y;
		this.obstacles = obstacles;
		
		this.posX = this.posY = 0;
		this.facing = NORTH;
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: ?(x,y,facing)(o1_x,o1_y)?  
		 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		for (int i = 0; i < command.length(); i++)
		{
			int prevX=posX, prevY=posY;
			
			
			if (command.charAt(i)== FORWARD) {
				switch (facing) {
				case NORTH:
					posY++;
					break;
				case EAST:
					posX++;
					break;
				case SOUTH:
					posY--;
					break;
				case WEST:
					posX--;
					break;
				}
				
			}
			else if (command.charAt(i)== BACKWARD) {
				switch (facing) {
				case NORTH:
					posY--;
					break;
				case EAST:
					posX--;
					break;
				case SOUTH:
					posY++;
					break;
				case WEST:
					posX++;
					break;
				}
			}
			else if (command.charAt(i)==RIGHT ) 
			{
				if (facing == NORTH) {
					facing = EAST;
				}else if (facing == EAST) {
					facing = SOUTH;
				}else if (facing == SOUTH) {
					facing = WEST;
				}else if (facing == WEST) {
					facing = NORTH;
				}
			}
			else if (command.charAt(i)==LEFT ) 
			{
				if (facing == NORTH) {
					facing = WEST;
				}else if (facing == EAST) {
					facing = NORTH;
				}else if (facing == SOUTH) {
					facing = EAST;
				}else if (facing == WEST) {
					facing = SOUTH;
				}
			}
			
			//Edges
			
			if (posX==-1) {
				posX = width-1;
			}else if (posX==width) {
				posX = 0;
			}
			
			if (posY==-1) {
				posY = heght-1;
			}else if (posY==heght) {
				posY = 0;
			}
			
			// Obstacles
			
			if (obstacles.contains("("+posX+","+posY+")")) {
				//obstacle found! reverse! finish!
				posX = prevX;
				posY  = prevY;
			}
		}
		
		String output = getCurrentPosition();
		String obstacle = "";
		if ((!"".equals(obstacle )) && obstacle != null) {
			output += "("+obstacle+")";
		}
		return "?"+output+"?";
	}

	public  String getCurrentPosition() {
		String output = "("+posX+","+posY+","+facing+")"; 
		return output;
	}

	private String getLongName(char aFacingValue) {
		switch (aFacingValue) {
		case NORTH:
			return "NORTH";
		case EAST:
			return "EAST";
		case SOUTH:
			return "SOUTH";
		case WEST:
			return "WEST";
		default:
			return "INVALID";
		}
	}
}

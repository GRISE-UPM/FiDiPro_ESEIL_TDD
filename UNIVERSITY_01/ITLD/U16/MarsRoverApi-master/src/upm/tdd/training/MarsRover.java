package upm.tdd.training;

public class MarsRover {
	private int point_x;
	private int point_y;
	private String Obstacles;
	
	private int posX_Current=0;
	private int posY_Current=0;
	private String direction = "N";
	
	public void setPosition_x(int x){
		this.posX_Current = x;
	}
	
	public void setPosition_y(int y){
		this.posY_Current = y;
	}
	
	public int getPosition_x(){
		return this.posX_Current;
	}
	
	public int getPosition_y(){
		return this.posY_Current;
	}
	
	public MarsRover(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: ?(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)? with no white spaces. 
	 *  
		Example use:
		MarsRover rover = new MarsRover(100,100,?(5,5)(7,8)?)  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		this.point_x = x;
		this.point_y = y;
		this.Obstacles = obstacles;
		this.posX_Current=0;
		this.posY_Current=0;
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: ?(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)?  
		 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		
		String tempCommand;
		
		for (int i=0; i < command.length(); i++){
			tempCommand = command.substring(i,i);
			
			if (command.equals("f")){
				//Verificar si hay un obstáculo antes de mover el rover
				//newPosition = posY_Current + 1;
				//if (No_Obstacle){
				if (this.direction.equals("N")){
					this.posY_Current+=1;
				}
				if (this.direction.equals("S"))
					posY_Current-=1;
				else if (this.direction.equals("E"))
					posX_Current+=1;
				else if (this.direction.equals("W"))
					posX_Current-=1;
				//}
			}
			else if (tempCommand.equals("b")){
				//Verificar si hay un obstáculo antes de mover el rover
				//newPosition = posY_Current + 1;
				//if (No_Obstacle){
				if (this.direction.equals("N"))
					posY_Current-=1;
				else if (this.direction.equals("S"))
					posY_Current+=1;
				else if (this.direction.equals("E"))
					posX_Current-=1;
				else if (this.direction.equals("W"))
					posX_Current+=1;
				//}
			}
			else if (tempCommand.equals("r")){
				this.direction = "E";
			}
			else if (tempCommand.equals("l")){
				this.direction = "W";
			}
		} // End For
		
		return "(" + Integer.toString(posX_Current) + "," + Integer.toString(posY_Current) + "," + this.direction + ")";

	}
}

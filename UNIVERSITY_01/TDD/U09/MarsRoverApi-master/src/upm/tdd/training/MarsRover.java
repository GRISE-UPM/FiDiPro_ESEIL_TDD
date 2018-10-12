package upm.tdd.training;

public class MarsRover {
	int sizeX;
	int sizeY;
	
	int x;
	int y;
	
	int facing ; // 1: North; 2: South;  3: West;  4: East 
	String obstacles;
	
	
	public MarsRover(int x1, int y1, String obstacles){
		
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: ?(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)? with no white spaces. 
	 *  
		Example use:
		MarsRover rover = new MarsRover(100,100,?(5,5)(7,8)?)  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		this.x=0;
		this.y=0;
		
		facing=1;// 1: North; 2: South;  3: West;  4: East 
		sizeX=x1;
		sizeY=y1;
		
	}
	


	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: ?(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)?  
		 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		
		String comando="";
		
		for (int i=0;(i<command.length());i++)
		{			
			comando=command.substring(i, i+1);			
			
			if (comando.compareTo("f") == 0) //forward
			{
				switch (facing)
				{	
					case 1: //North
							y++;					
							break;
					case 2: //South
							y++;
							break;				
					case 3: //West
							facing=1;
							break;
				
					case 4: //4: East 
							
							facing=1;
							break;
				}// switch
						
			}//if
			else if (comando.compareTo("r") == 0) //right
			{
				switch (facing)
				{		
					case 1://North
			
						facing=4;					
						break;
					case 2://South
						facing=4;	
						break;				
			
					case 3://West
						facing=4;	
						break;
			
					case 4://4: East
				
						x++;
						break;
						
					}// switch
			
			}//elseif
		
			else if (comando.compareTo("b") == 0) //backward
			{
				switch (facing)
				{		
					case 1://North
			
						y--;		
						break;
					case 2://South
						
						y--;
						break;				
			
					case 3://West
						facing=2;
						break;
			
					case 4: //4: East
				
						x++;
						break;
						
				}// switch
		
						
			}//elseif

			else if (comando.compareTo("l") == 0) //Left
			{
				switch (facing)
				{		
				case 1://North
					facing=3;
					
					break;
				case 2://South
					facing=3;
					break;				
			
				case 3://West
					x--;
					break;
			
				case 4: //4: East
					facing=3;
				
					break;
						
				}// switch
					
			}//elseif
		
		
		
			// cases where is out of grid
			if (y<0) y++;
			if (y>(sizeY -1)) y--;
			if (x<0) x++;
			if (x>(sizeX-1)) x--;
		
		}//for	
		
		
		String Resultado = Integer.toString(x).trim()+ "," + Integer.toString(y).trim();

		
		
		return Resultado;
		
	}// void execute command
}

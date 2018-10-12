package upm.tdd.training;

public class MarsRover {
	
	    public Integer N = 1;
	    public Integer E = 2;
	    public Integer S = 3;
	    public Integer W = 4;
	    public Integer x = 0;
	    public Integer y = 0;
	    public Integer facing = N;
	    public MarsRover Rover;
		public String command;
	    
	  	
	public MarsRover(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: ?(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)? with no white spaces. 
	 *  
		Example use:
		MarsRover rover = new MarsRover(100,100,?(5,5)(7,8)?)  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		int fila=x;
		int columna=y;
		String obstaculos= obstacles;
		int [][] grid = new int [fila][columna];
		String[] ObstacleElements = obstaculos.split(")");
		String txt;
		String []ObstacleCoord= new String[2];
		int[][]ObstacleMatrix= new int[ObstacleElements.length][2];
		int ObstX;
		int ObstY;
		
		for(int i=0;i<ObstacleElements.length; i++){
			txt = ObstacleElements[i];
			txt = txt.replace("(",",");
			ObstacleElements[i]= txt;
		}
		
		for(int i=0;i<ObstacleElements.length; i++){
			txt = ObstacleElements[i];
			ObstacleCoord= txt.split(",");
			ObstacleMatrix[i][0]= Integer.parseInt(ObstacleCoord[0]);
		}
		
		for(int i=0;i<ObstacleMatrix.length;i++){
			for(int j=0; j< ObstacleMatrix[0].length;j++){
				//
			}
		}
		
		
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: ?(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)?  
		 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		
		String comandos=command;
		char []ruta = comandos.toCharArray();
		char movimiento;
		String result;
		
		for (int i=0;i<ruta.length;i++){
			movimiento= ruta[i];
			switch(movimiento){
			case 'f':
			switch (facing)
				{
				case N:
					y=y+1;
					break;
				case S:
					y=y-1;
					break;
				case W:
					x=x+1;
					break;
				case E:
					x=x-1;
					break;
				}
				break;

			case 'b':
				y=y-1;
				break;

			case 'l':
				facing=W;
				break;

			case 'r':
				facing=E;
				break;

			}
			
		}	
		result="("+x+","+y+","+facing+")";
		return result;
		
		
		
	}
   
	
	
	public void setPositionAndFacing(int x, int y, int facing){
		this.x=x;
		this.y=y;
		this.facing=facing;
	}
	
	public void setCommands (String ruta){
		this.command=ruta;
	}

}

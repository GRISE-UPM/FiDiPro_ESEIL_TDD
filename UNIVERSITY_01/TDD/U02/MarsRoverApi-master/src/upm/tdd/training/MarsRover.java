package upm.tdd.training;

public class MarsRover {
	int posX=-1;
	int posY=-1;
	int maxX=-1;
	int maxY=-1;
	int intOrientation=-1;
	String newObstacle="";
	String possibleOrientations[]={"N","E","S","W"};
	int [][]grid;
	
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: ?(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)? with no white spaces. 
	 *  
		Example use:
		MarsRover rover = new MarsRover(100,100,?(5,5)(7,8)?)  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */ 
	
	
	
	public MarsRover(int x, int y, String obstacles){
		
		grid=new int[x][y];
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				grid[i][j]=0;
			}
		}
		maxX=x;
		maxY=y;
		if (obstacles!=null){
			String theObstacles="";
			// firstly we do some processing to the input
			String obstaclesString[]=obstacles.split("\\?");
			theObstacles=obstaclesString[1];
			theObstacles=theObstacles.replace("(","");
			theObstacles=theObstacles.replace(")",",");
			theObstacles=theObstacles.substring(0, theObstacles.length()-1);
			// then we set 1 in the array where are obstacles
			
			String numbers[]=theObstacles.split("\\,");
			for(int i=0;i<numbers.length;i=i+2){
				grid[Integer.parseInt(numbers[i+1])][Integer.parseInt(numbers[i])]=1;
			}
		}

	}
	
	public int getValueGrid(int x,int y){
		return grid[x][y];
	}
	
	
	/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
	 * Example: 
	 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.
	 
	 * The return string is in the format: ?(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)?  
	 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
	 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
	 */
	
	private int mod(int x, int y)
	{
	    int result = x % y;
	    if (result < 0)
	    {
	        result += y;
	    }
	    return result;
	}
	
	public String executeCommand(String command){
		String obstacles="";
		boolean flag=false;
		for(int i=0;i<command.length();i++){
			flag=false;
			switch(command.charAt(i)){
				case 'f':
					flag=true;
					break;
				case 'b':
					flag=true;
					break;				
				case 'r':
					flag=true;
					break;
				case 'l':
					flag=true;
					break;
				default: break;
			}
			if (flag==false){ //han introducido un comando invalido
				return null;
			}
			switch(command.charAt(i)){
				case 'f':
					switch(this.intOrientation){
						case 1: //direccion norte
							if (grid[mod((posX+1),maxX)][posY]==0){
								posX=mod((posX+1),maxX);
							}else{
								newObstacle="("+posY+","+mod((posX+1),maxX)+")";
								if (!obstacles.contains(newObstacle))
									obstacles=obstacles+newObstacle;
							}
							break;
						case 2: //direccion este
							if (grid[posX][mod((posY+1),maxY)]==0){
								posY=mod((posY+1),maxY);
							}else{
								newObstacle="("+mod((posY+1),maxY)+","+posX+")";
								if (!obstacles.contains(newObstacle))
									obstacles=obstacles+newObstacle;
							}
							break;
						case 3: //direccion sur
							if (grid[mod((posX-1),maxX)][posY]==0){
								posX=mod((posX-1),maxX);
							}else{
								newObstacle="("+posY+","+mod((posX-1),maxX)+")";
								if (!obstacles.contains(newObstacle))
									obstacles=obstacles+newObstacle;
							}
							break;
						case 4: //direccion oeste
							if (grid[posX][mod((posY-1),maxY)]==0){
								posY=mod((posY-1),maxY);
							}else{
								newObstacle="("+mod((posY-1),maxY)+","+posX+")";
								if (!obstacles.contains(newObstacle))
									obstacles=obstacles+newObstacle;
							}
							break;
					}					
					break;
				case 'b':
					switch(this.intOrientation){
						case 1: //direccion norte
							if (grid[mod((posX-1),maxX)][posY]==0){
								posX=mod((posX-1),maxX);
							}else{
								newObstacle="("+posY+","+mod((posX-1),maxX)+")";
								if (!obstacles.contains(newObstacle))
									obstacles=obstacles+newObstacle;
							}
							break;
						case 2: //direccion este
							if (grid[posX][mod((posY-1),maxY)]==0){
								posY=mod((posY-1),maxY);
							}else{
								newObstacle="("+mod((posY-1),maxY)+","+posX+")";
								if (!obstacles.contains(newObstacle))
									obstacles=obstacles+newObstacle;
							}
							break;
						case 3: //direccion sur
							if (grid[mod((posX+1),maxX)][posY]==0){
								posX=mod((posX+1),maxX);
							}else{
								newObstacle="("+posY+","+mod((posX+1),maxX)+")";
								if (!obstacles.contains(newObstacle))
									obstacles=obstacles+newObstacle;
							}
							break;
						case 4: //direccion oeste
							if (grid[posX][mod((posY+1),maxY)]==0){
								posY=mod((posY+1),maxY);
							}else{
								newObstacle="("+mod((posY+1),maxY)+","+posX+")";
								if (!obstacles.contains(newObstacle))
									obstacles=obstacles+newObstacle;
							}
							break;
					}
					break;
				case 'l':
					this.intOrientation=4;
					break;
				case 'r':
					this.intOrientation=2;
					break;
			}
		}	
		return "?"+"("+posY+","+posX+","+this.possibleOrientations[this.intOrientation-1]+")"+obstacles+"?";
	}

	public String getPosition() {
		return "["+posY+","+posX+"]";		
	}

	public boolean setInitialPosition(int i, int j, String orientation) {
		//there's an obstacle
		if (grid[i][j]!=0){
			return false;
		}else{
			this.posX=i;
			this.posY=j;
			switch(orientation.charAt(0)){
				case 'N':
					intOrientation=1;
					break;
				case 'E':
					intOrientation=2;
					break;
				case 'S':
					intOrientation=3;
					break;
				case 'W':
					intOrientation=4;
					break;
				default: break;
			}
			return true;
		}
		
	}

	public String getOrientation() {
		return possibleOrientations[intOrientation-1];
	}
}






public class PlanetExplorer {

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *	char[] sides = {'N','E','S','W'};
	char facingDirection;
	int roverX;
	int roverY;
	int x,y;
	String obstacles;
	public PlanetExplorer(int x, int y, String obstacles){
		this.x = x;
		this.y = y;
		roverX = 0;
		roverY = 0;
		this.obstacles = obstacles;
		facingDirection = sides[0];
	}

	public String executeCommand(String command) throws PlanetExplorerException{


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		char[] input = command.toCharArray();
		for(int i=0;i<input.length;i++){
			if(input[i]!= 'r' && input[i] != 'l' && input[i] != 'f' && input[i] != 'b'){
				throw new PlanetExplorerException();
			}
			if(input[i] == 'r'){
				this.turnRight();
			} else if(input[i] == 'l'){
				this.turnLeft();
			} else if(input[i] == 'f'){
				this.moveForth();
			} 
		} 
		return null;
	}
	String returnCordinates(){
		return "x="+this.roverX+",y="+this.roverY+","+this.facingDirection+","+this.obstacles;
	}
	public void turnRight(){
		if(this.facingDirection == sides[0]){
			this.facingDirection = sides[1];
		} else if(this.facingDirection == sides[1]){
			this.facingDirection = sides[2];
		} else if(this.facingDirection == sides[2]){
			this.facingDirection = sides[3];
		} else if(this.facingDirection == sides[3]){
			this.facingDirection = sides[0];
		}
	}

	public void turnLeft(){
		if(this.facingDirection == sides[0]){
			this.facingDirection = sides[3];
		} else if(this.facingDirection == sides[3]){
			this.facingDirection = sides[2];
		} else if(this.facingDirection == sides[2]){
			this.facingDirection = sides[1];		
		} else if(this.facingDirection == sides[1]){
			this.facingDirection = sides[0];
		}
	}
	public void moveForth(){
		if(this.facingDirection == sides[0]){
			this.roverY+=1;
		} else if(this.facingDirection == sides[1]){
			this.roverX+=1;
		}
	}


}

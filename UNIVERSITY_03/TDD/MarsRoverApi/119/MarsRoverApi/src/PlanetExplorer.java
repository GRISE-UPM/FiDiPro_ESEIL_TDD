




public class PlanetExplorer {

	private int x;
	private int y;
	private int roverX = 0;
	private int roverY = 0;
	private String obstacles;
	private String direction;
	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		this.x =x;
		this.y = y;
		this.obstacles = obstacles;
		this.direction = "n";
	}

	public String executeCommand(String command) throws PlanetExplorerException{
		char[] niz = command.toCharArray();
		for(char i : niz){
			switch(i){
			case 'f' : moveForth(); break;
			case 'b' : moveBack(); break;
			case 'r' : rotate(i);break;
			case 'l' : rotate(i);break;
			default : throw new PlanetExplorerException();
			}
		}

		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		return "(" + roverX + "," + roverY + "," + direction + ")";
	}

	public void moveForth(){
		if(direction.equals("n")){
			if(roverY == y)
				roverY = 0;
			else 
				roverY++;
		}else if(direction.equals("e")){
			if(roverX == x)
				roverX = 0;
			else roverX++;
		}else if(direction.equals("s")){
			if(roverY == y)
				roverY--;
		}else if(direction.equals("w")){
				roverX--;
		}
	}

	public void moveBack(){
		if(direction.equals("n")){
			if(roverY == y)
				roverY--;
		}else if(direction.equals("e")){
			if(roverX == 0)
				roverX = x;
			else 
				roverX--;
		}else if(direction.equals("s")){
			if(roverX == y)
				roverY = 0;
			else 
				roverY++;
			}else if(direction.equals("w")){
				if(roverX == x)
					roverX = 0;
				else
					roverX++;
			}
	}

	public void rotate(char i){
		switch(i){
		case 'r' :
			if(direction.equals("n"))
				direction = "e";
			else if(direction.equals("e"))
				direction = "s";
			else if(direction.equals("s"))
				direction = "w";
			else if(direction.equals("w"))
				direction = "n";
			break;
		case 'l' :
			if(direction.equals("n"))
				direction = "w";
			else if(direction.equals("w"))
				direction = "s";
			else if(direction.equals("s"))
				direction = "e";
			else if(direction.equals("e"))
				direction = "n";
		}

	}

	public int getRoverX() {
		return roverX;
	}

	public void setRoverX(int roverX) {
		this.roverX = roverX;
	}

	public int getRoverY() {
		return roverY;
	}



	public void setRoverY(int roverY2) {

		this.roverY = roverY;
	}
}

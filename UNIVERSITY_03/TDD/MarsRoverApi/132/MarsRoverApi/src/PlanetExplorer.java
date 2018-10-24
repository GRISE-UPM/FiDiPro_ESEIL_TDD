




public class PlanetExplorer {
	private int x;
	private int y;
	private int roverX;
	private int roverY;
	private String direction;
	private String obstacles;

	public PlanetExplorer(int x, int y, String obstacles){
		this.x = x;
		this.y= y;
		this.obstacles = obstacles;
		this.direction = "n";


	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *	}

	public String executeCommand(String command){

		char[] commands =command.toCharArray();
		for (char i : commands)
			switch(i) {
			case 'f': moveForth() ; break;
			case 'b': moveBack() ; break;
			case 'r': rotate(i); break;
			case 'l': rotate(i); break;

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

	public void rotate(char i){
		switch(i){
			case 'r':
			if(direction == "n")
				direction = "e";
			else if (direction == "e")
				direction = "s";
			else if (direction == "s")
				direction = "w";
			else if (direction == "w")
				direction = "n";
			break;
			case 'l': 
			if(direction == "n")
				direction = "w";
			else if (direction == "w")
				direction = "s";
			else if (direction == "s")
				direction = "e";
			else if (direction == "e")
				direction = "n";
			break;

		}

	}
	public void moveForth(){
		if(direction == "n")
			if(roverY == y)
				roverY = 0;
			else
				roverY ++;
		else if (direction == "e")
			if(roverX == x)
				roverX = 0;
			else
				roverX++;
		else if(direction == "s")
			if(roverY == 0)
				roverY = y;
			else
				roverY --;
		else if (direction == "w")
			if(roverX == 0)
				roverX = x;
			else
				roverX--;
	}
	public void moveBack(){
		if(direction == "n")
			if (roverY == 0)
				roverY = y;
			else
				roverY --;
		else if(direction == "e")
			if(roverX == 0)
				roverX = x;
			else
				roverX--;
		else if(direction == "s")
			if(roverY == x)
				roverY = 0;
			else
				roverY++;
		else if(direction == "w")
			if(roverX == x)
				roverX = 0;
			else
				roverX++;

	}

	public void setRoverX(int x) {
		this.roverX = x;
	}

	public void setRoverY(int y) {
		this.roverY = y;
	}
}

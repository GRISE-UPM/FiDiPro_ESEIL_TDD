




public class PlanetExplorer {

	private int x;
	private int y;
	private String direction;
	private String obstacles;

	public PlanetExplorer(int x, int y, String obstacles){

		this.x = x;
		this.y = y;
		this.direction = "N";
		this.obstacles = obstacles;

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *	}

	public void getFormatedCoordinates()
	{
		String ispis = null;
		ispis = "(" + Integer.toString(x) + "," + Integer.toString(y) + "," + direction + ")";
	}

	public void moveForth() throws PlanetExplorerException
	{
		if(this.direction == "N" || this.direction == "S")
			this.y++;
		else if(this.direction == "W" || this.direction == "E")
			this.x++;

	}

	public void moveBack() throws PlanetExplorerException
	{
		if(this.direction == "N" || this.direction == "S")
			this.y--;
		else if(this.direction == "W" || this.direction == "E")
			this.x--;
	}

	public void moveLeft() throws PlanetExplorerException
	{
		if (direction == "N")
			this.direction = "W";
		else if (direction == "W")
			this.direction = "S";
		else if (direction == "S")
			this.direction = "E";
		else if (direction == "E")
			this.direction = "N";

	}

	public void moveRight() throws PlanetExplorerException
	{
		if (direction == "N")
			this.direction = "E";
		else if (direction == "E")
			this.direction = "S";
		else if (direction == "S")
			this.direction = "W";
		else if (direction == "W")
			this.direction = "N";
	}

	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		return null;
	}
}

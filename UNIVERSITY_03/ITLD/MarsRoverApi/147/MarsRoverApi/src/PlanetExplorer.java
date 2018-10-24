




public class PlanetExplorer {

	private int x,y; 	private int obs_x, obs_y; 	private int pos_x, pos_y; 	private String direction;
	private String obstacles;


	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		this.pos_x=0;
		this.pos_y=0;
		this.x=x;
		this.y=y;
		this.obstacles=obstacles;


		String[] splited2 = splited[0].split(")");
		String[] splited3 = splited[0].split(",");
		this.obs_x = Integer.parseInt(splited3[0]);
		this.obs_y = Integer.parseInt(splited3[1]);*




	}



	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		char[] commands = command.toCharArray();
		for(int i=0; i<commands.length; i++)
		{
			switch(commands[i]){

			case 'f':
				if(this.direction == "N")
				{
					this.pos_y++;
					return "("+pos_x+","+pos_y+","+direction+")";
				}
				else if(this.direction == "E")
				{
					this.pos_x++;
					return "("+pos_x+","+pos_y+","+direction+")";
				}

			case 'b': 
				if(this.direction=="S")
				{
					this.pos_y--;
					return "("+pos_x+","+pos_y+","+direction+")";
				}

			case 'l':
				if(this.direction=="N")
					this.direction="W";
				else if(this.direction=="E")
					this.direction="N";

		}
		}


		return null;
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public int getObs_x() {
		return obs_x;
	}



	public void setObs_x(int obs_x) {
		this.obs_x = obs_x;
	}



	public int getObs_y() {
		return obs_y;
	}



	public void setObs_y(int obs_y) {
		this.obs_y = obs_y;
	}



	public int getPos_x() {
		return pos_x;
	}



	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}



	public int getPos_y() {
		return pos_y;
	}



	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}



	public String getDirection() {
		return direction;
	}



	public void setDirection(String direction) {
		this.direction = direction;
	}



	public String getObstacles() {
		return obstacles;
	}



	public void setObstacles(String obstacles) {
		this.obstacles = obstacles;
	}

}

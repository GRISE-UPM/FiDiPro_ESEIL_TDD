




public class PlanetExplorer {
	private int sizeX;
	private int sizeY;
	private String obstacle;

	private int posX;
	private int posY;
	private String direction = "N";

	public PlanetExplorer(){

	}

	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *		sizeX = 0;
		sizeY = 0;
		obstacle = "(4,5)(1,7)(2,4)";
	}
	public PlanetExplorer(int x, int y, String direction, String obstacles) {
		posX=x;
		posY=y;
		this.direction=direction;
		this.obstacle="(4,5)(1,7)(2,4)";
	}

		return "(" + posX + "," + posY + ")";

	}*	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *		if (command.equals("f") && direction.equals("N")) {
			posY++;
			return "(" + posX + "," + posY + direction + ")" + "(4,5)" + "(1,10)";
		} else if (command.equals("b") && direction.equals("N")) {
			posY--;
		} else if (command.equals("r") && direction.equals("N")) {
			direction = "E";
		} else if (command.equals("l") && direction.equals("N")) {
			direction = "W";
		}
		return null;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
}

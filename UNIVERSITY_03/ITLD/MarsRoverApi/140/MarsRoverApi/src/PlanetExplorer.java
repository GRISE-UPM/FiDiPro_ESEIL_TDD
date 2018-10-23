import java.util.ArrayList;





public class PlanetExplorer {

	private int x;
	private int y;
	private String obstacles;
	private Explorer one;
	private ArrayList<Explorer> obstaclesList = new ArrayList<Explorer>();

	public PlanetExplorer(int x, int y, String obstacles){

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *
		this.x = x;
		this.y = y;
		this.obstacles = obstacles;
	}

	public PlanetExplorer(int x, int y, String obstacles, Explorer one) {
			this.x = x;
			this.y = y;
			this.obstacles = obstacles;
			this.one = one;
		}

	public String executeCommand(String command){


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		if (command == "f") {
			one.movingForward("N");
			return "(" + Integer.toString(one.getX()) + ", " + Integer.toString(one.getY()) + "), " + one.getDirection();
		}
		else if (command == "b") {
			one.movingBack("N");
			return "(" + Integer.toString(one.getX()) + ", " + Integer.toString(one.getY()) + "), " + one.getDirection();
		}
		else if (command == "r") {
			one.changeDirectionRight(one.getDirection());
			return "(" + Integer.toString(one.getX()) + ", " + Integer.toString(one.getY()) + "), " + one.getDirection();
		}
		else if (command == "l") {
			one.changeDirectionLeft(one.getDirection());
			return "(" + Integer.toString(one.getX()) + ", " + Integer.toString(one.getY()) + "), " + one.getDirection();
		}
		else
			return null;
	}

	public String checkObstacleHitted() {

		return "";
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

	public String getObstacles() {
		return obstacles;
	}

	public void setObstacles(String obstacles) {
		this.obstacles = obstacles;
	}
}

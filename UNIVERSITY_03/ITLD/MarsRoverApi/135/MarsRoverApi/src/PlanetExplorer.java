import java.util.ArrayList;





public class PlanetExplorer {

	private Position explorerPosition = new Position(0,0);
	private Position grid = new Position(0,0);
	private String explorerDirection = "N";
	private ArrayList<Position> obstacleList = new ArrayList<Position>();
	public Position getGrid() {
		return grid;
	}

	public void setGrid(Position grid) {
		this.grid = grid;
	}

	public ArrayList<Position> getObstacleList() {
		return obstacleList;
	}

	public void setObstacleList(ArrayList<Position> obstacleList) {
		this.obstacleList = obstacleList;
	}

	private ArrayList<Position> obstaclesFound = new ArrayList<Position>();


	public PlanetExplorer(int x, int y, String obstacles) throws PlanetExplorerException{

	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  

	 *
		if(x<=0 || y<=0)
			throw new PlanetExplorerException("Invalid grid coordinates.");

		grid.setX(x);
		grid.setY(y);


		if(!obstacles.isEmpty()){

			if (Util.countNumOfMovement(obstacles, "(") != Util.countNumOfMovement(obstacles, ")") ||
					Util.countNumOfMovement(obstacles, "(") != Util.countNumOfMovement(obstacles, ",")){
					throw new PlanetExplorerException("Obstacles positions have unknown format.");
				}


			String initObstacles = obstacles.replace("(", "");
			String[] obstaclesValues = initObstacles.split("\\)");
			for (String obstacle : obstaclesValues) {
				String obstacleX = obstacle.split(",")[0];
				String obstacleY = obstacle.split(",")[1];

				if(!Util.isInteger(obstacleX) || !Util.isInteger(obstacleY))
					throw new PlanetExplorerException("Obstacle coordinate is not integer");

				Position currentObstacle = new Position(Integer.parseInt(obstacleX),Integer.parseInt(obstacleY));
				obstacleList.add(currentObstacle);
			}
		}
	}

	public String executeCommand(String command) throws PlanetExplorerException{


		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.

		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 *
		char[] commands = command.toCharArray();
		for (char currentCommand : commands) {
			Position obstacleF = move(currentCommand);
			if(obstacleF != null && !obstaclesFound.contains(obstacleF)){

			}
		}


		return null;
	}

	private Position move(char command) throws PlanetExplorerException{
		Position obstacle = null;
		Position nextPosition = new Position(explorerPosition.getX(), explorerPosition.getY());
		switch (command){
		case Util.MOVEFORWARD:
			nextPosition.moveForward(explorerDirection);
			break;
		case Util.MOVEBACKWARD:
			nextPosition.moveBackwards(explorerDirection);
			break;
		case Util.MOVELEFT:
			explorerDirection = Util.cycleDirectionLeft(explorerDirection);
			break;
		case Util.MOVERIGHT:
			explorerDirection = Util.cycleDirectionRight(explorerDirection);
			break;
		default:
			throw new PlanetExplorerException("Unknown command: " + command);
		}

		return obstacle;
	}


}

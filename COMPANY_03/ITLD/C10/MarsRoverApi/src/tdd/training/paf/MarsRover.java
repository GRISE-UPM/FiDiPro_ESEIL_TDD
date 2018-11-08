package tdd.training.paf;

import java.util.ArrayList;
import java.util.List;

public class MarsRover {
	String obstacles = null;
	int array[][] = null;
	int positionX,positionY = 0;
	public MarsRover(int x, int y, String obstacles) {
		/*
		 * x and y represent the size of the grid. Obstacles is a String
		 * formatted as follows: "(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)" with no
		 * white spaces.
		 * 
		 * Example use: MarsRover rover = new MarsRover(100,100,"(5,5)(7,8)")
		 * //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		 */
		this.array = new int[x][y];
		List<String> obsList = extractObstacles(obstacles);
		addObstacles(obsList);
		printArray();
	}

	void printArray() {
		for (int i = 0; i < 3; i++) {//TODO change the length of the array to support others than 3 dim array
			for (int j = 0; j < 3; j++) {
				System.out.print("array["+""+i+"]["+j+"]"+array[i][j] + " ");
				//System.out.print(array[i][j] + " ");
			}
			System.out.println("");
		}
	}

	void addObstacles(List<String> obsList) {
		for (String obs : obsList) {
			System.out.println(obs);
			int x = Integer.parseInt(obs.split(",")[0]);
			int y = Integer.parseInt(obs.split(",")[1]);
			array[x][y] = -1;
		}
		array[0][0] = 99;
	}

	List<String> extractObstacles(String obstacles) {
		int numberOfObstacles = obstacles.length()
				- obstacles.replace("(", "").length();
		List<String> obstacleCoordinates = new ArrayList<String>();

		while (numberOfObstacles > 0) {
			String requiredString = obstacles.substring(
					obstacles.indexOf("(") + 1, obstacles.indexOf(")"));
			obstacleCoordinates.add(requiredString);
			obstacles = obstacles.substring(obstacles.indexOf(")") + 1,
					obstacles.length());
			numberOfObstacles--;
		}
		return obstacleCoordinates;
	}

	public String executeCommand(String command) {
		StringBuffer result = new StringBuffer();
		char array[] = command.toCharArray();
		
		result.append("("+positionX+","+positionY+")");

		for (char direction : array) {
			System.out.println("------------------"+direction+"--------------");
			switch (direction) {
			case 'l': {
				if(this.array[positionX][positionY] != -1){
					positionY--;
					this.array[positionX][positionY] = 2;	
					result.append("("+positionX+","+positionY+")");					
				}			
				break;
			}
			case 'r': {
				if(this.array[positionX][positionY] != -1){
					positionY++;
					this.array[positionX][positionY] = 2;		
					result.append("("+positionX+","+positionY+")");					
				}				
				break;
			}
			case 'f': {
				if(this.array[positionX][positionY] != -1){
					positionX--;
					this.array[positionX][positionY] = 2;		
					result.append("("+positionX+","+positionY+")");					
				}								
				break;
			}
			case 'b': {
				if(this.array[positionX][positionY] != -1){
					positionX++;
					this.array[positionX][positionY] = 2;	
					result.append("("+positionX+","+positionY+")");
				}				
				break;
			}
			}
			System.out.println("");
			printArray();
		}
		result.insert(0, "(x,y,facing)");//TODO Modify
		/*
		 * The command string is composed of "f" (forward), "b" (backward), "l"
		 * (left) and "r" (right) Example: The rover is on a 100x100 grid at
		 * location (0, 0) and facing NORTH. The rover is given the commands
		 * "ffrff" and should end up at (2, 2) facing East.
		 * 
		 * The return string is in the format:
		 * "(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)" Where x and y are
		 * the final coordinates, facing is the current direction the rover is
		 * pointing to (N,S,W,E). The return string should also contain a list
		 * of coordinates of the encountered obstacles. No white spaces.
		 */

		return result.toString();
	}
}

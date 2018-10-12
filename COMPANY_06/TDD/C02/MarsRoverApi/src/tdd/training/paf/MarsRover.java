package tdd.training.paf;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarsRover {

	public enum Direction {
		N(0, 1, "W", "E"),
		E(1, 0, "N", "S"),
		S(0, -1, "E", "W"),
		W(-1, 0, "S", "N");

		private final int forwardX, forwardY;
		private final String right, left;

		Direction(int forwardX, int forwardY, String left, String right) {
			this.forwardX = forwardX;
			this.forwardY = forwardY;
			this.left = left;
			this.right = right;
		}

		public int getForwardX() {
			return forwardX;
		}

		public int getForwardY() {
			return forwardY;
		}

		public Direction getRight() {
			return Direction.valueOf(right);
		}

		public Direction getLeft() {
			return Direction.valueOf(left);
		}
	}

	private int x, y, width, height;
	private boolean[][] obstacleCoords;
	private List<String> obstaclesEncountered;
	private Direction direction;

	/*	width and height represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)" with no white spaces.
	 *
		Example use:
		MarsRover rover = new MarsRover(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacleCoords at coordinates (5,5) and (7,8)
	 */
	public MarsRover(int width, int height, String obstacles){
		if (width < 1 || height < 1) {
			throw new IllegalArgumentException("Invalid grid dimensions: width=" + width + ", height=" + height);
		}
		this.width = width;
		this.height = height;
		this.obstacleCoords = new boolean[width][height];
		this.obstaclesEncountered = new ArrayList<>();
		this.direction = Direction.N;

		Matcher mObstacle = Pattern.compile("\\(([0-9]+),([0-9]+)\\)").matcher(obstacles);
		while (mObstacle.find()) {
			int ox = Integer.parseInt(mObstacle.group(1));
			int oy = Integer.parseInt(mObstacle.group(2));
			this.obstacleCoords[ox][oy] = true;
		}
	}

	/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
	 * Example:
	 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.

	 * The return string is in the format: "(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)"
	 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
	 * The return string should also contain a list of coordinates of the encountered obstacleCoords. No white spaces.
	 */
	public String executeCommand(String command){

		for (int i = 0; i < command.length(); i++) {
			char commandChar = command.charAt(i);
			if (commandChar == 'f') {
				moveForward();
			}
			if (commandChar == 'b') {
				moveBackward();
			}
			if (commandChar == 'r') {
				turnRight();
			}
			if (commandChar == 'l') {
				turnLeft();
			}
		}

		StringBuffer result = new StringBuffer("(").
			append(x).
			append(",").
			append(y).
			append(",").
			append(direction).
			append(")");

		for (String obstacleReport : obstaclesEncountered) {
			result.append(obstacleReport);
		}

		return result.toString();
	}

	public boolean hasObstacleAt(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return false;
		}
		return obstacleCoords[x][y];
	}

	public void moveForward() {
		int newX = wrap(x + direction.getForwardX(), width);
		int newY = wrap(y + direction.getForwardY(), height);
		moveTo(newX, newY);
	}

	public void moveBackward() {
		int newX = wrap(x - direction.getForwardX(), width);
		int newY = wrap(y - direction.getForwardY(), height);
		moveTo(newX, newY);
	}

	public void turnRight() {
		direction = direction.getRight();
	}

	public void turnLeft() {
		direction = direction.getLeft();
	}

	private int wrap(int value, int max) {
		if (value < 0) {
			return max - 1;
		}
		if (value >= max) {
			return 0;
		}
		return value;
	}

	private void moveTo(int newX, int newY) {
		if (hasObstacleAt(newX, newY)) {
			String obstacleReport = "(" + newX + "," + newY  + ")";
			if (!obstaclesEncountered.contains(obstacleReport)) {
				obstaclesEncountered.add(obstacleReport);
			}
		}
		else {
			this.x = newX;
			this.y = newY;
		}
	}
}

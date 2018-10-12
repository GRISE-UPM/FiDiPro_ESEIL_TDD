package upm.tdd.training;

import java.util.ArrayList;

public class MarsRover {
	private int sizeX;
	private int sizeY;
	private String obstaclesPositions;
	private ArrayList<String> points;
	private String facing = "north";

	public MarsRover(int x, int y, String obstacles) {
		/*
		 * x and y represent the size of the grid. Obstacles is a String
		 * formatted as follows: ?(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)? with no
		 * white spaces.
		 * 
		 * Example use: MarsRover rover = new MarsRover(100,100,?(5,5)(7,8)?)
		 * //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		 */
		sizeX = x;
		sizeY = y;
		obstaclesPositions = obstacles.substring(1, obstacles.length() - 1);

	}

	public String executeCommand(String command) {
		int posX = 0, posY = 0;
		String finalResult = "";
		/*
		 * The command string is composed of "f" (forward), "b" (backward), "l"
		 * (left) and "r" (right) Example: The rover is on a 100x100 grid at
		 * location (0, 0) and facing NORTH. The rover is given the commands
		 * "ffrff" and should end up at (2, 2) facing East.
		 * 
		 * The return string is in the format:
		 * ?(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)? Where x and y are
		 * the final coordinates, facing is the current direction the rover is
		 * pointing to (N,S,W,E). The return string should also contain a list
		 * of coordinates of the encountered obstacles. No white spaces.
		 */
		for (int i = 0; i < command.length(); i++) {
			switch (command.charAt(i)) {
			case 'f':
				if (facing.equals("north") && posY >= 0 && posY <= sizeY) {
					posY += 1;
					if (moveRovers(posX, posY)) {
						posY -= 1;
					}
				} else if (facing.equals("east") && posX >= 0 && posX <= sizeX) {
					posX += 1;
					if (moveRovers(posX, posY)) {
						posX -= 1;
					}
				} else if (facing.equals("west") && posX >= 0 && posX <= sizeX) {
					posX -= 1;
					if (moveRovers(posX, posY)) {
						posX += 1;
					}
				} else if (facing.equals("south") && posY >= 0 && posY <= sizeY) {
					posY -= 1;
					if (moveRovers(posX, posY)) {
						posY += 1;
					}
				}
				break;
			case 'b':
				if (facing.equals("north") && posY >= 0 && posY <= sizeY) {
					posY -= 1;
					if (moveRovers(posX, posY)) {
						posY += 1;
					}
				} else if (facing.equals("west") && posX >= 0 && posX <= sizeX) {
					posX += 1;
					if (moveRovers(posX, posY)) {
						posX -= 1;
					}
				} else if (facing.equals("east") && posX >= 0 && posX <= sizeX) {
					posX -= 1;
					if (moveRovers(posX, posY)) {
						posX += 1;
					}
				} else if (facing.equals("south") && posY >= 0 && posY <= sizeY) {
					posY += 1;
					if (moveRovers(posX, posY)) {
						posY -= 1;
					}
				}
				break;

			case 'l':

				if (facing.equals("west")) {
					facing = "south";
				} else if (facing.equals("south")) {
					facing = "east";
				} else if (facing.equals("east")) {
					facing = "north";
				} else if (facing.equals("north")) {
					facing = "west";
				}
				break;

			case 'r':
				if (facing.equals("east")) {
					facing = "south";
				} else if (facing.equals("south")) {
					facing = "west";
				} else if (facing.equals("west")) {
					facing = "north";
				} else if (facing.equals("north")) {
					facing = "east";
				}
				break;

			default:
				break;
			}

		}
		finalResult = "(" + posX + "," + posY + "," + facing + ")";

		if (points != null) {
			for (int i = 0; i < points.size(); i++) {
				finalResult += "?" + points.get(i) + "?";
			}
		}

		return finalResult;
	}

	public boolean moveRovers(int posX, int posY) {
		points = new ArrayList<String>();

		if (obstaclesPositions.contains("(" + posX + "," + posY + ")")) {
			points.add("(" + posX + "," + posY + ")");
			return true;
		}
		return false;
	}
}

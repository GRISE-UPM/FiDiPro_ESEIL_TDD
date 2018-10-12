package tdd.training.paf;

import java.util.ArrayList;
import java.util.List;

public class MarsRover {
    private final int length;
    private final int height;

    private int xPos = 0;
    private int yPos = 0;
    private String facing = "north";

    private List<Obstacle> obstacles = new ArrayList<>();

    public MarsRover(int length, int height, String obstacles) {
    /*	x and y represent the size of the grid.
     *  Obstacles is a String formatted as follows: "(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)" with no white spaces.
	 *  
		Example use:
		MarsRover rover = new MarsRover(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */

        this.length = length;
        this.height = height;

        if (obstacles != null && obstacles.length() > 0 && obstacles.startsWith("(")) {
            //todo: implement
            this.obstacles.add(new Obstacle(parseFirstObstacleX(obstacles), parseFirstObstacleY(obstacles)));
        }
    }

    static int parseFirstObstacleX(String obstaclesText) {
        return parseInteger(obstaclesText, "(", ",");
    }

    static int parseFirstObstacleY(String obstaclesText) {
        return parseInteger(obstaclesText, ",", ")");
    }

    private static int parseInteger(String obstaclesText, String startSymbol, String endSymbol) {
        final int startIndex = obstaclesText.indexOf(startSymbol);
        if (startIndex >= 0) {
            final int endIndex = obstaclesText.indexOf(endSymbol);
            final String stringValue = obstaclesText.substring(startIndex + 1, endIndex);
            return Integer.parseInt(stringValue);
        }
        throw new RuntimeException("Cannot parse position");
    }


    public String executeCommand(String command) {

		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
         * Example:
		 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)"  
		 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */

        try {
            if ("f".equals(command)) {
                moveForward();
            } else if ("b".equals(command)) {
                moveBackward();
            } else if ("l".equals(command)) {
                facing = changeFacingToLeft(facing);
            } else if ("r".equals(command)) {
                facing = changeFacingToRight(facing);
            } else {
                throw new RuntimeException("cannot understand, kill all humans...");
            }
            return "(" + xPos + "," + yPos + "," + facing + ")";
        } finally {
            System.out.println("command: " + command);
            System.out.println("___planet___");
            System.out.print(toString());
            System.out.println("____________");
        }
    }

    private void moveBackward() {
        //noinspection Duplicates
        if ("north".equals(facing)) {
            moveSouth();
        } else if ("east".equals(facing)) {
            moveWest();
        } else if ("west".equals(facing)) {
            moveEast();
        } else if ("south".equals(facing)) {
            moveNorth();
        } else {
            throw new RuntimeException("cannot understand, kill all humans...");
        }
    }

    private void moveForward() {
        //noinspection Duplicates
        if ("north".equals(facing)) {
            moveNorth();
        } else if ("east".equals(facing)) {
            moveEast();
        } else if ("west".equals(facing)) {
            moveWest();
        } else if ("south".equals(facing)) {
            moveSouth();
        } else {
            throw new RuntimeException("cannot understand, kill all humans...");
        }
    }

    private void moveSouth() {
        int y = yPos - 1;
        if (y < 0) {
            y = height - 1;
        }
        if (freeWay(xPos, y)) {
            yPos = y;
        }
    }

    private void moveWest() {
        int x = xPos - 1;
        if (x < 0) {
            x = length - 1;
        }
        if (freeWay(x, yPos)) {
            xPos = x;
        }

    }

    private void moveEast() {
        int x = xPos + 1;
        if (x >= length) {
            x = 0;
        }
        if (freeWay(x, yPos)) {
            xPos = x;
        }
    }

    private void moveNorth() {
        int y = yPos + 1;
        if (y >= height) {
            y = 0;
        }
        if (freeWay(xPos, y)) {
            yPos = y;
        }
    }

    private boolean freeWay(int x, int y) {

        for (Obstacle next : obstacles) {
            if (next.x == x && next.y == y) {
                return false;
            }
        }
        return true;
    }

    static private String changeFacingToLeft(String current) {
        switch (current) {
            case "north":
                return "west";
            case "west":
                return "south";
            case "south":
                return "east";
            case "east":
                return "north";
        }
        throw new RuntimeException("Invalid current facing: " + current);
    }

    static private String changeFacingToRight(String current) {
        switch (current) {
            case "north":
                return "east";
            case "east":
                return "south";
            case "south":
                return "west";
            case "west":
                return "north";
        }
        throw new RuntimeException("Invalid current facing: " + current);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (int y = height - 1; y >= 0; y--) {
            for (int x = 0; x < length; x++) {
                if (xPos == x && yPos == y) {
                    if ("north".equals(facing)) {
                        builder.append("^");
                    } else if ("west".equals(facing)) {
                        builder.append("<");
                    } else if ("south".equals(facing)) {
                        builder.append("v");
                    } else if ("east".equals(facing)) {
                        builder.append(">");
                    } else {
                        builder.append("?");
                    }
                } else {
                    builder.append("O");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private static class Obstacle {
        final int x;
        final int y;

        public Obstacle(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

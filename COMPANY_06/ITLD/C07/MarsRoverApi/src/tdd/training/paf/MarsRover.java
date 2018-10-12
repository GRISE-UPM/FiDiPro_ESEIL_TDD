package tdd.training.paf;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarsRover {

    private Position pos = new Position(0, 0);

    private Direction dir = Direction.N;

    private final Set<Position> obstaclePositions;

    private final int dimensionX;
    private final int dimensionY;

    public MarsRover(int x, int y, String obstacles) {
    /*	x and y represent the size of the grid.
     *  Obstacles is a String formatted as follows: "(o1_x,o1_y)(o2_x,o2_y)...(on_x,on_y)" with no white spaces.
	 *  
		Example use:
		MarsRover rover = new MarsRover(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
        dimensionX = x;
        dimensionY = y;
        obstaclePositions = new HashSet<>(parseObstaclePositions(obstacles));
    }

    public String executeCommand(String command) {

		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
         * Example:
		 * The rover is on a 100x100 grid at location (0, 0) and facing NORTH. The rover is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(x,y,facing)(o1_x,o1_y)(o2_x,o2_y)?..(on_x,on_y)"  
		 * Where x and y are the final coordinates, facing is the current direction the rover is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
        Set<Position> obstaclesBumpedInto = new LinkedHashSet<>();
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            Position obstacleBumpedInto = executeSingleOperation(c);
            if (obstacleBumpedInto != null) {
                obstaclesBumpedInto.add(obstacleBumpedInto);
            }
        }

        String result = String.format("(%d,%d,%s)", this.pos.x, this.pos.y, this.dir);
        for (Position obstacleAt : obstaclesBumpedInto) {
            result += obstacleAt.toString();
        }
        return result;
    }

    /// Executes a single operation, l,r,f or b. If operation can't be fulfilled because an obstacle then the position of
    /// the obstacle is returned, otherwise null is returned and rovers position or direction is updated.
    private Position executeSingleOperation(char operation) {
        switch (operation) {
            case 'l':
                this.dir = this.dir.left();
                break;
            case 'r':
                this.dir = this.dir.right();
                break;
            case 'f':
            case 'b': {
                int moveAmount = (operation == 'f') ? 1 : -1;
                Position newPos = this.getPositionAfterMove(moveAmount);
                if (this.obstaclePositions.contains(newPos)) {
                    return newPos;
                } else {
                    this.pos = newPos;
                }
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown operation requested: " + operation);
        }
        return null;
    }

    private Position getPositionAfterMove(int amount) {
        int newX = clampToDimension(this.dimensionX, this.pos.x + (amount * this.dir.x_coeff));
        int newY = clampToDimension(this.dimensionY, this.pos.y + (amount * this.dir.y_coeff));
        return new Position(newX, newY);
    }

    private int clampToDimension(int dimension, int x_or_y) {
        return Math.floorMod(x_or_y, dimension);
    }

    public Position getPos() {
        return pos;
    }

    public Direction getDir() {
        return dir;
    }

    public Set<Position> getObstaclePositions() {
        return Collections.unmodifiableSet(obstaclePositions);
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public static List<Position> parseObstaclePositions(String obstaclesSpec) {
        obstaclesSpec = (obstaclesSpec == null) ? "" : obstaclesSpec;
        String regex = "(?:\\((\\d+),(\\d+)\\))";
        if (obstaclesSpec.matches(regex + "*")) {
            Pattern p = Pattern.compile(regex);
            Matcher matcher = p.matcher(obstaclesSpec);
            List<Position> result = new ArrayList<>();
            int startIndex = 0;
            while (matcher.find(startIndex)) {
                String xStr = matcher.group(1);
                String yStr = matcher.group(2);
                result.add(new Position(Integer.parseInt(xStr), Integer.parseInt(yStr)));
                startIndex = matcher.end();
            }
            return result;
        }
        throw new IllegalArgumentException("Invalid obstacle specification provided: " + obstaclesSpec);
    }
}

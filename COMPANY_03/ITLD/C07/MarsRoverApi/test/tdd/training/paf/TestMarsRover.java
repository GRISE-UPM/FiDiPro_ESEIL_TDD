package tdd.training.paf;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

import javafx.geometry.Pos;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

public class TestMarsRover {

	@Test
	public void testParseObstacles() throws Exception {
		List<Position> expectedPositions = asList(new Position(2,2), new Position(3,1));
		String obstaclesSpec = "(2,2)(3,1)";
		List<Position> obstaclePositions = MarsRover.parseObstaclePositions(obstaclesSpec);
		assertEquals(expectedPositions, obstaclePositions);
	}

	@Test
	public void testStartingPositionAndDirectionAndObstacles(){
		List<Position> expectedPositions = asList(new Position(2,2), new Position(3,1));
		MarsRover rover = new MarsRover(3,3, "(2,2)(3,1)");
		assertEquals(Direction.N, rover.getDir());
		assertEquals(new Position(0,0), rover.getPos());
		assertEquals(new HashSet<Position>(expectedPositions), rover.getObstaclePositions());
	}

	@Test
	public void testExecute_No_Obstacles() throws Exception {
		MarsRover rover = new MarsRover(3,3, null);
		String result = rover.executeCommand("ffrf");
		assertEquals("(1,2,E)", result);
	}

	@Test
	public void testExecute_wrap_around() throws Exception {
		MarsRover rover = new MarsRover(3,3, null);
		String result = rover.executeCommand("rfff");
		assertEquals("(0,0,E)", result);

		result = rover.executeCommand("b");
		assertEquals("(2,0,E)", result);

		result = rover.executeCommand("flfff");
		assertEquals("(0,0,N)", result);
	}

	@Test
	public void testExecute_obstacle() throws Exception {
		MarsRover rover = new MarsRover(3,3, "(0,2)");
		String result = rover.executeCommand("ffrf");
		assertEquals("(1,1,E)(0,2)", result);
	}

    @Test
    public void testExecute_many_obstacles() throws Exception {
        MarsRover rover = new MarsRover(3,3, "(0,2)(1,1)(2,2)");
        String result = rover.executeCommand("ffrf");
        assertEquals("(0,1,E)(0,2)(1,1)", result);
    }
}

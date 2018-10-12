package tdd.training.paf;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMarsRover {

	MarsRover rover;

	@Before
	public void setup() {
		rover = new MarsRover(10,10,"(1,1)(2,3)(5,5)(8,1)(9,0)");
	}

	@Test
	public void testEmptyCommand() {
		assertEquals("(0,0,N)", rover.executeCommand(""));
	}

	@Test
	public void testCommand_front() {
		assertEquals("(0,1,N)", rover.executeCommand("f"));
	}

	@Test
	public void testCommand_front5() {
		assertEquals("(0,5,N)", rover.executeCommand("fffff"));
	}

	@Test
	public void testCommand_front10() {
		assertEquals("(0,0,N)", rover.executeCommand("ffffffffff"));
	}

	@Test
	public void testCommand_back() {
		assertEquals("(0,9,N)", rover.executeCommand("b"));
	}

	@Test
	public void testCommand_back5() {
		assertEquals("(0,5,N)", rover.executeCommand("bbbbb"));
	}

	@Test
	public void testCommand_back10() {
		assertEquals("(0,0,N)", rover.executeCommand("bbbbbbbbbb"));
	}

	@Test
	public void testCommand_turnRight()  {
		assertEquals("(0,0,E)", rover.executeCommand("r"));
	}

	@Test
	public void testCommand_turnRight2()  {
		assertEquals("(0,0,S)", rover.executeCommand("rr"));
	}

	@Test
	public void testCommand_turnRight3()  {
		assertEquals("(0,0,W)", rover.executeCommand("rrr"));
	}

	@Test
	public void testCommand_turnLeft()  {
		assertEquals("(0,0,W)", rover.executeCommand("l"));
	}

	@Test
	public void testCommand_turnRightFront2()  {
		assertEquals("(2,0,E)", rover.executeCommand("rff"));
	}

	@Test
	public void testHasObstacleAt1_1() {
		assertTrue(rover.hasObstacleAt(1,1));
	}

	@Test
	public void testHasObstacleAt8_1() {
		assertTrue(rover.hasObstacleAt(8,1));
	}

	@Test
	public void testHasNoObstacleAt8_2() {
		assertFalse(rover.hasObstacleAt(8,2));
	}

	@Test
	public void testHasNoObstacleAtMinus1_Minus1() {
		assertFalse(rover.hasObstacleAt(-1,1));
	}

	@Test
	public void testCommand_turnLeftFront2()  {
		assertEquals("(0,0,W)(9,0)", rover.executeCommand("lff"));
	}

	@Test
	public void testCommand_frontLeftFront2Left()  {
		assertEquals("(9,1,S)(8,1)", rover.executeCommand("flffl"));
	}

	@Test
	public void testCommand_front2RightFront2()  {
		assertEquals("(2,2,E)", rover.executeCommand("ffrff"));
	}

	@Test
	public void testCommand_rightFrontLeftFront3LeftFront3Left()  {
		assertEquals("(2,2,W)(1,1)(2,3)", rover.executeCommand("rflfrflfffl"));
	}

	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testObstaclesOutsideGrid() {
		rover = new MarsRover(1,1,"(2,2)");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testInvalidGridDimensions() {
		rover = new MarsRover(1,0,"");
	}

	@Test
	public void testBigGrid()  {
		rover = new MarsRover(100, 100, "(90,1)");
		assertEquals("(91,1,W)(90,1)", rover.executeCommand("lfrflffffffffff"));
	}

}

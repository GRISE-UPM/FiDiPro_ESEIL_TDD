package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import upm.tdd.training.MarsRover;

public class TestRover {

	@Test
	public void testMove1StepForward() {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,1,N)?", marsRover.executeCommand("f"));
	}
	
	@Test
	public void testMove2StepsForward() {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,2,N)?", marsRover.executeCommand("ff"));
	}
	
	@Test
	public void testMove50StepsForward() {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,50,N)?", marsRover.executeCommand("ffffffffffffffffffffffffffffffffffffffffffffffffff"));
	}
	
	@Test
	public void testMoveRight1Time(){
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,0,E)?", marsRover.executeCommand("r"));
	}
	
	@Test
	public void testMoveRight2Times(){
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,0,S)?", marsRover.executeCommand("rr"));
	}
	
	@Test
	public void testMoveRightMultipleOf4Times(){
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,0,N)?", marsRover.executeCommand("rrrrrrrrrrrr"));
	}
	
	@Test
	public void testMoveForwarBackward()  {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,0,N)?", marsRover.executeCommand("fb"));
	}
	
	@Test
	public void testMoveRightForward()  {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(1,0,E)?", marsRover.executeCommand("rf"));
	}
	
	@Test
	public void testMove4Rights1Forward()  {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,1,N)?", marsRover.executeCommand("rrrrf"));
	}
	
	@Test
	public void testMoveInDiagonalAndReturn()  {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,0,N)?", marsRover.executeCommand("frfrfrfr"));
	}
	
	@Test
	public void testBackwardFacingWest()  {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(1,1,W)?", marsRover.executeCommand("frrrb"));
	}
	
	@Test
	public void testMoveLeft1Time() throws Exception {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,0,W)?", marsRover.executeCommand("l"));		
	}
	
	@Test
	public void testMoveLeft4Times() throws Exception {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,0,N)?", marsRover.executeCommand("llll"));		
	}
	
	@Test
	public void testMoveLeftBackwards() throws Exception {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(1,0,W)?", marsRover.executeCommand("lb"));		
	}
	
	@Test
	public void testEdgeAt00Back() throws Exception {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,99,N)?", marsRover.executeCommand("b"));
	}

	@Test
	public void testEdgeAt00LeftTop() throws Exception {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(99,0,W)?", marsRover.executeCommand("lf"));
	}
	
	@Test
	public void testEdgeAt99RightTop() throws Exception {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,0,E)?", marsRover.executeCommand("rffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"));
	}
	
	@Test
	public void testEdgeAt99UpperTop() throws Exception {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(0,0,N)?", marsRover.executeCommand("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"));
	}
	
	@Test
	public void testAllDirections() throws Exception {
		MarsRover marsRover = new MarsRover(100, 100, "");
		assertEquals("?(1,1,N)?", marsRover.executeCommand("flbr"));
	}

	@Test
	public void test1Obstacle() {
		MarsRover marsRover = new MarsRover(100, 100, "?(0,1)?");
		assertEquals("?(0,0,N)?", marsRover.executeCommand("f"));


	}
}

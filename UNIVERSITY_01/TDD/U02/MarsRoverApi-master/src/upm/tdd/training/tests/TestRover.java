package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import upm.tdd.training.MarsRover;

public class TestRover {

	@Test
	public void Test100x100GridNoObstacles() {
		MarsRover mr=new MarsRover(100,100,null);
		assertEquals(0,mr.getValueGrid(0, 0));
	}
	@Test
	public void Test100x100GridOneObstable11(){
		MarsRover mr=new MarsRover(100,100,"?(1,1)?");
		assertEquals(1,mr.getValueGrid(1, 1));
	}
	
	@Test
	public void TestInitialPositionRobot00(){
		MarsRover mr=new MarsRover(100,100,"?(1,1)?");
		mr.setInitialPosition(0,0,"N");
		assertEquals("[0,0]",mr.getPosition());
	}
	@Test
	public void TestInitialPositionRobot00Orientation(){
		MarsRover mr=new MarsRover(100,100,"?(1,1)?");
		mr.setInitialPosition(0,0,"N");
		assertEquals("N",mr.getOrientation());
	}
	@Test
	public void TestForwardMovement(){
		MarsRover mr=new MarsRover(20,30,"?(1,1)?");
		mr.setInitialPosition(0,0,"N");
		mr.executeCommand("f");
		assertEquals("[0,1]",mr.getPosition());
	}
	
	@Test
	public void TestBackWardMovement(){
		MarsRover mr=new MarsRover(4,3,"?(1,1)?");
		mr.setInitialPosition(0,0,"N");
		mr.executeCommand("b");
		assertEquals("[0,3]",mr.getPosition());
	}
	
	@Test
	public void TestLeftMovement(){
		MarsRover mr=new MarsRover(4,3,"?(1,1)?");
		mr.setInitialPosition(0,0,"N");
		mr.executeCommand("l");
		assertEquals("[0,0]",mr.getPosition());
		assertEquals("W",mr.getOrientation());
	}
	
	@Test
	public void TestForwardMovementWestOrientation(){
		MarsRover mr=new MarsRover(4,3,"?(1,1)?");
		mr.setInitialPosition(0,0,"W");
		mr.executeCommand("f");
		assertEquals("[2,0]",mr.getPosition());
		assertEquals("W",mr.getOrientation());
	}
	
	@Test
	public void TestForwardMovementSouthOrientation(){
		MarsRover mr=new MarsRover(4,3,"?(1,1)?");
		mr.setInitialPosition(0,0,"S");
		mr.executeCommand("f");
		assertEquals("[0,3]",mr.getPosition());
		assertEquals("S",mr.getOrientation());
	}
	
	
	@Test
	public void TestBackwardMovementNorthOrientation(){
		MarsRover mr=new MarsRover(4,3,"?(1,1)?");
		mr.setInitialPosition(0,0,"N");
		mr.executeCommand("b");
		assertEquals("[0,3]",mr.getPosition());
		assertEquals("N",mr.getOrientation());
	}
	
	@Test
	public void TestBackwardMovementEastOrientation(){
		MarsRover mr=new MarsRover(4,3,"?(1,1)?");
		mr.setInitialPosition(0,0,"E");
		mr.executeCommand("b");
		assertEquals("[2,0]",mr.getPosition());
		assertEquals("E",mr.getOrientation());
	}
	
	@Test
	public void TestExample100x10000NORTHCommandsffrff(){
		MarsRover mr=new MarsRover(100,100,null);
		mr.setInitialPosition(0,0,"N");
		mr.executeCommand("ffrff");
		assertEquals("[2,2]",mr.getPosition());
	}
	
	@Test
	public void TestPositionWithObstaclesffrff(){
		MarsRover mr=new MarsRover(100,100,"?(0,1)?");
		mr.setInitialPosition(0,0,"N");
		mr.executeCommand("ffrff");
		assertEquals("[2,0]",mr.getPosition());
	}
	
	@Test
	public void TestObstaclesffrffAppearOnlyOnceTheSameObstacle(){
		MarsRover mr=new MarsRover(100,100,"?(0,1)?");
		mr.setInitialPosition(0,0,"N");
		assertEquals("?(2,0,E)(0,1)?",mr.executeCommand("ffrff"));
	}

}

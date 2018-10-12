package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import upm.tdd.training.MarsRover;

public class TestRover {

	@Test
	public void executeCommandInLeftEdge() {
		MarsRover mr=new MarsRover(100,100,"?(5,5)(7,8)?");
		mr.executeCommand("lf");
		//fail("Not yet implemented");
	}
	
	public void executeCommandWhitoutObstacles(){
		MarsRover mr=new MarsRover(100,100,"??");
		mr.executeCommand("lfr");
		
	}
	
	public void excuteCommandInRightEdge(){
		MarsRover mr=new MarsRover(5,5,"??");
		mr.executeCommand("rrrrrrfrrrr");
		
	}
	
	public void executeCommandWhitObstacles(){
		MarsRover mr=new MarsRover(10,10,"?(5,5)(7,8)?");
		mr.executeCommand("lrffl");
		
	}

}

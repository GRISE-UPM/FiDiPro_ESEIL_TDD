package upm.tdd.training;

import static org.junit.Assert.assertEquals;


public class Principal {
	public static void main(String args[]){
		MarsRover mr=new MarsRover(100,100,"?(0,1)?");
		mr.setInitialPosition(0,0,"N");
		System.out.print(mr.executeCommand("ffrff"));
		
		//assertEquals("[2,0]",mr.getPosition());
		//assertEquals("[0,1]",mr.getPosition());
	}
}

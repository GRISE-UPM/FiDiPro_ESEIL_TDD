import java.util.ArrayList;

import java.util.List;





public class BowlingGame {

	BowlingException ex = new BowlingException("Greska") ;
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int rezultat = 0;

	public BowlingGame(){}


	public void addFrame(Frame frame) {
		int provera = frame.getFirstThrow() + frame.getSecondThrow();
		if(provera <=10){
			frames.add(frame);
		}
	}


	public void setBonus(int firstThrow, int secondThrow) {
		for(Frame f : frames){

		}

	}


	public int score(){

		int a = 0;
		for(Frame f : frames){

			a += f.score();
		}
		return a;
	}

	public Frame getBonus(){
		return bonus;
	}
}

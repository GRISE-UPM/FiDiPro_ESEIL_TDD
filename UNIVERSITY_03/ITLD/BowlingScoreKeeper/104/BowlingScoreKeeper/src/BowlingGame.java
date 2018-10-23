import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;






public class BowlingGame{


	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public int firstThrowOfNextFrame;
	public int secondThrowOfNextFrame;



	public BowlingGame(){

	}


	public void addFrame(Frame frame){

		if(frames.size()<10){
			frames.add(frame);
		} else {
			new BowlingException("Impossible to make new frame");
		}
	}



	public void setBonus(int firstThrow, int secondThrow) {

	}


	public int score(){

		int score=0;
		for(int i=0;i<frames.size();i++){
			score=score+frames.get(i).score();
		}

		return score;
	}

	public Frame getBonus() {
		return bonus;
	}

	public void setBonus(Frame bonus) {
		this.bonus = bonus;
	}

	public List<Frame> getFrames() {
		return frames;
	}


	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}
	public int getFirstThrowOfNextFrame() {
		return firstThrowOfNextFrame;
	}


	public void setFirstThrowOfNextFrame(int firstThrowOfNextFrame) {
		this.firstThrowOfNextFrame = firstThrowOfNextFrame;
	}


	public int getSecondThrowOfNextFrame() {
		return secondThrowOfNextFrame;
	}


	public void setSecondThrowOfNextFrame(int secondThrowOfNextFrame) {
		this.secondThrowOfNextFrame = secondThrowOfNextFrame;
	}

}

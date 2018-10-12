package upm.tdd.training;
import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame){
		if(frames.size()<10)
		  frames.add(frame);
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	public int score(){
		//to be implemented
		int score=0;
		for(int i=0;i<10;i++){
			if(frames.get(i).isStrike())
				score+=frames.get(i+1).getTrow1()+frames.get(i+1).getTrow2();
			if(frames.get(i).isSpare())
				score+=frames.get(i+1).getTrow1();
			score+=frames.get(i).score();
			
		}
		return score;
		
		
	}
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}
}

package upm.tdd.training;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame){
		frames.add(frame);
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	public int score(){
		int score = 0;
		boolean strike=false;
		boolean multipleStrike=false;
		boolean spare=false;

		for(Frame f  : frames){
			System.out.println(score);
			if(multipleStrike){
				score=score+f.score();
				multipleStrike=false;
			}
			if(strike){
				score=score+f.score();
				strike=false;	
				if(f.isStrike()){
					multipleStrike=true;
				}
			}
			else if(spare){
				score= score+f.getThrow1();
				spare=false;
			}
			score=score+f.score();
			if(f.isStrike()){
				strike=true;
			}
			else if(f.isSpare()){
				spare=true;
			}
		}
		return score;
	}
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}

	public boolean set10Frames(int[] valuesOfThrows) {
		// TODO Auto-generated method stub
		if(valuesOfThrows.length==20){
			for(int i=0; i<valuesOfThrows.length; i=i+2){
				addFrame(new Frame(valuesOfThrows[i],valuesOfThrows[i+1]));
			}
			return true;
		}
		else{
			return false;
		}	
	}
}

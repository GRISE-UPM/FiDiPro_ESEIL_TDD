package upm.tdd.training;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int firstThrow;
	private int secondThrow;
	
	public BowlingGame(Frame frame1,Frame frame2, Frame frame3, Frame frame4, Frame frame5, Frame frame6, Frame frame7, Frame frame8, Frame frame9, Frame frame10){
		frames.add(frame1);
		frames.add(frame2);
		frames.add(frame3);
		frames.add(frame4);
		frames.add(frame5);
		frames.add(frame6);
		frames.add(frame7);
		frames.add(frame8);
		frames.add(frame9);
		frames.add(frame10);
	}
	
	public void addFrame(Frame frame){
		//to be implemented
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
		this.firstThrow=firstThrow;
		this.secondThrow= secondThrow;
	}
	
	public int score(){
		//to be implemented
		int score = 0;
		int count = 0;
		int count1 = 0;
		boolean strike = false;
		boolean nextStrike = false;
		boolean nextNextStrike = false;
		boolean spare = false;
		Iterator<Frame> it= frames.iterator();
		Frame frameAux;
		while(it.hasNext()){
			frameAux=it.next();
			if(strike){
				if(frameAux.isStrike()){
					if(nextStrike){
						nextNextStrike=true;
					}else{
						nextStrike= true;
					}		
				}
				strike=false;
				score+=frameAux.score()*2;
			}else if(spare){
				spare=false;
				score+=frameAux.score()+frameAux.firstPin;
			}else{
				score+=frameAux.score();
			}
			if(nextStrike){
				count++;
				if(count==2){
					score+=frameAux.firstPin;
					nextStrike=false;
					count= 0;
				}
			}
			if(nextNextStrike){
				count1++;
				if(count1==2){
					score+=frameAux.firstPin;
					nextNextStrike=false;
					count1= 0;
				}
			}
			 if(frameAux.isStrike()){
				 strike = true;
				 if(!it.hasNext()){
					 score+=firstThrow+secondThrow;
				 }
			 }else if(frameAux.isSpare()){
				 spare = true;
				 if(!it.hasNext()){
					 score+=firstThrow;
				 }
			 }
		}
		return score;
	}
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}
}

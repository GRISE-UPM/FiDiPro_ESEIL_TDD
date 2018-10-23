import java.util.ArrayList;
import java.util.List;

import com.sun.glass.ui.Size;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int bonusPoints=0;
	private int score = 0;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException{
		if(frames.size()<10){
			frames.add(frame);
		}
		else{
			throw new BowlingException("Maximum frames are added!");
		}
	}


	public void setBonus(int firstThrow, int secondThrow) {

	}



	public int score(){
		for (Frame frame : frames) {
			score += frame.score();
		}
		return score;
	}

	public int scoreBonus(){
		for(int i = 1; i<frames.size(); i++){

			bonus = frames.get(i);
			if(frames.get(i-1).isStrike()&&frames.get(i-1)!=frames.get(9)){
				bonusPoints += bonus.getFirstThrow() + bonus.getSecondThrow();
			}
			else if(frames.get(i-1).isSpare()&&frames.get(i-1)!=frames.get(9)){
				bonusPoints += bonus.getFirstThrow();
			}else if(frames.get(i-1).isStrike()&&frames.get(i-1) == frames.get(9)){
				bonusPoints += frames.get(i-1).score() + frames.get(i-1).getThirdThrow();
			}else if(frames.get(i-1).isSpare()&&frames.get(i-1) == frames.get(9)){
				bonusPoints += frames.get(i-1).score() + frames.get(i-1).getThirdThrow();
			}

		}
		return score() + bonusPoints;
	}

	public int getFrames() {
		return frames.size();
	}
}

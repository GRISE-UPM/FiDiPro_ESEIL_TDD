import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int bonusGame = 0;
	public BowlingGame(){}
	private int score=0;

	public void addFrame(Frame frame) throws BowlingException{

		if(frames.size()==10)
			throw new BowlingException();
		else
			frames.add(frame);
	}


	public void setBonus(int firstThrow, int secondThrow) {


		for(int i = 0; i<frames.size();i++){
			if(frames.get(i).isStrike()){
				bonus = frames.get(i+1);
				bonusGame+=bonus.score();
			}
			else if (frames.get(i).isSpare()){
				bonus = frames.get(i+1);
				bonusGame+=bonus.getFirstThrow();
			}
		}
	}


	public int score(){


		for(int i = 0; i<frames.size();i++){
			score +=  frames.get(i).score();

		}
		return score + bonusGame;
	}

	public int getBonusGame() {
		return bonusGame;
	}


}

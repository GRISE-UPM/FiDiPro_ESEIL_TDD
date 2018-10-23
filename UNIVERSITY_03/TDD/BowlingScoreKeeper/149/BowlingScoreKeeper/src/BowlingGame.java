import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;


	public BowlingGame(){
	}


	public void addFrame(Frame frame) throws BowlingException{
		if(frames.size()<10){
			if(frame.score()<=10)
				frames.add(frame);
			else throw new BowlingException();
		} 
		else throw new BowlingException();
	}


	public void setBonus(int firstThrow, int secondThrow) throws BowlingException {
		if(frames.size()==10){
			if(secondThrow==0) {
			bonus.setFirstThrow(firstThrow);
			bonus.setSecondThrow(0);
			}
			else throw new BowlingException();
		}else throw new BowlingException();
	}
	public int countBonus() throws BowlingException{
		int bonuses=0;
		for(int i=0; i<frames.size(); i++){
			if(frames.get(i).isStrike()){
				bonuses+=frames.get(i+1).getFirstThrow() + frames.get(i+1).getSecondThrow();
			}
			else if(frames.get(i).isSpare()){
				bonuses+=frames.get(i+1).getFirstThrow();
			} 
		}
		return bonuses;
	}

	public int score() throws BowlingException{

		int score = 0;
		for(Frame frame : frames){
			score+=frame.score();
		}
		countBonus();
		score+=countBonus();
		return score;
	}

}

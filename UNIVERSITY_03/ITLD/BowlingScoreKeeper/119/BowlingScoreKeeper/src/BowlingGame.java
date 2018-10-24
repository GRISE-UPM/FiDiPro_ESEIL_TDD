import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException{
		for(int i = 0; i < 10; i++)
		{
			frames.add(frame);
		}
		if(frames.size() > 10){
			throw new BowlingException();
		}
		else{
			frames.add(frame);
		}
	}

	public boolean gameEnded(){
		if(frames.size() > 10){
			return true;
		}
		return false;
	}


	public void setBonus(int firstThrow, int secondThrow) {
		for(Frame fr : frames){
			if(fr.isStrike()){

			}
		}
	}


	public int score(){
		int score = 0;
		for(Frame fr : frames){
			if(fr.isStrike()){
				score += fr.getFirstThrow() + fr.getSecondThrow();
			}
			else if(fr.isSpare()){
				score += fr.getFirstThrow();
			}
		}
		return score;
	}
}

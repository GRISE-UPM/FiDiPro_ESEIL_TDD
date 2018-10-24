import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException{
		if (frames.size() == 10){
			throw new BowlingException();
		}
		frames.add(frame);
	}


	public void setBonus(int firstThrow, int secondThrow) {

	}


	public int score(){
		int score = 0;
		boolean flagStrike = false;
		boolean flagSpare = false;
		boolean flagDoubleStrike = false;
		for (Frame f : frames){
			if (flagStrike){
				if (flagDoubleStrike){
					score += f.getFirstThrow();
					flagDoubleStrike = false;
				} else if (flagStrike == true && f.isStrike() == true){
					flagDoubleStrike = true;
				}
				score += f.getFirstThrow() + f.getSecondThrow();
				flagStrike = false;

			} else if (flagSpare){
				score += f.getFirstThrow();
				flagSpare = false;
			}
			if (f.isStrike()){
				flagStrike = true;
			} else if(f.isSpare()){
				flagSpare = true;
			}
			score += f.getFirstThrow() + f.getSecondThrow();
		}
		return score;
	}
}

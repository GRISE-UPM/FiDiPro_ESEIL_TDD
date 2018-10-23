import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){}


	public void addFrame(Frame frame){


		if (frames.size() < 10) {
			frames.add(frame);
		} else {
			new BowlingException("Max size is 10");
		}
	}


	public void setBonus(int firstThrow, int secondThrow) {



	}


	public int score(){


		int score = 0;
		for (int i=0; i < frames.size(); i++) {
			score = score + frames.get(i).score();
		}

		return score;
	}
}

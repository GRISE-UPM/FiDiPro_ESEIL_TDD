import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int score = 0;

	public BowlingGame(){}


	public void addFrame(Frame frame){

		frames.add(frame);
	}


	public void setBonus(int firstThrow, int secondThrow) {

		for (Frame frame : frames) {
			int i = 0;
			if (frames.get(i-1).isSpare() && i > 0) {
				frames.get(i-1).bonus = frames.get(i).getFirstThrow();
				i++;
			}
		}
	}


	public int score(){


		for (int i = 0; i < frames.size()-1; i++) {
			if(frames.get(i).isSpare()){
				score += frames.get(i).score();

			} else {

				score += frames.get(i).score() + frames.get(i+1).getFirstThrow();
			}
		}*		int i = 0;
		boolean e = false;
		for (Frame frame : frames) {

			if (frame.isSpare() && i < 10) {
				e =  true;
				score += frame.score();
			} else {
				score += frame.score();
				i++;
			}

		}

		return score;
	}
}

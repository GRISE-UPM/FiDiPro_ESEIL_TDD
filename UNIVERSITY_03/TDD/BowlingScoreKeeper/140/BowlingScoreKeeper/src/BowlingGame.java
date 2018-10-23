import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int score = 0;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException {
		if (frames.size() < 10) {
			this.frames.add(frame);
		}
		else {
			throw new BowlingException() ;

		}
	}


	public void setBonus(int firstThrow, int secondThrow) throws BowlingException {
		if (frames.size() == 10) {
			if (firstThrow > 10) {
				throw new BowlingException();
			}
			else if (secondThrow > 10) {
				throw new BowlingException();
			}
			else {
				if (frames.get(9).isStrike() && frames.get(8).isStrike()) {
					score = score + 10 + firstThrow + firstThrow;
				}
				else if (frames.get(9).isStrike()) {
					score = score  + firstThrow;
				}
				else if (frames.get(9).isSpare()) {
					score = score  + firstThrow;
				}
			}
		}
	}

	public int addBonus() throws BowlingException {
		for (int i = 0; i < frames.size() - 1; i++) {
			if (frames.get(i).isStrike() && frames.get(i+1).isStrike() && i <= frames.size() - 2) {
				score = score + 10 + frames.get(i+1).getFirstThrow();
			}
			else if (frames.get(i).isStrike() && i <= frames.size() - 1) {
				score = score + frames.get(i+1).getFirstThrow() + frames.get(i+1).getSecondThrow();
			}
			else if (frames.get(i).isSpare() && i <= frames.size() - 1) {
				score = score + frames.get(i+1).getFirstThrow();
			}
		}
		return score;
	}


	public int score() throws BowlingException{
		int score = 0;
		for (int i = 0; i < frames.size(); i++) {
			score = score + frames.get(i).score();
		}
		return score + addBonus();
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}
}

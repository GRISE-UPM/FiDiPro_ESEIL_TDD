import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int totalScore = 0;

	public BowlingGame() {
	}


	public void addFrame(Frame frame) throws BowlingException {
		if (frames.size() < 10)
			frames.add(frame);
		else
			throw new BowlingException("Max number of frames exceded.");
	}


	public int score() {
		for (int i = 0; i < frames.size(); i++) {



			if (i != 0) {
				if (frames.get(i - 1).isStrike())
					frames.get(i - 1).setFrameScore(frames.get(i - 1).score() + frames.get(i).score());
				else if (frames.get(i - 1).isSpare())
					frames.get(i - 1).setFrameScore(frames.get(i - 1).score() + frames.get(i).getFirstThrow());
			}

			totalScore += frames.get(i).score();
		}

		if (bonus != null) {
			if (frames.get(9).isSpare())
				totalScore += bonus.getFirstThrow();
			else if (frames.get(9).isStrike())
				totalScore += bonus.score();
		}
		return totalScore;
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}

	public Frame getBonus() {
		return bonus;
	}


	public void setBonus(int firstThrow, int secondThrow) throws BowlingException {

		bonus = new Frame(firstThrow, secondThrow);
	}
}

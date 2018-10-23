import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int totalScore = 0;

	public BowlingGame(){

	}


	public void addFrame(Frame frame) throws BowlingException{
		if (frames.size() > 10) {
			throw new BowlingException("Error. Maximum number of frames reached.");
		}
		frames.add(frame);
	}


	public void setBonus(int firstThrow, int secondThrow) {
		bonus = new Frame(firstThrow, secondThrow);
	}


	public int score() throws BowlingException{
		for (int i = 0; i < frames.size(); i++) {
			if (i != 0) {
				if(frames.get(i-1).isStrike()) {
					frames.get(i-1).setFrameScore(frames.get(i-1).score() + frames.get(i).score());
				} else if (frames.get(i-1).isSpare()) {
					frames.get(i-1).setFrameScore(frames.get(i-1).score() + frames.get(i).getFirstThrow());
				}
			}
			totalScore += frames.get(i).score();
		}

		if (bonus != null) {
			if (frames.get(9).isStrike()) {
				totalScore += bonus.score();
			} else if (frames.get(9).isSpare()) {
				totalScore += bonus.getFirstThrow();
			}
		}
		return totalScore;
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}
}

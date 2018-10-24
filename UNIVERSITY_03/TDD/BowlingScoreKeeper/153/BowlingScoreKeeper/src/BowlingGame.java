import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException{

		if(frames.size() > 10)
			throw new BowlingException();
		else
			frames.add(frame);
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}


	public void setBonus(int firstThrow, int secondThrow) {

		if(frames.size() == 10)
		{

		}
	}


	public int score(){

		int score = 0;
		for(Frame f : frames)
		{
			score += f.score();
		}
		return score;
	}

	public void addBonus()
	{

	}

	public Frame getBonus() {
		return bonus;
	}

	public void setBonus(Frame bonus) {
		this.bonus = bonus;
	}
}

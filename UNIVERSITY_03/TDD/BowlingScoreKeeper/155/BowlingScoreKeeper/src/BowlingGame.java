import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException {
		if(frames.size() < 10)
			frames.add(frame);
		else
			throw new BowlingException("Frame limit exceeded.");
	}


	public int getFramesScore(int index)
	{
		return frames.get(index).score();
	}


	public Frame getFrame(int index)
	{
		return frames.get(index);
	}


	public void setBonus(int firstThrow, int secondThrow) {
		if (frames.get(frames.size()-1).isSpare() || frames.get(frames.size()-1).isStrike())
			bonus = new Frame();
	}


	public int score(){

		int score = 0;



		for(int i = 0; i < frames.size(); i++)
		{
			score += frames.get(i).score();


			if(frames.get(i).isStrike() && i <= 7)
				score = score + frames.get(i+1).score() + frames.get(i+2).score();
			else if (frames.get(i).isStrike() && i == 8)
				score = score + frames.get(i+1).score();


			if(frames.get(i).isSpare() && i <= 8)
				score = score + frames.get(i).getFirstThrow();
		}
		*

		for(Frame f : frames)
		{
			score += f.score();
		}

		return score;
	}
}

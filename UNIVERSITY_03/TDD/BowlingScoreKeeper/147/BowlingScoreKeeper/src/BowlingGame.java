import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException{
		if(frames.size() <10)
		{
			frames.add(frame);
		}
		else
		{
			throw new BowlingException();
		}
	}


	public void setBonus(int firstThrow, int secondThrow) {

		if(frames.get(frames.size()-1).isSpare() || frames.get(frames.size()-1).isStrike())
			{
				bonus = new Frame(firstThrow, 0);
				frames.add(bonus);
			}

		}

	public void addBonus()
	{
		for(int i=0; i<frames.size(); i++)
		{
			if(frames.get(i).isStrike())
			{
				bonus = new Frame(frames.get(i+1).getFirstThrow(),frames.get(i+1).getSecondThrow());
				frames.add(bonus);
			}
			else if(frames.get(i).isSpare())
			{
				bonus = new Frame(frames.get(i+1).getFirstThrow(),0);
				frames.add(bonus);
			}
		}
	}



	public int score() throws BowlingException{
		int score=0;
		for(int i=0; i<frames.size(); i++)
			score+=frames.get(i).score();
		return score;
	}
}

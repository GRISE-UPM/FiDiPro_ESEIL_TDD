import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int bonusEnd = 0;

	int score = 0;

	public BowlingGame(){}


	public void addFrame(Frame frame){
		frames.add(frame);
	}


	public void setBonus(int firstThrow, int secondThrow) {
		for(int i =0; i < frames.size(); i++)
		{
			if(frames.get(i).isSpare())
			{
				bonus = frames.get(i+1);
				bonusEnd = bonus.score();
			}
			else 

			if(frames.get(i).isStrike())
			{
				bonus = frames.get(i+1);
				bonusEnd = bonus.score();
			}

		}
	}


	public int score(){


		for(int i=0; i<frames.size(); i++)
		{
			score += frames.get(i).getFirstThrow() + frames.get(i).getSecondThrow() + bonusEnd;
		}
		return score;

	}
}

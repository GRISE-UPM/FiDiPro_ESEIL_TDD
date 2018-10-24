import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int bonusGame =0;
	private int score=0;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException
	{
		if(frames.size()==10)
			throw new BowlingException();
		else
			frames.add(frame);




	}


	public void setBonus(int firstThrow, int secondThrow) {

		for(int i=0; i<10; i++)
			if(frames.get(i).isSpare())
			{
				bonus= frames.get(i+1);
				bonusGame+=bonus.score();
			}
			else if(frames.get(i).isStrike())
			{
				bonus = frames.get(i+1);
				bonusGame+=bonus.score();

			}
	}


	public int score(){

		for(int i=0; i<10; i++)
		{
			score= frames.get(i).score();
		}


		return score + bonusGame;
	}
}

import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	private int bonuss;


	public BowlingGame(){}


	public void addFrame(Frame frame){


		frames.add(frame);


	}


	public void setBonus(int firstThrow, int secondThrow) {

		for(int i=0;i<10;i++)
		{
			if(bonus.isSpare())
			{
				bonuss=frames.get(i+1).score(); 
			}
			else if(bonus.isStrike())
			{
				bonuss=frames.get(i+1).getFirstThrow() + frames.get(i+1).getSecondThrow(); 
			}
		}

	}



	public int score(){

		return bonus.getFirstThrow() + bonus.getSecondThrow(); 
	}
}

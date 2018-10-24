import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int totalScore=0;


	public BowlingGame(){
		bonus=new Frame(0,0);
	}


	public void addFrame(Frame frame) throws BowlingException{
		if(frames.size()>10)
			throw new BowlingException("Broj frame-ova ne smije biti veci od 10!");
		else
			frames.add(frame);
	}


	public void setBonus(int firstThrow, int secondThrow) {
		bonus.setFirstThrow(firstThrow);
		bonus.setSecondThrow(secondThrow);
	}


	public int score() throws BowlingException{

		for(int i=0;i<frames.size();i++)
		{
			totalScore+=frames.get(i).score();
			if(i<9)
			{
				if(frames.get(i).isSpare())
				{
					this.setBonus(frames.get(i+1).getFirstThrow(), 0);
				}
				else if(frames.get(i).isStrike())
				{
					this.setBonus(frames.get(i+1).getFirstThrow(), frames.get(i+1).getSecondThrow());
				}	
			}
			totalScore+=bonus.score();
			setBonus(0,0);	
		}	
		return totalScore;
	}

	public Frame getBonus() {
		return bonus;
	}

}

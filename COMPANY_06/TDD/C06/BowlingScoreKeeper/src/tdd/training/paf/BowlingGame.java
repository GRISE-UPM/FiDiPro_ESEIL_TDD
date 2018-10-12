package tdd.training.paf;
import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus = null;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame){
		if ( frames.size() < 10 )
		{
			frames.add(frame);
		}
		if ( frames.size() == 10 )
		{
			frames.add(new Frame(0, 0));
		}
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		bonus = new Frame(firstThrow, secondThrow);
	}
	
	public int score(){
		int result = 0;
		for (int i = 0; i < frames.size(); i++)
		{
			if ( i < 10 )
			{
				if ( frames.get(i).isSpare() && frames.size() >= i + 1 )
				{
					int validRoll = frames.get(i + 1).GetFirstThrow() != 0 ? frames.get(i + 1).GetFirstThrow() : frames.get(i + 1).GetSecondThrow();
					//System.out.println(frames.get(i).score() + validRoll);
					result += frames.get(i).score() + validRoll;
				}
				else if ( frames.get(i).isStrike() && frames.size() >= i + 1 )
				{
					//System.out.println(frames.get(i).score() + frames.get(i + 1).score());
					result += frames.get(i).score() + frames.get(i + 1).score();
				} 
				else
				{
					//System.out.println(frames.get(i).score());
					result += frames.get(i).score();
				}
			}
		}
		if ( bonus != null )
		{
			result += bonus.score();
		}
		return result;
	}
	
	public boolean isNextFrameBonus(){
		if ( frames.size() != 0 )
		{
			Frame last = frames.get(frames.size() - 1);
			return last.isSpare() || last.isStrike();
		}
		return false;
	}
	
	public int getFrameCount()
	{
		return frames.size();
	}
}

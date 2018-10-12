package tdd.training.paf;
import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	
	public static final int MAX_NUMBER_OF_FRAMES = 10;
	public static final int MAX_NUMBER_OF_PINS = 10;
	
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus = null;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame)
	{
		//first frame
		if (bonus != null) 
		{
			if (frames.size() != MAX_NUMBER_OF_FRAMES)
			{
				if (bonus.isStrike())
				{
					bonus.setBonus(frame.getFirstThrow() + frame.getSecondThrow());
				}
				else if (bonus.isSpare()) 
				{
					bonus.setBonus(frame.getFirstThrow());
				}	
				//System.out.println("Before update " + frame.score());
				frame.updateTotalScore(bonus.score());
				//System.out.println("After update " + frame.score());
				bonus.setLastFrame(false);
				frames.add(frame);
				//to be implemented
				frame.setLastFrame(true);
				bonus = frame;
			}
			else
			{
				if ((bonus.isSpare())||(bonus.isStrike()) )
				{
					bonus.updateTotalScore(frame.getFirstThrow());
				}
			}
		}
		else
		{
			frames.add(frame);
			bonus = frame;
		}
	
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	public int score(){
		//to be implemented
		int length = frames.size();
		return frames.get(length-1).score();
	}
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}
	
	public void printScores()
	{
		for (Frame fr : frames)
			System.out.println("SCORE " + fr.score());
	}
	
	public static void main(String args[])
	{
		BowlingGame bowlingGame = new BowlingGame();
		Frame f1 = new Frame(1,4);
		bowlingGame.addFrame(f1);
		Frame f2 = new Frame(4,5);
		bowlingGame.addFrame(f2);
		Frame f3 = new Frame(6,4);
		bowlingGame.addFrame(f3);
		Frame f4 = new Frame(5,5);
	    bowlingGame.addFrame(f4);
		Frame f5 = new Frame(10,0);
	    bowlingGame.addFrame(f5);
		Frame f6 = new Frame(0,1);
	    bowlingGame.addFrame(f6);
		Frame f7 = new Frame(7,3);
	    bowlingGame.addFrame(f7);
		Frame f8 = new Frame(6,4);
	    bowlingGame.addFrame(f8);
		Frame f9 = new Frame(10,0);
	    bowlingGame.addFrame(f9);
		Frame f10 = new Frame(2,8);
	    bowlingGame.addFrame(f10);
		Frame f11 = new Frame(6,0);
	    bowlingGame.addFrame(f11);
		System.out.println("FINLA SCORE: " +  bowlingGame.score());
		bowlingGame.printScores();
	}
}

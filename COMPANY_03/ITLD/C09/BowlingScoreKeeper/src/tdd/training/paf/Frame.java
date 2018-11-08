package tdd.training.paf;


public class Frame {
	private int firstThrow;
	private int secondThrow;
	private boolean isLastFrame = false;
	private int bonus = 0;
	private int score =0;

	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;

		score = firstThrow + secondThrow;
	}
	
	//the score of a single frame
	public int score(){
		//to be implemented
		return  score;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike()
	{
		boolean result = false;
		
		if ((firstThrow == BowlingGame.MAX_NUMBER_OF_PINS)|| (secondThrow == BowlingGame.MAX_NUMBER_OF_PINS) )
		{
			result = true;
			//score = BowlingGame.MAX_NUMBER_OF_PINS;
		}
		return result;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare()
	{
		boolean result = false;
		
		if ((firstThrow + secondThrow) == BowlingGame.MAX_NUMBER_OF_PINS) 
		{
			result = true;
			//score = BowlingGame.MAX_NUMBER_OF_PINS;
		}
		
		return result;
	}

	//return whether this is the last frame of the match
	public boolean isLastFrame()
	{
		return isLastFrame;
	}
	
	public void setLastFrame(boolean bool)
	{
		isLastFrame = bool;
	}

	//bonus throws
	public int bonus(){
		return bonus;
	}
	
	public void setBonus(int bonusA)
	{
		this.bonus = bonusA;
		score += bonusA;
	}
	
	public int getFirstThrow()
	{
		return firstThrow;
	}
	
	public int getSecondThrow()
	{
		return secondThrow;
	}
	
	public void updateTotalScore(int total)
	{
		 score += total;
	}

}

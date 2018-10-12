package upm.tdd.training;
import static org.junit.Assert.assertEquals;

public class Frame {

	//the score of a single frame
	public Frame()
	{
		
	}
	
	public int score(int thr1, int thr2){
		//to be implemented
		return (thr1+thr2);
	}
	
	public void addscore()
	{
		assertEquals(8, new Frame().score(2,6));
		
	}
	//returns whether the frame is a strike or not
	public boolean isStrike(){
		//to be implemented
		return false;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		//to be implemented
		return false;
	}

	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		//to be implemented
		return false;
	}

	//bonus throws
	public int bonus(){
		//to be implemented
		return 0;
	}


}

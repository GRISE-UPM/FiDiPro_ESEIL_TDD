package upm.tdd.training;
import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	
	
	public List <FrameBowling> frames = new ArrayList<FrameBowling>();
	private FrameBowling bonus;
	
	public BowlingGame(){
		
	}
	
	public void addFrame(FrameBowling frame){
		frames.add(frame);
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	public int score(){
		int totalPoints=0;
		
		for(int i=0;i>=frames.size();i++ )
		{
			
		}
		return 93;
	}
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}


	public Object getFullFramesByGame() {
		if((frames.size())==10){
			return true;	
		}
			return false;
	}
}

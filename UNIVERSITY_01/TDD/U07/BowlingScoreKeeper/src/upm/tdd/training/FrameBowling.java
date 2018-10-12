package upm.tdd.training;


public class FrameBowling {
	
	public Integer throw1=null;
	public Integer throw2=null;


	BowlingGame game1= new BowlingGame();
		
	public void setThrowsByFrame(int firstThrow, int secondThrow){
			this.throw1= firstThrow;
			this.throw2= secondThrow;
		}
	
	
	public boolean getThrowsByFrame(){
		if (throw1!= null && throw2!=null){
			return true;
		}else
			return false;
	}
	
	//the score of a single frame
	public int score(){
		//to be implemented
		return 0;
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

	public Object scoreByFrame() {
		int result = throw1+throw2;
		return result;
	}


}

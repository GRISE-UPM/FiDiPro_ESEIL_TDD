package tdd.training.paf;


public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	
	//the score of a single frame
	public int score(){
		return firstThrow+secondThrow;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		//to be implemented
		if(firstThrow == 10){			
			return true;
		}
		return false;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		if(firstThrow < 10 && firstThrow+secondThrow == 10)
			return true;
		return false;
	}

	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		return false;
	}

	//bonus throws
	public int bonus(){
		int total = 0;
		if(isStrike()){
			
		}else if(isSpare()){
			
		}
		return total;
	}


}

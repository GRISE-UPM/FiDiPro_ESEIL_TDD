package upm.tdd.training;


public class Frame {
	int firstPin;
	int secondPin;
	int [] frame;
	
	public Frame(int x,int y){
		firstPin=x;
		secondPin=y;
		frame=new int[2];
		frame[0]=firstPin;
		frame[1]=secondPin;
		
	}
	
	public int getFirstPin() {
		return firstPin;
	}

	public void setFirstPin(int firstPin) {
		this.firstPin = firstPin;
	}

	public int getSecondPin() {
		return secondPin;
	}

	public void setSecondPin(int secondPin) {
		this.secondPin = secondPin;
	}

	//the score of a single frame
	public int score(){
		//to be implemented
		return firstPin+secondPin;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		boolean strike = false;
		if(firstPin==10 && secondPin==0){
			strike = true;
		}
		return strike;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		boolean spare=false;
		if(firstPin+secondPin==10){
			spare=true;
		}
		return spare;
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

package upm.tdd.training;


public class Frame {

	private int pins;
	private int trow1;
	private int trow2;
	
	public int getTrow1() {
		return trow1;
	}


	public int getTrow2() {
		return trow2;
	}

	
	
	public Frame(int trow1,int trow2){
		pins=10;
		this.trow1=trow1;
		this.trow2=trow2;
	} 
	
	
	//the score of a single frame
	public int score(){
		//to be implemented
		return trow1+trow2;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		//to be implemented
		if(trow1==10)
			return true;
		else
			return false;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		//to be implemented
		if(trow1+trow2==10)
			return true;
		else
			return false;
	}

	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		return false;
	}

	//bonus throws
	public int bonus(){
		//to be implemented
		return 0;
	}
	
	


}

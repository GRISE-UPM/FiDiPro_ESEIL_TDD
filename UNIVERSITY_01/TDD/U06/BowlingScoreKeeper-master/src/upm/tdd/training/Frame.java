package upm.tdd.training;


public class Frame {

	private int throw1;
	private int throw2;
	
	public Frame(int throw1, int throw2){
		this.throw1=throw1;
		this.throw2=throw2;
	}
	
	//the score of a single frame
	public int score(){
		return this.throw1+this.throw2;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		if(this.throw1==10){
			return true;
		}
		return false;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		if(score()==10 && this.throw1!=10){
			return true;
		}
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

	public String getFrame(){
		return "["+this.throw1+","+this.throw2+"]";
	}
	
	public int getThrow1(){
		return this.throw1;
	}

}

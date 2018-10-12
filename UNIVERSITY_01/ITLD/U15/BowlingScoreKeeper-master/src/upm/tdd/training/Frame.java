package upm.tdd.training;


public class Frame {
	private String lanzamiento1;
	private String lanzamiento2;
	
	public Frame(String Lanzamiento1, String Lanzamiento2){
		lanzamiento1 = Lanzamiento1;
		lanzamiento2 = Lanzamiento2;
	}
	
	public String getLanzamiento1(){
		return lanzamiento1;
	}
	
	public void setLanzamiento1(String lanzamiento1){
		this.lanzamiento1 = lanzamiento1;
	}
	
	public String getLanzamiento2(){
		return lanzamiento2;
	}
	
	public void setLanzamiento(String lanzamiento2){
		this.lanzamiento2 = lanzamiento2;
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


}

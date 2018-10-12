package upm.tdd.training;


public class Frame {

	public int tiro1;
	public int tiro2;
	
	
	public Frame(){
		tiro1=0;
		tiro2=0;
				
	}
	
	public void iniciarFrame()
	{
		tiro1 = (int) (Math.random()*10 + 1); 
		tiro2 = (int) (Math.random()*10 + 1);
	}
	
	//the score of a single frame
	public int score(){
		//to be implemented
		int total;
		
		total = tiro1 + tiro2;
		
		return total;
		
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		//to be implemented
		boolean indicador=false;
		
		if (tiro1 ==10 && tiro2==0) indicador = true;
		
		return indicador;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		//to be implemented
		int suma=0;
		boolean indicador =false;
		
		suma=tiro1+tiro2;
		if (suma==10) indicador =true;
		
		return indicador;
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

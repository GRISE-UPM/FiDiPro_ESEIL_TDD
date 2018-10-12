package upm.tdd.training;
import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private Frame frame01 = null ;
	
			
	public BowlingGame(){
				
	}
	
	public void addFrame(Frame frame){
		//to be implemented
		
		frames.add(frame);
		
	}
	
	public void iniciarJuego() {
		for (int i=0; i < 10;i++ )
		{
			frame01.iniciarFrame();
			frames.add(frame01);
		}
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	
	public int score(){
		
		int sumatoria=0;
		
		for (int i=0; i < 10;i++ )
		{	//Strike
			if (i==0 && frames.get(i).tiro1 ==10 && frames.get(i).tiro2 ==0)
			{
				sumatoria = sumatoria + frames.get(i+1).tiro1;
				sumatoria = sumatoria + frames.get(i+1).tiro2;
			}
			else //Spare
			if ((frames.get(i).tiro1 + frames.get(i).tiro2) ==10 && (frames.get(i+1).tiro1 + frames.get(i+1).tiro2) ==10 )
			{
				sumatoria = sumatoria + frames.get(i+1).tiro1;				
			}
			else //Strike + Spare
			if (frames.get(i).isStrike()&& (frames.get(i+1).isSpare()) && (frames.get(i+2).isSpare()))
			{
				sumatoria = sumatoria + frames.get(i+1).tiro1;				
				sumatoria = sumatoria + frames.get(i+1).tiro2;
				
				sumatoria = sumatoria + frames.get(i+2).tiro1;
			}
			else //Multiple Strike
			if (frames.get(i).isStrike() && frames.get(i+1).isStrike())
			{
				sumatoria = sumatoria + frames.get(i+1).tiro1;				
				sumatoria = sumatoria + frames.get(i+2).tiro1;
				
				sumatoria = sumatoria + frames.get(i+2).tiro1;
				sumatoria = sumatoria + frames.get(i+2).tiro2;
			}

			else //Multiple Spare
			if (frames.get(i).isSpare()  && frames.get(i+1).isSpare())
			{
				sumatoria = sumatoria + frames.get(i+1).tiro1;				
				sumatoria = sumatoria + frames.get(i+2).tiro1;
				
				sumatoria = sumatoria + frames.get(i+2).tiro1;
				sumatoria = sumatoria + frames.get(i+2).tiro2;
			}
			else //Spare Last Frame
			if (frames.get(9).isSpare())
			{
				sumatoria = sumatoria + frames.get(i+1).tiro1;				
				sumatoria = sumatoria + frames.get(i+2).tiro1;
				
				sumatoria = sumatoria + frames.get(i+2).tiro1;
				sumatoria = sumatoria + frames.get(i+2).tiro2;
			}

			
			
			
			sumatoria = sumatoria + frames.get(i).tiro1;
			sumatoria = sumatoria + frames.get(i).tiro2;
		}
				
		
		return sumatoria;
	}
	
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}
	
	
}

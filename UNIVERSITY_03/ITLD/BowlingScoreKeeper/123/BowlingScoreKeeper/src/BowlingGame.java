import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int bonusBroj = 0;
	Frame frame = new Frame();
	public int frameNumber;



	public BowlingGame(){}

	public BowlingGame(Frame frame){

	}


	public void addFrame(Frame frame){
		if(frame.frameDodavanje == true){
			frames.add(frame);	
			frameNumber++;
		}


	}


	public void setBonus(int firstThrow, int secondThrow) {
		if(firstThrow == 10){
			bonusBroj = bonus.getFirstThrow() * 2; 
		} else if(firstThrow + secondThrow == 10){
			bonusBroj = bonus.getFirstThrow(); 
		} else 
			bonusBroj = 0;

	}


	public int score(){
		 return frame.getFirstThrow() + frame.getSecondThrow() + bonusBroj ;

	}
}

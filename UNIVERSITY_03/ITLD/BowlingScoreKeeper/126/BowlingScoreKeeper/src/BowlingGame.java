import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){}


	public void addFrame(Frame frame){
		if(frames.size()<=10)
		frames.add(frame);
	}


	public void setBonus(int firstThrow, int secondThrow) {
		if(firstThrow+secondThrow==10){
			System.out.println("Bonus pri spare-u je "+bonus.getFirstThrow());
		}
		else if(firstThrow==10){
			System.out.println("Bonus pri strike-u je "+bonus.getFirstThrow()+bonus.getSecondThrow());

		}
	}


	public int score(){

		return 0;
	}
}

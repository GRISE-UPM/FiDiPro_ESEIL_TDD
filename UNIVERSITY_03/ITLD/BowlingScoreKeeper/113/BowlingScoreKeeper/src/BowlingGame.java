import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int bonusPoints = 0;

	public BowlingGame(){}


	public void addFrame(Frame frame){
		frames.add(frame);
	}


	public void setBonus(int firstThrow, int secondThrow) {
		if(bonus.isSpare() == true)
			bonusPoints = firstThrow + secondThrow + frames.get(1).getFirstThrow();
		else if(bonus.isStrike() == true)
			bonusPoints = firstThrow + secondThrow + frames.get(1).getFirstThrow() + frames.get(1).getSecondThrow();
	}


	public int score(){
		int rez = 0;
		for(int i = 0; i < 10; i++)
			rez = rez + frames.get(i).score();
		return rez;
	}
}

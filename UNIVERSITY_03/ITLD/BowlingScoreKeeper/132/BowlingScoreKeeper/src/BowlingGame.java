import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){}


	public void addFrame(Frame frame){

	}


	public void setBonus(int firstThrow, int secondThrow) {

	}


	public int score(){
		int score = 0;
		for(Frame n: frames)
		{
			score += n.score();
		}
		return score;
	}
}

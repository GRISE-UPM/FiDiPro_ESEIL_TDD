import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int score;
	private int frameCounter=-1;


	public BowlingGame(){

		score=0;
	}


	public void addFrame(Frame frame) throws Exception{

		frames.add(frame);
		score=score+frame.score();
		frameCounter++;

		if (frameCounter>=1) {

			if (frames.get(frameCounter-1).isSpare()) {

				setBonus(frame.getFirstThrow(), 0);
			}

			else if (frames.get(frameCounter-1).isStrike()) {

				setBonus(frame.getFirstThrow(), frame.getSecondThrow());
			}

		} 
	}


	public void setBonus(int firstThrow, int secondThrow) {

			score=score+firstThrow+secondThrow;

	}


	public int score(){

		return score;
	}
}

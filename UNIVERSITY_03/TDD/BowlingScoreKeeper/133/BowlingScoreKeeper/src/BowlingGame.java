import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int finalScore;

	public BowlingGame() throws BowlingException{
		bonus = new Frame(0,0);
		finalScore = 0;
	}


	public void addFrame(Frame frame) throws BowlingException{
		if(frames.size() == 10 && (frame.isSpare() || frame.isStrike()))
			frames.add(frame);
		else if(frames.size() < 10)
			frames.add(frame);
		else
			throw new BowlingException();
	}


	public void setBonus(int firstThrow, int secondThrow) {
		bonus.setFirstThrow(firstThrow);
		bonus.setSecondThrow(secondThrow);
	}


	public int score() throws BowlingException{

		Frame tmp = new Frame(0,0);

		for(int i = 0 ; i < frames.size() ; i++){

			finalScore = finalScore + frames.get(i).score();

			if(tmp.isStrike())
				this.setBonus(frames.get(i).getFirstThrow(),frames.get(i).getSecondThrow());
			else if(tmp.isSpare())
				this.setBonus(frames.get(i).getFirstThrow(), 0);

			finalScore = finalScore + bonus.score();

			this.setBonus(0, 0);
			tmp = frames.get(i);
		}

		return finalScore;
	}

	public Frame getBonus() {
		return bonus;
	}

	public void setBonus(Frame bonus) {
		this.bonus = bonus;
	}
}

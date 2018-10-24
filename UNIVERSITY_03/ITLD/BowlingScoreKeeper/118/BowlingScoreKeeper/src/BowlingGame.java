import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int finalScore;


	public BowlingGame(){
		this.bonus = new Frame(0,0);
		finalScore = 0;

	}


	public void addFrame(Frame frame) throws BowlingException{
		if(frames.size()<10)
		frames.add(frame);
		else throw new BowlingException();

	}


	public void setBonus(int firstThrow, int secondThrow) {

		this.bonus.setFirstThrow(firstThrow); 
		this.bonus.setSecondThrow(secondThrow);

	}


	public int score() throws BowlingException{
		Frame temp = new Frame(0,0);
		for (Frame frame : frames) {
			finalScore+=frame.score();


			if(temp.isStrike()) 
				this.setBonus(frame.getFirstThrow(),frame.getSecondThrow());

			else if(temp.isSpare())
				this.setBonus(frame.getFirstThrow(), 0);

			finalScore+=this.bonus.score();
			this.setBonus(0, 0);
			temp = frame;

		}


		return finalScore;
	}
}

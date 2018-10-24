import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;


	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException{
		if(frames.size()<11)
		{
			frames.add(frame);
		}
		else
		{
			throw new BowlingException();
		}

	}


	public void setBonus(int firstThrow, int secondThrow) {
		if(frames.get(9).isStrike()||frames.get(9).isSpare()){
			bonus=new Frame(firstThrow,secondThrow);

		}


	}


	public int score(){

		return 0;
	}
}

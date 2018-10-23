import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException{

		if(frame.size()<10)
		{
			frames.add(frame);
		}else
			throw new BowlingException();

	}


	public void setBonus(int firstThrow, int secondThrow) {

	}


	public int score(){

		int score=0;
		for(int i=0;i<getFramesNumber(); i++)
		{
			score+=((List<Frame>) this.getFrames()).get(i).score();
		}
		return 0;
	}

	private int getFramesNumber() {

		return 0;
	}

	public Object getFrames() {

		return null;
	}
}

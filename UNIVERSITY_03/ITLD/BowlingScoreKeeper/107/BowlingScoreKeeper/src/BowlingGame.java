import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	int num=0;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException{
		if(num<10)
		{
		frames.add(new Frame(0,0));
		num++;
		} else
			throw new BowlingException("Nije moguce kreirati vise od 10 ramova.");
	}


	public void setBonus(int firstThrow, int secondThrow) {

	}


	public int score(){

		return 0;
	}
}

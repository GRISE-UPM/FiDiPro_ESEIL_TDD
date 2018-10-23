import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){

		this.bonus = bonus;
		this.frames = frames;

	}



	public void addFrame(Frame frame) throws BowlingException{
		frame = new Frame();
		if (frames.size() < 10)
			frames.add(frame);
		else 
			throw new BowlingException();


	}


	public void setBonus(int firstThrow, int secondThrow) {
		int bonus=0;





	}


	public int score(){





		return 0;
	}
}

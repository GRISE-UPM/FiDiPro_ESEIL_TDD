import java.util.ArrayList;
import java.util.List;
import java.util.Random;





public class BowlingGame{

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int index = 0;

	public BowlingGame(){}


	public void addFrame(Frame frame) 		if(!frame.isSpare() && !frame.isStrike())
			frames.add(frame);
		else if(frames.get(index - 1).isSpare() && index != 0){
			frames.get(index - 1).setBonus(frame.getFirstThrow());
			frames.add(frame);
		}
		else if(frames.get(index - 1).isStrike() && index != 0){
			frames.get(index - 1).setBonus(frame.getFirstThrow() + frame.getSecondThrow());
			frames.add(frame);
		}
		else if(index == 9){
			if(frame.isSpare() || frame.isStrike()){
				setBonus(frame.getFirstThrow(), frame.getSecondThrow());
			}
		}

			throw new BowlingException();*
		index++;
	}


	public void setBonus(int firstThrow, int secondThrow) {

	}


	public int score(){

		int result = 0;
		for(int i = 0; i < index; i++)
			result += frames.get(i).score();

		return result;
	}
}

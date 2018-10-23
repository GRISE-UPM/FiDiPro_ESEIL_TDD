import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();


	public List<Frame> getFrames() {
		return frames;
	}

	private Frame bonus;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException{
		if(frames.size()<10){
			frames.add(frame);
		}else {
			throw new BowlingException();
		}

	}


	public void setBonus(int firstThrow, int secondThrow) {

	}


	public int score() throws BowlingException{
		int score=0;
		for(int i=0;i<getFramesNumber();i++){
		score+=this.getFrames().get(i).score();	
		}
		return score;
	}

	public int getFramesNumber(){
		return frames.size();
	}






	}


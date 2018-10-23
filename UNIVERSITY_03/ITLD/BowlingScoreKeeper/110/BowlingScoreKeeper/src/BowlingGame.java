import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){}



	public void addFrame(Frame frame){
		this.frames.add(frame);
	}

	public int getFrameNumber(){
		return this.frames.size();
	}


	public void setBonus(int firstThrow, int secondThrow) {
		Frame frejm = new Frame(firstThrow,secondThrow);
		if(frames.size()==10&&(frejm.isSpare()||frejm.isStrike())){
			this.frames.add(bonus);
		}
	}


	public int score(){

		return 0;
	}
}

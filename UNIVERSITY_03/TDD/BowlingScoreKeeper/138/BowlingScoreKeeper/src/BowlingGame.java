import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int totalScore = 0;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws Exception{
		if(frames.size() < 10){
			frames.add(frame);
		}
		else{
			throw new Exception("Max number of frames is 10");
		}
	}


	public void setBonus(int firstThrow, int secondThrow) {
		if(frames.get(10).isSpare() || frames.get(10).isStrike()){
			frames.add(bonus);
		}
	}


	public int score() throws Exception{
		totalScore = 0;
		for (int i = 0; i < frames.size(); i++) {
				if(i == 0){
					totalScore += frames.get(i).getFirstThrow() + frames.get(i).getSecondThrow();
				}
				if(i > 0 && frames.get(i-1).isSpare()){
					totalScore += frames.get(i).getFirstThrow();
				}
				else if(i > 0 && frames.get(i-1).isStrike()){
					totalScore += frames.get(i).getFirstThrow() + frames.get(i).getSecondThrow();
				}
				else{
					totalScore += frames.get(i).getFirstThrow() + frames.get(i).getSecondThrow();
				}
		}
		return totalScore;
	}
}

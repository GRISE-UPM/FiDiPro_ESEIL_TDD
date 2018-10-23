import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private boolean spareBonus, strikeBonus;
	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException{
		if (frames.size() == 10)
			throw new BowlingException();
		if (strikeBonus){
			frames.get(frames.size()-1).addBonus(frame.getFirstThrow(), frame.getSecondThrow());
			strikeBonus = false;
		}
		if (spareBonus){
			frames.get(frames.size()-1).addBonus(frame.getFirstThrow(), 0);
			spareBonus = false;
		}
		if (frame.isStrike())
			strikeBonus = true;
		else if (frame.isSpare())
			spareBonus = true;
		frames.add(frame);
	}


	public void setBonus(int firstThrow, int secondThrow) throws BowlingException {
		if (frames.size() == 10){
			if(frames.get(9).isSpare() || frames.get(9).isStrike()){
				bonus = new Frame(firstThrow, secondThrow);
				frames.get(9).addBonus(firstThrow, 0);
			}
		}
		else
			throw new BowlingException();
	}

	public Frame getBonusFrame()
	{
		return bonus;
	}


	public int score(){
		int score = 0;
		for(int i = 0; i < frames.size(); i++){
			score += frames.get(i).score();
		}
		return score;
	}
}

import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int result;

	public BowlingGame(){}


	public void addFrame(Frame frame){

		frames.add(frame);
	}


	public void setBonus(int firstThrow, int secondThrow) throws BowlingException {


		for(int i = 0; i < frames.size(); i++){
			if(frames.get(i).isSpare() == true){
				throw new BowlingException();			
			}
			else if(frames.get(i).isStrike() == true){
				throw new BowlingException();
			}else{

			}
		}
	}
	public int bonuses(){
		int bonus;
		for(int i =0; i < frames.size(); i++){
			if(frames.get(i).isSpare() == true){
				bonus=  frames.get(i+1).getFirstThrow();
				return bonus;
			}
			else if(frames.get(i).isStrike() == true){
				bonus = frames.get(i+1).getFirstThrow() + frames.get(i+1).getSecondThrow() + 
						frames.get(i+2).getFirstThrow() + frames.get(i+2).getSecondThrow();
				return bonus;

			}
		}
		return 0;

	}


	public int score(){

		for(int i =0; i < frames.size(); i++){
			if(frames.get(i).isSpare() == true || frames.get(i).isStrike() == true){
				return result += frames.get(i).score() + bonuses();

			}
			else{
				return result += frames.get(i).score();
			}

		}

		return 0;
	}

}

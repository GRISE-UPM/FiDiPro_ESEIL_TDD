import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){}


	public void addFrame(Frame frame){

		frames.add(frame);
	}


	public void setBonus(int firstThrow, int secondThrow) {

		int score;
		for(int i=0; i<frames.size(); i++){
			if(frames.get(i).isStrike() && i<frames.size()-1){
				score = 10 + frames.get(i+1).getFirstThrow() + frames.get(i+1).getSecondThrow();
			}
			else if (frames.get(i).isSpare() && i<frames.size()-1){
				score = 10 + frames.get(i+1).getFirstThrow();
			}
			else if(frames.get(i).isStrike() && i<frames.size()){
				score = 10 + bonus.getFirstThrow() + bonus.getSecondThrow();
			}
			else if (frames.get(i).isSpare() && i<frames.size()){
				score = 10 + bonus.getFirstThrow();
			}
			else{
				score = frames.get(i).getFirstThrow() + frames.get(i).getSecondThrow();
			}
		}
	}


	public int score(){

		int rez=0;

			rez= rez + ;
		}*		return 0;
	}
}

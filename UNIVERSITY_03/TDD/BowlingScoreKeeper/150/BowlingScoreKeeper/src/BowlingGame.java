import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();


	private Frame bonus=new Frame(0,0);

	public BowlingGame(){}


	public void addFrame(Frame frame){

		frames.add(frame);
	}


	public void setBonus(int firstThrow, int secondThrow) {

		Frame frame = new Frame(firstThrow, secondThrow);
		if(frame.isStrike() == true){

			addFrame(bonus);
		} else if(frame.isSpare() == true){

			addFrame(bonus);
		}


	}


	public int score(){

		int s=0;

		for(int i = 0; i<frames.size(); i++){

			if(frames.get(i).isStrike() == true && frames.get(i+1).isStrike() == false){

				s = s+frames.get(i).score() + frames.get(i+1).score();

			}else if(frames.get(i).isStrike() == true && frames.get(i+1).isStrike() == true){

				s = s + frames.get(i).score() + frames.get(i+1).score() + frames.get(i+2).getFirstThrow();


			}else if(frames.get(i).isSpare() == true && frames.get(i+1).isSpare() == false){

				s = s + frames.get(i).score() + frames.get(i+1).getFirstThrow();

			} else if(frames.get(i).isSpare() == true && frames.get(i+1).isSpare() == true){

				s = s + frames.get(i).score() + frames.get(i+1).getFirstThrow() + frames.get(i+1).score() + frames.get(i+2).getFirstThrow();


			}else {

				s = s + frames.get(i).score();
			}





		}

		return s;
	}



	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}

	public Frame getBonus() {
		return bonus;
	}

	public void setBonus(Frame bonus) {
		this.bonus = bonus;
	}
}

import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame pomocni;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException{
		if(frames.size()<10){
			frames.add(frame);
		}
	}


	public void setBonus(int firstThrow, int secondThrow) {
		if(firstThrow == 10 || (firstThrow < 10 && firstThrow + secondThrow == 10)){

		}
	}


	public int score(){
		int brojBodova = 0;
		int bonus = 0;
		for(int i=0; i<frames.size(); i++){
			pomocni = frames.get(i);

			if(pomocni.isSpare()){
				bonus += frames.get(i+1).getFirstThrow();
			}
			if(pomocni.isStrike()){
				bonus += frames.get(i+1).score();
			}

			if(i == frames.size() - 1){
				if(pomocni.isSpare() || pomocni.isStrike()){
					pomocni.setThird(true);
				}
			}

			brojBodova += pomocni.score();

		}
		brojBodova += bonus;
		return brojBodova;
	}

	public int size(){
		return frames.size();
	}
}

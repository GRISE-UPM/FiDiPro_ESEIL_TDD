import java.io.Console;
import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	int s = 0;

	public BowlingGame(){}


	public void addFrame(Frame frame){
		frames.add(frame);
	}


	public void setBonus(Frame f, int treceBacanje) throws BowlingException{
		if(frames.size() != 10){
			throw new BowlingException();
		}else if(f == frames.get(9)){
			f.addBonus(treceBacanje);
		}else{
			throw new BowlingException();
		}
	}

	public void dodajBonuseFrejmovima(){

		for(int i = 0; i < frames.size(); i++){
			if(frames.get(i).isSpare() && i != frames.size() - 1){
				frames.get(i).addBonus(frames.get(i+1).getFirstThrow());
			}else if(frames.get(i).isStrike() && i != frames.size() - 1){
				frames.get(i).addBonus(frames.get(i+1).getFirstThrow() + frames.get(i+1).getSecondThrow());
			}
		}
	}


	public int score(){

		int s = 0;
		for(Frame f : frames){
			s += f.score();
		}
		return s;
	}

	public int scoreWithBonus(){
		dodajBonuseFrejmovima();

		int s = 0;
		for(Frame f : frames){
			s += f.scoreWithBonus();
		}
		return s;
	}
}

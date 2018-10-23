import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private boolean bonusZaSpare, bonusZaStrike;
	private int rezultat = 0;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException{
		if(frames.size() == 10)
			throw new BowlingException("Igra je zavrsena");
		frames.add(frame);

		setBonus(frame.getFirstThrow(), frame.getSecondThrow());
	}



	 * i proverava da li je ostvaren neki od bonusa za Strike ili za Spare
	 *	public void setBonus(int firstThrow, int secondThrow) {
		if(bonusZaSpare){
			rezultat += firstThrow;
			bonusZaSpare = false;
		}
		if(bonusZaStrike){
			rezultat += (firstThrow + secondThrow);
			bonusZaStrike = false;
		}
		if(firstThrow + secondThrow == 10 && firstThrow != 10){
			bonusZaSpare = true;
		}
		if(firstThrow == 10){
			bonusZaStrike = true;
		}
		rezultat += (firstThrow + secondThrow);
	}


	public int score(){

		return rezultat;
	}

	public String getNumberOfFrames(){
		return frames.size() + "";
	}

	public String getScore(){
		return score() + "";
	}

}

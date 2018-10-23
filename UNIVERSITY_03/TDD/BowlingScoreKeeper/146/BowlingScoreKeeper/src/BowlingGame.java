import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	private int s=0;

	public BowlingGame(){}


	public void addFrame(Frame frame){

		frames.add(frame);
	}


	public void dodajSpareStrikeBonus(){

		for(int i = 0; i < frames.size(); i++){
			if(frames.get(i).isSpare() && i != frames.size() - 1){
				frames.get(i).addBonus(frames.get(i+1).getFirstThrow());
			}else if(frames.get(i).isStrike() && i != frames.size() - 1){
				frames.get(i).addBonus(frames.get(i+1).getFirstThrow() + frames.get(i+1).getSecondThrow());
			}
		}
	}


	public void setBonus(int firstThrow, int secondThrow) {

		dodajSpareStrikeBonus();
		for(int i=0; i < frames.size(); i++)
		{
			s = s + frames.get(i).score();
		}

	}



	public int score(){

		for(int i=0; i<frames.size(); i++){
			s = s + frames.get(i).score();
		}

		return s;
	}

}

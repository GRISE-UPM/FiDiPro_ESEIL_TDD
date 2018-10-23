import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){


	}


	public void addFrame(Frame frame){
		frames.add(frame);
	}


	public void setBonus(int firstThrow, int secondThrow) {
		for(int i=0;i<10;i++){
			if(frames.get(i).isSpare()==true){
				bonus=frames.get(i+1);
			}
			else if(frames.get(i).isStrike()==true){
				int prvi=frames.get(i+1).getFirstThrow()+frames.get(i+2).getFirstThrow();
				int drugi=frames.get(i+1).getSecondThrow()+frames.get(i+2).getSecondThrow();
				bonus=new Frame(prvi,drugi);
			}
		}
	}

	public Frame getBonus(){
		return bonus;
	}

	public int score(){
		int rezultat=0;
		for(int i=0;i<10;i++){
			rezultat=rezultat+frames.get(i).score();
		}
		int bonusi=bonus.getFirstThrow()+bonus.getSecondThrow();
		int k=rezultat+bonusi;
		return k;
	}
}

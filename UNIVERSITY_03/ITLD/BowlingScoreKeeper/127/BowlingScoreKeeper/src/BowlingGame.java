import java.util.ArrayList;
import java.util.List;





public class BowlingGame{

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	private int b=0;
	private int s=0;

	public BowlingGame(){}


	public void addFrame(Frame frame) throws BowlingException{
		if(frames.size()<=10){
			frames.add(frame);
		}else{
			throw new BowlingException();
		}
	}


	public void setBonus(int firstThrow, int secondThrow) {
		for(int i=0;i<frames.size();i++){
			if(frames.get(i).isSpare()==true){
				b+=frames.get(i+1).getFirstThrow();

			}
			else if(frames.get(i).isStrike()==true){
				b+=frames.get(i+1).getSecondThrow();
				b+=frames.get(i+1).getFirstThrow();


			}
		}
	}


	public int score(){
		for(int i=0;i<frames.size();i++)
			s+=frames.get(i).score();
		return s+b;
	}
}

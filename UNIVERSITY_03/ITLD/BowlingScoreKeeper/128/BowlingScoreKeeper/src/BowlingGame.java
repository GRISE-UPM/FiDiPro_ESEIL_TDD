import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame(){}


	public void addFrame(Frame frame)throws BowlingException
	{

		if(frames.size()<10){
			frames.add(frame);
		}
		else
			throw new BowlingException();

	}


	public void setBonus(int firstThrow, int secondThrow) {

		bonus = new Frame(firstThrow,secondThrow);
	}


	public int score(){

		int result=0;
		int count=0;
		int count1=0;
		int spare =0;
		Iterator<Frame>it = frames.iterator();
		while(it.hasNext()){
			Frame help = (Frame)it.next();
			if(help.isSpare()==true ){
				spare ++;
				if(spare==1){
					setBonus(help.getFirstThrow(), help.getSecondThrow());
				}
				if(spare==2){
					result+= help.getFirstThrow()+bonus.getFirstThrow()+ bonus.getSecondThrow();
					setBonus(help.getFirstThrow(), help.getSecondThrow());

					return result;
				}

			}
			else{
				if(count!=0){
					result+= help.score()+bonus.getFirstThrow()+bonus.getFirstThrow();
					count--;
				}
				else
					result+=help.score();
			}
		}
		return result;
	}
}

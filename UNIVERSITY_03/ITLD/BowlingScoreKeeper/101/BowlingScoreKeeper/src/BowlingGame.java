import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>(10);
	private Frame bonus;
	private int bonus_rez;

	public BowlingGame(){}


	public void addFrame(Frame frame){

		frames.add(frame);

	}


	public void setBonus(int firstThrow, int secondThrow) {

		for (int i=0; i<10; i++)
		{
			if (bonus.isSpare())
			{
				bonus_rez=frames.get(i+1).score();

			}
		}


	}


	public int score(){

		return 0;
	}
}

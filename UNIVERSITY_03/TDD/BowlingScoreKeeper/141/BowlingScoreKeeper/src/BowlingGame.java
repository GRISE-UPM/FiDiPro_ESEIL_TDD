import java.util.ArrayList;
import java.util.List;





public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	private int ukupanBonus;
	private boolean okidac=false;
	private int brojac=0;
	private boolean poslednjiBonus=false;

	public BowlingGame(){}


	public void addFrame(Frame frame){
		frames.add(frame);
		brojac++;
	}


	public void setBonus(int firstThrow, int secondThrow) {

		if(brojac>9)
		{
			bonus.setFirstThrow(firstThrow);
			bonus.setSecondThrow(secondThrow);
			poslednjiBonus=true;
		}
		else{

			ukupanBonus=firstThrow+secondThrow;
			okidac=true;
		}

	}


	public int score(){

		int score=0;
		for(int i=0;i<frames.size();i++)
		{
			if(frames.get(i).isSpare() && i != frames.size()-1)
			{
				if(okidac==true)
				{
				score+=ukupanBonus+frames.get(i).score();
				}else{

				okidac=false;

				score+= frames.get(i).score()+frames.get(i+1).getFirstThrow() ;

				}
			}else if(frames.get(i).isStrike() && i != frames.size()-1){

				score+=frames.get(i).score()+frames.get(i+1).score();


			}

			else{

				score=score+frames.get(i).score();
			}

		}

		if(poslednjiBonus==true)
		{
			score+=bonus.score();
		}
		poslednjiBonus=false;



		return score;
	}
}

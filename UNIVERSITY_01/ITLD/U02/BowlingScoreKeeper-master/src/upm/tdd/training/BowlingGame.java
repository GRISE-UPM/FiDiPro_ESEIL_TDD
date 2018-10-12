package upm.tdd.training;
import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame){
		//to be implemented
		frames.add(frame);
	}
	public void addBonus(Frame a){
		bonus=a;
	}

	public void setBonus(int firstThrow, int secondThrow) {
		this.bonus=new Frame(firstThrow,secondThrow);
	}
	
	public int score(){
		int suma=0;
		int i;
		for(i=0;i<frames.size();i++){
			if (frames.get(i).isStrike()){ //if its strike
				if (frames.get(i).isLastFrame()){
					suma=suma+frames.get(i).score()+bonus.score();
				}else{
					if (frames.get(i+1).isStrike()){
						if (i+2<frames.size()) //sino se sale de rango
							suma=suma+frames.get(i).score()+frames.get(i+1).score()+frames.get(i+2).tiradas.get(0).puntuacion;
						else //sumo 10 (primera tirada del strike)
							suma=suma+frames.get(i).score()+frames.get(i+1).score()+bonus.tiradas.get(0).puntuacion;
					}else{
						suma=suma+frames.get(i).score()+frames.get(i+1).score();
					}
				}
			}else if (frames.get(i).isSpare()){
				if (frames.get(i).isLastFrame()){
					suma=suma+frames.get(i).score()+bonus.tiradas.get(0).puntuacion;
				}else{
					suma=suma+frames.get(i).score()+frames.get(i+1).tiradas.get(0).puntuacion;
				}				
			}else{		
				suma=suma+frames.get(i).score();
			}			
		}		
		return suma;
	}
	
	public boolean isNextFrameBonus(){
		return false;
	}
	
	public String toString(){
		String cadenaza="";
		for(int i=0;i<frames.size();i++){
			cadenaza=cadenaza+frames.get(i).toString();
		}
		return cadenaza;
	}
	
	public void modifyFrame(int id,Frame a){
		frames.set(id, a);
	}
}

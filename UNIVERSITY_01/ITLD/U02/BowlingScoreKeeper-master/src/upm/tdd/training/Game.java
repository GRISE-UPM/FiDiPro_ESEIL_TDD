package upm.tdd.training;

import java.util.ArrayList;

public class Game {
	ArrayList<Frame> frames;
	ArrayList<Frame> bonus;
	
	public Game(){
		frames=new ArrayList<Frame>();		
		bonus=new ArrayList<Frame>();
	}
	
	public void addBonus(Frame a){
		bonus.add(a);
	}
	public void addFrame(Frame a){
		frames.add(a);
	}
	
	public int score(){
		int suma=0;
		int i;
		for(i=0;i<frames.size();i++){
			if (frames.get(i).isStrike()){ //if its strike
				if (frames.get(i).isLastFrame()){
					suma=suma+frames.get(i).score()+bonus.get(0).score();
				}else{
					if (frames.get(i+1).isStrike()){
						if (i+2<frames.size()) //sino se sale de rango
							suma=suma+frames.get(i).score()+frames.get(i+1).score()+frames.get(i+2).tiradas.get(0).puntuacion;
						else //sumo 10, sino no llego a 300
							suma=suma+frames.get(i).score()+frames.get(i+1).score()+10;
					}else{
						suma=suma+frames.get(i).score()+frames.get(i+1).score();
					}
				}
			}else if (frames.get(i).isSpare()){
				if (frames.get(i).isLastFrame()){
					suma=suma+frames.get(i).score()+bonus.get(0).tiradas.get(0).puntuacion;
				}else{
					suma=suma+frames.get(i).score()+frames.get(i+1).tiradas.get(0).puntuacion;
				}				
			}else{		
				suma=suma+frames.get(i).score();
			}			
		}
		
		return suma;
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

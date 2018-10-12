package upm.tdd.training;

import java.util.ArrayList;


public class Frame {
	ArrayList<Throw> tiradas;
	boolean isLast=false;
	
	public Frame(){
		tiradas=new ArrayList<Throw>();
		tiradas.add(new Throw(-1));
		tiradas.add(new Throw(-1));
	}
	
	public void setTirada(int i,int value){
		tiradas.set(i,new Throw(value));
	}
	public void addThrow(Throw a){
		if (tiradas.size()>2)
			return;
		if (tiradas.get(0).puntuacion==-1){ //si es la primera tirada...
			tiradas.set(0, a);
			if (a.puntuacion==10){
				tiradas.set(1, new Throw(0));
			}
		}else{
			if (tiradas.get(0).puntuacion==10){ //si ya es 10, no puede haber segunda tirada
				tiradas.set(1, new Throw(0));
				return;
			}else if ((tiradas.get(0).puntuacion+a.puntuacion)<=10){ //si es menor o igual que 10 entra, sino es imposible
				tiradas.set(1, a);				
			}
		}
	}
	
	public Frame(int firstThrow, int secondThrow){
		if (firstThrow+secondThrow>10) return;
		tiradas=new ArrayList<Throw>();
		tiradas.add(new Throw(firstThrow));
		tiradas.add(new Throw(secondThrow));
	}
	

	
	public String toString(){
		return "["+(tiradas.get(0).puntuacion)+","+tiradas.get(1).puntuacion+"]";
	}
	
	//the score of a single frame
	public int score(){
		//to be implemented
		int suma=0;
		for(int i=0;i<tiradas.size();i++){
			Throw a= tiradas.get(i);
			suma=suma+a.puntuacion;
		}
		return suma;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		//to be implemented
		if (tiradas.get(0).puntuacion==10)
			return true;
		return false;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		//to be implemented
		if ((tiradas.get(0).puntuacion+tiradas.get(1).puntuacion)==10)
			return true;
		return false;
	}

	public void setLastFrame(){
		this.isLast=true;
	}
	//return whether this is the last frame of the match
	public boolean isLastFrame(){
		return this.isLast;
	}

	//bonus throws
	public int bonus(){
		//to be implemented
		return 0;
	}


}

package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import upm.tdd.training.BowlingGame;
import upm.tdd.training.Frame;

public class TestBowlingScoreKeeper {

	@Test
	public void testFrameScore() {
		Frame frm=new Frame(2,4);
		assertEquals(6, frm.score());
	}
	
	@Test
	public void defineGame(){
		BowlingGame bg=new BowlingGame();
		int secuence[]={1,5,3,6,7,2,3,6,4,4,5,3,3,3,4,5,8,1,2,6};
		for(int i=0;i<20;i+=2){
			bg.addFrame(new Frame(secuence[i], secuence[i+1]));
		}
		assertNotNull(bg);
		
	}
	
	@Test
	public void gameScore(){
		BowlingGame bg=new BowlingGame();
		int secuence[]={1,5,3,6,7,2,3,6,4,4,5,3,3,3,4,5,8,1,2,6};
		for(int i=0;i<20;i+=2){
			bg.addFrame(new Frame(secuence[i], secuence[i+1]));
		}
		assertEquals(81, bg.score());
	}
	
	@Test
	public void gameStrick(){
		
		BowlingGame bg=new BowlingGame();
		int secuence[]={10,0,3,6,7,2,3,6,4,4,5,3,3,3,4,5,8,1,2,6};
		for(int i=0;i<20;i+=2){
			bg.addFrame(new Frame(secuence[i], secuence[i+1]));
		}
		assertEquals(94, bg.score());
	}
	
	@Test
	public void isStrike(){
		 
		Frame frm=new Frame(10,0);
		assertEquals(true,frm.isStrike() );
	}
	
	@Test
	public void isSpare(){
		 
		Frame frm=new Frame(9,1);
		assertEquals(true,frm.isSpare());
	}
	
	@Test
	public void gameSpare(){
		
		BowlingGame bg=new BowlingGame();
		int secuence[]={1,9,3,6,7,2,3,6,4,4,5,3,3,3,4,5,8,1,2,6};
		for(int i=0;i<20;i+=2){
			bg.addFrame(new Frame(secuence[i], secuence[i+1]));
		}
		assertEquals(88, bg.score());
	}
	
	
	
	

}

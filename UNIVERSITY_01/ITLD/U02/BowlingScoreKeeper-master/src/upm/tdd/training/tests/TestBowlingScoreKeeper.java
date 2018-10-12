package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import upm.tdd.training.Frame;
import upm.tdd.training.BowlingGame;
import upm.tdd.training.Throw;

public class TestBowlingScoreKeeper {

	@Test
	public void SetFirstThrow24() {
		Frame f=new Frame();
		f.addThrow(new Throw(2));
		f.addThrow(new Throw(4));
		assertEquals("[2,4]",f.toString());
	}
	
	@Test
	public void AssertThrow24Sum6() {
		Frame f=new Frame();
		f.addThrow(new Throw(2));
		f.addThrow(new Throw(4));
		assertEquals(6,f.score());
	}
	
	@Test
	public void AssertBowlingGameWhenPushingFrames(){
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(1,5));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(8,1));
		game.addFrame(new Frame(2,6));
		assertEquals("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]",game.toString());
	}
	
	@Test
	public void AssertBowlingGameWhenPushingFramesExampleSum81(){
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(1,5));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(8,1));
		game.addFrame(new Frame(2,6));
		assertEquals(81,game.score());
	}

	@Test
	public void Add10Throw(){
		Frame f=new Frame();
		f.addThrow(new Throw(10));
		assertEquals("[10,0]",f.toString());
	}
	
	@Test
	public void Add82Throw(){
		Frame f=new Frame();
		f.addThrow(new Throw(8));
		f.addThrow(new Throw(2));
		assertEquals("[8,2]",f.toString());
	}
	
	@Test
	public void Add83Throw(){
		Frame f=new Frame();
		f.addThrow(new Throw(8));
		f.addThrow(new Throw(3));
		//imposible que tire 3
		assertEquals("[8,-1]",f.toString());
	}
	
	@Test
	public void AssertIsStrike10(){
		Frame f=new Frame();
		f.addThrow(new Throw(10));
		//imposible que tire 3
		assertEquals(true,f.isStrike());
	}
	
	@Test
	public void AssertNotIsStrike10(){
		Frame f=new Frame();
		f.addThrow(new Throw(8));
		f.addThrow(new Throw(2));
		//imposible que tire 3
		assertEquals(false,f.isStrike());
	}
	
	
	@Test
	public void AssertStrikeScore(){
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(8,1));
		game.addFrame(new Frame(2,6));
		assertEquals(94,game.score());
	}
	
	@Test
	public void AssertSpareScore(){
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(1,9));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(8,1));
		game.addFrame(new Frame(2,6));
		assertEquals(88,game.score());
	}
	
	@Test
	public void AssertSpareStrikeScore(){
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(4,6));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(8,1));
		game.addFrame(new Frame(2,6));
		assertEquals(103,game.score());
	}
	
	
	@Test
	public void AssertStrikeStrikeScore(){
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(8,1));
		game.addFrame(new Frame(2,6));
		assertEquals(112,game.score());
	}
	
	@Test
	public void AssertSpareSpareScore(){
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(8,2));
		game.addFrame(new Frame(5,5));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(8,1));
		game.addFrame(new Frame(2,6));
		assertEquals(98,game.score());
	}
	
	@Test
	public void AssertLastSpareScore(){
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(1,5));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(8,1));
		Frame spare=new Frame(2,8);
		spare.setLastFrame();
		game.addFrame(spare);
		game.addBonus(new Frame(7,0));
		assertEquals(90,game.score());
	}
	
	@Test
	public void AssertLastStrikeScore(){
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(1,5));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(8,1));
		Frame strike=new Frame(10,0);
		strike.setLastFrame();
		game.addFrame(strike);
		game.addBonus(new Frame(7,2));
		assertEquals(92,game.score());
	}
	
	@Test
	public void AssertLastStrikeStrikeBonusScore(){
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(1,5));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(8,1));
		Frame strike=new Frame(10,0);
		strike.setLastFrame();
		game.addFrame(strike);
		game.addBonus(new Frame(10,0));
		assertEquals(93,game.score());
	}
	
	@Test
	public void CheckPerfectBowlingGame(){
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		Frame strike=new Frame(10,0);
		strike.setLastFrame();
		game.addFrame(strike);
		Frame specialFrame=new Frame(0,0);
		specialFrame.setTirada(0, 10);
		specialFrame.setTirada(1, 10);
		game.addBonus(specialFrame);
		//System.out.print(game.score());
		assertEquals(300,game.score());
	}
	
	@Test
	public void CheckNormalBowlingGame(){
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(6,3));
		game.addFrame(new Frame(7,1));
		game.addFrame(new Frame(8,2));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(6,2));
		game.addFrame(new Frame(7,3));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(8,0));
		Frame strike=new Frame(7,3);
		strike.setLastFrame();
		game.addFrame(strike);
		Frame specialFrame=new Frame(0,0);
		specialFrame.setTirada(0, 10);
		game.addBonus(specialFrame);
		//System.out.print(game.score());
		assertEquals(135,game.score());
	}
	
}

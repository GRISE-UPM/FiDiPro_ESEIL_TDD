import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestBowling {


	public void test() {
		fail("Not yet implemented");
	}*
	@Test
	public void test_Score(){
		Frame frame = new Frame(3,5);
		assertEquals(8,frame.score());
	}

	@Test
	public void test_Spare(){
		Frame frame = new Frame(5,5);
		assertTrue(frame.isSpare());
	}

	@Test
	public void test_Strike(){
		Frame frame = new Frame(10, 0);
		assertTrue(frame.isStrike());
	}

	@Test
	public void test_DodajBonus(){

		BowlingGame game = new BowlingGame();
		Frame f1 = new Frame(5,5);
		Frame f2 = new Frame(2,5);
		game.addFrame(f1);
		game.addFrame(f2);		
		assertEquals(19, game.dodajSpareStrikeBonus());
	}

	@Test
	public void test_ScoreGame(){
		BowlingGame game = new BowlingGame();
		Frame f1 = new Frame(5,1);
		Frame f2 = new Frame(3,1);
		game.addFrame(f1);
		game.addFrame(f2);
		assertEquals(10, game.score());

	}

	@Test
	public void test_AddBonus(){
		Frame f1 = new Frame(3,1);
		f1.addBonus(5);
		assertEquals(9, f1);
	}

	@Test
	public void test_Desetobacanje(){
		BowlingGame game =  new BowlingGame();
		Frame f1 = new Frame(5,1);
		Frame f2 = new Frame(3,1);
		Frame f3 = new Frame(5,1);
		Frame f4 = new Frame(3,1);
		Frame f5 = new Frame(5,1);
		Frame f6 = new Frame(3,1);
		Frame f7 = new Frame(5,1);
		Frame f8 = new Frame(3,1);
		Frame f9 = new Frame(5,1);
		Frame f10 = new Frame(3,1);

		game.addFrame(f1);
		game.addFrame(f2);
		game.addFrame(f3);
		game.addFrame(f4);
		game.addFrame(f5);
		game.addFrame(f6);
		game.addFrame(f7);
		game.addFrame(f8);
		game.addFrame(f9);
		game.addFrame(f10);

		assertEquals(50, game.score());

	}


	@Test
	public void test_DesetobacanjeSaBonusom(){
		BowlingGame game =  new BowlingGame();
		Frame f1 = new Frame(5,1);
		Frame f2 = new Frame(3,1);
		Frame f3 = new Frame(5,1);
		Frame f4 = new Frame(3,1);
		Frame f5 = new Frame(5,1);
		Frame f6 = new Frame(3,1);
		Frame f7 = new Frame(5,1);
		Frame f8 = new Frame(3,1);
		Frame f9 = new Frame(5,1);
		Frame f10 = new Frame(3,1);

		game.addFrame(f1);
		game.addFrame(f2);
		game.addFrame(f3);
		game.addFrame(f4);
		game.addFrame(f5);
		game.addFrame(f6);
		game.addFrame(f7);
		game.addFrame(f8);
		game.addFrame(f9);
		game.addFrame(f10);

		assertEquals(50, game.score());

	}

}

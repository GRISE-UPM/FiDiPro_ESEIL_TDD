package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import upm.tdd.training.BowlingGame;
import upm.tdd.training.Frame;

public class TestBowlingScoreKeeper {

	@Test
	public void testFrame() {
		Frame frame = new Frame(2,4);
		assertEquals("[2,4]",frame.getFrame());
		frame = new Frame(3,5);
		assertEquals("[3,5]",frame.getFrame());
	}
	
	@Test
	public void testFramescore() {
		Frame frame = new Frame(2,6);
		assertEquals(8,frame.score());
		frame = new Frame(0,9);
		assertEquals(9,frame.score());
	}
	
	@Test
	public void testNewGameof10Frames(){
		BowlingGame game = new BowlingGame();
		int[] valuesOfThrows = {1,5,3,6,7,2,3,6,4,4,5,3,3,3,4,5,8,1,2,6};
		assertEquals(true,game.set10Frames(valuesOfThrows));
		int[] valuesOfThrows2= {1,5,3,6,7,2,3,6,4,4,5,3,3,3,4,5,8,1,2};
		assertEquals(false,game.set10Frames(valuesOfThrows2));
	}
	
	@Test
	public void testGameScore(){
		BowlingGame game = new BowlingGame();
		int[] valuesOfThrows = {1,5,3,6,7,2,3,6,4,4,5,3,3,3,4,5,8,1,2,6};
		game.set10Frames(valuesOfThrows);
		assertEquals(81,game.score());
		
		game = new BowlingGame();
		int[] valuesOfThrows2 = {1,5,3,6,7,2,3,6,4,4,5,3,3,3,4,5,8,1,2,7};
		game.set10Frames(valuesOfThrows2);
		assertEquals(82,game.score());

	}
	
	@Test
	public void testAStrikeFrame(){
		Frame frame = new Frame(10,0);
		assertEquals(true,frame.isStrike());
		frame = new Frame(9,0);
		assertEquals(false,frame.isStrike());
	}
	
	@Test
	public void testAStrikeGameScore(){
		BowlingGame game = new BowlingGame();
		int[] valuesOfThrows = {10,0,3,6,7,2,3,6,4,4,5,3,3,3,4,5,8,1,2,6};
		game.set10Frames(valuesOfThrows);
		assertEquals(94,game.score());
	}
	
	@Test
	public void testASpareFrame(){
		Frame frame = new Frame(1,9);
		assertEquals(true,frame.isSpare());
		frame = new Frame(9,0);
		assertEquals(false,frame.isSpare());
	}
	
	@Test
	public void testASpareGameScore(){
		BowlingGame game = new BowlingGame();
		int[] valuesOfThrows = {1,9,3,6,7,2,3,6,4,4,5,3,3,3,4,5,8,1,2,6};
		game.set10Frames(valuesOfThrows);
		assertEquals(88,game.score());
	}
	
	@Test
	public void testAStrikeAndSpareGameScore(){
		BowlingGame game = new BowlingGame();
		int[] valuesOfThrows = {10,0,4,6,7,2,3,6,4,4,5,3,3,3,4,5,8,1,2,6};
		game.set10Frames(valuesOfThrows);
		assertEquals(103,game.score());
	}

	@Test
	public void testMultipleStrikesGameScore(){
		BowlingGame game = new BowlingGame();
		int[] valuesOfThrows = {10,0,10,0,7,2,3,6,4,4,5,3,3,3,4,5,8,1,2,6};
		game.set10Frames(valuesOfThrows);
		assertEquals(112,game.score());
	}
}

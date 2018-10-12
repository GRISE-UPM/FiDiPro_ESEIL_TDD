package tdd.training.paf;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBowlingGame {
	BowlingGame m_Game;
	
	@Before
	public void setup()
	{
		m_Game = new BowlingGame();
	}
	
	@After
	public void tearDown()
	{
		m_Game = null;
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testScore0() {
		assertEquals(m_Game.score(), 0);
	}
	
	@Test
	public void testScoreNoBonus() {
		for (int i = 0; i < 10; i++)
		{
			m_Game.addFrame(new Frame(3, 3));
		}
		assertEquals(m_Game.score(), 60);
	}
	
	@Test
	public void testIsNextFrameBonus() {
		assertEquals(m_Game.isNextFrameBonus(), false);
	}
	
	@Test
	public void testMaxFrameCount() {
		for (int i = 0; i < 21; i++)
		{
			m_Game.addFrame(new Frame(2, 3));
		}
		assertEquals(m_Game.getFrameCount(), 11);
	}

	@Test
	public void testFirstTwoFramesFromTheTask() {
		m_Game.addFrame(new Frame(1, 4));
		m_Game.addFrame(new Frame(4, 5));
		assertEquals(m_Game.score(), 14);
	}
	
	@Test
	public void testThirdFrameFromTheTask() {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1, 4));
		game.addFrame(new Frame(4, 5));
		game.addFrame(new Frame(6, 4));
		game.addFrame(new Frame(5, 5));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(0, 1));
		assertEquals(game.score(), 61);
	}
	
	@Test
	public void testThirdFrameFromTheTaskLimited() {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1, 4));
		game.addFrame(new Frame(4, 5));
		game.addFrame(new Frame(6, 4));
		game.addFrame(new Frame(5, 0));
		assertEquals(game.score(), 34);
	}
	
	@Test
	public void testTheTask() {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1, 4));
		game.addFrame(new Frame(4, 5));
		game.addFrame(new Frame(6, 4));
		game.addFrame(new Frame(5, 5));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(0, 1));
		game.addFrame(new Frame(7, 3));
		game.addFrame(new Frame(6, 4));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(2, 8));
		game.setBonus(6, 0);
		assertEquals(game.score(), 133);
	}
	
}

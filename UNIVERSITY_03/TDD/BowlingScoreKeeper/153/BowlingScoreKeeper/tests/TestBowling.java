import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test_Frame()
	{
		int firstThrow = 2;
		int secondThrow = 5;
		Frame f = new Frame(firstThrow, secondThrow);

		assertEquals(firstThrow, f.getFirstThrow());
		assertEquals(secondThrow, f.getSecondThrow());
	}

	@Test
	public void test_ScoreOfSingleFrame()
	{
		int firstThrow = 2;
		int secondThrow = 5;
		Frame f = new Frame(firstThrow, secondThrow);

		assertEquals(7, f.score());
	}

	@Test
	public void test_IsStrike()
	{
		int firstThrow = 10;
		int secondThrow = 0;
		Frame f = new Frame(firstThrow, secondThrow);

		assertTrue(f.isStrike());
	}

	@Test
	public void test_IsSpare()
	{
		int firstThrow = 2;
		int secondThrow = 8;
		Frame f = new Frame(firstThrow, secondThrow);

		assertTrue(f.isSpare());
	}

	@Test
	public void test_AddFrameToTheGame() throws BowlingException
	{
		int firstThrow = 2;
		int secondThrow = 8;
		Frame f1 = new Frame(firstThrow, secondThrow);
		Frame f2 = new Frame(firstThrow, secondThrow);
		Frame f3 = new Frame(firstThrow, secondThrow);
		Frame f4 = new Frame(firstThrow, secondThrow);
		Frame f5 = new Frame(firstThrow, secondThrow);
		Frame f6 = new Frame(firstThrow, secondThrow);
		Frame f7 = new Frame(firstThrow, secondThrow);
		Frame f8 = new Frame(firstThrow, secondThrow);
		Frame f9 = new Frame(firstThrow, secondThrow);
		Frame f10 = new Frame(firstThrow, secondThrow);
		BowlingGame bg = new BowlingGame();
		bg.addFrame(f1);
		bg.addFrame(f2);
		bg.addFrame(f3);
		bg.addFrame(f4);
		bg.addFrame(f5);
		bg.addFrame(f6);
		bg.addFrame(f7);
		bg.addFrame(f8);
		bg.addFrame(f9);
		bg.addFrame(f10);

		assertEquals(10, bg.getFrames().size());
	}

	@Test
	public void test_GameScore() throws BowlingException
	{
		int firstThrow = 2;
		int secondThrow = 6;
		Frame f1 = new Frame(firstThrow, secondThrow);
		Frame f2 = new Frame(firstThrow, secondThrow);
		BowlingGame bg = new BowlingGame();
		bg.addFrame(f1);
		bg.addFrame(f2);

		assertEquals(16, bg.score());
	}

	@Test
	public void test_SetBonusSpare() throws BowlingException
	{
		int firstThrow = 2;
		int secondThrow = 8;
		Frame f1 = new Frame(firstThrow, secondThrow);
		BowlingGame bg = new BowlingGame();
		bg.addFrame(f1);
		bg.setBonus(firstThrow, secondThrow);
		assertEquals(12, f1.score() + bg.getBonus().getFirstThrow() );
	}

	@Test
	public void test_SetBonusStrike() throws BowlingException
	{
		int firstThrow = 10;
		int secondThrow = 0;
		Frame f1 = new Frame(firstThrow, secondThrow);
		int firstThrow2 = 4;
		int secondThrow2 = 6;
		BowlingGame bg = new BowlingGame();
		bg.addFrame(f1);
		bg.setBonus(firstThrow2, secondThrow2);
		assertEquals(20, f1.score() + bg.getBonus().getFirstThrow() + bg.getBonus().getSecondThrow());
	}

	@Test (expected =  BowlingException.class)
	public void test_AddMoreThen10Frames() throws BowlingException
	{
		int firstThrow = 2;
		int secondThrow = 6;
		Frame f1 = new Frame(firstThrow, secondThrow);
		Frame f2 = new Frame(firstThrow, secondThrow);
		Frame f3 = new Frame(firstThrow, secondThrow);
		Frame f4 = new Frame(firstThrow, secondThrow);
		Frame f5 = new Frame(firstThrow, secondThrow);
		Frame f6 = new Frame(firstThrow, secondThrow);
		Frame f7 = new Frame(firstThrow, secondThrow);
		Frame f8 = new Frame(firstThrow, secondThrow);
		Frame f9 = new Frame(firstThrow, secondThrow);
		Frame f10 = new Frame(firstThrow, secondThrow);
		Frame f11 = new Frame(firstThrow, secondThrow);
		BowlingGame bg = new BowlingGame();
		bg.addFrame(f1);
		bg.addFrame(f2);
		bg.addFrame(f3);
		bg.addFrame(f4);
		bg.addFrame(f5);
		bg.addFrame(f6);
		bg.addFrame(f7);
		bg.addFrame(f8);
		bg.addFrame(f9);
		bg.addFrame(f10);
		bg.addFrame(f11);
	}

	@Test
	public void test_AddBonusSpare()
	{
		int firstThrow = 2;
		int secondThrow = 8;
		Frame f1 = new Frame(firstThrow, secondThrow);
		int firstThrow2 = 2;
		int secondThrow2 = 6;
		Frame f2 = new Frame(firstThrow2, secondThrow2);

		assertEquals(2, f1.bonus);
	}

	public void test_AddBonusStrike()
	{
		int firstThrow = 2;
		int secondThrow = 8;
		Frame f1 = new Frame(firstThrow, secondThrow);
		int firstThrow2 = 2;
		int secondThrow2 = 6;
		Frame f2 = new Frame(firstThrow2, secondThrow2);

		assertEquals(8, f1.bonus);
	}

	public void test() {
		fail("Not yet implemented");
	} *
}

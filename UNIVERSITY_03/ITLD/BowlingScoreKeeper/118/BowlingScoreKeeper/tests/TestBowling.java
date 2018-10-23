import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test(expected = BowlingException.class)
	public void TestAddingFrameToGameWithTenFrames() throws BowlingException
	{
		BowlingGame game = new BowlingGame();
		for(int i= 0; i<10;i++) game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(4,4));
	}


	@Test
	public void TestIfFrameIsNotStrike()
	{
		Frame f = new Frame(4,3);
		boolean expected = false;
		assertEquals(expected, f.isStrike());
	}

	@Test
	public void TestIfFrameIsStrike()
	{
		Frame f = new Frame(10,0);
		boolean expected = true;
		assertEquals(expected, f.isStrike());
	}


	@Test
	public void TestIfFrameIsNotSpare()
	{
		Frame f = new Frame(3,3);
		boolean expected = false;
		assertEquals(expected, f.isSpare());
	}

	@Test
	public void TestIfFrameIsSpare()
	{
		Frame f = new Frame(7,3);
		boolean expected = true;
		assertEquals(expected, f.isSpare());
	}

@Test(expected = BowlingException.class)

	public void TestFrameScoreAboveTen() throws BowlingException
	{
		Frame f = new Frame(10, 3);
		f.score();
	}

@Test
public void TestFrameScore() throws BowlingException
{
	Frame f = new Frame(3, 3);
	int expected = 6;
	assertEquals(expected, f.score());
}

@Test
public void TestGameScore() throws BowlingException
{
	BowlingGame game = new BowlingGame();
	for(int i= 0; i<10;i++) game.addFrame(new Frame(4,4));
	int expected = 10*8;
	assertEquals(expected, game.score());
}

@Test
public void TestGameScoreWithSpare() throws BowlingException
{
	BowlingGame game = new BowlingGame();
	for(int i= 0; i<5;i++) game.addFrame(new Frame(4,4));
	game.addFrame(new Frame(6,4));
	for(int i= 0; i<4;i++) game.addFrame(new Frame(4,4));
	int expected = 5*8 + 10 + 4 + 4*8;;
	assertEquals(expected, game.score());
}

@Test
public void TestGameScoreWithStrike() throws BowlingException
{
	BowlingGame game = new BowlingGame();
	for(int i= 0; i<5;i++) game.addFrame(new Frame(4,4));
	game.addFrame(new Frame(10,0));
	for(int i= 0; i<4;i++) game.addFrame(new Frame(4,4));
	int expected = 5*8 + 10 + 4 + 4+ 4*8;;
	assertEquals(expected, game.score());
}



}

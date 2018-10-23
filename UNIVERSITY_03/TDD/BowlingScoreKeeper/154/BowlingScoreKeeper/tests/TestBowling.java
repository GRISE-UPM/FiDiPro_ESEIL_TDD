import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {



	@Test(expected=BowlingException.class)
	public void testIfFrameOutOfLimit() throws BowlingException{
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
	}


	@Test
	public void testIfFrameSpareWorks() throws BowlingException{
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(5,5));
		String check=Boolean.toString(game.getFrames().get(0).isSpare());
		assertEquals("Greska","true",check);	
	}


	@Test
	public void testIfFrameStrikeWorks() throws BowlingException{
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(10,0));
		String check=Boolean.toString(game.getFrames().get(0).isStrike());
		assertEquals("Greska","true", check);
	}

	@Test 
	public void testIfFrameScoreWorks() throws BowlingException{
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(5,2));
		String score=Integer.toString(game.getFrames().get(0).score());
	}


	@Test 
	public void testIfSingleFrameScoreIsInsideBounds() throws BowlingException{
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(5,6));
	}


	@Test
	public void testIfgameScoreWorks() throws BowlingException{
		BowlingGame game=new BowlingGame();
		game.addFrame(new Frame(1,4));
		game.addFrame(new Frame(1,10));
		game.addFrame(new Frame(1,3));
		String score=Integer.toString(game.score());
		assertEquals("Rezultat igre nije ocekivan","20",score);
	}


}

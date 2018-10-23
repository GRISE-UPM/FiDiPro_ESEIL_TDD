import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddFrame() throws BowlingException {
		BowlingGame game = new BowlingGame();
		for(int i=0; i<10;i++){
			game.addFrame(new Frame(5,0));
		}

		int size = 10;
		assertEquals("Error",size, game.size());
	}

	@Test
	public void testGameScoreIfAllFramesAre5() throws BowlingException{
		BowlingGame game = new BowlingGame();
		for(int i=0; i<10;i++){
			game.addFrame(new Frame(5,0));
		}

		int score = 50;
		assertEquals("Error",score, game.score());
	}

}

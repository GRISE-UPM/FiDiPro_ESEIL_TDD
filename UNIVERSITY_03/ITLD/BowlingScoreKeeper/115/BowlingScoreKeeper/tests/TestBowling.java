import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test_firstThrow5_secondThrow5_isSpare() throws BowlingException{
		Frame frame = new Frame(5,5);
		assertTrue(frame.isSpare());


	}
	@Test 
	public void test_firstThrow3_secondThrow5_notSpare() throws BowlingException {
		Frame frame = new Frame(3,5);
		assertFalse(frame.isSpare());
	}
	@Test 
	public void test_firstThrow10_isStrike() throws BowlingException{
		Frame frame = new Frame(10,0);
		assertTrue(frame.isStrike());
	}
	@Test
	public void test_firstThrow8_notStrike() throws BowlingException{
		Frame frame = new Frame(8,1);
		assertFalse(frame.isStrike());
	}
	@Test
	public void test_firstThrow7_secondThrow3_frameScore() throws BowlingException{
		Frame frame = new Frame(7,3);
		assertEquals("Incorect score!", 10, frame.score());
	}
	@Test (expected = BowlingException.class)
	public void test_tryTo_add11Frame() throws BowlingException{
		Frame frame = new Frame(10,0);
		BowlingGame game = new BowlingGame();
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
		game.addFrame(frame);
	}
	@Test
	public void test_firstThrow10_checkBonus() throws BowlingException{
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(10,0);
		Frame frame1 = new Frame(5,4);
		game.addFrame(frame);
		game.addFrame(frame1);
		game.setBonus(frame1.getFirstThrow(), frame1.getSecondThrow());
		assertEquals("Incorrect bonus!", 9, game.getBonusGame() );
	}

	@Test
	public void test_gameScore() throws BowlingException{
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(10,0);
		Frame frame1 = new Frame(5,4);
		game.addFrame(frame);
		game.addFrame(frame1);
		game.addFrame(frame1);
		game.addFrame(frame1);
		game.addFrame(frame1);
		game.addFrame(frame1);
		game.addFrame(frame1);
		game.addFrame(frame1);
		game.addFrame(frame);
		game.addFrame(frame1);
		game.setBonus(frame.getFirstThrow(), frame.getSecondThrow());
		assertEquals("Incorect game score!", 112, game.score());

	}
}

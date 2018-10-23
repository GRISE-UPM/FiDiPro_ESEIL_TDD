import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestBowling {


	public void test() {
		fail("Not yet implemented");
	} *
	@Test
	public void initial_test() {
		BowlingGame bwlGame=new BowlingGame();

		int score=bwlGame.score();
		assertEquals("Incorrect initial score", 0, score);

	}

	@Test 
	public void score_4_and_5() throws Exception {

		Frame frame=new Frame(4, 5);

		int score=frame.score();
		assertEquals("Incorrect score", 9, score);

	}

	@Test
	public void spare_test() throws Exception {

		Frame frame=new Frame(5, 5);

		boolean isSpare=frame.isSpare();
		assertEquals("Incorrect score when spare", true, isSpare);
	}

	@Test
	public void strike_test() throws BowlingException {

		Frame frame=new Frame(10, 0);

		boolean isStrike=frame.isStrike();
		assertEquals("Incorrect score when strike", true, isStrike);
	}

	@Test
	public void not_spare_test() throws Exception {

		Frame frame=new Frame(3, 5);

		boolean isSpare=frame.isSpare();
		assertEquals("Incorrect score when not spare", false, isSpare);

	}

	@Test
	public void not_strike_test() throws BowlingException {

		Frame frame=new Frame(8, 0);

		boolean isStrike=frame.isStrike();
		assertEquals("Incorrect score when not strike", false, isStrike);
	}

	@Test
	public void score_after_one_frame_test() throws Exception {

		BowlingGame bwlGame=new BowlingGame();

		Frame frame=new Frame(4, 3);
		bwlGame.addFrame(frame);

		int score=bwlGame.score();

		assertEquals("Incorrect score after one frame", 7, score);
	}

	@Test
	public void score_after_two_tests() throws Exception {

		BowlingGame bwlGame=new BowlingGame();

		Frame frame1=new Frame(4, 3);
		bwlGame.addFrame(frame1);

		Frame frame2=new Frame(3, 6);
		bwlGame.addFrame(frame2);

		int score=bwlGame.score();

		assertEquals("Incorrect score after one frame", 16, score);
	}

	@Test
	public void bonus_when_spare_test() throws Exception {

		BowlingGame bwlGame=new BowlingGame();

		Frame frame1=new Frame(4, 6);
		bwlGame.addFrame(frame1);

		Frame frame2=new Frame(4, 3);
		bwlGame.addFrame(frame2);

		int score=bwlGame.score();

		assertEquals("Incorrect score after spare bonus", 21, score);
	}

	@Test 
	public void bonus_when_strike_test() throws Exception {

		BowlingGame bwlGame=new BowlingGame();

		Frame frame1=new Frame(10, 0);
		bwlGame.addFrame(frame1);

		Frame frame2=new Frame(4, 3);
		bwlGame.addFrame(frame2);

		int score=bwlGame.score();

		assertEquals("Incorrect score after strike bonus", 24, score);

	}

	@Test
	public void score_after_one_strike_and_one_spare_test() throws Exception {

		BowlingGame bwlGame=new BowlingGame();

		Frame frame1=new Frame(10, 0);
		bwlGame.addFrame(frame1);

		Frame frame2=new Frame(4, 6);
		bwlGame.addFrame(frame2);

		Frame frame3=new Frame(3, 2);
		bwlGame.addFrame(frame3);

		int score=bwlGame.score();

		assertEquals("Incorrect score after strike and spare", 38, score);

	}

	@Test (expected=BowlingException.class)
	public void incorrect_score_test() throws Exception {

		Frame frame=new Frame(11, 0);

		int score=frame.score();

	}

}

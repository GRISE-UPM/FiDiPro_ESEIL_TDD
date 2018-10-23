import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test_Spare_in_frame() {

		Frame frame=new Frame(1,4);

		boolean isSpare=frame.isSpare();
		assertEquals("Checking validity of spare in one frame",false,isSpare);

	}

	@Test
	public void test_Strike_in_frame() {

		Frame frame=new Frame(10,0);

		boolean isStrike=frame.isStrike();
		assertEquals("Checking validity of spare in one frame",true,isStrike);

	}

	@Test
	public void test_numberOfFrames_in_game_moreThan10() throws Exception {

		BowlingGame game=new BowlingGame();
		try{
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(4,3));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(6,3));
		game.addFrame(new Frame(7,3));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(4,3));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(2,3));
		} catch (Exception e){

			assertEquals("Checking if we can make 11 frames","Impossible to make new frame",e.getMessage());
		}

	}

	@Test
	public void test_numberOfFrames_in_game_lessThan10() throws Exception {

		BowlingGame game=new BowlingGame();

		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(4,3));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(6,3));
		game.addFrame(new Frame(7,3));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(4,3));

		int numOfFrames=game.getFrames().size();

		assertEquals("Checking if we can make less than 10 frames",7,numOfFrames);


	}

	@Test
	public void test_score_of_frames() throws Exception {

		BowlingGame game=new BowlingGame();

		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(2,2));
		game.addFrame(new Frame(5,2));


		int score=game.score();

		assertEquals("Checking score of frames",15,score);


	}


}

import static org.junit.Assert.*;
import java.awt.Frame;

import org.junit.Test;

public class TestBowling {

	@Test(expected = BowlingException.class)
	public void exception_test() throws BowlingException {


		BowlingGame game = new BowlingGame();
		for (int i = 0 ; i<11; i++)
			game.addFrame(new Frame());



	}


	public void test_points() throws BowlingException {

		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame (4,4));


	}
	*


}

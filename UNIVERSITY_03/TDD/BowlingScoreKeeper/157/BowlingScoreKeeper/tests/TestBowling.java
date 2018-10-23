import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test(excepted=BowlingException.class)
  public void Add_frame1 throws 	BowlingException {
		BowlingGame bow= new BowlingGame();
		assertEquals(bow.frame("1,4",5);
	}
	@Test(excepted=BowlingException.class)
	 public void Add_frame2 throws 	BowlingException {
			BowlingGame bow= new BowlingGame();
			assertEquals(bow.frame("4,5",9);
		}
	@Test(excepted=BowlingException.class)
	 public void Add_frame3 throws 	BowlingException {
			BowlingGame bow= new BowlingGame();
			assertEquals(bow.frame("6,4",10);
		}
	@Test(excepted=BowlingException.class)
	 public void Add_frame4 throws 	BowlingException {
			BowlingGame bow= new BowlingGame();
			assertEquals(bow.frame("10,5",10);
		}
	@Test(excepted=BowlingException.class) 
	 public void Add_frame5 throws 	BowlingException {
			BowlingGame bow= new BowlingGame();
			assertEquals(bow.frame("3,7",10);
		}




}

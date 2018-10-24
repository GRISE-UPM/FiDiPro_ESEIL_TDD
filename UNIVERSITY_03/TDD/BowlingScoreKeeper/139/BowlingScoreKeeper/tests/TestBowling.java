import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	Frame frame;
	BowlingGame bg;


	@Test
	public void testFrameConstr() throws BowlingException{
		frame= new Frame(2,2);
		assertNotNull(frame);
	}

	@Test
	public void testSimpleScore() throws BowlingException{
		frame = new Frame(2,2);
		assertEquals(4,frame.score());
	}

	@Test(expected=BowlingException.class)
	public void testWhenThrowsAreMoreThen10() throws BowlingException{
		frame = new Frame(4,8);
	}

	@Test(expected=BowlingException.class)
	public void testWhenFirstisMoreThen10() throws BowlingException{
		frame = new Frame(12,0);
	}

	@Test
	public void testIfFrameIsSpare() throws BowlingException{
		frame = new Frame(5,5);
		assertTrue(frame.isSpare());
	}

	@Test
	public void testIfFrameIsStrike() throws BowlingException{
		frame = new Frame(10,0);
		assertTrue(frame.isStrike());
	}


	@Test
	public void testBowlingGameConstr(){
		bg= new BowlingGame();
		assertNotNull(bg);
	}

	@Test
	public void testAddingFrame() throws BowlingException{
		bg= new BowlingGame();
		bg.addFrame(new Frame(2,2));
		assertEquals(1,bg.getFrames().size());
	}


	@Test(expected=BowlingException.class)
	public void testAddingFrameWhenMoreThen10()throws BowlingException{
		bg= new BowlingGame();
		addFrames(bg,new Frame(1,1),11);

	}

	@Test
	public void testSimpleBowlingGame()throws BowlingException{
		bg= new BowlingGame();
		addFrames(bg,new Frame(1,1),10);
		assertEquals(20,bg.score());
	}

	@Test
	public void testAddingBonus() throws BowlingException{
		bg = new BowlingGame();
		bg.setBonus(2,2);
		assertTrue(bg.getBonus().getFirstThrow()==2 && bg.getBonus().getSecondThrow()==2);
		}


	@Test (expected=BowlingException.class)
	public void testAddingBonusMoreThen10() throws BowlingException{
		bg = new BowlingGame();
		bg.setBonus(4, 8);
	}

	@Test
	public void testWhenLastFrameIsSpare()throws BowlingException{
		bg= new BowlingGame();
		addFrames(bg, new Frame(1,1), 9);
		bg.addFrame(new Frame(5,5));
		bg.setBonus(1, 0);
		assertEquals(29,bg.score());
	}

	@Test
	public void testWhenLastFrameIsStrike()throws BowlingException{
		bg= new BowlingGame();
		addFrames(bg, new Frame(1,1), 9);
		bg.addFrame(new Frame(10,0));
		bg.setBonus(1, 0);
		assertEquals(29,bg.score());
	}



	public void addFrames(BowlingGame bg, Frame frame, int number) throws BowlingException{
		for (int i = 0; i < number; i++) {
			bg.addFrame(frame);
		}
	}



}

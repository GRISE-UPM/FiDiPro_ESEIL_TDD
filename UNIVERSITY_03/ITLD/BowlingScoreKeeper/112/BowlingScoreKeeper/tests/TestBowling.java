import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestBowling {

	private int firstThrow;
	private int secondThrow;

	Frame frame;

	@Test
	public void testIfIsStrike() {
		firstThrow=9;
		frame=new Frame(firstThrow,secondThrow);
		assertFalse(frame.isStrike());


	}

	@Test
	public void testIfIsSpare(){
		firstThrow=5;
		secondThrow=4;
		frame=new Frame(firstThrow,secondThrow);
		assertFalse(frame.isSpare());
	}

	@Test (expected=BowlingException.class)
	public void testIfIsMoreFrames(){
		List<Frame> f = new ArrayList<Frame>();
		frame=new Frame(firstThrow,secondThrow);

		f.add(frame);
		f.add(frame);
		f.add(frame);
		f.add(frame);
		f.add(frame);
		f.add(frame);
		f.add(frame);
		f.add(frame);
		f.add(frame);
		f.add(frame);
		f.add(frame);
		f.add(frame);

	}

}

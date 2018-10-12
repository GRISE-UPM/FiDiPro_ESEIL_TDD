package tdd.training.paf;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFrame {

	@Test
	public void test_score_no_bonus() {
		Frame frame = new Frame(1,2);
        frame.setNextFrame(new Frame(3,4)); // this should have no effect on score
        assertEquals(3, frame.score());
	}

    @Test
    public void test_score_strike(){
        Frame frame = new Frame(10,0);
        frame.setNextFrame(new Frame(3,4)); // this should have effect on score
        assertEquals(17, frame.score());
    }

    @Test
    public void test_score_spare(){
        Frame frame = new Frame(5,5);
        frame.setNextFrame(new Frame(3,4)); // this should have effect on score
        assertEquals(13, frame.score());
    }

    @Test
    public void test_bonus_zero(){
        Frame frame = new Frame(4,5);
        assertEquals(0, frame.bonus());
    }

    @Test
    public void test_bonus_spare(){
        Frame frame = new Frame(5,5);
        assertEquals(1, frame.bonus());
    }

    @Test
    public void test_bonus_strike(){
        Frame frame = new Frame(10,0);
        assertEquals(2, frame.bonus());
    }

    @Test
    public void test_is_strike(){
        Frame frame = new Frame(5,5);
        assertFalse(frame.isStrike());

        frame = new Frame(10,0);
        assertTrue(frame.isStrike());
    }

    @Test
    public void test_is_spare(){
        Frame frame = new Frame(5,5);
        assertTrue(frame.isSpare());

        frame = new Frame(10,0);
        assertFalse(frame.isSpare());

        frame = new Frame(0,0);
        assertFalse(frame.isSpare());
    }

}

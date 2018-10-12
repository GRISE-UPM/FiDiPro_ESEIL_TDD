package tdd.training.paf;


import org.junit.Test;

import static org.junit.Assert.*;

public class TestFrame {

    @Test
    public void simpleScore() {
        assertEquals(0, new Frame(0, 0).score());
        assertEquals(3, new Frame(1, 2).score());
        assertEquals(10, new Frame(1, 9).score());
        assertEquals(10, new Frame(9, 1).score());
        try {
            new Frame(11, 1);
            fail("should be exception");
        } catch (RuntimeException e) {
            assertEquals("Invalid pins number", e.getMessage());
        }
        try {
            new Frame(1, 11);
            fail("should be exception");
        } catch (RuntimeException e) {
            assertEquals("Invalid pins number", e.getMessage());
        }

    }

    @Test
    public void spareAndStrike() {
        assertFalse(new Frame(0, 0).isSpare());
        assertFalse(new Frame(0, 0).isStrike());

        assertFalse(new Frame(5, 4).isSpare());
        assertFalse(new Frame(5, 4).isStrike());

        assertTrue(new Frame(1, 9).isSpare());
        assertFalse(new Frame(1, 9).isStrike());
        assertTrue(new Frame(9, 1).isSpare());
        assertFalse(new Frame(9, 1).isStrike());
        assertTrue(new Frame(0, 10).isSpare());
        assertFalse(new Frame(0, 10).isStrike());

        assertFalse(new Frame(10, 0).isSpare());
        assertTrue(new Frame(10, 0).isStrike());
    }

    @Test
    public void fullGameNoBonuses() {
        final Frame frame1 = new Frame(1, 2);
        assertEquals(1, frame1.number());
        assertEquals(3, frame1.totalScore());
        final Frame frame2 = new Frame(3, 4, frame1);
        assertEquals(2, frame2.number());
        assertEquals(10, frame2.totalScore());

        final Frame frame3 = new Frame(1, 1, frame2);
        final Frame frame4 = new Frame(1, 1, frame3);
        final Frame frame5 = new Frame(1, 1, frame4);
        final Frame frame6 = new Frame(1, 1, frame5);
        final Frame frame7 = new Frame(1, 1, frame6);
        final Frame frame8 = new Frame(1, 1, frame7);
        final Frame frame9 = new Frame(1, 1, frame8);
        final Frame frame10 = new Frame(1, 1, frame9);

        assertEquals(10, frame10.number());
        assertEquals(26, frame10.totalScore());

        try {
            new Frame(1, 1, frame10);
            fail("Should be exception");
        } catch (RuntimeException e) {
            assertEquals("Game is over!", e.getMessage());
        }
    }

    @Test
    public void lastFrameCanHave3Throws() {

        try {
            new Frame(1, 9, 1, null);
            fail("Should be exception");
        } catch (RuntimeException e) {
            assertEquals("Only last frame can have third trow", e.getMessage());
        }
        try {
            new Frame(1, 9, 1, new Frame(1, 1));
            fail("Should be exception");
        } catch (RuntimeException e) {
            assertEquals("Only last frame can have third trow", e.getMessage());
        }

        new Frame(1, 1, 0, null); //it is ok

        final Frame frame1 = new Frame(1, 1);
        final Frame frame2 = new Frame(1, 1, frame1);
        final Frame frame3 = new Frame(1, 1, frame2);
        final Frame frame4 = new Frame(1, 1, frame3);
        final Frame frame5 = new Frame(1, 1, frame4);
        final Frame frame6 = new Frame(1, 1, frame5);
        final Frame frame7 = new Frame(1, 1, frame6);
        final Frame frame8 = new Frame(1, 1, frame7);
        final Frame frame9 = new Frame(1, 1, frame8);
        final Frame frame10 = new Frame(1, 9, 2, frame9);

        assertEquals(10, frame10.number());
        assertEquals(12, frame10.score());
        assertEquals(30, frame10.totalScore());

        //third throw only after spare or strike
        try {
            new Frame(1, 8, 1, frame9);
            fail("Should be exception");
        } catch (RuntimeException e) {
            assertEquals("Third throw allowed only after spare or strike", e.getMessage());
        }

        assertEquals(30, new Frame(10, 10, 10, frame9).score());
        assertEquals(48, new Frame(10, 10, 10, frame9).totalScore());
    }

    @Test
    public void testSpareBonus() {

        final Frame frame1 = new Frame(1, 1);
        final Frame frame2 = new Frame(2, 8, frame1);
        final Frame frame3 = new Frame(2, 3, frame2);

        assertEquals(0, frame1.bonus());
        assertEquals(2, frame1.score());

        assertEquals(0, frame2.bonus());
        assertEquals(10, frame2.score());

        assertEquals(2, frame3.bonus());
        assertEquals(5, frame3.score());
        assertEquals(19, frame3.totalScore()); //12 after frame2 + 2 + 3 + 2 bonus

    }

    @Test
    public void tesStrikeBonus() {
        final Frame frame1 = new Frame(1, 1);
        final Frame frame2 = new Frame(10, 0, frame1);
        final Frame frame3 = new Frame(2, 3, frame2);

        assertEquals(0, frame1.bonus());
        assertEquals(2, frame1.score());

        assertEquals(0, frame2.bonus());
        assertEquals(10, frame2.score());

        assertEquals(5, frame3.bonus());
        assertEquals(5, frame3.score());
        assertEquals(22, frame3.totalScore()); //12 after frame2 + 2 + 3 + 2 bonus + 3 bonus
    }

    @Test
    public void superEnding() {
        final Frame frame1 = new Frame(1, 1);
        final Frame frame2 = new Frame(1, 1, frame1);
        final Frame frame3 = new Frame(1, 1, frame2);
        final Frame frame4 = new Frame(1, 1, frame3);
        final Frame frame5 = new Frame(1, 1, frame4);
        final Frame frame6 = new Frame(1, 1, frame5);
        final Frame frame7 = new Frame(1, 1, frame6);
        final Frame frame8 = new Frame(1, 1, frame7);
        final Frame frame9 = new Frame(10, 0, frame8);
        final Frame frame10 = new Frame(10, 10, 10, frame9);

        //20 bonus in last frame
        assertEquals(26 + 30 + 20, frame10.totalScore());

    }
}
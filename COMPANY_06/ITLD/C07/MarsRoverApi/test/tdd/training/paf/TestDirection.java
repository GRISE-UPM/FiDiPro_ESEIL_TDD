package tdd.training.paf;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDirection {

    @Test
    public void testParseFromString(){
        Direction dir = Direction.valueOf("N");
        assertEquals(Direction.N, dir);
    }

    @Test
    public void testRotate(){
        Direction dir = Direction.N;
        dir = dir.left();
        assertEquals(Direction.W, dir);

        dir = dir.right();
        assertEquals(Direction.N, dir);

        dir = dir.left().left();
        assertEquals(Direction.S, dir);
    }

}

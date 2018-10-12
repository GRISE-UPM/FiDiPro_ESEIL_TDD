package tdd.training.paf;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMarsRover {

    @Test
    public void moveNorth() {
        final MarsRover rover = new MarsRover(3, 3, "");

        assertEquals("" +
                "OOO\n" +
                "OOO\n" +
                "^OO\n", rover.toString());

        assertEquals("(0,1,north)", rover.executeCommand("f"));
        assertEquals("(0,2,north)", rover.executeCommand("f"));
        assertEquals("(0,0,north)", rover.executeCommand("f"));

        //backward
        assertEquals("(0,2,north)", rover.executeCommand("b"));
        assertEquals("(0,1,north)", rover.executeCommand("b"));
        assertEquals("(0,0,north)", rover.executeCommand("b"));
    }

    @Test
    public void rotateLeft() {
        final MarsRover rover = new MarsRover(3, 3, "");

        assertEquals("(0,0,west)", rover.executeCommand("l"));
        assertEquals("(0,0,south)", rover.executeCommand("l"));
        assertEquals("(0,0,east)", rover.executeCommand("l"));
        assertEquals("(0,0,north)", rover.executeCommand("l"));
    }

    @Test
    public void rotateRight() {
        final MarsRover rover = new MarsRover(3, 3, "");

        assertEquals("(0,0,east)", rover.executeCommand("r"));
        assertEquals("(0,0,south)", rover.executeCommand("r"));
        assertEquals("(0,0,west)", rover.executeCommand("r"));
        assertEquals("(0,0,north)", rover.executeCommand("r"));
    }

    @Test
    public void moveEast() {
        final MarsRover rover = new MarsRover(3, 3, "");

        assertEquals("(0,0,east)", rover.executeCommand("r"));
        assertEquals("(1,0,east)", rover.executeCommand("f"));
        assertEquals("(2,0,east)", rover.executeCommand("f"));
        assertEquals("(0,0,east)", rover.executeCommand("f"));

        //backward
        assertEquals("(2,0,east)", rover.executeCommand("b"));
        assertEquals("(1,0,east)", rover.executeCommand("b"));
        assertEquals("(0,0,east)", rover.executeCommand("b"));
    }

    @Test
    public void moveWest() {
        final MarsRover rover = new MarsRover(3, 3, "");

        assertEquals("(0,0,west)", rover.executeCommand("l"));
        assertEquals("(2,0,west)", rover.executeCommand("f"));
        assertEquals("(1,0,west)", rover.executeCommand("f"));
        assertEquals("(0,0,west)", rover.executeCommand("f"));

        //backward
        assertEquals("(1,0,west)", rover.executeCommand("b"));
        assertEquals("(2,0,west)", rover.executeCommand("b"));
        assertEquals("(0,0,west)", rover.executeCommand("b"));
    }

    @Test
    public void moveSouth() {
        final MarsRover rover = new MarsRover(3, 3, "");

        assertEquals("(0,0,west)", rover.executeCommand("l"));
        assertEquals("(0,0,south)", rover.executeCommand("l"));
        assertEquals("(0,2,south)", rover.executeCommand("f"));
        assertEquals("(0,1,south)", rover.executeCommand("f"));
        assertEquals("(0,0,south)", rover.executeCommand("f"));

        //backward
        assertEquals("(0,1,south)", rover.executeCommand("b"));
        assertEquals("(0,2,south)", rover.executeCommand("b"));
        assertEquals("(0,0,south)", rover.executeCommand("b"));
    }


    @Test
    public void moveZigZag4x4Planet() {
        final MarsRover rover = new MarsRover(4, 4, "");

        assertEquals("(0,1,north)", rover.executeCommand("f"));
        assertEquals("(0,1,east)", rover.executeCommand("r"));
        assertEquals("(1,1,east)", rover.executeCommand("f"));
        assertEquals("(2,1,east)", rover.executeCommand("f"));
        assertEquals("(2,1,north)", rover.executeCommand("l"));
        assertEquals("(2,2,north)", rover.executeCommand("f"));
        assertEquals("(2,3,north)", rover.executeCommand("f"));
        assertEquals("(2,0,north)", rover.executeCommand("f"));
    }

    @Test
    public void obstacles() {
        final MarsRover rover = new MarsRover(3, 3, "(0,2)");
        //assertEquals("" +
        //        "#OO\n" +
        //        "OOO\n" +
        //        "^OO\n", rover.toString());

        assertEquals("(0,1,north)", rover.executeCommand("f"));
        assertEquals("(0,1,north)(0,2)", rover.executeCommand("f"));

    }

    @Test
    public void parseObstaclePosition() {
        assertEquals(2, MarsRover.parseFirstObstacleX("(2,3)"));
        assertEquals(24, MarsRover.parseFirstObstacleX("(24,36)"));
        assertEquals(3, MarsRover.parseFirstObstacleY("(2,3)"));
        assertEquals(36, MarsRover.parseFirstObstacleY("(24,36)"));
    }

}

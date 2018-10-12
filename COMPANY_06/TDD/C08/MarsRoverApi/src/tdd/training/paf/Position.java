package tdd.training.paf;

/**
 * Created by Administrator on 16.3.2016.
 */
public class Position {

    private int x;
    private int y;
    private String facing;

    public Position(int x, int y, String facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getFacing() {
        return facing;
    }

    @Override
    public String toString() {
        return "("+ x +
                ","+ y +
                "," + facing +")";
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }
}

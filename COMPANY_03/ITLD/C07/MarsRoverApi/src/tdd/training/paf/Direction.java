package tdd.training.paf;

public enum Direction {
    N(0, 1), S(0, -1), E(1, 0), W(-1, 0);

    public final int x_coeff;
    public final int y_coeff;

    Direction(int x_coeff, int y_coeff) {
        this.x_coeff = x_coeff;
        this.y_coeff = y_coeff;
    }

    public Direction left() {
        switch (this) {
            case N:
                return W;
            case S:
                return E;
            case E:
                return N;
            case W:
                return S;
        }
        throw new IllegalStateException("Not possible");
    }

    public Direction right() {
        switch (this) {
            case N:
                return E;
            case S:
                return W;
            case E:
                return S;
            case W:
                return N;
        }
        throw new IllegalStateException("Not possible");
    }

}

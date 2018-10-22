package tdd.training.paf;


public class Frame {
    private final int firstThrow;
    private final int secondThrow;
    private final int thirdThrow;
    private final Frame prevFrame;

    public Frame(int firstThrow, int secondThrow) {
        this(firstThrow, secondThrow, null);
    }

    public Frame(int firstThrow, int secondThrow, Frame prevFrame) {
        this(firstThrow, secondThrow, 0, prevFrame);
    }

    public Frame(int firstThrow, int secondThrow, int thirdThrow, Frame prevFrame) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
        this.thirdThrow = thirdThrow;
        this.prevFrame = prevFrame;
        if (number() < 10 && (firstThrow + secondThrow) > 10 || (firstThrow + secondThrow) < 0) {
            throw new RuntimeException("Invalid pins number");
        }

        if (number() > 10) {
            throw new RuntimeException("Game is over!");
        }
        if (thirdThrow > 0 && number() != 10) {
            throw new RuntimeException("Only last frame can have third trow");
        }

        if (thirdThrow > 0 && (firstThrow + secondThrow) < 10) {
            throw new RuntimeException("Third throw allowed only after spare or strike");
        }
    }

    //the score of a single frame
    public int score() {
        if (number() == 10) {
            return firstThrow + secondThrow + thirdThrow;
        }
        return firstThrow + secondThrow;
    }

    //returns whether the frame is a strike or not
    public boolean isStrike() {
        return firstThrow == 10;
    }

    //return whether a frame is a spare or not
    public boolean isSpare() {
        return firstThrow < 10 && firstThrow + secondThrow == 10;
    }


    public int number() {
        if (prevFrame == null) {
            return 1;
        }
        return prevFrame.number() + 1;
    }

    public int totalScore() {
        if (prevFrame == null) {
            return score();
        }
        return prevFrame.totalScore() + score() + bonus();
    }

    public int bonus() {
        if (prevFrame != null) {
            if (prevFrame.isSpare()) {
                return firstThrow;
            } else if (prevFrame.isStrike()) {
                return firstThrow + secondThrow;
            }
        }
        return 0;
    }
}

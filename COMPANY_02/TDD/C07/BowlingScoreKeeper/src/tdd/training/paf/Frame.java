package tdd.training.paf;


public class Frame {
    private int firstThrow;
    private int secondThrow;
    private boolean isLastFrame;
    private Frame nextFrame;

    public Frame(int firstThrow, int secondThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
    }

    public void setNextFrame(Frame nextFrame){
        this.nextFrame = nextFrame;
    }

    public void setLastFrame(boolean isLastFrame){
        this.isLastFrame = isLastFrame;
    }

    //the score of a single frame
    public int score() {
        int score = firstThrow + secondThrow;
        if (bonus() > 0 && nextFrame != null){
            score += nextFrame.firstThrow;
        }
        if (bonus() > 1 && nextFrame != null){
            score += nextFrame.secondThrow;
        }
        return score;
    }

    //returns whether the frame is a strike or not
    public boolean isStrike() {
        return firstThrow == 10;
    }

    //return whether a frame is a spare or not
    public boolean isSpare() {
        return firstThrow != 10 && (firstThrow + secondThrow == 10);
    }

    //return whether this is the last frame of the match
    public boolean isLastFrame() {
        return isLastFrame;
    }

    //bonus throws
    public int bonus() {
        if (isSpare()) {
            return 1;
        } else if (isStrike()) {
            return 2;
        }
        return 0;
    }


}

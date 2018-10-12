package tdd.training.paf;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    //a bowling game is made of (at least) 10 frames
    private List<Frame> frames = new ArrayList<Frame>();
    private Frame bonus;

    public BowlingGame() {
    }

    public void addFrame(Frame frame) {
        if (frames.size() == 10){
            throw new IllegalStateException("There's already 10 frames added to this game");
        }
        Frame prev = lastFrame();
        frames.add(frame);
        if (prev != null) {
            prev.setNextFrame(frame);
        }
        if (frames.size() == 10){
            frame.setLastFrame(true);
        }
    }

    public void setBonus(int firstThrow, int secondThrow) {
        if (isNextFrameBonus() && bonus == null) {
            bonus = new Frame(firstThrow, secondThrow);
            lastFrame().setNextFrame(bonus);
        }
    }

    public int score() {
        return frames.stream().mapToInt((frame) -> frame.score()).sum();
    }

    public boolean isNextFrameBonus() {
        Frame lastFrame = lastFrame();
        return lastFrame != null && lastFrame.isLastFrame() && lastFrame.bonus() > 0;
    }

    private Frame lastFrame() {
        if (frames.isEmpty()) {
            return null;
        }
        return frames.get(frames.size() - 1);
    }
}

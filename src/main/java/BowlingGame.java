import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private int score = 0;

    private List<Frame> frames = new ArrayList();

    public int score() {

        for (int currentFrame = 0; currentFrame < frames.size(); currentFrame++) {
            Frame frame = frames.get(currentFrame);
            score += frame.totalRollScore();
            if (frame.isSpare()) {
                Frame nextFrame = frames.get(currentFrame + 1);
                score += nextFrame.Roll1();
            } else if (frame.isStrike()) {
                Frame nextFrame = frames.get(currentFrame + 1);
                score += nextFrame.Roll1();
                if (nextFrame.isStrike()) {
                    Frame thirdFrame = frames.get(currentFrame + 2);
                    score += thirdFrame.Roll1();
                } else {
                    score += nextFrame.Roll2();
                }
            }
        }
        return score;
    }

    public void rolling(int roll1, int roll2) {
        frames.add(new Frame(roll1, roll2));
    }

    public void rollInFrames(int roll1, int roll2, int numberOfFrames) {
        for (int i = 0; i < numberOfFrames; i++) {
            rolling(roll1, roll2);
        }
    }

    public void rollSpare(int roll1, int roll2) {
        Frame frame = new Frame(roll1, roll2);
        frame.setSpare(true);
        frames.add(frame);

    }

    public void rollStrike() {
        Frame frame = new Frame(10, 0);
        frame.setStrike(true);
        frames.add(frame);
    }
}

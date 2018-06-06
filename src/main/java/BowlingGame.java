import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private int score = 0;

    private List<Frame> frames = new ArrayList();

    public int score() {

        for (int currentFrame = 0; currentFrame < frames.size(); currentFrame++) {
            Frame frame = frames.get(currentFrame); //add roll1 and roll2 to the current frame
            score += frame.totalRollScore(); //calculate roll1 + roll2 scores per current frame
            if (frame.isSpare()) { //if sum of roll1 and roll2 scores >= 10
                Frame secondFrame = frames.get(currentFrame + 1); //include 2nd frame roll1 score
                score += secondFrame.Roll1(); //add 2nd frame roll1 score as bonus to the current score
            } else if (frame.isStrike()) { //if roll1 score is 10
                Frame secondFrame = frames.get(currentFrame + 1); //include 2nd frame roll1 score
                score += secondFrame.Roll1(); //add 2nd frame roll1 score as bonus to the current score
                if (secondFrame.isStrike()) { //if 2nd frame roll1 score is 10 again
                    Frame thirdFrame = frames.get(currentFrame + 2); //include 3rd frame roll1 score
                    score += thirdFrame.Roll1(); //add 3rd frame roll1 score as bonus to the current score
                } else {
                    score += secondFrame.Roll2(); //if 2nd frame roll1 score <10 then add roll2 score to the current score
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

    public void rollInTenthFrame(int roll1, int roll2, int roll3) {
        Frame frame = new Frame(roll1, roll2);
        frame.setBonusRoll(roll3);
        frames.add(frame);
    }
}

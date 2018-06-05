import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BowlingGame {

    private static Random r = new Random();
    private static int score;
    private static int frames;
    private List<Integer> rolls = new ArrayList<>();

    public void roll(int score) {
        rolls.add(score);
    }

    public int getPins() {
        return r.nextInt(11);
    }

    public void getScore(int frameIndex, int numberOfPins) {
        int score = 0;
        for (int i = 1; i <= frameIndex; i++) {
            score += numberOfPins;
        }
        System.out.println(score);
    }

    public void getCurrentScore(int frame) {
        for (int i = 0; i <= frame; i++) {
            int scorePerFrame = getPins();
            System.out.println(scorePerFrame);
        }
    }

    public void getScore() {
        for (int i = 0; i <= 9; i++) {
            rolls.add(getPins());
            if (isStrike(rolls.get(0))) {

            }
        }
    }

    public int getTotalScore(int frames) {
        return score;
    }

    private boolean isStrike(int rollIndex) {
        return getPins() == 10;
    }
}

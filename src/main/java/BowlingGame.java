import java.util.Random;

public class BowlingGame {

    private static Random r = new Random();
    private static int score;
    private static int frameIndex;

    public int getScore() {
        return r.nextInt(11);
    }

    public int getFrameScore() {
//        score = r.nextInt(11);
        if (score == 10) {
            score = score + getStrikeBonus();
        }
        return score;
    }

    public int getCurrentScore() {
        return score;
    }

    public int getTotalScore() {
        return score;
    }

    private boolean isStrikeScore() {
        return score == 10;
    }

    private boolean isSpareScore() {
        int totalFrameScore = 0;
        for (int i = 1; i <= 2; i++) {
            totalFrameScore += score;
        }
        return totalFrameScore >= 10;
    }

    private int getStrikeBonus() {
        int totalScore = 0;
        for (int i = 1; i <= 2; i++) {
            int scorePerFrame = getScore();
            totalScore += scorePerFrame;
        }
        return totalScore;
    }
//
//    private int getSpareBonus() {
//
//    }
}

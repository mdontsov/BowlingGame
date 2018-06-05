import java.util.Random;

public class BowlingGame {

    private static Random r = new Random();
    private static int score;
    private static int frameIndex;

    public int getScore() {
        return r.nextInt(11);
    }

    public int getCurrentScore() {
        return score;
    }

    public int getTotalScore() {
        return score;
    }

    private boolean isStrikeScore() {
        return getScore() == 10;
    }

    private boolean isSpareScore() {
        int firstRollScore = getScore();
        int totalScore = 0;
        if (firstRollScore > 0 && firstRollScore < 10) {
            int spareRollScore = getScore();
            totalScore = spareRollScore + firstRollScore;
        }
        return totalScore >= 10;
    }
}

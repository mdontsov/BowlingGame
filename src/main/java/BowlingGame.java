import java.util.Random;

public class BowlingGame {

    private static Random r = new Random();
    private static int score;

    public int getScore() {
        score = r.nextInt(10) + 1;
        return score;
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

//    private boolean isSpareScore() {
//
//    }
}

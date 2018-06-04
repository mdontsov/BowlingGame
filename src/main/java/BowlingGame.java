import java.util.Random;

public class BowlingGame {

    private static Random r = new Random();

    public int getScore() {
        return r.nextInt(10) + 1;
    }
}

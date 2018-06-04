import java.util.Random;

public class BowlingGame {

    private static Random r = new Random();

//    private static int numberOfPins = Math.abs(new Random().nextInt()%11);

    public int getScore() {
//        return numberOfPins;
        return r.nextInt(10) + 1;
    }

}

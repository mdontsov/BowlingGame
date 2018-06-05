import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BowlingGame {

    private static Random r = new Random();
    private List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
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

    public int getScore() {
        int score = 0;
        int frameIndex = 0;
        for (int i = 0; i <= 9; i++) {
            rolls.add(getPins());
            if (isStrike(rolls.get(0))) {
                score += 10 + getStrikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(rolls.get(0))) {
                score += 10 + getSpareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += getSum(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int frameIndex) {
        return rolls.get(frameIndex) == 10;
    }

    private boolean isSpare(int frameIndex) {
        return getSum(frameIndex) >= 10;
    }

    private int getStrikeBonus(int frameIndex) {
        return rolls.get(frameIndex + 1);
    }

    private int getSpareBonus(int frameIndex) {
        return rolls.get(frameIndex + 2);
    }

    private int getSum(int frameIndex) {
        return rolls.get(frameIndex) + rolls.get(frameIndex + 1);
    }
}

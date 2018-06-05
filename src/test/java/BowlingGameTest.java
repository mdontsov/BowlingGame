import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    void rollMany(int frames, int pins) {
        for (int i = 0; i <= frames; i++) {
            bowlingGame.roll(pins);
        }
    }

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void canRandomlyStrike() {
        assertThat(bowlingGame.getPins(), equalTo(10));
    }

    @Test
    public void canRandomlySpare() {
        List<Integer> rolls = new ArrayList<>();
        int totalScore = 0;
        for (int i = 0; i <= 1; i++) {
            rolls.add(bowlingGame.getPins());
            totalScore = rolls.stream().mapToInt(Integer::intValue).sum();
        }
        assertThat(totalScore, greaterThanOrEqualTo(10));
    }

    @Test
    public void canRandomlyOpenFrame() {
        List<Integer> rolls = new ArrayList<>();
        int totalScore = 0;
        for (int i = 0; i <= 1; i++) {
            rolls.add(bowlingGame.getPins());
            totalScore = rolls.stream().mapToInt(Integer::intValue).sum();
        }
        assertThat(totalScore, lessThan(10));
    }

    @Test
    public void canRandomlyZero() {
        int scorePerFrame = bowlingGame.getPins();
        assertThat(scorePerFrame, equalTo(0));
    }

    @Test
    public void canSpareInAllFrames() {
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            rolls.add(bowlingGame.getPins());
            assertThat(rolls.get(i), allOf(greaterThan(0), lessThanOrEqualTo(10)));
        }
//        rolls.set(20, 0);
//        if (rolls.get(18) == 10 | (rolls.get(18) + rolls.get(19) >= 10)) {
//            rolls.set(20, bowlingGame.getScore());
//        }
//        for (int j = 0; j <= rolls.size(); j++) {
//            assertThat(rolls.get(j), allOf(greaterThan(0), lessThanOrEqualTo(10)));
//        }
    }

    @Test
    public void canStrikeInAllFrames() {
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            rolls.add(bowlingGame.getPins());
            assertThat(rolls.get(i), equalTo(10));
        }
    }

    @Test
    public void canZeroInAllFrames() {
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            rolls.add(bowlingGame.getPins());
            assertThat(rolls.get(i), equalTo(0));
        }
    }

    @Test
    public void canCalculateStrikeBonus() {
        bowlingGame.roll(bowlingGame.getPins());
    }

    @Test
    public void canCalculateSpareBonus() {

    }

    @Test
    public void canRoll3rdTime() {
    }

    @Test
    public void currentScore() {
        bowlingGame.getScore(4, 10);
    }

    @Test
    public void scoreZeroes() {
        rollMany(20, 0);
        assertThat(bowlingGame.getScore(), equalTo(0));
    }

    @Test
    public void scoreOnes() {
        rollMany(20, 1);
        assertThat(bowlingGame.getScore(), equalTo(20));
    }

    @Test
    public void scoreOneSpare() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(3);
        rollMany(17, 0);
        assertThat(bowlingGame.getScore(), equalTo(16));
    }

    @Test
    public void scoreOneStrike() {
        bowlingGame.roll(10);
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        rollMany(16, 0);
        assertThat(bowlingGame.getScore(), equalTo(24));
    }

    @Test
    public void scoreAllStrikes() {
        rollMany(12, 10);
        assertThat(bowlingGame.getScore(), equalTo(300));
    }
}

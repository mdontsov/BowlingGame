import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void canRandomlyStrike() {
        assertThat(bowlingGame.getScore(), equalTo(10));
    }

    @Test
    public void canRandomlySpare() {
        int totalScore = 0;
        for (int i = 1; i <= 2; i++) {
            int scorePerFrame = bowlingGame.getScore();
            totalScore += scorePerFrame;
        }
        assertThat(totalScore, greaterThanOrEqualTo(10));
    }

    @Test
    public void canRandomlyOpenFrame() {
        int totalScore = 0;
        for (int i = 1; i <= 2; i++) {
            int scorePerFrame = bowlingGame.getScore();
            totalScore += scorePerFrame;
        }
        assertThat(totalScore, lessThan(10));
    }

    @Test
    public void canRandomlyZero() {
        int totalScore = 0;
        for (int i = 1; i <= 2; i++) {
            int scorePerFrame = bowlingGame.getScore();
            totalScore += scorePerFrame;
        }
        assertThat(totalScore, equalTo(0));
    }

    @Test
    public void canSpareInAllFrames() {
        int scorePerFrame = 0;
        for (int i = 0; i <= 20; i++) {
            scorePerFrame = bowlingGame.getScore();
            System.out.println(scorePerFrame);
        }
        assertThat(scorePerFrame, allOf(greaterThan(0), lessThan(10)));
    }

    @Test
    public void canCalculateStrikeBonus() {
        if (bowlingGame.getScore() == 10) {

        }
    }
}

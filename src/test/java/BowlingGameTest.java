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
}

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void scoreTwoInAllFrames() {
        bowlingGame.rollInFrames(2, 2, 10);
        assertThat(bowlingGame.score(), equalTo(40));
    }

    @Test
    public void scoreZeroInAllSpares() {
        bowlingGame.rollInFrames(0, 0, 10);
        assertThat(bowlingGame.score(), equalTo(0));
    }

    @Test
    public void rollSpares() {
        for (int i = 0; i < 2; i++) {
            bowlingGame.rollSpare(2, 8);
        }
        bowlingGame.rollInFrames(2, 2, 8);
        assertThat(bowlingGame.score(), equalTo(56));
    }

    @Test
    public void rollStrike() {
        bowlingGame.rollStrike();
        bowlingGame.rollInFrames(2, 2, 9);
        assertThat(bowlingGame.score(), equalTo(50));
    }

    @Test
    public void rollStrikeTwice() {
        for (int i = 0; i < 2; i++) {
            bowlingGame.rollStrike();
        }
        bowlingGame.rollInFrames(2, 2, 8);
        assertThat(bowlingGame.score(), equalTo(68));
    }
}

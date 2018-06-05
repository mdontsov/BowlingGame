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
    public void canCalculateBonuses() {
        int firstRollScore = 10;//bowlingGame.getScore();
        int bonusRollScore = 0;
        int totalScore = 0;
        if (firstRollScore == 10) {
            for (int nextRoll = 1; nextRoll <= 2; nextRoll++) {
                int nextRollScore = bowlingGame.getScore();
                bonusRollScore += nextRollScore;
                totalScore = bonusRollScore + firstRollScore;
            }
            assertThat(totalScore, equalTo(bonusRollScore + firstRollScore));
        } else if (firstRollScore > 0 && firstRollScore < 10) {
            int spareRollScore = bowlingGame.getScore();
            totalScore = spareRollScore + firstRollScore;
            if (totalScore >= 10) {
                bonusRollScore = bowlingGame.getScore();
                totalScore = totalScore + bonusRollScore;
            }
            assertThat(totalScore, lessThanOrEqualTo(totalScore + bonusRollScore));
        } else {
            System.out.println("No bonuses for Open Frame!");
        }
    }

//    @Test
//    public void canCalculateSpareBonus() {
//        int firstRollScore = bowlingGame.getScore();
//        if (firstRollScore > 0 && firstRollScore < 10) {
//            int secondRollScore = bowlingGame.getScore();
//            int totalFrameScore = firstRollScore + secondRollScore;
//            if (totalFrameScore >= 10) {
//                int newRollScore
//            }
//            assertThat(totalScore, equalTo(nextFrameScore + score));
//        }
//    }
//
//    @Test
//    public void canCalculateBonuses() {
//        int score = bowlingGame.getScore();
//        int bonusScore = 0;
//        int totalScore = 0;
//        int newFrameScore = 0;
//        if (score == 10) {
//            for (int nextBonus = 1; nextBonus <= 2; nextBonus++) {
//                newFrameScore = bowlingGame.getScore();
//                bonusScore += newFrameScore;
//                totalScore = bonusScore + score;
//            }
//            assertThat(totalScore, equalTo(bonusScore + score));
//        } else if (score > 0 && score < 10){
//            bonusScore = newFrameScore + score;
//            totalScore =
//        }
//        assertThat(bonusScore, equalTo(newFrameScore + score));
//    }
}

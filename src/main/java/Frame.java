public class Frame {

    private int roll1;
    private int roll2;
    private boolean isSpare;
    private boolean isStrike;
    private int bonusRoll;

    public int Roll1() {
        return roll1;
    }

    public int Roll2() {
        return roll2;
    }

    public Frame(int roll1, int roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public void setSpare(boolean spare) {
        isSpare = spare;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    public int totalRollScore() {
        return roll1 + roll2 + getBonusRoll();
    }

    public int getBonusRoll() {
        return bonusRoll;
    }

    public void setBonusRoll(int bonusRoll) {
        this.bonusRoll = bonusRoll;
    }
}

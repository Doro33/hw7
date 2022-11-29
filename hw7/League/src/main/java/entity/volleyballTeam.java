package entity;

public class volleyballTeam extends Team{
    private int won3_0;
    private int won3_1;
    private int won3_2;
    private int lose3_0;
    private int lose3_1;
    private int lose3_2;
    private int winingSets;
    private int losingSets;
    private int winingPoints;
    private int losingPoints;


    public volleyballTeam(String teamName, int matches, int won, int lose, int points, int won3_0, int won3_1, int won3_2, int lose3_0, int lose3_1, int lose3_2, int winingSets, int losingSets, int winingPoints, int losingPoints) {
        super(teamName, matches, won, lose, points);
        this.won3_0 = won3_0;
        this.won3_1 = won3_1;
        this.won3_2 = won3_2;
        this.lose3_0 = lose3_0;
        this.lose3_1 = lose3_1;
        this.lose3_2 = lose3_2;
        this.winingSets = winingSets;
        this.losingSets = losingSets;
        this.winingPoints = winingPoints;
        this.losingPoints = losingPoints;
    }

    public volleyballTeam(){}

    public int getWon3_0() {
        return won3_0;
    }

    public void setWon3_0(int won3_0) {
        this.won3_0 = won3_0;
    }

    public int getWon3_1() {
        return won3_1;
    }

    public void setWon3_1(int won3_1) {
        this.won3_1 = won3_1;
    }

    public int getWon3_2() {
        return won3_2;
    }

    public void setWon3_2(int won3_2) {
        this.won3_2 = won3_2;
    }

    public int getLose3_0() {
        return lose3_0;
    }

    public void setLose3_0(int lose3_0) {
        this.lose3_0 = lose3_0;
    }

    public int getLose3_1() {
        return lose3_1;
    }

    public void setLose3_1(int lose3_1) {
        this.lose3_1 = lose3_1;
    }

    public int getLose3_2() {
        return lose3_2;
    }

    public void setLose3_2(int lose3_2) {
        this.lose3_2 = lose3_2;
    }

    public int getWiningSets() {
        return winingSets;
    }

    public void setWiningSets(int winingSets) {
        this.winingSets = winingSets;
    }

    public int getLosingSets() {
        return losingSets;
    }

    public void setLosingSets(int losingSets) {
        this.losingSets = losingSets;
    }

    public int getWiningPoints() {
        return winingPoints;
    }

    public void setWiningPoints(int winingPoints) {
        this.winingPoints = winingPoints;
    }

    public int getLosingPoints() {
        return losingPoints;
    }

    public void setLosingPoints(int losingPoints) {
        this.losingPoints = losingPoints;
    }

    @Override
    public String toString() {
        return
                 teamName.toUpperCase() +
                " | Matches: " + matches +
                " | Won: " + won +
                " | Lose: " + lose +
                " | Points: " + points +
                " | Won3_0: " + won3_0 +
                " | Won3_1: " + won3_1 +
                " | Won3_2: " + won3_2 +
                " | Lose3_0: " + lose3_0 +
                " | Lose3_1: " + lose3_1 +
                " | Lose3_2: " + lose3_2 +
                " | Wining Sets: " + winingSets +
                " | Losing Sets: " + losingSets +
                " | Wining Points: " + winingPoints +
                " | Losing Points: " + losingPoints ;
    }
}

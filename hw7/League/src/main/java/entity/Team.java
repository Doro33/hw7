package entity;

public class Team {
    protected String teamName;
    protected int matches;
    protected int won;
    protected int lose;
    protected int points;

    public Team() {
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, int matches, int won, int lose, int points) {
        this.teamName = teamName;
        this.matches = matches;
        this.won = won;
        this.lose = lose;
        this.points = points;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
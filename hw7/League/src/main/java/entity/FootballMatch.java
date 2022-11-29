package entity;

public class FootballMatch {
    private int week;
    private String homeTeamName;
    private String awayTeamName;
    private int homeTeamGoals;
    private int awayTeamGoals;

    public FootballMatch(int week, String homeTeamName, String awayTeamName, int homeTeamGoals, int awayTeamGoals) {
        this.week = week;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
    }

    public FootballMatch() {
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    @Override
    public String toString() {
        return "week:" + week +
                " | " + homeTeamName.toUpperCase() +
                " " + homeTeamGoals +
                " - " + awayTeamGoals +
                " " + awayTeamName.toUpperCase() +" |";
    }

    public void showMatches(FootballMatch[] footballMatches) {
        if (footballMatches[0] == null)
            System.out.println("There Is Not Any Match To Show Yet.");
        for (int i = 0; i < 100; i++) {
            if (footballMatches[i] != null)
                System.out.println(i + 1 + ") " + footballMatches[i]);
        }
    }
}
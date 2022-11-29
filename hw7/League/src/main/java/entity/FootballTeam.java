package entity;

public class FootballTeam extends Team {

    private int draw;

    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;

    public FootballTeam() {
    }

    public FootballTeam(String teamName) {
        super(teamName);
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }


    @Override
    public String toString() {
        return teamName.toUpperCase() +
                " : Matches: " + matches +
                " | Won :" + won +
                " | Draw :" + draw +
                " | Loss :" + lose +
                " | Goals For :" + goalsFor +
                " | Goals Against :" + goalsAgainst +
                " | GoalDifference :" + goalDifference +
                " | Points :" + points;
    }
}
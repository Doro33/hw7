package repository;

import config.ApplicationConnection;
import entity.FootballTeam;

import java.sql.*;

public class FootballStandRepository {

    public void insertTeam(String newTeamName) throws SQLException {
        String sql = """
                INSERT INTO stand
                VALUES (?,?,?,?,?,?,?,?,?)
                """;
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, newTeamName);
        ps.setInt(2, 0);
        ps.setInt(3, 0);
        ps.setInt(4, 0);
        ps.setInt(5, 0);
        ps.setInt(6, 0);
        ps.setInt(7, 0);
        ps.setInt(8, 0);
        ps.setInt(9, 0);

        ps.execute();
        ps.close();
    }

    public void deleteTeam(String TeamName) throws SQLException {
        String sql = """
                DELETE FROM stand
                WHERE team=?
                """;
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, TeamName);

        ps.execute();
        ps.close();
    }

    public FootballTeam getTeam(String teamName) throws SQLException {
        String sql = """
                Select * from stand
                where team=?;
                """;
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql);
        ps.setString(1, teamName);

        ResultSet rs = ps.executeQuery();
        rs.next();
        FootballTeam footballTeam = new FootballTeam();
        footballTeam.setTeamName(rs.getString("team"));
        footballTeam.setMatches(rs.getInt("matches"));
        footballTeam.setWon(rs.getInt("won"));
        footballTeam.setDraw(rs.getInt("draw"));
        footballTeam.setLose(rs.getInt("loss"));
        footballTeam.setGoalsFor(rs.getInt("goalsFor"));
        footballTeam.setGoalsAgainst(rs.getInt("goalsAgainst"));
        footballTeam.setGoalDifference(rs.getInt("goalDifference"));
        footballTeam.setPoints(rs.getInt("points"));
        ps.execute();
        ps.close();
        rs.close();
        return footballTeam;
    }

    public void winnerChange(String winnerTeamName) throws SQLException {
        FootballTeam winnerFootballTeam = getTeam(winnerTeamName);
        int newMatches = winnerFootballTeam.getMatches() + 1;
        int newWon = winnerFootballTeam.getWon() + 1;
        int newPoints = winnerFootballTeam.getPoints() + 3;
        String sql = """
                UPDATE stand
                SET matches=? , won=? , points=?
                WHERE team = ?
                """;
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql);

        ps.setInt(1, newMatches);
        ps.setInt(2, newWon);
        ps.setInt(3, newPoints);
        ps.setString(4, winnerTeamName);
        ps.execute();
        ps.close();
    }

    public void loserChange(String loserTeamName) throws SQLException {
        FootballTeam loserFootballTeam = getTeam(loserTeamName);
        int newMatches = loserFootballTeam.getMatches() + 1;
        int newLoss = loserFootballTeam.getLose() + 1;
        String sql = """
                UPDATE stand
                SET matches=? , loss=?
                WHERE team = ?
                """;
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql);

        ps.setInt(1, newMatches);
        ps.setInt(2, newLoss);
        ps.setString(3, loserTeamName);
        ps.execute();
        ps.close();
    }

    public void drawChange(String drawTeamName) throws SQLException {
        FootballTeam drawFootballTeam = getTeam(drawTeamName);
        int newMatches = drawFootballTeam.getMatches() + 1;
        int newDraw = drawFootballTeam.getDraw() + 1;
        int newPoints = drawFootballTeam.getPoints() + 1;
        String sql = """
                UPDATE stand
                SET matches=? , draw=? , points=?
                WHERE team = ?
                """;
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql);

        ps.setInt(1, newMatches);
        ps.setInt(2, newDraw);
        ps.setInt(3, newPoints);
        ps.setString(4, drawTeamName);
        ps.execute();
        ps.close();
    }

    public void goalsForChange(String teamName, int goalsFor) throws SQLException {
        FootballTeam footballTeam = getTeam(teamName);
        int newGoalsFor = footballTeam.getGoalsFor() + goalsFor;
        int newGoalDifference = footballTeam.getGoalDifference() + goalsFor;
        String sql = """
                UPDATE stand
                SET goalsFor=? , goalDifference=?
                WHERE team = ?
                """;
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql);

        ps.setInt(1, newGoalsFor);
        ps.setInt(2, newGoalDifference);
        ps.setString(3, teamName);
        ps.execute();
        ps.close();
    }

    public void goalAgainstChange(String teamName, int goalsAgainst) throws SQLException {
        FootballTeam footballTeam = getTeam(teamName);
        int newGoalsAgainst = footballTeam.getGoalsAgainst() + goalsAgainst;
        int newGoalDifference = footballTeam.getGoalDifference() - goalsAgainst;
        String sql = """
                UPDATE stand
                SET goalsAgainst=? , goalDifference=?
                WHERE team = ?
                """;
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql);

        ps.setInt(1, newGoalsAgainst);
        ps.setInt(2, newGoalDifference);
        ps.setString(3, teamName);
        ps.execute();
        ps.close();
    }

    public boolean teamExist(String teamName) throws SQLException {
        String sql = """
                SELECT team from stand
                WHERE team=? ;
                """;
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, teamName);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public FootballTeam[] showStand() throws SQLException {
        String sql = """
                Select * from stand
                order by points desc ,
                goalDifference desc ,
                matches,
                won desc ,
                draw desc ,
                goalsFor desc,
                team;
                """;
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        FootballTeam[] footballTeams = new FootballTeam[20];

        footballTeamProperties(rs, footballTeams);
        ps.close();
        rs.close();
        return footballTeams;
    }

    private void footballTeamProperties(ResultSet rs, FootballTeam[] footballTeams) throws SQLException {
        int index = 0;
        while (rs.next()) {
            FootballTeam footballTeam = new FootballTeam();
            footballTeam.setTeamName(rs.getString("team"));
            footballTeam.setMatches(rs.getInt("matches"));
            footballTeam.setWon(rs.getInt("won"));
            footballTeam.setDraw(rs.getInt("draw"));
            footballTeam.setLose(rs.getInt("loss"));
            footballTeam.setGoalsFor(rs.getInt("goalsFor"));
            footballTeam.setGoalsAgainst(rs.getInt("goalsAgainst"));
            footballTeam.setGoalDifference(rs.getInt("goalDifference"));
            footballTeam.setPoints(rs.getInt("points"));
            footballTeams[index] = footballTeam;
            index++;
        }
    }
}
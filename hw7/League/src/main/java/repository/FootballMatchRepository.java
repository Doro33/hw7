package repository;

import config.ApplicationConnection;
import entity.FootballMatch;

import java.sql.*;

public class FootballMatchRepository {

    private final Connection connection =  ApplicationConnection.getConnection();

    public void insert(FootballMatch footballMatch) throws SQLException {
        String sql = """
                INSERT INTO footballMatch(week,homeTeam,homeTeamGoals,awayTeamGoals,awayTeam)
                VALUES (?,?,?,?,?)
                """;
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, footballMatch.getWeek());
        ps.setString(2, footballMatch.getHomeTeamName());
        ps.setInt(3, footballMatch.getHomeTeamGoals());
        ps.setInt(4, footballMatch.getAwayTeamGoals());
        ps.setString(5, footballMatch.getAwayTeamName());

        ps.execute();
        ps.close();
    }

    public boolean teamHasPlayed(int week, String teamName) throws SQLException {
        String sql = """
                SELECT * from footballMatch
                WHERE week=? AND homeTeam=? OR awayTeam=?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, week);
        ps.setString(2, teamName);
        ps.setString(3, teamName);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public FootballMatch[] weeklyMatches(int week) throws SQLException {
        String sql = """
                Select * from footballMatch
                where week = ?
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, week);
        ResultSet rs = ps.executeQuery();
        FootballMatch[] footballMatches = new FootballMatch[100];
        footballMatchProperties(week, rs, footballMatches);
        ps.close();
        rs.close();
        return footballMatches;
    }

    private void footballMatchProperties(int week, ResultSet rs, FootballMatch[] footballMatches) throws SQLException {
        int index = 0;
        while (rs.next()) {
            FootballMatch footballMatch = new FootballMatch();
            footballMatch.setWeek(week);
            footballMatch.setHomeTeamName(rs.getString("homeTeam"));
            footballMatch.setHomeTeamGoals(rs.getInt("homeTeamGoals"));
            footballMatch.setAwayTeamGoals(rs.getInt("awayTeamGoals"));
            footballMatch.setAwayTeamName(rs.getString("awayTeam"));
            footballMatches[index] = footballMatch;
            index++;
        }
    }

    public FootballMatch[] teamMatches(String teamName) throws SQLException {
        String sql = """
                Select * from footballMatch
                where homeTeam = ? or awayTeam=?
                order by week
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, teamName);
        ps.setString(2, teamName);
        ResultSet rs = ps.executeQuery();
        FootballMatch[] footballMatches = new FootballMatch[100];
        footballMatchProperties(rs, footballMatches);
        ps.close();
        rs.close();
        return footballMatches;
    }

    private void footballMatchProperties(ResultSet rs, FootballMatch[] footballMatches) throws SQLException {
        int index = 0;
        while (rs.next()) {
            FootballMatch footballMatch = new FootballMatch();
            footballMatch.setWeek(rs.getInt("week"));
            footballMatch.setHomeTeamName(rs.getString("homeTeam"));
            footballMatch.setHomeTeamGoals(rs.getInt("homeTeamGoals"));
            footballMatch.setAwayTeamGoals(rs.getInt("awayTeamGoals"));
            footballMatch.setAwayTeamName(rs.getString("awayTeam"));
            footballMatches[index] = footballMatch;
            index++;
        }
    }

    public boolean deleteTeamPermission(String teamName) throws SQLException {
        String sql = """
                SELECT * from footballMatch
                WHERE homeTeam=? or awayTeam= ?;
                """;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, teamName);
        ps.setString(2, teamName);

        ResultSet rs = ps.executeQuery();
        return !rs.next();
    }
}
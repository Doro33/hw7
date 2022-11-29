package servive.teamServices;

import entity.FootballMatch;
import entity.FootballTeam;
import servive.AppContext;

import java.sql.SQLException;

public class TeamInformation {
    public void showTeamInformation() throws SQLException {
        System.out.println("Show Team Information:"+'\n'+
                "0) Back.");
        String input= AppContext.teamExist();
        FootballTeam footballTeam= AppContext.getFootballStandRepository().getTeam(input);
        System.out.println(AppContext.setFootballTeam(footballTeam));
        System.out.println("Results:");
        FootballMatch[] teamMatches=AppContext.getFootballMatchRepository().teamMatches(input);
        AppContext.getFootballMatch().showMatches(teamMatches);
        System.out.println("-------");
        AppContext.doneReaction();
        showTeamInformation();
    }
}
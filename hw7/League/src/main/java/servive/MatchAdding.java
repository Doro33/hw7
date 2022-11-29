package servive;

import entity.FootballMatch;
import repository.FootballMatchRepository;
import repository.FootballStandRepository;

import java.sql.SQLException;

public class MatchAdding {

    private int setGoals(){
        String input;
        while (true) {
            input = AppContext.getScanner().nextLine();
            if (!input.matches("^0?[0-9]|[1][0-5]$"))
                System.out.println("Goals Must Be Between 0-15 ");
            else
                break;
        }
        return Integer.parseInt(input);
    }

    FootballMatchRepository fMatchRepo=AppContext.getFootballMatchRepository();

    FootballStandRepository fStandRepo=AppContext.getFootballStandRepository();
    private FootballMatch createMatch() throws SQLException {
        int week = AppContext.getWeeklyResults().setWeek();
        System.out.println("Home Team:");
        String homeTeam = AppContext.teamExist();
        if (fMatchRepo.teamHasPlayed(week,homeTeam)){
            System.out.println("This Team Has Already Played In This Week.");
            System.out.println("--------");
            resultsOfMatch();
        }
        System.out.println("AwayTeam: ");
        String awayTeam = AppContext.teamExist();
        if (fMatchRepo.teamHasPlayed(week,awayTeam)){
            System.out.println("This Team Has Already Played In This Week.");
            System.out.println("--------");
            resultsOfMatch();
        }
        System.out.print(homeTeam.toUpperCase() + " Goals: ");
        int homeTeamGaols = setGoals();
        System.out.print(awayTeam.toUpperCase() + " Goals: ");
        int awayTeamGoals = setGoals();
        return new FootballMatch(week, homeTeam, awayTeam, homeTeamGaols, awayTeamGoals);
    }

    private FootballMatch areYouSure() throws SQLException {
        FootballMatch footballMatch=createMatch();
        System.out.println(footballMatch);
        System.out.println("Are You Sure?");
        System.out.print("y as yes / n as no: ");
        String input;
        while (true) {
            input = AppContext.getScanner().nextLine().toLowerCase();
            if (input.matches("y")) {
                break;
            } else if (input.matches("n")) {
                System.out.println("--------");
                resultsOfMatch();
            } else {
                System.out.println("Your Input Is Not Valid.");
                System.out.print("y as yes / n as no : ");
            }
        }
        return footballMatch;
    }

    public void  resultsOfMatch() throws SQLException {
        System.out.println("Add A Match:"+'\n'+
                            "0) Back.");
        FootballMatch footballMatch = areYouSure();
        fMatchRepo.insert(footballMatch);
        String homeTeam=footballMatch.getHomeTeamName();
        String awayTeam=footballMatch.getAwayTeamName();
        int homeTeamGoals=footballMatch.getHomeTeamGoals();
        int awayTeamGoals=footballMatch.getAwayTeamGoals();
        if(homeTeamGoals >awayTeamGoals){
            fStandRepo.winnerChange(homeTeam);
            fStandRepo.loserChange(awayTeam);
        }else if (homeTeamGoals < awayTeamGoals){
            fStandRepo.winnerChange(awayTeam);
            fStandRepo.loserChange(homeTeam);
        } else{
            fStandRepo.drawChange(homeTeam);
            fStandRepo.drawChange(awayTeam);
        }
        fStandRepo.goalsForChange(homeTeam,homeTeamGoals);
        fStandRepo.goalsForChange(awayTeam,awayTeamGoals);
        fStandRepo.goalAgainstChange(homeTeam,awayTeamGoals);
        fStandRepo.goalAgainstChange(awayTeam,homeTeamGoals);
        AppContext.doneReaction();
        resultsOfMatch();
    }
}
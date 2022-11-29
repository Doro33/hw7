package servive;

import entity.FootballMatch;
import entity.FootballTeam;
import repository.FootballMatchRepository;
import repository.FootballStandRepository;
import servive.teamServices.TeamAdding;
import servive.teamServices.TeamDeleting;
import servive.teamServices.TeamInformation;
import view.FootballMenuStarter;

import java.sql.SQLException;
import java.util.Scanner;

public class AppContext {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final FootballStandRepository FOOTBALL_STAND_REPOSITORY = new FootballStandRepository();

    private static final FootballMatchRepository FOOTBALL_MATCH_REPOSITORY = new FootballMatchRepository();
    private static final FootballMenuStarter F_MENU = new FootballMenuStarter();

    private static final FootballMatch FOOTBALL_MATCH = new FootballMatch();

    private static final TeamAdding TEAM_ADDING = new TeamAdding();

    private static final TeamDeleting TEAM_DELETING = new TeamDeleting();

    private static final TeamInformation teamInformation = new TeamInformation();

    private static final WeeklyResults WEEKLY_RESULTS = new WeeklyResults();

    private static final Standing STANDING = new Standing();

    private static final MatchAdding MATCH_ADDING = new MatchAdding();

    private static final ExitChecking EXIT_CHECKING = new ExitChecking();

    public static Scanner getScanner() {
        return SCANNER;
    }

    public static FootballStandRepository getFootballStandRepository() {
        return FOOTBALL_STAND_REPOSITORY;
    }

    public static FootballMatchRepository getFootballMatchRepository() {
        return FOOTBALL_MATCH_REPOSITORY;
    }

    public static FootballMenuStarter getFMenu() {
        return F_MENU;
    }

    public static FootballMatch getFootballMatch() {
        return FOOTBALL_MATCH;
    }

    public static TeamAdding getTeamAdding() {
        return TEAM_ADDING;
    }

    public static TeamDeleting getTeamDeleting() {
        return TEAM_DELETING;
    }

    public static TeamInformation getTeamInformation() {
        return teamInformation;
    }

    public static WeeklyResults getWeeklyResults() {
        return WEEKLY_RESULTS;
    }

    public static Standing getStanding() {
        return STANDING;
    }

    public static MatchAdding getMatchAdding(){return MATCH_ADDING;}
    public static ExitChecking getExitChecking() {
        return EXIT_CHECKING;
    }

    public static FootballTeam setFootballTeam(FootballTeam footballTeam) {
        return footballTeam;
    }

    public static String teamExist() throws SQLException {
        String input;
        while (true) {
            System.out.print("Name Of The Team: ");
            input = getScanner().nextLine();
            if (input.matches("0"))
                AppContext.getFMenu().startMenu();

            if (!AppContext.getFootballStandRepository().teamExist(input))
                System.out.println("There Is No Team With This Name.");
            else
                break;
        }
        return input;
    }


    public static void doneReaction() {
        System.out.println("Done.");
        System.out.println("Press Enter To Continue");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }
}
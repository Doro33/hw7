package view;

import servive.AppContext;

import java.sql.SQLException;

public class FootballMenuStarter {
    private void showMenu() {
        System.out.print("""
                ----------------
                Start Menu:
                1) Add A Team
                2) Delete A Team
                3) Show A Team Information
                4) Weekly Results
                5) Standings
                6) Add A Match
                7) Exit
                What Do You Want To Do?""");
    }
    private  void getOption() throws SQLException {
        String input = AppContext.getScanner().nextLine();
        loop1:
        while (!input.isEmpty()) {
            switch (input) {
                case "1":
                    System.out.println("----------------");
                    AppContext.getTeamAdding().addATeam();
                    break;
                case "2":
                    System.out.println("----------------");
                   AppContext.getTeamDeleting().deleteATeam();
                    break loop1;
                case "3":
                    System.out.println("----------------");
                    AppContext.getTeamInformation().showTeamInformation();
                    break loop1;
                case "4":
                    System.out.println("----------------");
                    AppContext.getWeeklyResults().showWeeklyResults();
                case "5":
                    System.out.println("----------------");
                    AppContext.getStanding().showStanding();
                    break loop1;
                case "6":
                    System.out.println("----------------");
                    AppContext.getMatchAdding().resultsOfMatch();
                    break loop1;
                case "7":
                    System.out.println("----------------");
                    AppContext.getExitChecking().exitCheck();
                    break loop1;
                default:
                    System.out.println("Your Input Is Not Valid.");
                    System.out.print("You Can Only Choose 1-7 : ");
                    input = AppContext.getScanner().next();
            }
        }
    }
    public void startMenu() throws SQLException {
        showMenu();
        getOption();
    }
}
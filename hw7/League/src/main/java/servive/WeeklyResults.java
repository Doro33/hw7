package servive;

import entity.FootballMatch;

import java.sql.SQLException;

public class WeeklyResults {
    public int setWeek() throws SQLException {
        String input;
        while (true) {
            System.out.print("Week: ");
            input = AppContext.getScanner().nextLine();
            if (input.matches("0"))
                AppContext.getFMenu().startMenu();
            if (!input.matches("^0?[1-9]|[12][0-9]|3[0-8]$"))
                System.out.println("Week Must Be Between 1-38 ");
            else
                break;
        }
        return Integer.parseInt(input);
    }

    public void showWeeklyResults() throws SQLException {
        System.out.println("Show Weekly Results::" + '\n' +
                "0) Back.");
        int week = setWeek();
        FootballMatch[] weeklyMatches = AppContext.getFootballMatchRepository().weeklyMatches(week);
        AppContext.getFootballMatch().showMatches(weeklyMatches);
        System.out.println("-------");
        AppContext.doneReaction();
        showWeeklyResults();
    }
}
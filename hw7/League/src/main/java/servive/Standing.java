package servive;

import entity.FootballTeam;

import java.sql.SQLException;

public class Standing {
    public void showStanding() throws SQLException {
        System.out.println("Standings:");
        FootballTeam[] stand = AppContext.getFootballStandRepository().showStand();
        if (stand[0] == null)
            System.out.println("This League Does Not Have A Team Yet.");
        for (int i = 0; i < 20; i++) {
            if (stand[i] != null)
                System.out.println(i + 1 + ") " + stand[i]);
        }
        System.out.println("-------");
        System.out.println("Press Enter To Get Back.");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
        AppContext.getFMenu().startMenu();
    }
}
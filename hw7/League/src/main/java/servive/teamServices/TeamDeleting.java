package servive.teamServices;

import servive.AppContext;

import java.sql.SQLException;

public class TeamDeleting {

    public void deleteATeam() throws SQLException {
        System.out.println("Delete A Team:" + '\n' +
                "0) Back.");
        String input = AppContext.teamExist();
        if (AppContext.getFootballMatchRepository().deleteTeamPermission(input)) {
            AppContext.getFootballStandRepository().deleteTeam(input);
            AppContext.doneReaction();
            deleteATeam();
        } else {
            System.out.println("You Cannot Delete A Team In The Middle Of Season.");
            System.out.println("Press Enter To Continue");
            try {
                System.in.read();
            } catch (Exception ignored) {
            }
            deleteATeam();
        }
    }
}
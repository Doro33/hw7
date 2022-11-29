package servive.teamServices;

import servive.AppContext;

import java.sql.SQLException;

public class TeamAdding {

    private String setTeamName() throws SQLException {
        String newTeamName;
        while (true) {
            System.out.print("Name Of The Team: ");
            newTeamName = AppContext.getScanner().nextLine();

            if (newTeamName.matches("0"))
                AppContext.getFMenu().startMenu();
            if (newTeamName.isEmpty())
                System.out.println("Name of The Team Cannot Be Empty");

            else if (32 < newTeamName.length())
                System.out.println("Team's Name Cannot Have More than 32 Characters.");

            else if ((AppContext.getFootballStandRepository().teamExist(newTeamName)))
                System.out.println("This Team Has Already Been Made.");
            else
                return newTeamName;
        }
    }

    public void addATeam() throws SQLException {
        System.out.println("Add A Team:" + '\n' +
                "0) Back.");
        String newTeamName = setTeamName();
        AppContext.getFootballStandRepository().insertTeam(newTeamName);
        AppContext.doneReaction();
        addATeam();
    }
}
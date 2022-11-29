package servive;

import java.sql.SQLException;
import java.util.Scanner;

public class ExitChecking {
    public void exitCheck() throws SQLException {
        System.out.println("Are You Sure You Want To Exit?");
        System.out.print("y as yes / n as no: ");
        String input;
        Scanner scanner=AppContext.getScanner();
        while (true) {
            input = scanner.nextLine().toLowerCase();
            if (input.matches("y")) {
                System.out.println("Good Bye.");
                System.out.println("----------------");
                System.exit(0);
            } else if (input.matches("n")) {
                AppContext.getFMenu().startMenu();
            } else {
                System.out.println("Your Input Is Not Valid.");
                System.out.print("y as yes / n as no : ");
            }
        }
    }
}
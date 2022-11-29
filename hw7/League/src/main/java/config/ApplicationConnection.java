package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ApplicationConnection {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "vaqtinichegerist";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection==null) {
            try {
                connection = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/test",
                                USERNAME,
                                PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}


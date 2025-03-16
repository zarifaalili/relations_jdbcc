package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConfig {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/jdbc_db";
    private static final String DATABASE_USERNAME = "postgres";
    private static final String DATABASE_PASSWORD = "password";
    private static Connection connection = null;

    public static Connection getConnection() {

        if (connection == null) {
            try {
                loadDatabaseDriver();
                Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                System.out.println("Database-e qosuldu");
                return connection;
            } catch (SQLException e) {
                throw new RuntimeException("Failde", e);
            }

        }
        return connection;

    }

    public static void loadDatabaseDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failde", e);
        }


    }
}


import Config.DatabaseConfig;
import repo.Repository;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Connection connection = DatabaseConfig.getConnection();

        Repository repository = new Repository();

        repository.query_1(connection, 2024, 2022);


    }
}

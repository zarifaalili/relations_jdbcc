
import Config.DatabaseConfig;
import repo.Repository;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = DatabaseConfig.getConnection();

        Repository repository = new Repository();

//        repository.query_1(connection,2021,2023);

//        repository.desc_book(connection);
//        repository.all_book(connection);
//repository.insert_book(connection,"Sarka
// ç",2025,3);
repository.insert_author(connection,"Lore","Aysha");
//repository.insert_author(connection,"Maral","Atmaca");
//repository.all_authors(connection);


    }
}

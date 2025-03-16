package Query;

public enum Queries {
    CREATE_TABLE_AUTHOR("CREATE TABLE IF NOT EXISTS author (\n" +
            "    id SERIAL PRIMARY KEY,\n" +
            "    name VARCHAR(50) NOT NULL,\n" +
            "    surname VARCHAR(50) NOT NULL,\n" +
            "    UNIQUE (name, surname)\n" +
            ");"),

    CREATE_TABLE_BOOK("CREATE TABLE IF NOT EXISTS book (\n" +
            "    id BIGSERIAL PRIMARY KEY,\n" +  // Kitab ID-si avtomatik artsın
            "    name VARCHAR(100) NOT NULL,\n" +
            "    year INT NOT NULL,\n" +
            "    author_id INT,\n" +
            "    FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE,\n" +
            "    UNIQUE (name, year, author_id)\n" +  // Eyni müəllifin eyni kitabı 2 dəfə ola bilməz
            ");"),

    INSERT_AUTHOR("INSERT INTO author (name, surname) \n" +
            "VALUES (?, ?) \n" +
            "ON CONFLICT (name, surname) DO NOTHING;"),

    FIND_ALL_AUTHORS("SELECT a.id, a.name as author_name, a.surname, b.name as book_name, b.year \n" +
            "FROM author a \n" +
            " JOIN book b ON a.id = b.author_id;"), // Sol birləşmə ilə müəllifin kitabı yoxdursa da göstər

    UPDATE_AUTHOR("UPDATE author SET name=?, surname=? WHERE id=?;"),

    DELETE_AUTHOR("DELETE FROM author WHERE id=?;"), // `ON DELETE CASCADE` aktivdir, kitablar da silinəcək

    INSERT_BOOK("INSERT INTO book (name, year, author_id) \n" +
            "VALUES (?, ?, ?) \n" +
            "ON CONFLICT (name, year, author_id) DO NOTHING;"), // Eyni müəllifin eyni kitabı təkrar olmasın

    FIND_ALL_BOOKS("SELECT b.id, b.name as book_name, b.year, a.name AS author_name, a.surname  \n" +
            "FROM book b \n" +
            "JOIN author a ON b.author_id = a.id;"),

    UPDATE_BOOK("UPDATE book SET name=?, year=?, author_id=? WHERE id=?;"),

    DELETE_BOOK("DELETE FROM book WHERE id=?;");

    private String query;

    Queries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}

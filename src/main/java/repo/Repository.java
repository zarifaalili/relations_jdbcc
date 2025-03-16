package repo;

import Query.Queries;

import java.sql.*;

public class Repository {

    public void createAuthor(Connection connection) throws SQLException {
        String query = Queries.CREATE_TABLE_AUTHOR.getQuery();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void createBook(Connection connection) throws SQLException {
        String query = Queries.CREATE_TABLE_BOOK.getQuery();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }


    public void insert_author(Connection connection, String name, String surname){
        String query=Queries.INSERT_AUTHOR.getQuery();
        try {
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setString(2,surname);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void all_authors(Connection connection){
        String query=Queries.FIND_ALL_AUTHORS.getQuery();

        try {
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("author_name"));
                System.out.println(resultSet.getString("surname"));
                System.out.println(resultSet.getString("book_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert_book(Connection connection, String name, int year, int author_id){
        String query=Queries.INSERT_BOOK.getQuery();
        try {
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setInt(2,year);
            statement.setInt(3,author_id);
            statement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public  void all_book(Connection connection){

        String query=Queries.FIND_ALL_BOOKS.getQuery();

        try {
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("book_name"));
                System.out.println(resultSet.getString("year"));
                System.out.println(resultSet.getString("author_name"));
                System.out.println(resultSet.getString("surname"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void query_1(Connection connection, int bas_il, int son_il) {
        String query = "SELECT b.id, b.name AS book_name, b.year, a.name AS author_name, a.surname " +
                "FROM book b " +
                "JOIN author a ON b.author_id = a.id " +
                "WHERE b.year BETWEEN ? AND ?";

        try {
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1,bas_il);
            statement.setInt(2,son_il);


            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("book_name"));
                System.out.println(resultSet.getString("year"));
                System.out.println(resultSet.getString("author_name"));
                System.out.println(resultSet.getString("surname"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public  void desc_book(Connection connection){
        String  query=("SELECT b.id, b.name as book_name, b.year, a.name AS author_name, a.surname  \n" +
                "FROM book b \n" +
                "JOIN author a ON b.author_id = a.id order by year asc;");

        try {
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("book_name"));
                System.out.println(resultSet.getString("year"));
                System.out.println(resultSet.getString("author_name"));
                System.out.println(resultSet.getString("surname"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

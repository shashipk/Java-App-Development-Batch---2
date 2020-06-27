package com.example.demojdbc2.demojdbc2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {

    private static Connection connection;

    public static void getConnection() throws SQLException {

        if(connection == null){
            // Protocol: DB_Type : URL : Port : books
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/books", "root", "piyushagg@5807");
        }
    }

    public static void closeConnection(){
        if(connection != null){
            connection = null;
        }
    }

    public static void createTable(String table_name) throws SQLException {

        getConnection();

        Statement statement = connection.createStatement();
        boolean isOpSucc = statement.execute("CREATE TABLE " + table_name + "(id INT primary key, book_name VARCHAR(30), author_name VARCHAR(30), cost INT)");

        if(isOpSucc){
            System.out.println("Table " + table_name + " has been created succesfully");
        }else{
            System.out.println("Table " + table_name + " has not been created");
        }

        closeConnection();
    }

    public static List<Book> getBooks() throws SQLException {

        getConnection();

        List<Book> booksToReturn = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM my_books");

        while(resultSet.next()){

            int id = resultSet.getInt(1);
            String book_name = resultSet.getString(2);
            String author_name = resultSet.getString(3);
            int cost = resultSet.getInt(4);

            Book b = new Book(id, book_name, author_name, cost);
            booksToReturn.add(b);
        }

        return booksToReturn;
    }

    public static Book getBook(String id) throws SQLException {

        getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM my_books where id = " + id);

        while(resultSet.next()){

            int book_id = resultSet.getInt(1);
            String book_name = resultSet.getString(2);
            String author_name = resultSet.getString(3);
            int cost = resultSet.getInt(4);

            Book b = new Book(book_id, book_name, author_name, cost);
            return b;
        }

        System.out.println("There are no books present with this id : " + id);
        return null;

    }


    public static void insert(Book book) throws SQLException {

        getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO my_books VALUES (?, ?, ?, ?)");

        preparedStatement.setInt(1, book.getId());
        preparedStatement.setString(2, book.getName());
        preparedStatement.setString(3, book.getAuthorName());
        preparedStatement.setInt(4, book.getCost());

        int rowN = preparedStatement.executeUpdate();

        if(rowN < 1){
            System.out.println("Insertion of book " + book + " is not successful");
        }else{
            System.out.println("Book " + book + "  has been successfully inserted");
        }

    }
}

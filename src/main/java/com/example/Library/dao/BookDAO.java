package com.example.Library.dao;

import java.io.File;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.Library.models.Book;
import com.example.Library.services.BookServices;


public class BookDAO {
    private static Connection connection;

    static {
        DBWorker worker = new DBWorker();
        connection = worker.getConnection();
    }

    /**
     * Gets list of all books
     *
     * @return List of all books
     * @throws SQLException
     */
    public List<Book> getListOfAllBooks() throws SQLException {
        List<Book> listOfAllBooks = new ArrayList<>();

        String query = "SELECT * FROM books_general";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);

        while (result.next()) {
            Book book = new Book();

            book.setTitle(result.getString("title"));
            book.setPublisher(result.getString("publisher"));
            book.setPageCount(result.getInt("page_count"));
            book.setISBN(result.getString("isbn"));
            book.setDescription(result.getString("desc_rip"));
            book.setPublishingDate(result.getString("publ_date"));

            getAuthorsSet(book);
            getGenresSet(book);
            getAmountOfBooks(book);
            getBorrows(book);

            book.setStatus(BookServices.statusValue(book));

            listOfAllBooks.add(book);
        }

        return listOfAllBooks;
    }


    /**
     * Retrieves books parameters from DB depending on isbn
     *
     * @param isbn
     * @return Book with fields from DB
     */

    public Book getBook(String isbn) {
        Book book = new Book();
        String query = "SELECT * FROM books_general WHERE isbn = ?";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, isbn);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                book.setTitle(result.getString("title"));
                book.setPublisher(result.getString("publisher"));
                book.setPageCount(result.getInt("page_count"));
                book.setISBN(result.getString("isbn"));
                book.setDescription(result.getString("desc_rip"));
                book.setPublishingDate(result.getString("publ_date"));
                book.setStatus(result.getString("stat"));
            }

            getAuthorsSet(book);
            getGenresSet(book);
            getAmountOfBooks(book);
            getBorrows(book);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }



    /**
     * Gets set of authors, because they have multiple values unlike other columns
     *
     * @param book
     * @throws SQLException
     */

    public void getAuthorsSet(Book book) throws SQLException {
        String query = "SELECT * FROM books_authors WHERE isbn = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, book.getISBN());

        ResultSet result = preparedStatement.executeQuery();

        Set<String> authors = new HashSet<>();
        while (result.next()) {
            authors.add(result.getString("author"));
        }
        book.setAuthors(authors);

    }

    /**
     * Gets set of genres, because they have multiple values unlike other columns
     *
     * @param book
     * @throws SQLException
     */

    public void getGenresSet(Book book) throws SQLException {
        String query = "SELECT * FROM books_genres WHERE isbn = ?";


        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, book.getISBN());

        ResultSet result = preparedStatement.executeQuery();

        Set<String> genres = new HashSet<>();
        while (result.next()) {
            genres.add(result.getString("genre"));
        }
        book.setGenres(genres);
    }

    /**
     * Gets the physically available in the world owned by this library amount of books and sets it in Book obj
     *
     * @param book
     * @return amount of books
     * @throws SQLException
     */
    public void getAmountOfBooks(Book book) throws SQLException {
        String query = "SELECT books_amount FROM books_amount WHERE isbn = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, book.getISBN());

        ResultSet result = preparedStatement.executeQuery();

        result.next();

        book.setAmount(result.getInt(1));
    }

    /**
     * Gets the physically available in the world owned by this library amount of books and sets it in Book obj
     *
     * @param book
     * @return amount of books
     * @throws SQLException
     */
    public void getBorrows(Book book) throws SQLException {
        String query = "SELECT books_borrows FROM books_borrows WHERE isbn = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, book.getISBN());

        ResultSet result = preparedStatement.executeQuery();

        result.next();

        book.setBorrows(result.getInt(1));
    }


    /**
     * Adds book`s parameters to DB, creates new entry
     *  @param title
     * @param publisher
     * @param page_count
     * @param isbn
     * @param desc
     * @param publ_date
     * @param authors
     * @param genres
     */
    public void addBook(String title, String publisher, int page_count, String isbn, String desc, String publ_date,
                        Set<String> authors, Set<String> genres, int amount, int borrows) {

        String query = "INSERT INTO books_general (title, publisher, page_count, isbn, desc_rip, publ_date, stat)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, publisher);
            preparedStatement.setInt(3, page_count);
            preparedStatement.setString(4, isbn);
            preparedStatement.setString(5, desc);
            preparedStatement.setString(6, publ_date);
            preparedStatement.setString(7, BookServices.statusValue(amount, borrows));

            preparedStatement.execute();


            addAuthorsSet(isbn, authors);
            addGenresSet(isbn, genres);

            addAmount(isbn, amount);
            addBorrows(isbn, borrows);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Sets lists of authors, because they have multiple values unlike other columns
     *
     * @param isbn
     * @param authors
     * @throws SQLException
     */
    public void addAuthorsSet(String isbn, Set<String> authors) throws SQLException {
        String query = "INSERT INTO books_authors (author, isbn) VALUES (?, ?)";


        PreparedStatement preparedStatement = connection.prepareStatement(query);

        for (String author : authors) {
            preparedStatement.setString(1, author);
            preparedStatement.setString(2, isbn);
            preparedStatement.execute();
        }
    }

    /**
     * Sets lists of genres, because they have multiple values unlike other columns
     *
     * @param isbn
     * @param genres
     * @throws SQLException
     */
    public void addGenresSet(String isbn, Set<String> genres) throws SQLException {
        String query = "INSERT INTO books_genres (genre, isbn) VALUES (?, ?)";


        PreparedStatement preparedStatement = connection.prepareStatement(query);

        for (String genre : genres) {
            preparedStatement.setString(1, genre);
            preparedStatement.setString(2, isbn);
            preparedStatement.execute();
        }

    }

    /**
     * Adds amount of books to books_amount table
     *
     * @param isbn
     * @param amount
     * @throws SQLException
     */
    public void addAmount(String isbn, int amount) throws SQLException {
        String query = "INSERT INTO books_amount (books_amount, isbn) VALUES (?, ?)";


        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, amount);
        preparedStatement.setString(2, isbn);
        preparedStatement.execute();
    }

    /**
     * Adds borrows of book to books_borrow table
     *
     * @param isbn
     * @param borrows
     * @throws SQLException
     */
    public void addBorrows(String isbn, int borrows) throws SQLException {
        String query = "INSERT INTO books_borrows (books_borrows, isbn) VALUES (?, ?)";


        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, borrows);
        preparedStatement.setString(2, isbn);
        preparedStatement.execute();
    }

    /**
     * Removes book by isbn from DB
     *
     * @param isbn
     */

    public void removeBook(String isbn) {
        String query_1 = "DELETE FROM books_authors WHERE isbn = ?";
        String query_2 = "DELETE FROM books_genres WHERE isbn = ?";
        String query_3 = "DELETE FROM books_general WHERE isbn = ?";
        String query_4 = "DELETE FROM books_amount WHERE isbn = ?";
        String query_5 = "DELETE FROM books_borrows WHERE isbn = ?";

        PreparedStatement preparedStatement_1;
        PreparedStatement preparedStatement_2;
        PreparedStatement preparedStatement_3;
        PreparedStatement preparedStatement_4;
        PreparedStatement preparedStatement_5;
        try {
            preparedStatement_1 = connection.prepareStatement(query_1);
            preparedStatement_1.setString(1, isbn);

            preparedStatement_2 = connection.prepareStatement(query_2);
            preparedStatement_2.setString(1, isbn);

            preparedStatement_3 = connection.prepareStatement(query_3);
            preparedStatement_3.setString(1, isbn);

            preparedStatement_4 = connection.prepareStatement(query_4);
            preparedStatement_4.setString(1, isbn);

            preparedStatement_5 = connection.prepareStatement(query_5);
            preparedStatement_5.setString(1, isbn);

            preparedStatement_1.executeUpdate();
            preparedStatement_2.executeUpdate();
            preparedStatement_3.executeUpdate();
            preparedStatement_4.executeUpdate();
            preparedStatement_5.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCover(String isbn, String coverPath) throws SQLException {
        String query = "INSERT INTO books_covers (isbn, books_cover_path) VALUES (?, ?)";


        PreparedStatement preparedStatement = connection.prepareStatement(query);


        preparedStatement.setString(1, isbn);
        preparedStatement.setString(2, coverPath);

        preparedStatement.execute();
    }

}
/**
 * //     * Gets current book`s id by book`s isbn
 * //     * @param isbn book`s isbn
 * //     * @return id
 * //
 */
//
//    public int getBookIdFromDB (String isbn) {
//        int book_id = 0;
//        String query = "SELECT book_id FROM books_general WHERE isbn = ?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, isbn);
//            ResultSet result = preparedStatement.executeQuery();
//
//            result.next();
//            book_id = result.getInt(1);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return book_id;
//    }
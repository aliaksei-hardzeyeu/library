package com.example.Library.services;

import com.example.Library.models.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IBookDAOService {
    Book getBook(String isbn);

    List<Book> getListOfAllBooks() throws SQLException;

    Set<String> getAuthorsSetFromDB(Book book) throws SQLException;

    Set<String> getGenresSetFromDB(Book book) throws SQLException;

    int getAmountOfBooksFromDB(Book book) throws SQLException;

    int getBorrowsFromDB(Book book) throws SQLException;

    String getCoverExtensionFromDB(Book book) throws SQLException;

    String getCoverExtensionFromDB(String isbn) throws SQLException;

    void addBook(String title, String publisher, int page_count, String isbn, String desc, String publ_date,
                 Set<String> authors, Set<String> genres, int amount, int borrows, String coverExtension);

    void addBookWithSameCover(String title, String publisher, int page_count, String isbn, String desc, String publ_date,
                              Set<String> authors, Set<String> genres, int amount, int borrows);

    void addAuthorsSet(String isbn, Set<String> authors) throws SQLException;

    void addGenresSet(String isbn, Set<String> genres) throws SQLException;

    void addAmount(String isbn, int amount) throws SQLException;

    void addBorrows(String isbn, int borrows) throws SQLException;

    void removeBook(String isbn);




}

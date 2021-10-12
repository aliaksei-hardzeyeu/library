package com.example.Library;

import com.example.Library.dao.BookDAO;
import com.example.Library.models.Book;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws SQLException {
        BookDAO bookDAO = new BookDAO();
//        Book testBook = bookDAO.getBook("12");
//        System.out.println(testBook.toString());

//

//        Set<String> authors = new HashSet<>();
//        authors.add("Bagdanovich");
//        authors.add("Kolas");
//        authors.add("Kupala");
//
//        Set<String> genres = new HashSet<>();
//        genres.add("historical");
//        genres.add("poem");
//        genres.add("poetry");
////
//        bookDAO.addBook("vershy", "Beldumka", 300, "12", "impressiveqqqq q  q", "1964-11-23", authors,
//                genres, 50, 45);
//
//        bookDAO.addBook("2 musketeers", "AST", 600, "2", "impressive", "2021-11-23", 99,
//                "available", authors, genres );
//
//        bookDAO.addBook("1 musketeers", "AST", 600, "3", "impressive", "2021-11-23", 99,
//                "available", authors, genres );

        System.out.println(bookDAO.getListOfAllBooks().toString());
    }
}

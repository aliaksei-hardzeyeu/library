package com.example.Library;


import com.example.Library.services.BookService;
import com.example.Library.services.implementations.BookServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        BookService bookService = BookServiceImpl.bookService();

    }
}

package com.example.Library.services;

import com.example.Library.services.implementations.BookServiceImpl;
import com.example.Library.services.implementations.BookDAOServiceImpl;

public final class ServiceFactory {

    public static BookService getBookService() {
        BookService bookService = new BookServiceImpl();
        return bookService;
    }

    public static BookDAOService getBookDAOService() {
        BookDAOService bookDAOService = new BookDAOServiceImpl();
        return bookDAOService;
    }
}

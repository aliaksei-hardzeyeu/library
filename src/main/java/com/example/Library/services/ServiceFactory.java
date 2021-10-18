package com.example.Library.services;

import com.example.Library.services.implementations.BookServiceImpl;
import com.example.Library.services.implementations.BookDAOServiceImpl;

public final class ServiceFactory {

    public static IBookService getBookService() {
        IBookService bookService = new BookServiceImpl();
        return bookService;
    }

    public static IBookDAOService getBookDAOService() {
        IBookDAOService bookDAOService = new BookDAOServiceImpl();
        return bookDAOService;
    }
}

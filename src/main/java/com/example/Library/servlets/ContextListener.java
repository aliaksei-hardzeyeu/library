package com.example.Library.servlets;

import com.example.Library.dao.BookDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    private BookDAO bookDAO;
//    private String editableISBN;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        final ServletContext servletContext = event.getServletContext();

        bookDAO = new BookDAO();
//        editableISBN = null;
        servletContext.setAttribute("bookDAO", bookDAO);
//        servletContext.setAttribute("editableISBN", editableISBN);
    }

}

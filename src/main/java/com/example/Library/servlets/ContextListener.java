package com.example.Library.servlets;

import com.example.Library.dao.BookDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.Part;

@WebListener
public class ContextListener implements ServletContextListener {
    private Part filePart;
    private BookDAO bookDAO;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        final ServletContext servletContext = event.getServletContext();

        bookDAO = new BookDAO();
        servletContext.setAttribute("bookDAO", bookDAO);
        filePart = null;

    }

}

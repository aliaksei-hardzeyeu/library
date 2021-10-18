//package com.example.Library.servlets;
//
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//@WebListener
//public class ContextListener implements ServletContextListener {
//    private BookDAO bookDAO;
//
//    @Override
//    public void contextInitialized(ServletContextEvent event) {
//        final ServletContext servletContext = event.getServletContext();
//
//        bookDAO = new BookDAO();
//        servletContext.setAttribute("bookDAO", bookDAO);
//
//    }
//
//}

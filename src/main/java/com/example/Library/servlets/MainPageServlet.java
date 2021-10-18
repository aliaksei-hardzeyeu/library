package com.example.Library.servlets;

import com.example.Library.models.Book;
import com.example.Library.services.IBookDAOService;
import com.example.Library.services.IBookService;
import com.example.Library.services.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MainPageServlet", value = "/")
public class MainPageServlet extends HttpServlet {
    private IBookDAOService bookDAOService;
    private IBookService bookService;

    @Override
    public void init() {
        bookService = ServiceFactory.getBookService();
        bookDAOService = ServiceFactory.getBookDAOService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> listOfBooks;

        try {
            listOfBooks = bookDAOService.getListOfAllBooks();
            request.setAttribute("listOfBooks", listOfBooks);
            request.getRequestDispatcher("WEB-INF/views/mainPage.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.example.Library.servlets;

import com.example.Library.models.Book;
import com.example.Library.services.BookDAOService;
import com.example.Library.services.BookService;
import com.example.Library.services.ServiceFactory;
import com.example.Library.services.implementations.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditBookServlet", value = "/edit_book")
public class EditBookServlet extends HttpServlet {
    private BookDAOService bookDAOService;
    private BookService bookService;

    @Override
    public void init() {

        bookService = BookServiceImpl.bookService();
        bookDAOService = ServiceFactory.getBookDAOService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ISBN = request.getParameter("isbn");
        Book book = bookDAOService.getBook(ISBN);

        request.setAttribute("book", book);
        getServletContext().setAttribute("book", book);
        request.getRequestDispatcher("/WEB-INF/views/bookPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

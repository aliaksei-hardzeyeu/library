package com.example.Library.servlets;

import com.example.Library.models.Book;
import com.example.Library.services.IBookDAOService;
import com.example.Library.services.IBookService;
import com.example.Library.services.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditBookServlet", value = "/edit_book")
public class EditBookServlet extends HttpServlet {
    private IBookDAOService bookDAOService;
    private IBookService bookService;

    @Override
    public void init() {
        bookService = ServiceFactory.getBookService();
        bookDAOService = ServiceFactory.getBookDAOService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ISBN = request.getParameter("isbn");
        Book book = bookDAOService.getBook(ISBN);

        request.setAttribute("book", book);
        getServletContext().setAttribute("book", book);
        request.getRequestDispatcher("/WEB-INF/views/editBook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

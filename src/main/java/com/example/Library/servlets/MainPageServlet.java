package com.example.Library.servlets;

import com.example.Library.dao.BookDAO;
import com.example.Library.models.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MainPageServlet", value = "/")
public class MainPageServlet extends HttpServlet {
    private BookDAO bookDAO;

    @Override
    public void init() {
        final Object bookDAO = getServletContext().getAttribute("bookDAO");

        if (!(bookDAO instanceof BookDAO)) {
            throw new IllegalStateException("Problem with initialization of BookDAO from ServletContext");
        } else {
            this.bookDAO = (BookDAO) bookDAO;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> listOfBooks;

        try {
            listOfBooks = bookDAO.getListOfAllBooks();
            request.setAttribute("listOfBooks", listOfBooks);
            request.getRequestDispatcher("WEB-INF/views/mp4.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

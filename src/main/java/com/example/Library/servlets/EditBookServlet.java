package com.example.Library.servlets;

import com.example.Library.dao.BookDAO;
import com.example.Library.models.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditBookServlet", value = "/edit_book")
public class EditBookServlet extends HttpServlet {
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
        String ISBN = request.getParameter("isbn");
        Book book = bookDAO.getBook(ISBN);

        request.setAttribute("book", book);
        getServletContext().setAttribute("book", book);
        request.getRequestDispatcher("/WEB-INF/views/editBook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

package com.example.Library.servlets;

import com.example.Library.dao.BookDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "RemoveBookServlet", value = "/remove_book")
public class RemoveBookServlet extends HttpServlet {
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
        bookDAO.removeBook(ISBN);


        File cover = new File("E:\\books_covers_server\\" + ISBN + ".png");

        if (cover.delete()) {
            System.out.println(cover.getName() + "deleted");
        } else {
            System.out.println(cover.getName() + "delete failed");
        }


        request.getRequestDispatcher("/").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

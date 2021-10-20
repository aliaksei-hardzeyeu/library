package com.example.Library.servlets;

import com.example.Library.services.BookDAOService;
import com.example.Library.services.BookService;
import com.example.Library.services.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RemoveBookServlet", value = "/remove_book")
public class RemoveBookServlet extends HttpServlet {
    private BookDAOService bookDAOService;
    private BookService bookService;

    @Override
    public void init() {
        bookService = ServiceFactory.getBookService();
        bookDAOService = ServiceFactory.getBookDAOService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ISBN = request.getParameter("isbn");

        File cover;
        try {
            cover = new File("E:\\books_covers_server\\" + ISBN + bookDAOService.getCoverExtensionFromDB(ISBN));


            if (cover.delete()) {
                System.out.println(cover.getName() + " deleted");
            } else {
                System.out.println(cover.getName() + " delete failed");
            }

            bookDAOService.removeBook(ISBN);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.getRequestDispatcher("/").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

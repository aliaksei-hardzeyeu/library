package com.example.Library.servlets;

import com.example.Library.models.Book;
import com.example.Library.services.IBookDAOService;
import com.example.Library.services.IBookService;
import com.example.Library.services.ServiceFactory;
import com.example.Library.services.implementations.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "AddBookServlet", value = "/add_book")
@MultipartConfig
public class AddBookServlet extends HttpServlet {
    private IBookDAOService bookDAOService;
    private IBookService bookService;

    @Override
    public void init() {
        bookService = ServiceFactory.getBookService();
        bookDAOService = ServiceFactory.getBookDAOService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/addBook.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        Set<String> authors = bookService.stringAuthorsToSet(request.getParameter("authors"));
        String publisher = request.getParameter("publisher");
        String publish_date = request.getParameter("publish_date");
        Set<String> genres = bookService.stringGenresToSet(request.getParameter("genres"));
        int page_count = Integer.parseInt(request.getParameter("page_count"));
        String isbn = request.getParameter("isbn");
        String description = request.getParameter("description");
        int tot_amount = Integer.parseInt(request.getParameter("tot_amount"));
        int borrows = Integer.parseInt(request.getParameter("borrows"));


        Book book = (Book) getServletContext().getAttribute("book");
        String coverExtension = book.getCoverExtension();

        bookDAOService.addBook(title, publisher, page_count, isbn, description, publish_date, authors, genres, tot_amount, borrows, coverExtension);


        response.sendRedirect("/");
    }
}

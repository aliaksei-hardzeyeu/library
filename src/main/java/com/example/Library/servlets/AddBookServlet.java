package com.example.Library.servlets;

import com.example.Library.dao.BookDAO;
import com.example.Library.models.Book;
import com.example.Library.services.BookServices;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

@WebServlet(name = "AddBookServlet", value = "/add_book")
@MultipartConfig
public class AddBookServlet extends HttpServlet {
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
        request.getRequestDispatcher("WEB-INF/views/addBook.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        Set<String> authors = BookServices.stringAuthorsToSet(request.getParameter("authors"));
        String publisher = request.getParameter("publisher");
        String publish_date = request.getParameter("publish_date");
        Set<String> genres = BookServices.stringGenresToSet(request.getParameter("genres"));
        int page_count = Integer.parseInt(request.getParameter("page_count"));
        String isbn = request.getParameter("isbn");
        String description = request.getParameter("description");
        int tot_amount = Integer.parseInt(request.getParameter("tot_amount"));
        int borrows = Integer.parseInt(request.getParameter("borrows"));


        Book book = (Book) getServletContext().getAttribute("book");
        String coverExtension = book.getCoverExtension();

        bookDAO.addBook(title, publisher, page_count, isbn, description, publish_date, authors, genres, tot_amount, borrows, coverExtension);


        response.sendRedirect("/");
    }
}

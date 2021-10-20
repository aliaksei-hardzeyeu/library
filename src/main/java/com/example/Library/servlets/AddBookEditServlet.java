//package com.example.Library.servlets;
//
//import com.example.Library.models.Book;
//import com.example.Library.services.BookDAOService;
//import com.example.Library.services.BookService;
//import com.example.Library.services.ServiceFactory;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Set;
//
//@WebServlet(name = "AddBookServlet", value = "/add_book_edit")
//@MultipartConfig
//public class AddBookEditServlet extends HttpServlet {
//    private BookDAOService bookDAOService;
//    private BookService bookService;
//
//    @Override
//    public void init() {
//        bookService = ServiceFactory.getBookService();
//        bookDAOService = ServiceFactory.getBookDAOService();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("WEB-INF/views/addBook.jsp").forward(request, response);
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String title = request.getParameter("title");
//        Set<String> authors = bookService.stringAuthorsToSet(request.getParameter("authors"));
//        String publisher = request.getParameter("publisher");
//        String publish_date = request.getParameter("publish_date");
//        Set<String> genres = bookService.stringGenresToSet(request.getParameter("genres"));
//        int page_count = Integer.parseInt(request.getParameter("page_count"));
//        String isbn = request.getParameter("isbn");
//        String description = request.getParameter("description");
//        int tot_amount = Integer.parseInt(request.getParameter("tot_amount"));
//        int borrows = Integer.parseInt(request.getParameter("borrows"));
//
//        getServletContext().is
//        Book book = (Book) getServletContext().getAttribute("book");
//        String coverExtension = book.getCoverExtension();
//
//        bookDAOService.addBook(title, publisher, page_count, isbn, description, publish_date, authors, genres, tot_amount, borrows, coverExtension);
//
//
//        response.sendRedirect("/");
//    }
//}

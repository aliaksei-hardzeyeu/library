package com.example.Library.servlets;

import com.example.Library.services.IBookDAOService;
import com.example.Library.services.IBookService;
import com.example.Library.services.ServiceFactory;
import com.example.Library.services.implementations.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@WebServlet(name = "UploadFileServlet", value = "/upload_file")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    final String path = "E:\\books_covers_server\\";
    private IBookService bookService;

    @Override
    public void init() {
        bookService = ServiceFactory.getBookService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Part filePart = request.getPart("file");

        if (filePart.getSize() != 0) {

            final String isbn = request.getParameter("isbn");
            final String fileExtension = bookService.getFileExtension(filePart);

            File file = new File(path, isbn + fileExtension);
            InputStream inputStream = filePart.getInputStream();
            Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

            request.setAttribute("cover_extension", fileExtension);
        }
        request.getRequestDispatcher("/add_book").forward(request, response);

    }
}
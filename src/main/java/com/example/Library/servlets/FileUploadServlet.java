package com.example.Library.servlets;

import com.example.Library.services.BookServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "UploadFileServlet", value = "/upload_file")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    final String path = "E:\\books_covers_server\\";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Part filePart = request.getPart("file");
        System.out.println(filePart.getName());
        int x = 1;

        if (filePart == null) {
            request.setAttribute("cover_extension", x);
            request.getRequestDispatcher("/add_book").forward(request, response);

        } else {

            final String isbn = request.getParameter("isbn");
            final String fileExtension = BookServices.getFileExtension(filePart);

            File file = new File(path, isbn + fileExtension);
            InputStream inputStream = filePart.getInputStream();
            Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

            request.setAttribute("cover_extension", fileExtension);
        }

        request.getRequestDispatcher("/add_book").forward(request, response);
    }
}
package com.example.Library.servlets;

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
    final String path = "E:\\books_cover_server\\";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Create path components to save the file
//        final Part filePart = (Part) getServletContext().getAttribute("filePart");
//        final String isbn = (String) getServletContext().getAttribute("isbn");
        final Part filePart = request.getPart("file");
        final String isbn = request.getParameter("isbn");

        System.out.println(filePart.getSize());


        final String fileExtension = getFileExtension(filePart);


        File uploads = new File(path);
        File file = new File(uploads, isbn + fileExtension);
        InputStream inputStream = filePart.getInputStream();
        Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

    }

    private String getFileExtension(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('.') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
package com.example.Library;

import com.example.Library.dao.BookDAO;

import javax.servlet.http.Part;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        BookDAO bookDAO = new BookDAO();
        System.out.println(bookDAO.getListOfAllBooks().toString());

        String header = "Content-Disposition: form-data; name=\"file\"; filename=\"sample.txt\"";

        System.out.println(getFileExtension(header));

    }

    public static String getFileExtension(String header) {
        for (String content : header.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('.') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }


}

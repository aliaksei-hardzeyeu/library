package com.example.Library.services.implementations;

import com.example.Library.models.Book;
import com.example.Library.services.IBookService;

import javax.servlet.http.Part;
import java.util.HashSet;
import java.util.Set;

public class BookServiceImpl implements IBookService {
    /**
     * 1. Method for counting if status is available -> amount of books > borrows. So we
     * need in DAO method for getting amount/borrows
     */
    public String statusValue(Book book) {
        int amount = book.getAmount();
        int borrows = book.getBorrows();

        return amount - borrows > 0 ? "available" : "unavailable";
    }

    public String statusValue(int amount, int borrows) {
        return amount - borrows > 0 ? "available" : "unavailable";
    }

    /**
     * First iteration of method: now main goal -> turn String into Set, without dividing into different authors
     * @param authors
     * @return
     */
    public Set<String> stringAuthorsToSet(String authors) {
        Set<String> authorsFinal = new HashSet<>();
        authorsFinal.add(authors);

        return authorsFinal;
    }

    /**
     * First iteration of method: now main goal -> turn String into Set, without dividing into different genres
     * @param genres
     * @return
     */
    public Set<String> stringGenresToSet(String genres) {
        Set<String> genresFinal = new HashSet<>();
        genresFinal.add(genres);

        return genresFinal;
    }

    /**
     * Gets submitted as part file extension from part header
     * @param part
     * @return String extension -> .jpg
     */
    public String getFileExtension(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('.')).trim().replace("\"", "");
            }
        }
        return null;
    }
}

package com.example.Library.services;

import com.example.Library.models.Book;

import javax.servlet.http.Part;
import java.util.Set;

public interface BookService {
    String statusValue(Book book);

    String statusValue(int amount, int borrows);

    Set<String> stringAuthorsToSet(String authors);

    Set<String> stringGenresToSet(String genres);

    String getFileExtension(final Part part);

}

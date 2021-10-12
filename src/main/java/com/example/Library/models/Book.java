package com.example.Library.models;

import java.io.File;
import java.util.Set;

public class Book {
    private String title;
    private Set<String> authors;
    private String publisher;
    private Set<String> genres;
    private int pageCount;
    private String ISBN;
    private String description;
    private String publishingDate;//check jdbc -> mysql
    private String status;
    private int amount;
    private int borrows;
    private String coverPath;

    public Book() {
    }


    /**
     * Constructor isn`t complete!!!!!
     * @param title
     * @param authors
     * @param publisher
     * @param genre
     * @param pageCount
     * @param ISBN
     * @param description
     * @param publishingDate
     * @param status
     */
    //constructor without id!
    public Book(String title, Set<String> authors, String publisher, Set<String> genre,
                int pageCount, String ISBN, String description, String publishingDate, String status) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.genres = genre;
        this.pageCount = pageCount;
        this.ISBN = ISBN;
        this.description = description;
        this.publishingDate = publishingDate;
        this.status = status;
    }


    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBorrows() {
        return borrows;
    }

    public void setBorrows(int borrows) {
        this.borrows = borrows;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  " title = " + title +"| authors=" + authors + "| publisher= " + publisher + "| genre= " + genres + "| pageCount= " + pageCount +
                "| ISBN= " + ISBN + "| description=" + description + "| publishingDate= " + publishingDate + "| status= " + status +
                "| amount= " + amount + "| borrows= " + borrows;
    }
}

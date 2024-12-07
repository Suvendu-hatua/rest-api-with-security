package com.spring_boot.rest_api.Rest_Api_Demo.pojo;

public class Movie {
    private long id;
    private String title;
    private String Isbn;
    private String publication_year;


    public Movie(long id, String title, String isbn, String publication_year) {
        this.id = id;
        this.title = title;
        Isbn = isbn;
        this.publication_year = publication_year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Isbn='" + Isbn + '\'' +
                ", publication_year='" + publication_year + '\'' +
                '}';
    }
}

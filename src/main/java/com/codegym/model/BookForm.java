package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class BookForm {
    private Long id;
    private String name;
    private int releaseYear;
    private MultipartFile image;
    private int publishingYear;

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public BookForm(String name, int releaseYear, MultipartFile image, int publishingYear) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.image = image;
        this.publishingYear = publishingYear;
    }

    public BookForm() {
    }

    public BookForm(Long id, String name, int releaseYear, MultipartFile image,int publishingYear) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.image = image;
        this.publishingYear = publishingYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}

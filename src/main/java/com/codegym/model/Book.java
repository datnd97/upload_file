package com.codegym.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int releaseYear;
    private String image;
    private int publishingYear;

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Book() {
    }

    public Book(Long id,String name, int releaseYear,String image,int publishingYear) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.image = image;
        this.publishingYear = publishingYear;
    }

    public Book(String name, int releaseYear, String image,int publishingYear) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.image = image;
        this.publishingYear = publishingYear;
    }
//
//    @Override
//    public String toString() {
//        return String.format("Book[id=%d, name='%s', releaseYear='%d']", id, name, releaseYear);
//    }
}

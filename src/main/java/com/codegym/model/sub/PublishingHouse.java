package com.codegym.model.sub;

import com.codegym.model.Book;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "publishinghouse")
public class PublishingHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    @OneToMany(targetEntity = Book.class)
    private List<Book> books;


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

    public PublishingHouse(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}

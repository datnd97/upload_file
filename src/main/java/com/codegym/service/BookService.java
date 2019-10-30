package com.codegym.service;

import com.codegym.model.Book;

import javax.transaction.Transactional;
import java.util.List;

public interface BookService {
    Iterable<Book> findAll();
    Book findOne(Long id);
    void save(Book book);
    void delete(Long id);
}

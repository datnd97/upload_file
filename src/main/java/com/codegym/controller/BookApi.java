package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.annotation.Repeatable;
import java.util.List;

@RestController
public class BookApi {
    @Autowired
    private BookService bookService;
//List-Book
    @GetMapping("/api/book")
    public ResponseEntity<List<Book>> getAll(){
        List<Book> books = (List<Book>) bookService.findAll();
        if(books.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(books,HttpStatus.OK);
    }
// Lay 1 khach hang
    @RequestMapping(value = "/api/book/{id}",method =  RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable("id") long id) {
        System.out.println("Fetching Book with id "+id);
        Book book = bookService.findOne(id);
        if(book == null) {
            System.out.println("Book with id "+ id +" not found ");
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book,HttpStatus.OK);
    }
    // Tao 1 khach hang moi:
    @RequestMapping(value = "/api/book",method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody Book book) {
        System.out.println("Creating User" + book.getName());
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    // sua thong tin khach hang:
//    @RequestMapping(value = "/api/book/")
}

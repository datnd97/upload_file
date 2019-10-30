package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.BookForm;
import com.codegym.service.BookService;
import com.codegym.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class BookController {
    @Autowired
    Environment env;
    @Autowired
    private BookService bookService;
    @GetMapping("/create-book")
    public ModelAndView showCreatForm() {
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("bookForm",new BookForm());
        return modelAndView;
    }
    @PostMapping("/create-book")
    public ModelAndView saveBook(@ModelAttribute BookForm bookForm) {
        MultipartFile multipartFile = bookForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(bookForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Book book = new Book(bookForm.getName(),bookForm.getReleaseYear(),fileName,bookForm.getPublishingYear());
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("bookForm", new BookForm() );
        modelAndView.addObject("message", "New Book created successfully");
        return modelAndView;
    }

    @GetMapping("/list-book")
    public ModelAndView listBook() {
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("/book/list-book");
        modelAndView.addObject("books",books);
        return modelAndView;
    }
    @GetMapping("/edit-book/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id){
        Book book = bookService.findOne(id);
        if(book!=null) {
            ModelAndView modelAndView = new ModelAndView("/book/edit");
//            Long id, String name, int releaseYear, MultipartFile image
            BookForm bookForm = new BookForm(book.getName(),book.getReleaseYear(),null,book.getPublishingYear());
            modelAndView.addObject("book",book);
            modelAndView.addObject("bookForm",bookForm);
            return modelAndView;
        }
        else {
            return new ModelAndView("/error");
        }
    }
    @PostMapping("/edit-book")
    public ModelAndView updateBook(@ModelAttribute BookForm bookForm) {
        MultipartFile multipartFile = bookForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(bookForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Book book = new Book(bookForm.getId(),bookForm.getName(),bookForm.getReleaseYear(),fileName,bookForm.getPublishingYear());
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/edit");
        modelAndView.addObject("bookForm", bookForm);
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", "Create successfully!");
        return modelAndView;
    }
    @GetMapping("/delete-book/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Book book = bookService.findOne(id);
        if(book != null) {
            ModelAndView modelAndView = new ModelAndView("/book/delete");
            modelAndView.addObject("book", book);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/delete-book")
    public String deleteCustomer(@ModelAttribute("book") Book book){
        bookService.delete(book.getId());
        return "redirect:list-book";
    }
}

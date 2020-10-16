package com.spring.mongo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.api.model.Book;
import com.spring.mongo.api.respository.BookRepository;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    private String saveBook(@RequestBody Book book) {
        bookRepository.save(book);
        return "Added Book with ID: " + book.getId();
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    @GetMapping("/findAllBooks/{id}")
    public java.util.Optional<Book> getBook(@PathVariable int id) {
        return bookRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookRepository.deleteById(id);
        return "Book deleted with id : " + id;
    }
}

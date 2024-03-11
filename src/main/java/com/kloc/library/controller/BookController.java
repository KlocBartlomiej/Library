package com.kloc.library.controller;

import com.kloc.library.model.Book;
import com.kloc.library.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/all")
    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}

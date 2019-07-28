package com.kloc.demo2.Controllers;

import com.kloc.demo2.Entities.Book;
import com.kloc.demo2.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("book")
@RestController
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "getAll")
    public List<Book> getAll() {
        List<Book> books;
        books = bookRepository.findAll();
        return books;
    }

    @PostMapping(value = "addBook")
    public void addBook(String title, String author, BigDecimal price, int quantity) {
        Book b = new Book();
        b.setTitle(title);
        b.setAuthor(author);
        b.setPrice(price);
        b.setQuantity(quantity);
        bookRepository.save(b);
    }

    @RequestMapping(value = "findByTitle", method = RequestMethod.GET)
    public Book findByTitle(String title) {
        return bookRepository.findByTitleIgnoreCase(title);
    }

    @RequestMapping(value = "findByAuthor", method = RequestMethod.GET)
    public List<Book> finByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        books = bookRepository.findByAuthorIgnoreCase(author);
        return books;
    }

    @RequestMapping(value = "deleteBook", method = RequestMethod.DELETE)
    public void deleteBook(String title) {
        bookRepository.delete(bookRepository.findByTitleIgnoreCase(title));
    }
}

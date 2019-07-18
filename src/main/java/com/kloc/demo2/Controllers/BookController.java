package com.kloc.demo2.Controllers;

import com.kloc.demo2.Entities.Book;
import com.kloc.demo2.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("book")
@RestController
public class BookController {

    @Autowired
    private BookRepository br;

    @RequestMapping(value="getAll", method=RequestMethod.GET)
    public List<Book> getAll(){
        List<Book> books = new ArrayList<>();
        books = br.findAll();
        return books;
    }

    @RequestMapping(value="addBook", method=RequestMethod.POST)
    public void addBook(String title, String author, float price, int quantity){
        Book b = new Book();
        b.setTitle(title);
        b.setAuthor(author);
        b.setPrice(price);
        b.setQuantity(quantity);
        br.save(b);
    }

    @RequestMapping(value="findByTitle", method=RequestMethod.GET)
    public Book findByTitle(String title){
        return br.findByTitleIgnoreCase(title);
    }

    @RequestMapping(value="findByAuthor", method=RequestMethod.GET)
    public List<Book> finByAuthor(String author){
        List<Book> books = new ArrayList<>();
        books = br.findByAuthorIgnoreCase(author);
        return books;
    }

    @RequestMapping(value="deleteBook", method=RequestMethod.DELETE)
    public void deleteBook(String title){
        br.delete(br.findByTitleIgnoreCase(title));
    }
}

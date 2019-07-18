package com.kloc.demo2.Repositories;

import com.kloc.demo2.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByAuthorIgnoreCase(String author);
    Book findByTitleIgnoreCase(String title);
}

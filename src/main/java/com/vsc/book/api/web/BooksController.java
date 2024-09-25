package com.vsc.book.api.web;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vsc.book.api.model.Book;
import com.vsc.book.api.service.BooksService;


@RestController
public class BooksController {
    
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/books")
    public Collection<Book> get(
        @RequestParam(defaultValue="") String title,
        @RequestParam(defaultValue="") String author,
        @RequestParam(value="year", required=false) Integer year,
        @RequestParam(value="rating", required=false) Integer rating
    ) {
        System.err.println(title);
        return booksService.get(title, author, year, rating);
    }

    @GetMapping("/books/{id}")
    public Book get(@PathVariable int id) {
        Book book = booksService.get(id);
        if (book == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return book;
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable int id) {
        booksService.remove(id);
    }

    @PutMapping("/books/{id}")
    public Book rate(@PathVariable int id, @RequestParam("rating") Integer rating) {
        if (rating < 1 || rating > 5) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        Book book = booksService.rate(id, rating);
        if (book == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return book;
    }
    
    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        Book newBook = booksService.save(book.getTitle(), book.getAuthor() , book.getYear());        
        return newBook;
    }
}

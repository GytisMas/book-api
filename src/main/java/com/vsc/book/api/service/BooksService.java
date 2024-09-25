package com.vsc.book.api.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.vsc.book.api.model.Book;
import com.vsc.book.api.repositories.BookRepo;

@Service
public class BooksService {
    
    private final BookRepo bookRepo;

    public BooksService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Collection<Book> get(String title, String author, Integer year, Integer rating) {
        if (year != null)
            if (rating != null)
                return bookRepo.findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCaseAndYearAndRating(title, author, year, rating);
            else
                return bookRepo.findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCaseAndYear(title, author, year);
        else if (rating != null)
            return bookRepo.findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCaseAndRating(title, author, rating);
        return bookRepo.findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(title, author);
    }

    public Book get(Integer id) {
        return bookRepo.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        bookRepo.deleteById(id);
    }
    
    public Book rate(Integer id, int rating) {
        Book book = bookRepo.findById(id).orElse(null);
        if (book == null) return null;
        
        book.setRating(rating);
        Book updatedBook = bookRepo.save(book);

        return updatedBook;
    }

    public Book save(String title, String author, int year) {
        Book book = new Book();

        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        Book savedBook = bookRepo.save(book);

        return savedBook;
    }

}

package com.vsc.book.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsc.book.api.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
    List<Book> findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(String title, String author);
    List<Book> findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCaseAndYear(String title, String author, Integer year);
    List<Book> findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCaseAndRating(String title, String author, Integer rating);
    List<Book> findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCaseAndYearAndRating(String title, String author, Integer year, Integer rating);
}

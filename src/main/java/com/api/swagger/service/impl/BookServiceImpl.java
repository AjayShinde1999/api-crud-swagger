package com.api.swagger.service.impl;

import com.api.swagger.entity.Author;
import com.api.swagger.entity.Book;
import com.api.swagger.repository.AuthorRepository;
import com.api.swagger.repository.BookRepository;
import com.api.swagger.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Book saveOneBook(Book book, long authorId) {
        Author author = authorRepository.findById(authorId).get();
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getListOfBooksByAuthorId(long authorId) {
       return bookRepository.findByAuthorId(authorId);
    }

    @Override
    public List<Book> getListOfAllBooks() {
        return bookRepository.findAll();
    }
}

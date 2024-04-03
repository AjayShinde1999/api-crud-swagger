package com.api.swagger.service;

import com.api.swagger.entity.Book;

import java.util.List;

public interface BookService {

    Book saveOneBook(Book book,long authorId);

    List<Book> getListOfBooksByAuthorId(long authorId);

    List<Book> getListOfAllBooks();
}

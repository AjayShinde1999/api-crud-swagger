package com.api.swagger.controller;

import com.api.swagger.entity.Book;
import com.api.swagger.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/{authorId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBookDetails(@RequestBody Book book, @PathVariable long authorId){
        return bookService.saveOneBook(book,authorId);
    }

    @GetMapping("/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getListOfBooksByAuthorId(@PathVariable long authorId){
        return bookService.getListOfBooksByAuthorId(authorId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getListOfAllBooks(){
        return bookService.getListOfAllBooks();
    }
}

package com.api.swagger.service;

import com.api.swagger.entity.Author;
import com.api.swagger.utils.DeleteResponse;

import java.util.List;

public interface AuthorService {
    
    Author saveAuthor(Author author);

    Author getAuthorDetailsById(long id);

    List<Author> getAllAuthors();

    Author updateAuthorDetailsById(Author author, long id);

    DeleteResponse deleteAuthorById(long id);
}

package com.api.swagger.service.impl;

import com.api.swagger.entity.Author;
import com.api.swagger.repository.AuthorRepository;
import com.api.swagger.service.AuthorService;
import com.api.swagger.utils.DeleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorDetailsById(long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthorDetailsById(Author author, long id) {
        Author existingAuthor = authorRepository.findById(id).get();
        existingAuthor.setName(author.getName());
        existingAuthor.setNationality(author.getNationality());
        existingAuthor.setBirthDate(author.getBirthDate());
        return authorRepository.save(existingAuthor);
    }

    @Override
    public DeleteResponse deleteAuthorById(long id) {
        authorRepository.deleteById(id);
        DeleteResponse response = new DeleteResponse();
        response.setMessage("Deleted Successfully");
        return response;
    }
}

package com.api.swagger.controller;

import com.api.swagger.entity.Author;
import com.api.swagger.service.AuthorService;
import com.api.swagger.utils.DeleteResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
@Api(tags = "Authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "save the author details")
    public Author saveAuthorDetails(@RequestBody Author author){
       return authorService.saveAuthor(author);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "get author details by id")
    public Author getAuthorDetailsById(@PathVariable long id){
        return authorService.getAuthorDetailsById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "get all authors details")
    public List<Author> getAllAuthorsDetails(){
        return authorService.getAllAuthors();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "update the author details by id")
    public Author updateAuthorDetailsById(@RequestBody Author author,@PathVariable long id){
        return authorService.updateAuthorDetailsById(author,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "delete author details by id")
    public DeleteResponse deleteAuthorById(@PathVariable long id){
        return authorService.deleteAuthorById(id);
    }
}

package com.api.swagger.repository;

import com.api.swagger.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByAuthorId(long authorId);
}

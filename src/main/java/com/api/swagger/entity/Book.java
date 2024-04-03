package com.api.swagger.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int publicationYear;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}

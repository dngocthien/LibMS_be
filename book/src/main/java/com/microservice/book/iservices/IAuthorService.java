package com.microservice.book.iservices;

import com.microservice.book.entities.Author;

import java.util.List;

public interface IAuthorService {

    Integer saveAuthor(Author author);
    public List<Author> getAllAuthor();
    public Author getAuthorById(Integer id);
    public List<Author> getAuthorByName(String name);
}

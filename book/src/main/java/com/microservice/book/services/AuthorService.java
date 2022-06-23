package com.microservice.book.services;

import com.microservice.book.entities.Author;
import com.microservice.book.iservices.IAuthorService;
import com.microservice.book.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private AuthorRepo repository;

    @Override
    public Integer saveAuthor(Author author) {
        // If author existed return id, else save author and return id
        List<Author> query = getAuthorByName(author.getName());
        if(query.size()>0){
            return query.get(0).getId();
        }
        return repository.save(author).getId();
    }

    @Override
    public List<Author> getAllAuthor() {
        return (List<Author>) repository.findAll();
    }

    @Override
    public Author getAuthorById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Author> getAuthorByName(String name) {
        return repository.findByName(name);
    }

}

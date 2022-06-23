package com.microservice.book.services;

import com.microservice.book.entities.Own;
import com.microservice.book.iservices.IOwnService;
import com.microservice.book.repo.OwnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnService implements IOwnService {

    @Autowired
    private OwnRepo repository;

    @Override
    public Own saveOwn(Own user) {
        return repository.save(user);
    }

    @Override
    public List<Own> getAllOwn() {
        return (List<Own>) repository.findAll();
    }

    @Override
    public List<Own> getOwnByBookId(Integer id) {
        return repository.findByBookId(id);
    }

    @Override
    public void deleteOwn(Integer id){
        repository.deleteById(id);
    }

    @Override
    public void deleteOwnByBookId(Integer id) {
        repository.deleteByBookId(id);
    }
}

package com.microservice.userr.services;

import com.microservice.userr.entities.Userr;
import com.microservice.userr.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repository;

    public Userr saveUser(Userr book) {
        return repository.save(book);
    }

    public List<Userr> getAllUsers() {
        return (List<Userr>) repository.findAll();
    }

    public Userr getUserByID(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Userr> getUserByName(String text) {
        return repository.findByNameContaining(text);
    }

    public List<Userr> getActiveUserr() {
        return repository.findActiveUser();
    }

    public Userr updateUser(Integer id, Userr user) {
        Userr existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(user.getName());
            existing.setEmail(user.getEmail());
            existing.setPhone(user.getPhone());
            existing.setIssueDate(user.getIssueDate());
            existing.setExpiredDate(user.getExpiredDate());
            return repository.save(existing);
        }
        return null;
    }

    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }
}

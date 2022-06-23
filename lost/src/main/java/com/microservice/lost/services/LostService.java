package com.microservice.lost.services;

import com.microservice.lost.entities.Lost;
import com.microservice.lost.iservices.ILostService;
import com.microservice.lost.repo.LostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostService implements ILostService {

    @Autowired
    private LostRepo repository;

    @Override
    public Lost saveLost(Lost lost) {
        return repository.save(lost);
    }

    @Override
    public List<Lost> getAllLost() {
        return repository.findAll();
    }

    @Override
    public Lost getLostByID(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Lost> getLostByUserId(Integer id) {
        return repository.findByUserId(id);
    }

    @Override
    public List<Lost> getLostByBookId(Integer id) {
        return repository.findByBookId(id);
    }
}

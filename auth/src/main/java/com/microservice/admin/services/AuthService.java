package com.microservice.admin.services;

import com.microservice.admin.entities.LoginData;
import com.microservice.admin.iservices.IAuthService;
import com.microservice.admin.repo.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private AuthRepo repository;

    @Override
    public LoginData loadLoginDataByName(String name) {
        return repository.findByEmail(name).orElse(null);
    }
}

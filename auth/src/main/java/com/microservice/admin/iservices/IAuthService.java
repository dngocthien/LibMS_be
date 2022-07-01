package com.microservice.admin.iservices;


import com.microservice.admin.entities.LoginData;

public interface IAuthService {

    public LoginData loadLoginDataByName(String name);
}

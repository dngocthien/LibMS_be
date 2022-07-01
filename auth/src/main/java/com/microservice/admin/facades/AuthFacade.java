//package com.microservice.admin.facades;
//
//import com.microservice.admin.dto.LoginRequest;
//import com.microservice.admin.entities.LoginData;
//import com.microservice.admin.iservices.IAuthService;
//import com.sun.istack.NotNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AuthFacade {
//    @Autowired
//    private IAuthService service;
//
//    public LoginRequest login(@NotNull LoginRequest dto) {
//        LoginData model = service.login(dto.getEmail());
//        return model2Dto(model);
//    }
//
//    private LoginData dto2Model(LoginRequest dto){
//        LoginData model = new LoginData();
//        model.setEmail(dto.getEmail());
//        model.setPassword(dto.getPassword());
//        return model;
//    }
//
//    private LoginRequest model2Dto(LoginData model){
//        LoginRequest dto = new LoginRequest();
//        dto.setId(model.getId());
//        dto.setEmail(model.getEmail());
//        dto.setPassword(model.getPassword());
//        return dto;
//    }
//}

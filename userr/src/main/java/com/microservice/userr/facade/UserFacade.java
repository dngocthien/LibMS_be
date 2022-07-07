package com.microservice.userr.facade;

import com.microservice.userr.dto.UserDto;
import com.microservice.userr.entities.Userr;
import com.microservice.userr.services.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFacade {
    @Autowired
    private UserService service;

    public UserDto saveUser(@NotNull UserDto dto) {
        Userr userr = service.saveUser(dto2Model(dto));
        return model2Dto(userr);
    }

    public List<UserDto> getAllUser() {
        List<Userr> list = service.getAllUsers();
        return addDtoList(list);
    }

    public UserDto getUserById(Integer id) {
        Userr userr = service.getUserByID(id);
        return model2Dto(userr);
    }

    public List<UserDto> getUserByName(String text) {
        List<Userr> list = service.getUserByName(text);
        return addDtoList(list);
    }

    public List<UserDto> getActiveUsers() {
        List<Userr> userList = service.getActiveUserr();
        return addDtoList(userList);
    }

    public UserDto updateUser(Integer id, UserDto dto) {
        Userr userr = service.updateUser(id, dto2Model(dto));
        return model2Dto(userr);
    }

    public void deleteUser(Integer id) {
        service.deleteUser(id);
    }

    private Userr dto2Model(UserDto dto) {
        Userr model = new Userr();
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setPhone(dto.getPhone());
        model.setIssueDate(dto.getIssuedDate());
        model.setExpiredDate(dto.getExpiredDate());
        return model;
    }

    private UserDto model2Dto(Userr model) {
        if (model == null) return null;
        UserDto dto = new UserDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setEmail(model.getEmail());
        dto.setPhone(model.getPhone());
        dto.setIssuedDate(model.getIssueDate());
        dto.setExpiredDate(model.getExpiredDate());
        return dto;
    }

    private List<Userr> addModelList(List<UserDto> dtoList) {
        List<Userr> modelList = new ArrayList<>();
        for (UserDto u : dtoList) {
            modelList.add(dto2Model(u));
        }
        return modelList;
    }

    private List<UserDto> addDtoList(List<Userr> modelList) {
        List<UserDto> dtoList = new ArrayList<>();
        for (Userr u : modelList) {
            dtoList.add(model2Dto(u));
        }
        return dtoList;
    }

}

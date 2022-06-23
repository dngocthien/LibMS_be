package com.microservice.lost.facades;

import com.microservice.lost.dto.LostDto;
import com.microservice.lost.entities.Lost;
import com.microservice.lost.iservices.ILostService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LostFacade {
    @Autowired
    private ILostService service;

    public LostDto saveLost(@NotNull LostDto dto) {
        Lost lost = service.saveLost(dto2Model(dto));
        return model2Dto(lost);
    }

    public List<LostDto> getAllLost() {
        List<Lost> userList = service.getAllLost();
        return addDtoList(userList);
    }

    public LostDto getLostById(Integer id) {
        Lost user = service.getLostByID(id);
        return model2Dto(user);
    }

    public List<LostDto> getLostByUserId(Integer id) {
        List<Lost> userList = service.getLostByUserId(id);
        return addDtoList(userList);
    }

    public List<LostDto> getLostByBookId(Integer id) {
        List<Lost> userList = service.getLostByBookId(id);
        return addDtoList(userList);
    }

    private Lost dto2Model(LostDto dto){
        Lost model = new Lost();
        model.setLostDate(dto.getLostDate());
        model.setBookId(dto.getBookId());
        model.setUserId(dto.getUserId());
        return model;
    }

    private LostDto model2Dto(Lost model){
        LostDto dto = new LostDto();
        dto.setId(model.getId());
        dto.setLostDate(model.getLostDate());
        dto.setBookId(model.getBookId());
        dto.setUserId(model.getUserId());
        return dto;
    }

    private List<Lost> addUserList(List<LostDto> dtoList){
        List<Lost> modelList = new ArrayList<>();
        for(LostDto u: dtoList){
            modelList.add(dto2Model(u));
        }
        return modelList;
    }

    private List<LostDto> addDtoList(List<Lost> modelList){
        List<LostDto> dtoList = new ArrayList<>();
        for(Lost u: modelList){
            dtoList.add(model2Dto(u));
        }
        return dtoList;
    }
}

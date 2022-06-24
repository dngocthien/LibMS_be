package com.microservice.transaction.facades;

import com.microservice.transaction.dto.BorrowDto;
import com.microservice.transaction.entities.Borrow;
import com.microservice.transaction.iservices.IBorrowService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BorrowFacade {
    @Autowired
    private IBorrowService service;

    public BorrowDto saveBorrow(@NotNull BorrowDto dto) {
        Borrow model = service.saveBorrow(dto2Model(dto));
        return model2Dto(model);
    }

    public List<BorrowDto> getAllBorrows() {
        List<Borrow> modelList = service.getAllBorrow();
        return addDtoList(modelList);
    }

    public BorrowDto getBorrowById(Integer id) {
        Borrow model = service.getBorrowByID(id);
        return model2Dto(model);
    }

    public List<BorrowDto> getBorrowByStatus(boolean status) {
        List<Borrow> models = service.getBorrowByStatus(status);
        return addDtoList(models);
    }

    public List<BorrowDto> getBorrowByOverDue() {
        List<Borrow> models = service.getBorrowByOverDue();
        return addDtoList(models);
    }

    public List<BorrowDto> getBorrowByTransactionId(Integer id) {
        List<Borrow> models = service.getByTransactionId(id);
        return addDtoList(models);
    }

    public BorrowDto updateBorrow(Integer id, BorrowDto dto){
        Borrow model = service.updateBorrow(id, dto2Model(dto));
        return model2Dto(model);
    }

    private Borrow dto2Model(BorrowDto dto){
        Borrow model = new Borrow();
        model.setReturnDate(dto.getReturnDate());
        model.setStatus(dto.isStatus());
        model.setBookId(dto.getBookId());
        model.setTransactionId(dto.getTransactionId());
        return model;
    }

    private BorrowDto model2Dto(Borrow model){
        BorrowDto dto = new BorrowDto();
        dto.setId(model.getId());
        dto.setReturnDate(model.getReturnDate());
        dto.setStatus(model.isStatus());
        dto.setBookId(model.getBookId());
        dto.setTransactionId(model.getTransactionId());
        return dto;
    }

    private List<Borrow> addModelList(List<BorrowDto> dtoList){
        List<Borrow> modelList = new ArrayList<>();
        for(BorrowDto m: dtoList){
            modelList.add(dto2Model(m));
        }
        return modelList;
    }

    private List<BorrowDto> addDtoList(List<Borrow> modelList){
        List<BorrowDto> dtoList = new ArrayList<>();
        for(Borrow m: modelList){
            dtoList.add(model2Dto(m));
        }
        return dtoList;
    }
}

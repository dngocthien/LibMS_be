package com.microservice.borrow.facades;


import com.microservice.borrow.dto.BorrowDto;
import com.microservice.borrow.dto.ByTime;
import com.microservice.borrow.dto.TransactionDto;
import com.microservice.borrow.entities.Borrow;
import com.microservice.borrow.feign.TransactionClient;
import com.microservice.borrow.iservices.IBorrowService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BorrowFacade {
    @Autowired
    private IBorrowService service;

    @Autowired
    private TransactionClient transactionClient;

    public BorrowDto saveBorrow(@NotNull BorrowDto dto) {
        Borrow model = service.saveBorrow(dto2Model(dto));
        return model2Dto(model);
    }

    public List<BorrowDto> saveBorrows(List<BorrowDto> dto) {
        List<Borrow> modelList = service.saveBorrows(addModelList(dto));
        return addDtoList(modelList);
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

    public List<BorrowDto> getBorrowByTransactionId(Integer id) {
        List<Borrow> models = service.getByTransactionId(id);
        return addDtoList(models);
    }

    public List<Integer> getBorrowIdsByTransactionId(Integer id) {
        return service.getBorrowIdsByTransactionId(id);
    }

    public List<BorrowDto> getBorrowsByUserId(Integer id) {
        List<TransactionDto> list = transactionClient.findTransactionByUserId(id);
        if (list.size() > 0) {
            return getBorrowByTransactionId(list.get(0).getId());
        }
        return new ArrayList<>();
    }

    public List<Integer> getBorrowIdsByTime(ByTime byTime) {
        List<TransactionDto> transactionByTime = transactionClient.findTransactionByTime(byTime);
        List<Integer> borrowsIdsByTime = new ArrayList<>();
        for (int i = 0; i < transactionByTime.size(); i++) {
            List<Integer> list = getBorrowIdsByTransactionId(transactionByTime.get(i).getId());
            borrowsIdsByTime.addAll(list);
        }
        return borrowsIdsByTime;
    }

    public BorrowDto updateBorrow(Integer id, BorrowDto dto) {
        Borrow model = service.updateBorrow(id, dto2Model(dto));
        return model2Dto(model);
    }

    private Borrow dto2Model(BorrowDto dto) {
        Borrow model = new Borrow();
        model.setReturnDate(dto.getReturnDate());
        model.setStatus(dto.isStatus());
        model.setBookId(dto.getBookId());
        model.setTransactionId(dto.getTransactionId());
        return model;
    }

    private BorrowDto model2Dto(Borrow model) {
        BorrowDto dto = new BorrowDto();
        dto.setId(model.getId());
        dto.setReturnDate(model.getReturnDate());
        dto.setStatus(model.isStatus());
        dto.setBookId(model.getBookId());
        dto.setTransactionId(model.getTransactionId());
        return dto;
    }

    private List<Borrow> addModelList(List<BorrowDto> dtoList) {
        List<Borrow> modelList = new ArrayList<>();
        for (BorrowDto m : dtoList) {
            modelList.add(dto2Model(m));
        }
        return modelList;
    }

    private List<BorrowDto> addDtoList(List<Borrow> modelList) {
        List<BorrowDto> dtoList = new ArrayList<>();
        for (Borrow m : modelList) {
            dtoList.add(model2Dto(m));
        }
        return dtoList;
    }
}

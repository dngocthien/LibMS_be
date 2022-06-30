package com.microservice.transaction.facades;

import com.microservice.transaction.dto.TransactionDto;
import com.microservice.transaction.entities.Transaction;
import com.microservice.transaction.iservices.ITransactionService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TransactionFacade {
    @Autowired
    private ITransactionService service;

    public TransactionDto saveTransaction(@NotNull TransactionDto dto) {
        Transaction transaction = service.saveTransaction(dto2Model(dto));
        return model2Dto(transaction);
    }

    public List<TransactionDto> getAllTransaction() {
        List<Transaction> list = service.getAllTransaction();
        return addDtoList(list);
    }

    public TransactionDto getTransactionById(Integer id) {
        Transaction transaction = service.getTransactionByID(id);
        return model2Dto(transaction);

    }public List<TransactionDto> getTransactionByOverdue() {
        List<Transaction> list = service.getByOverdue();
        return addDtoList(list);
    }

    public List<TransactionDto> getTransactionByUserId(Integer id) {
        List<Transaction> list = service.getByUserId(id);
        return addDtoList(list);
    }

    public List<TransactionDto> findTransactionByTime(Date start, Date end) {
        List<Transaction> list = service.getTransactionByTime(start, end);
        return addDtoList(list);
    }

    public TransactionDto updateTransaction(Integer id, TransactionDto dto) {
        Transaction transaction = service.updateTransaction(id, dto2Model(dto));
        return model2Dto(transaction);
    }

    private Transaction dto2Model(TransactionDto dto){
        Transaction model = new Transaction();
        model.setIssuedDate(dto.getIssuedDate());
        model.setDueDate(dto.getDueDate());
        model.setFinished(dto.isFinished());
        model.setUserId(dto.getUserId());
        return model;
    }

    private TransactionDto model2Dto(Transaction model){
        if(model == null) return null;
        TransactionDto dto = new TransactionDto();
        dto.setId(model.getId());
        dto.setIssuedDate(model.getIssuedDate());
        dto.setDueDate(model.getDueDate());
        dto.setFinished(model.isFinished());
        dto.setUserId(model.getUserId());
        return dto;
    }

    private List<Transaction> addModelList(List<TransactionDto> dtoList){
        List<Transaction> modelList = new ArrayList<>();
        for(TransactionDto u: dtoList){
            modelList.add(dto2Model(u));
        }
        return modelList;
    }

    private List<TransactionDto> addDtoList(List<Transaction> modelList){
        List<TransactionDto> dtoList = new ArrayList<>();
        for(Transaction u: modelList){
            dtoList.add(model2Dto(u));
        }
        return dtoList;
    }

}

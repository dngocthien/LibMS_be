package com.microservice.transaction.facades;

import com.microservice.transaction.dto.TransactionDto;
import com.microservice.transaction.entities.Transaction;
import com.microservice.transaction.iservices.ITransactionService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        List<Transaction> userList = service.getAllTransaction();
        return addDtoList(userList);
    }

    public TransactionDto getTransactionById(Integer id) {
        Transaction user = service.getTransactionByID(id);
        return model2Dto(user);
    }

    public List<TransactionDto> getTransactionByUserId(Integer id) {
        List<Transaction> userList = service.getByUserId(id);
        return addDtoList(userList);
    }

    private Transaction dto2Model(TransactionDto dto){
        Transaction model = new Transaction();
        model.setIssuedDate(dto.getIssuedDate());
        model.setFinished(dto.isFinished());
        model.setUserId(dto.getUserId());
        return model;
    }

    private TransactionDto model2Dto(Transaction model){
        TransactionDto dto = new TransactionDto();
        dto.setId(model.getId());
        dto.setIssuedDate(model.getIssuedDate());
        dto.setFinished(model.isFinished());
        dto.setUserId(model.getUserId());
        return dto;
    }

    private List<Transaction> addUserList(List<TransactionDto> dtoList){
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

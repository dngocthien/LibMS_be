package com.microservice.transaction.dto;

import lombok.Data;

import java.util.List;

@Data
public class TransactionBorrows {
    private TransactionDto transactionDto;
    private List<BorrowDto> borrows;
}

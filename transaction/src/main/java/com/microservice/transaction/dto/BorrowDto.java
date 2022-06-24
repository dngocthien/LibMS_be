package com.microservice.transaction.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BorrowDto {

    private Integer id;
    private Date returnDate;
    private boolean status;
    private Integer bookId;
    private Integer transactionId;

}

package com.microservice.borrow.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDto {

    private Integer id;
    private Date issuedDate;
    private Date dueDate;
    private boolean finished;
    private Integer userId;
}

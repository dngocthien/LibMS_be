package com.microservice.transaction.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDto {

    private Integer id;
    private Date issuedDate;
    private boolean finished;
    private Integer userId;
}

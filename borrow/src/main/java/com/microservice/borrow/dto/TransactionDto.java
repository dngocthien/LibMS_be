package com.microservice.borrow.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class TransactionDto {

    private Integer id;
    private Date issuedDate;
    private Date dueDate;
    private boolean finished;
    private Integer userId;
}

package com.microservice.transaction.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ByTime {
    private Date fromDate;
    private Date toDate;
}

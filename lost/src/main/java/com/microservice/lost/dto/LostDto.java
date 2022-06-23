package com.microservice.lost.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LostDto {

    private Integer id;
    private Date lostDate;
    private Integer bookId;
    private Integer userId;
}

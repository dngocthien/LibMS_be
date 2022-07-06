package com.microservice.book.dto;

import lombok.Data;

import java.util.List;

@Data
public class TopBookDto {

    private Integer id;
    private String title;
    private int edition;
    private int price;
    private int quantity;
    private List<String> authors;
    private Integer categoryId;
    private int time;

}

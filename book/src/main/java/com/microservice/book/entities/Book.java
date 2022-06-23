package com.microservice.book.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;
    private int edition;
    private int price;
    private int quantity;
    private Integer categoryId;

}

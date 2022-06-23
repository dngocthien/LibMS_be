package com.microservice.book.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;

}

package com.microservice.category.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;

}

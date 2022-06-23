package com.microservice.book.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Own {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer authorId;
    private Integer bookId;

}

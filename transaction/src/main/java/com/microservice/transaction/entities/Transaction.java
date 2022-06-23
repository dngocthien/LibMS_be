package com.microservice.transaction.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Date issuedDate;
    private Date dueDate;
    private boolean finished;
    private Integer userId;

}

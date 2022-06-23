package com.microservice.borrow.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Date returnDate;
    private boolean status;
    private Integer bookId;
    private Integer transactionId;

}

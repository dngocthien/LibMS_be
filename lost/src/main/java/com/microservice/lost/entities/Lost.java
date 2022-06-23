package com.microservice.lost.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Lost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Date lostDate;
    private Integer fee;
    private Integer bookId;
    private Integer userId;

}

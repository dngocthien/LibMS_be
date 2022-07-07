package com.microservice.user.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Userr {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "issue_date")
    private String issueDate;
    @Column(name = "expired_date")
    private String expiredDate;

}

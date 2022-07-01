package com.microservice.admin.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class LoginData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String email;
    private String password;

}

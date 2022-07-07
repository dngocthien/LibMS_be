package com.microservice.userr.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String issuedDate;
    private String expiredDate;

}

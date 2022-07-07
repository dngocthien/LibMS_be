package com.microservice.user.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String issueDate;
    private String expiredDate;

}

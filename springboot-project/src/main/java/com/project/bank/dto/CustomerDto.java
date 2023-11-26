package com.project.bank.dto;

import lombok.Data;

@Data
public class CustomerDto {

    private String userId;
    private String password;
    private String emailId;
    private String mobileNo;
}

package com.example.classconnect.model.dtos;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LoginResponse {
    private String email;
    private String password;
    private String status;
}
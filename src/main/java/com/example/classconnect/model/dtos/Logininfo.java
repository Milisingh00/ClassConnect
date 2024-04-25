
package com.example.classconnect.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Logininfo {
    String email;
    String password;
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
}
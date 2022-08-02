package com.example.kejani_backend.payload;
import lombok.Data;

@Data
public class HouseOwnerRequest {
    private String userName;
    private String email;
    private String mobileNumber;
    private String password;
    private String confirmPassword;

}

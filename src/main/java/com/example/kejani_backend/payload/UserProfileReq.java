package com.example.kejani_backend.payload;

import lombok.Data;

@Data
public class UserProfileReq {
    private String userName;
    private String email;
    private String mobileNumber;
}

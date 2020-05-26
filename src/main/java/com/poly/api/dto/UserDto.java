package com.poly.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private int userId;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private FacilityDto facility;

    public UserDto() {
    }

    public UserDto(int userId, String username, String email, String password, String address, String phoneNumber, FacilityDto facility) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.facility = facility;
    }
}

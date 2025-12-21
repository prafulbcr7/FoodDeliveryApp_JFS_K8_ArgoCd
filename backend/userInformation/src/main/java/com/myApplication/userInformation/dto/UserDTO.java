package com.myApplication.userInformation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String address;
    private String city;
}

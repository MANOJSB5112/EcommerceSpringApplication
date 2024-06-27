package com.example.ecommercespringapplication.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class UserDto {
    private String name;
    private String email;
    private String hashedPassword;
    private List<RolesDto> roles;
    private Boolean isEmailVerified;

}

package com.appvenir.imageoptimization.domain.user.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private String fullName;
    private String email;
    private String password;
}

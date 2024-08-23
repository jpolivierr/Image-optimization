package com.appvenir.imageoptimization.domain.user.dto;

import lombok.Data;

@Data
public class UserDto {
    private String fullName;
    private String email;
    private String dateCreated;
    private String lastUpdated;
}

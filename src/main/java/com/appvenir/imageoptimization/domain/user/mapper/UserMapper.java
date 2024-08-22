package com.appvenir.imageoptimization.domain.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.appvenir.imageoptimization.domain.user.dto.UserDto;
import com.appvenir.imageoptimization.domain.user.dto.UserRegistrationDto;
import com.appvenir.imageoptimization.domain.user.model.User;

@Mapper
@Component
public interface UserMapper {
    
    UserDto toUserDto(User user);

    User toUserModel(UserDto userDto);

    User toUserModel(UserRegistrationDto userDto);

    UserRegistrationDto toUserRegistrationDto(User userDto);

}

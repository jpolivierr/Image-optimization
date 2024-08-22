package com.appvenir.imageoptimization.domain.user.service;

import org.springframework.stereotype.Service;

import com.appvenir.imageoptimization.domain.user.dto.UserDto;
import com.appvenir.imageoptimization.domain.user.dto.UserRegistrationDto;
import com.appvenir.imageoptimization.domain.user.mapper.UserMapper;
import com.appvenir.imageoptimization.domain.user.model.User;
import com.appvenir.imageoptimization.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto save(UserRegistrationDto userRegistrationDto ){
        User user = userMapper.toUserModel(userRegistrationDto);
        return userMapper.toUserDto(userRepository.save(user));
    }

    
}

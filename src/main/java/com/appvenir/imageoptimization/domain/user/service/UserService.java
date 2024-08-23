package com.appvenir.imageoptimization.domain.user.service;

import org.springframework.stereotype.Service;

import com.appvenir.imageoptimization.domain.user.dto.UserDto;
import com.appvenir.imageoptimization.domain.user.dto.UserRegistrationDto;
import com.appvenir.imageoptimization.domain.user.exception.EmailAlreadyExistException;
import com.appvenir.imageoptimization.domain.user.exception.UserNotFoundException;
import com.appvenir.imageoptimization.domain.user.mapper.UserMapper;
import com.appvenir.imageoptimization.domain.user.model.User;
import com.appvenir.imageoptimization.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto saveUser(UserRegistrationDto userRegistrationDto){
        if (userRepository.findByEmail(userRegistrationDto.getEmail()).isPresent()) {
            throw new EmailAlreadyExistException();
        }
        User user = userMapper.toUserModel(userRegistrationDto);
        return userMapper.toUserDto(userRepository.save(user));
    }

    public UserDto updateUser(String email, UserDto userDto){
        User currentUser = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());
        currentUser.setEmail(userDto.getEmail());
        currentUser.setFullName(userDto.getFullName());
        return userMapper.toUserDto(userRepository.save(currentUser));
    }

    public UserDto getUserByEmail(String email){
        User currentUser = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());
        return userMapper.toUserDto(currentUser);
    }

    public void deleteUserByEmail(String email){
        User currentUser = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());
        userRepository.delete(currentUser);
    }

    
}

package com.appvenir.imageoptimization.domain.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.appvenir.imageoptimization.domain.user.dto.UserDto;
import com.appvenir.imageoptimization.domain.user.dto.UserRegistrationDto;
import com.appvenir.imageoptimization.domain.user.mapper.UserMapper;
import com.appvenir.imageoptimization.domain.user.model.User;
import com.appvenir.imageoptimization.domain.user.repository.UserRepository;
import java.time.LocalDateTime;


public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;

    private UserService userService;

    private UserMapper userMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize the mocks and inject them into userService
        userMapper = Mappers.getMapper(UserMapper.class);  // Use the real mapper implementation
        userService = new UserService(mockUserRepository, userMapper);  // Manually inject the real mapper
    }

    @Test
    public void save_should_save_a_user_entity() {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setFullName("John Smith");
        userRegistrationDto.setEmail("jp@gmail.com");
        userRegistrationDto.setPassword("49897");

        User user = new User();
        user.setId(1L);
        user.setFullName("John");
        user.setEmail("jp@gmail.com");
        user.setPassword("49897");
        user.setDateCreated(LocalDateTime.now());
        user.setLastUpdated(LocalDateTime.now());

        when(mockUserRepository.save(any(User.class))).thenReturn(user);

        UserDto result = userService.save(userRegistrationDto);

        assertNotNull(result);
        assertEquals("John", result.getFullName());
        assertEquals("jp@gmail.com", result.getEmail());

        verify(mockUserRepository).save(any(User.class));
    }
}
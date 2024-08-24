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
import com.appvenir.imageoptimization.domain.user.factory.UserFactory;
import com.appvenir.imageoptimization.domain.user.mapper.UserMapper;
import com.appvenir.imageoptimization.domain.user.model.User;
import com.appvenir.imageoptimization.domain.user.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.Optional;


public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;
    private UserService userService;
    private UserMapper userMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userMapper = Mappers.getMapper(UserMapper.class);
        userService = new UserService(mockUserRepository, userMapper);
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

        UserDto result = userService.saveUser(userRegistrationDto);

        assertNotNull(result);
        assertEquals("John", result.getFullName());
        assertEquals("jp@gmail.com", result.getEmail());

        verify(mockUserRepository).save(any(User.class));
    }

    @Test
    public void update_should_update_existing_user(){

        User currentUser = UserFactory.createDemoUser();
        String originalEmail = currentUser.getEmail();
        UserDto updateUser = userMapper.toUserDto(UserFactory.createDemoUser());
        System.out.println(updateUser);

        when(mockUserRepository.findByEmail(currentUser.getEmail())).thenReturn(Optional.of(currentUser));
        when(mockUserRepository.save(any(User.class))).thenAnswer(invocation -> {
            User savedUser = invocation.getArgument(0);
            savedUser.setId(currentUser.getId());
            return savedUser; 
        });

        UserDto result = userService.updateUser(currentUser.getEmail(), updateUser);

        assertNotNull(result);
        assertEquals(updateUser.getEmail(), result.getEmail());

        verify(mockUserRepository).findByEmail(originalEmail);
        verify(mockUserRepository).save(any(User.class));

    }
}
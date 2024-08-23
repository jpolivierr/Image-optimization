package com.appvenir.imageoptimization.domain.user.factory;

import java.time.LocalDateTime;
import com.github.javafaker.Faker;
import com.appvenir.imageoptimization.domain.user.dto.UserRegistrationDto;
import com.appvenir.imageoptimization.domain.user.model.User;

public class UserFactory {

    private static final Faker faker = new Faker();

    public static User createDemoUser() {
        User user = new User();
        user.setId(faker.number().randomNumber());
        user.setFullName(faker.name().fullName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setDateCreated(LocalDateTime.now());
        user.setLastUpdated(LocalDateTime.now());
        return user;
    }

    public static UserRegistrationDto createDemoUserRegistrationDto() {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setFullName(faker.name().fullName());
        userRegistrationDto.setEmail(faker.internet().emailAddress());
        userRegistrationDto.setPassword(faker.internet().password());
        return userRegistrationDto;
    }
    
}

package com.appvenir.imageoptimization.domain.imageDetails.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.appvenir.imageoptimization.domain.imageDetails.model.ImageDetails;
import com.appvenir.imageoptimization.domain.imageDetails.repository.ImageDetailsRepository;
import com.appvenir.imageoptimization.domain.user.factory.UserFactory;
import com.appvenir.imageoptimization.domain.user.model.User;
import com.appvenir.imageoptimization.domain.user.repository.UserRepository;
import com.appvenir.imageoptimization.domain.user.service.UserService;

public class ImageDetailsServiceTest {

    @InjectMocks
    private ImageDetailsRepository mockImageDetailsRepository;

    @InjectMocks
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService mockUserService;

    private ImageDetailsService imageDetailsService;

    

    @BeforeEach
    public void setup(){
        this.mockImageDetailsRepository = mock(ImageDetailsRepository.class);
        this.mockUserRepository = mock(UserRepository.class);
        this.mockUserService = mock(UserService.class);
        this.imageDetailsService = new ImageDetailsService(mockImageDetailsRepository, mockUserService);
    }

    @Test
    public void save_should_save_an_imageDetails(){
        User user = UserFactory.createDemoUser();

        ImageDetails imageDetails = new ImageDetails();
        imageDetails.setId(1L);
        imageDetails.setTitle("This is an Image Detail");
        imageDetails.setDescription("Some description");
        imageDetails.setHost("domain.com");
        imageDetails.setPath("/some/path");
        imageDetails.setLastUpdated(LocalDateTime.now());
        imageDetails.setDateCreated(LocalDateTime.now());

        when(mockImageDetailsRepository.save(imageDetails)).thenReturn(imageDetails);
        when(mockUserService.findUserByEmail(user.getEmail())).thenReturn(user);

        ImageDetails result = imageDetailsService.save(user.getEmail(), imageDetails);

        assertNotNull(result);
        verify(mockUserService).findUserByEmail(user.getEmail());
        verify(mockImageDetailsRepository).save(imageDetails);
    }
    
}

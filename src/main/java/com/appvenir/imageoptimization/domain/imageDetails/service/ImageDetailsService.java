package com.appvenir.imageoptimization.domain.imageDetails.service;

import org.springframework.stereotype.Service;

import com.appvenir.imageoptimization.domain.imageDetails.model.ImageDetails;
import com.appvenir.imageoptimization.domain.imageDetails.repository.ImageDetailsRepository;
import com.appvenir.imageoptimization.domain.user.model.User;
import com.appvenir.imageoptimization.domain.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageDetailsService {
    
    private final ImageDetailsRepository imageDetailsRepository;
    private final UserService userService;

    public ImageDetails save(String email, ImageDetails imageDetails){
        User user = userService.findUserByEmail(email);
        imageDetails.addUser(user);
        return imageDetailsRepository.save(imageDetails);
    }

}

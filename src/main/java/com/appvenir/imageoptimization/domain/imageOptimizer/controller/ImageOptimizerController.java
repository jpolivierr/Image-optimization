package com.appvenir.imageoptimization.domain.imageOptimizer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appvenir.imageoptimization.domain.imageDetails.model.ImageDetails;
import com.appvenir.imageoptimization.domain.imageOptimizer.service.ImageOptimizerService;

@RestController
@RequestMapping("/images")
public class ImageOptimizerController {

    private final ImageOptimizerService imageOptimizerService;

    public ImageOptimizerController(ImageOptimizerService imageOptimizerService){
        this.imageOptimizerService = imageOptimizerService;
    }
    
    @PostMapping
    public ResponseEntity<?> postData(@RequestBody ImageDetails imageDetail) {
        // imageOptimizerService.run(imageDetail);
        return ResponseEntity.ok(imageDetail);
    }
}

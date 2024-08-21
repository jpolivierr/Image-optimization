package com.appvenir.imageoptimization.domain.imageOptimizer.service;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;


import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;


public class ImageOptimizerIT {

    private ImageOptimizer imageOptimizer;
    private Path filePath;
    private Path outPutFilePath;
    private final String pathURI = "static/images/house.jpg";
    private final String outputPathURI = "/Users/Fred/apps/image-optimizer/src/test/resources/static/images/output";


    @Test
    void scale_should_resize_an_image() throws IOException, URISyntaxException
    {
        filePath = Paths.get(getClass().getClassLoader().getResource(pathURI).toURI());
        outPutFilePath = Paths.get(outputPathURI);
        imageOptimizer = new ImageOptimizer(filePath.toString(), outPutFilePath.toString());
        imageOptimizer.scale();

        Paths.get(imageOptimizer.getFinalFilePath());
        assertTrue(Files.exists(outPutFilePath), "Output file should exist");

        // Additional assertions...
        
        // Clean up
        // Files.deleteIfExists(outputFile);
        
    }
    
}

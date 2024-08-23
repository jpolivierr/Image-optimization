package com.appvenir.imageoptimization.domain.imageOptimizer.model;

public record ImageDetails(
    boolean isAbsolutePath,
    String host, 
    String path
){} 
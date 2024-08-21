package com.appvenir.imageoptimization.domain.imageOptimizer.model;

public record ImageDetail(
    boolean isAbsolutePath,
    String host, 
    String path
){} 
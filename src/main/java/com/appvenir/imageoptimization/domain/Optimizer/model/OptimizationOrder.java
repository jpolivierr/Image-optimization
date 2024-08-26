package com.appvenir.imageoptimization.domain.Optimizer.model;

import com.appvenir.imageoptimization.domain.Optimizer.service.attributes.ScaleAttribute;

public record OptimizationOrder( 
    String host, 
    String path, 
    String outputPath,
    ScaleAttribute scale
    ) {}

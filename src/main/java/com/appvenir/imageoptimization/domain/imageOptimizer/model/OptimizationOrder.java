package com.appvenir.imageoptimization.domain.imageOptimizer.model;

import com.appvenir.imageoptimization.domain.imageOptimizer.service.attributes.ScaleAttribute;

public record OptimizationOrder( 
    String host, 
    String path, 
    String outputPath,
    ScaleAttribute scale
    ) {}

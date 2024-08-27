package com.appvenir.imageoptimization.domain.Optimizer.service.factory;

import java.nio.file.Path;

import com.appvenir.imageoptimization.domain.Optimizer.exception.NoOptimizationOperationSpecifyException;
import com.appvenir.imageoptimization.domain.Optimizer.model.OptimizationContext;
import com.appvenir.imageoptimization.domain.Optimizer.service.operations.ScalingOperation;
import com.appvenir.imageoptimization.domain.Optimizer.service.optimizer.ImageOptimizer;
import com.appvenir.imageoptimization.domain.Optimizer.service.optimizer.Optimizer;

public class ImageOptimizerFactory {

    private final OptimizationContext optimizationContext;

    public ImageOptimizerFactory(OptimizationContext optimizationContext){
        this.optimizationContext = optimizationContext;
    }

    public Optimizer getOptimizer(Path filePath){

        var imageOptimizer = new ImageOptimizer(filePath.toString());

        if(optimizationContext.getScale() != null){
            imageOptimizer.addOperation(new ScalingOperation(filePath.toString(), optimizationContext.getOutputPath(), optimizationContext.getScale()));
            return imageOptimizer;
        }

        throw new NoOptimizationOperationSpecifyException();

    }
    
}

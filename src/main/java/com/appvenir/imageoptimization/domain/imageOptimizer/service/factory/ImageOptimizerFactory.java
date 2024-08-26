package com.appvenir.imageoptimization.domain.imageOptimizer.service.factory;

import java.nio.file.Path;

import com.appvenir.imageoptimization.domain.imageOptimizer.exception.NoOptimizationOperationSpecifyException;
import com.appvenir.imageoptimization.domain.imageOptimizer.model.OptimizationContext;
import com.appvenir.imageoptimization.domain.imageOptimizer.service.operations.ScalingOperation;
import com.appvenir.imageoptimization.domain.imageOptimizer.service.optimizer.ImageOptimizer;
import com.appvenir.imageoptimization.domain.imageOptimizer.service.optimizer.Optimizer;

public class ImageOptimizerFactory {

    private final OptimizationContext optimizationContext;

    public ImageOptimizerFactory(OptimizationContext optimizationContext){
        this.optimizationContext = optimizationContext;
    }

    public Optimizer getOptimizer(Path filePath){

        var imageOptimizer = new ImageOptimizer(filePath.toString());

        if(optimizationContext.getScale() != null){
            var scaleOperation = new ScalingOperation(filePath.toString(), optimizationContext.getOutputPath(), optimizationContext.getScale());
            imageOptimizer.addOperation(scaleOperation);
            return imageOptimizer;
        }

        throw new NoOptimizationOperationSpecifyException();

    }
    
}

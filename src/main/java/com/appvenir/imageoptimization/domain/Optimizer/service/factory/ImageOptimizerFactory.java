package com.appvenir.imageoptimization.domain.Optimizer.service.factory;

import java.nio.file.Path;

import com.appvenir.imageoptimization.domain.Optimizer.enums.OperationType;
import com.appvenir.imageoptimization.domain.Optimizer.exception.NoOptimizationOperationSpecifyException;
import com.appvenir.imageoptimization.domain.Optimizer.model.OptimizationContext;
import com.appvenir.imageoptimization.domain.Optimizer.service.OptimizeOperationRegistry;
import com.appvenir.imageoptimization.domain.Optimizer.service.optimizer.ImageOptimizer;
import com.appvenir.imageoptimization.domain.Optimizer.service.optimizer.Optimizer;

public class ImageOptimizerFactory {

    private final OptimizationContext optimizationContext;
    private final OptimizeOperationRegistry optimizeOperationRegistry;

    public ImageOptimizerFactory(OptimizationContext optimizationContext, OptimizeOperationRegistry optimizeOperationRegistry){
        this.optimizationContext = optimizationContext;
        this.optimizeOperationRegistry = optimizeOperationRegistry;
    }

    public Optimizer getOptimizer(Path filePath){

        var imageOptimizer = new ImageOptimizer(filePath.toString());

        if(optimizationContext.getScale() != null){
            var scalingOperation = optimizeOperationRegistry.getOperation(OperationType.SCALE, filePath.toString(), optimizationContext);
            imageOptimizer.addOperation(scalingOperation);
            return imageOptimizer;
        }

        throw new NoOptimizationOperationSpecifyException();

    }
    
}

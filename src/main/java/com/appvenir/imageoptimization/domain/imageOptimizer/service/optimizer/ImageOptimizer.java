package com.appvenir.imageoptimization.domain.imageOptimizer.service.optimizer;

import java.util.HashSet;
import java.util.Set;

import com.appvenir.imageoptimization.domain.imageOptimizer.service.operations.OptimizeOperation;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ImageOptimizer implements Optimizer {
    
    private final String filePath;
    private final Set<OptimizeOperation> optimizeOperations;

    public ImageOptimizer(String filePath){
        this.filePath = filePath;
        this.optimizeOperations = new HashSet<>();
    }

    public void addOperation(OptimizeOperation optimizeOperation){
        this.optimizeOperations.add(optimizeOperation);
    }

    @Override
    public void run() {
       
        for( OptimizeOperation optimizeOperation : optimizeOperations )
        {
            optimizeOperation.execute();
        }

    }

}

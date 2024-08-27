package com.appvenir.imageoptimization.domain.Optimizer.service.optimizer;

import java.util.HashSet;
import java.util.Set;

import com.appvenir.imageoptimization.domain.Optimizer.exception.NullFilePathException;
import com.appvenir.imageoptimization.domain.Optimizer.service.operations.OptimizeOperation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ImageOptimizer implements Optimizer {
    
    private final String filePath;
    private final Set<OptimizeOperation> optimizeOperations;

    public ImageOptimizer(String filePath){
        if(filePath == null) throw new NullFilePathException();
        this.filePath = filePath;
        this.optimizeOperations = new HashSet<>();
    }

    public void addOperation(OptimizeOperation optimizeOperation){
        this.optimizeOperations.add(optimizeOperation);
    }

    @Override
    public void run(){
        for( OptimizeOperation optimizeOperation : optimizeOperations )
        {
            optimizeOperation.execute();
        }
    }

}

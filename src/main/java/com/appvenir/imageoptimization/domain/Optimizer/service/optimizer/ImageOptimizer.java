package com.appvenir.imageoptimization.domain.Optimizer.service.optimizer;

import java.util.HashSet;
import java.util.Set;

import com.appvenir.imageoptimization.domain.Optimizer.exception.NullFilePathException;
import com.appvenir.imageoptimization.domain.Optimizer.service.operations.ImageOperation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ImageOptimizer implements Optimizer {
    
    private final String filePath;
    private final Set<ImageOperation> optimizeOperations;

    public ImageOptimizer(String filePath){
        if(filePath == null) throw new NullFilePathException();
        this.filePath = filePath;
        this.optimizeOperations = new HashSet<>();
    }

    public void addOperation(ImageOperation optimizeOperation){
        this.optimizeOperations.add(optimizeOperation);
    }

    @Override
    public void run(){
        for( ImageOperation optimizeOperation : optimizeOperations )
        {
            optimizeOperation.execute();
        }
    }

}

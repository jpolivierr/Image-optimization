package com.appvenir.imageoptimization.domain.Optimizer.model;

import com.appvenir.imageoptimization.domain.Optimizer.service.attributes.ScaleAttribute;
import com.appvenir.imageoptimization.domain.Optimizer.util.IO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class OptimizationContext {

    private final String host;
    private final String path;
    private final String outputPath;
    private final boolean hasOutpuPath;
    private final boolean isDirectory;
    private final boolean isAbsolute; 
    private final ScaleAttribute scale;

    public OptimizationContext(OptimizationOrder optimizationOrder){
        this.host = optimizationOrder.host();
        this.path = IO.getPath(optimizationOrder.path());
        this.outputPath = IO.getOutputPath(this.path, optimizationOrder.outputPath());
        this.hasOutpuPath = optimizationOrder.outputPath() == null;
        this.isAbsolute = IO.isAbsolutePath(optimizationOrder.path());
        this.isDirectory = IO.isDirectory(optimizationOrder.path());
        this.scale = optimizationOrder.scale();
    }
    
}

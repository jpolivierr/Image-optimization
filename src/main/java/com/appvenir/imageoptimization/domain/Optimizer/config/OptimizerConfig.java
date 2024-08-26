package com.appvenir.imageoptimization.domain.Optimizer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.appvenir.imageoptimization.domain.Optimizer.enums.OperationType;
import com.appvenir.imageoptimization.domain.Optimizer.service.OptimizeOperationRegistry;
import com.appvenir.imageoptimization.domain.Optimizer.service.operations.ScalingOperation;

@Configuration
public class OptimizerConfig {

    @Bean
    public OptimizeOperationRegistry createRegistry() {
        OptimizeOperationRegistry registry = new OptimizeOperationRegistry();

        registry.register(OperationType.SCALE, (filePath, context) -> 
            new ScalingOperation(filePath, context.getOutputPath(), context.getScale())
        );

        return registry;
    }
    
}

package com.appvenir.imageoptimization.domain.Optimizer.service.processors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.appvenir.imageoptimization.domain.Optimizer.model.OptimizationContext;
import com.appvenir.imageoptimization.domain.Optimizer.model.OptimizationOrder;
import com.appvenir.imageoptimization.domain.Optimizer.service.attributes.ScaleAttribute;
import com.appvenir.imageoptimization.domain.Optimizer.service.factory.ImageOptimizerFactory;

public class ImageOptimizerProcessorTest {

    private String targetPath;
    private String outputPath;

    @BeforeEach
    public void setUp(){
        this.targetPath = "/Users/Fred/apps/image-optimization/src/test/resources/demo";
        this.outputPath = "/Users/Fred/apps/image-optimization/src/test/resources/output";

    }

    @Test
    public void process_should_optimize_images_in_a_directory()
    {
        ScaleAttribute scaleAttribute = new ScaleAttribute(200, null, null, null);
        var optimizationOrder = new OptimizationOrder("testHost", targetPath, outputPath, scaleAttribute);
        var optimizationContext = new OptimizationContext(optimizationOrder);
        var optimizerFactory = new ImageOptimizerFactory(optimizationContext);
        var imageOptimizerProcessor = new ImageOptimizerProcessor(optimizationContext, optimizerFactory);
        imageOptimizerProcessor.process();
    }
    
}

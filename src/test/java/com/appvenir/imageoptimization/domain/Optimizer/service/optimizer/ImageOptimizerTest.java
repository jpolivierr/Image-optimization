package com.appvenir.imageoptimization.domain.Optimizer.service.optimizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.appvenir.imageoptimization.domain.Optimizer.exception.NullFilePathException;
import com.appvenir.imageoptimization.domain.Optimizer.service.attributes.ScaleAttribute;
import com.appvenir.imageoptimization.domain.Optimizer.service.operations.OptimizeOperation;
import com.appvenir.imageoptimization.domain.Optimizer.service.operations.ScalingOperation;

public class ImageOptimizerTest {

    @TempDir
    private Path TempDir;

    private Path targetPath;
    private Path outputPath;

    private ScalingOperation scalingOperation;

    @Mock
    private ScaleAttribute scaleAttribute;

    @Mock
    private OptimizeOperation mockOptimizeOperation;

    @BeforeEach
    public void setup() throws IOException{
        MockitoAnnotations.openMocks(this);
       this.targetPath = Files.createTempFile(TempDir, "target-file", ".jpg");
       this.outputPath = Files.createTempDirectory(TempDir, "output-dir");
       this.scalingOperation = new ScalingOperation(targetPath.toString(), outputPath.toString(), scaleAttribute);
    }

    @Test
    public void addOperation_should_add_an_OptimizeOperation(){
        ImageOptimizer imageOptimizer = new ImageOptimizer(targetPath.toString());

        imageOptimizer.addOperation(scalingOperation);
        int size = imageOptimizer.getOptimizeOperations().size();

        imageOptimizer.getOptimizeOperations()
        .forEach( (ops) -> assertTrue(ops instanceof OptimizeOperation, "Should be a subclass of OptimizeOperation") );

        assertEquals(1, size, "The optimize operations list should contain 1 operation after adding an operation.");
    }

    @Test
    public void ImageOptimizer_should_throw_NullFilePathException()
    {
        assertThrows(NullFilePathException.class, () -> {
            new ImageOptimizer(null);
        }, "Should throw a NullFilePathException");
    }

    @Test
    public void run_should_iterate_over_the_optimizeOperation_and_call_the_execute_method()
    {
        ImageOptimizer imageOptimizer = new ImageOptimizer(targetPath.toString());
        imageOptimizer.addOperation(mockOptimizeOperation);
        imageOptimizer.run();

        verify(mockOptimizeOperation, times(1)).execute();
    }
    
}

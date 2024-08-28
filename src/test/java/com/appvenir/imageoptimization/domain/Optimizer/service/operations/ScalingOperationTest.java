package com.appvenir.imageoptimization.domain.Optimizer.service.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.appvenir.imageoptimization.domain.Optimizer.exception.NullFilePathException;
import com.appvenir.imageoptimization.domain.Optimizer.service.attributes.ScaleAttribute;
import com.appvenir.imageoptimization.system.IO;

public class ScalingOperationTest {

    @TempDir
    private Path tempDir;

    @TempDir
    private File tempFile;
    private Path outputPath;
    private String imagePath = "/Users/Fred/apps/image-optimization/src/test/resources/demo/couples.jpg";
    private String output = "/Users/Fred/apps/image-optimization/src/test/resources/output";

    @Mock
    private ScaleAttribute mockScaleAttribute;

    @BeforeEach
    public void setUp() throws IOException{
        MockitoAnnotations.openMocks(this);
        this.outputPath = Files.createTempDirectory("output");
    }

    @AfterEach
    public void cleanUp() throws IOException{
        IO.deleteFilesInDirectory(output);
    }

    @Test
    public void scalingOperation_should_throw_nullFilePathException_when_filePath_is_null()
    {
        assertThrows(NullFilePathException.class, () -> {
            new ScalingOperation(null, outputPath.toString(), mockScaleAttribute);
        }, "Should throw a NullFilePathException");
    }

    @Test
    public void testExecute() throws IOException {
        
        // Mocking the ScaleAttribute (assuming it's a custom class with a getWidth() method)
        ScaleAttribute mockScaleAttribute = Mockito.mock(ScaleAttribute.class);
        when(mockScaleAttribute.getWidth()).thenReturn(50); // Desired width for resizing

        // Create an instance of the class that contains the execute method
        ScalingOperation resizer = new ScalingOperation(imagePath, output, mockScaleAttribute);

        // Run the execute method
        resizer.execute();

        // Verify the image was resized (you can compare dimensions)
        BufferedImage resizedImage = ImageIO.read(new File(output + "/" + resizer.getFileName()));
        assertEquals(50, resizedImage.getWidth(), "Image width should be resized to 50 pixels");

    }
    
}

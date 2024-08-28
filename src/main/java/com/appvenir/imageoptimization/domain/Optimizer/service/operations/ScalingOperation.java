package com.appvenir.imageoptimization.domain.Optimizer.service.operations;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

import com.appvenir.imageoptimization.domain.Optimizer.exception.NullFilePathException;
import com.appvenir.imageoptimization.domain.Optimizer.service.attributes.ScaleAttribute;
import com.appvenir.imageoptimization.domain.Optimizer.util.ImageFiles;

import lombok.Getter;

@Getter
public class ScalingOperation implements ImageOperation{

    private final String fileName;
    private final String fileExt;
    private final String filePath;
    private final String outputFilePath;
    private final String finalFilePath;
    private final ScaleAttribute scaleAttribute;

    public ScalingOperation(String filePath, String outputFilePath, ScaleAttribute scaleAttribute){
        if(filePath == null) throw new NullFilePathException();
        this.filePath = filePath.toString();
        this.fileName = ImageFiles.getFileName(filePath);
        this.fileExt = ImageFiles.getFileExtension(fileName);
        this.outputFilePath = ImageFiles.getOutputFilePath(outputFilePath);
        this.finalFilePath = outputFilePath + "/" + fileName;
        this.scaleAttribute = scaleAttribute;
    }

    @Override 
public void execute() {
    try {
        // Read the original image
        BufferedImage originalImage = ImageIO.read(new File(filePath));
        
        // Get the target width from scaleAttribute
        int targetWidth = scaleAttribute.getWidth();
        
        // Resize the image while maintaining the aspect ratio
        BufferedImage resizedImage = Scalr.resize(originalImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_TO_WIDTH, targetWidth);
        
        // Save the resized image to the specified file path
        ImageIO.write(resizedImage, fileExt, new File(finalFilePath));
        
        System.out.println("Image resized successfully while maintaining aspect ratio!");
    } 

    catch (IOException e) {
        System.err.println("Error occurred while resizing the image: " + e.getMessage());
    }
}

    @Override
    public void undo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'undo'");
    }

    @Override
    public void cleanUp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cleanUp'");
    }
    
}

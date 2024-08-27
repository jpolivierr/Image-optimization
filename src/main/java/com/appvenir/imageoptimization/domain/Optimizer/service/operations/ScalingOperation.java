package com.appvenir.imageoptimization.domain.Optimizer.service.operations;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

import com.appvenir.imageoptimization.domain.Optimizer.service.attributes.ScaleAttribute;
import com.appvenir.imageoptimization.domain.Optimizer.util.ImageFiles;

import lombok.Getter;

@Getter
public class ScalingOperation implements OptimizeOperation{

    private final String fileName;
    private final String fileExt;
    private final String filePath;
    private final String outputFilePath;
    private final String finalFilePath;
    private final ScaleAttribute scaleAttribute;

    public ScalingOperation(String filePath, String outputFilePath, ScaleAttribute scaleAttribute){
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
            BufferedImage originalImage = ImageIO.read(new File(filePath));

            BufferedImage resizedImage = Scalr.resize(originalImage, scaleAttribute.getWidth().intValue());

            ImageIO.write(resizedImage, fileExt, new File(finalFilePath));

            System.out.println("Image resized successfully!");
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

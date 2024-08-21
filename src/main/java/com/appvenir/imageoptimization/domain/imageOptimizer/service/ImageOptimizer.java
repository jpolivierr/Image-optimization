package com.appvenir.imageoptimization.domain.imageOptimizer.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;


import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

import com.appvenir.imageoptimization.domain.imageOptimizer.exception.InvalidFileTypeException;
import com.appvenir.imageoptimization.domain.imageOptimizer.exception.InvalidOutputFilePathException;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ImageOptimizer {
    
    private final String fileName;
    private final String fileExt;
    private final String filePath;
    private final String outputFilePath;
    private final String finalFilePath;

    public ImageOptimizer(String filePath, String outputFilePath){
        this.filePath = filePath;
        this.fileName = getFileName(Paths.get(filePath));
        this.fileExt = getFileExtension(fileName);
        this.outputFilePath = getOutputFilePath(outputFilePath);
        this.finalFilePath = outputFilePath + "/" + fileName;
    }

    
    public void scale() {
        try {
            // Load the original image
            BufferedImage originalImage = ImageIO.read(new File(filePath));

            // Resize the image to 200x200 pixels
            BufferedImage resizedImage = Scalr.resize(originalImage, 200);

            // Save the resized image to a new file
            ImageIO.write(resizedImage, fileExt, new File(finalFilePath));

            System.out.println("Image resized successfully!");
        } 
    
        catch (IOException e) {
            System.err.println("Error occurred while resizing the image: " + e.getMessage());
        }
    }

    private String getFileName(Path fileName){

        List<String> validExtensions = new ArrayList<>(Arrays.asList("jpg", "jpeg", "png"));

        if (fileName == null || fileName.getFileName() == null) {
            throw new IllegalArgumentException("File name cannot be null");
        }

        String fileNameStr = fileName.getFileName().toString();
        int dotIndex = fileNameStr.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == 0) {
            throw new InvalidFileTypeException();
        }

        String extension = fileNameStr.substring(dotIndex + 1).toLowerCase();

        if(!validExtensions.contains(extension)) throw new InvalidFileTypeException();

        return fileName.getFileName().toString();
    }

    private String getFileExtension(String fileName)
    {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == 0) {
            throw new IllegalArgumentException("File does not have an extension");
        }

       return fileName.substring(dotIndex + 1).toLowerCase();
    }

    private String getOutputFilePath(String outputFilePath)
    {
        Path filePath = Paths.get(outputFilePath);

        if(!Files.isDirectory(filePath)) throw new InvalidOutputFilePathException();

        return outputFilePath;

    }

    public String getFinalFilePath(){
        return this.finalFilePath;
    }
}

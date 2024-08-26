package com.appvenir.imageoptimization.domain.imageOptimizer.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.appvenir.imageoptimization.domain.imageOptimizer.exception.InvalidFileTypeException;
import com.appvenir.imageoptimization.domain.imageOptimizer.exception.InvalidOutputFilePathException;

public class ImageFiles {

    public static String getFileName(String fileName){

        if (fileName == null) {
            throw new IllegalArgumentException("File name cannot be null");
        }

        Path path = Paths.get(fileName);

        String fileNameStr = path.getFileName().toString();

        int dotIndex = fileNameStr.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == 0) {
            throw new InvalidFileTypeException();
        }

        String extension = fileNameStr.substring(dotIndex + 1).toLowerCase();

        List<String> validExtensions = new ArrayList<>(Arrays.asList("jpg", "jpeg", "png"));

        if(!validExtensions.contains(extension)) throw new InvalidFileTypeException();

        return path.getFileName().toString();
    }

     public static String getFileName(Path fileName){

        

        if (fileName == null || fileName.getFileName() == null) {
            throw new IllegalArgumentException("File name cannot be null");
        }

        String fileNameStr = fileName.getFileName().toString();
        int dotIndex = fileNameStr.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == 0) {
            throw new InvalidFileTypeException();
        }

        String extension = fileNameStr.substring(dotIndex + 1).toLowerCase();

        List<String> validExtensions = new ArrayList<>(Arrays.asList("jpg", "jpeg", "png"));
        
        if(!validExtensions.contains(extension)) throw new InvalidFileTypeException();

        return fileName.getFileName().toString();
    }

    public static String getFileExtension(String fileName)
    {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == 0) {
            throw new IllegalArgumentException("File does not have an extension");
        }

       return fileName.substring(dotIndex + 1).toLowerCase();
    }

    public static String getOutputFilePath(String outputFilePath)
    {
        if (outputFilePath == null) {
            throw new IllegalArgumentException("File name cannot be null");
        }

        Path filePath = Paths.get(outputFilePath);

        if(!Files.isDirectory(filePath)) throw new InvalidOutputFilePathException();

        return outputFilePath;
    }
    
}

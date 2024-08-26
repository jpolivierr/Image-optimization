package com.appvenir.imageoptimization.domain.Optimizer.service.processors;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import com.appvenir.imageoptimization.domain.Optimizer.model.OptimizationContext;
import com.appvenir.imageoptimization.domain.Optimizer.service.factory.ImageOptimizerFactory;

public class ImageOptimizerProcessor implements OptimizerProcessor {

    private final boolean isDirectory;
    private final String path;
    private final ImageOptimizerFactory imageOptimizerFactory;

    public ImageOptimizerProcessor(OptimizationContext optimizationContext, ImageOptimizerFactory imageOptimizerFactory){
        this.isDirectory = optimizationContext.isDirectory();
        this.path = optimizationContext.getPath();
        this.imageOptimizerFactory = imageOptimizerFactory;
    }

    @Override
    public void process(){
        if(isDirectory){
            processDirectory(path);
        }
    }

    @Override
    public void processDirectory(String dir) {
        try {
            Path dirPath = Paths.get(dir);

            Files.walkFileTree(dirPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                    try {
                        var imageOptimizer = imageOptimizerFactory.getOptimizer(file);
                    imageOptimizer.run();
                    return FileVisitResult.CONTINUE;
                    } catch (Exception e) {
                       e.printStackTrace();
                       return FileVisitResult.CONTINUE;
                    }
                    
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("Failed to process file: " + file + " due to " + exc.getMessage());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.err.println("An error occurred while processing the directory: " + e.getMessage());
        }
    }

    @Override
    public void processFile(String file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processFile'");
    }
    
}

package com.appvenir.imageoptimization.domain.imageOptimizer.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.appvenir.imageoptimization.domain.imageOptimizer.exception.InvalidPathSyntaxException;
import com.appvenir.imageoptimization.domain.imageOptimizer.exception.NullTargetPathException;

public class IO {

    public static String getPath(String path) {
        if(path == null) throw new NullTargetPathException();
        String regex = "^/([^/]+/)*([^/]+)?$";
        boolean validPath =  path != null && path.matches(regex);
        if(!validPath) throw new InvalidPathSyntaxException(path);
        return path;
    }

    public static String getOutputPath(String targetPath, String outputPath){
        if(targetPath == null) throw new NullTargetPathException();
        String path = outputPath == null ? targetPath : outputPath;
        String regex = "^/([^/]+/)*([^/]+)?$";
        boolean validPath =  path != null && path.matches(regex);
        if(!validPath) throw new InvalidPathSyntaxException(path);
        return path;
    }

    public static boolean isAbsolutePath(String filePath){
        if(filePath == null) return false;
        Path path = Paths.get(filePath);
        return path.isAbsolute();
    }

    public static  boolean isDirectory(String filePath){
        if(filePath == null) throw new NullTargetPathException();
        Path path = Paths.get(filePath);
        return Files.isDirectory(path);
    }

    
}

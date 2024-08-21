package com.appvenir.imageoptimization.system;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class IO {

    public static boolean fileExist(String filePath){
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }
    
}

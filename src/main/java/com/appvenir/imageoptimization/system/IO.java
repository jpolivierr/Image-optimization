package com.appvenir.imageoptimization.system;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class IO {

    public static boolean fileExist(String filePath){
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }

    public static void deleteFilesInDirectory(String directoryPath) throws IOException {
        Path dir = Paths.get(directoryPath);

        // Ensure the directory exists
        if (Files.exists(dir) && Files.isDirectory(dir)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                for (Path filePath : stream) {
                    if (Files.isRegularFile(filePath)) {
                        Files.delete(filePath);
                    }
                }
            }
        }
    }
    
}

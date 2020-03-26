/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author PC
 */
public class FileUtils {

    public FileUtils() {
    }

    public static String getPath(String dirName, String fileName) {
        Path root = FileSystems.getDefault().getPath(dirName).toAbsolutePath();
        Path filePath = Paths.get(root.toString(), fileName);
        if (!filePath.isAbsolute()) {
            return null;
        }
        return filePath.toString();
    }

}

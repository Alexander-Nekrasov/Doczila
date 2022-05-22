package ru.alex.walk;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        List<File> fileList = new ArrayList<>();
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        searchFile(new File(properties.getProperty("directory")), fileList);

        Collections.sort(fileList);

        for (File file : fileList) {
            try {
                Files.write(Paths.get(properties.getProperty("saveFile")),
                        Files.readAllLines(file.toPath()), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void searchFile(File rootFile, List<File> fileList) {
        if (rootFile.isDirectory()) {
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFile(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".txt")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}

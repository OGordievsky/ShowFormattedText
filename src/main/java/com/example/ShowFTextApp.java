package com.example;

import com.example.controller.FormatTextController;
import com.example.util.ReadUserConsoleUtil;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public class ShowFTextApp {
    private static final String PROPERTIES = "ShowFormattedText.properties";
    private static final String DEFAULT_MEDIA = "media";
    private static final int[] resolution = new int[2];
    private static String fontName;
    private static int maxSymbols;
    private static int someWordsCount;
    private static Path fileUrl;

    public static void main(String[] args) {
        try {
            readProperties();
            Path foundedFile = ReadUserConsoleUtil.readConsoleFileUrl(DEFAULT_MEDIA);
            if (foundedFile != null){
                fileUrl = foundedFile;
            } else {
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        FormatTextController controller = new FormatTextController(fileUrl, fontName, resolution, maxSymbols, someWordsCount);
        controller.init();
    }


    private static void readProperties() throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties appProps = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream(PROPERTIES)) {
            appProps.load(resourceStream);
            fontName = appProps.getProperty("fontName");
            resolution[0] = Integer.parseInt(appProps.getProperty("windowWidth"));
            resolution[1] = Integer.parseInt(appProps.getProperty("windowHeight"));
            maxSymbols = Integer.parseInt(appProps.getProperty("maxSymbols"));
            someWordsCount = Integer.parseInt(appProps.getProperty("someWordsCount"));
        } catch (NumberFormatException | FileNotFoundException e) {
            throw new Exception(
                    String.format(
                            "This application crashed! Please check file into \"ProjectName\"/%1$s \n" +
                                    "this file may be contain next parameters: \n" +
                                    "com.example.ShowFTextApp.fontName = %2$s type \n" +
                                    "com.example.ShowFTextApp.windowWidth = %3$s type \n" +
                                    "com.example.ShowFTextApp.windowHeight = %3$s type \n" +
                                    "com.example.ShowFTextApp.maxSymbols = %3$s type \n",
                            PROPERTIES, "String", "positive integer")
            );
        }
    }
}
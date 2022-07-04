package com.example.init;

import com.example.controller.FormatTextController;
import com.example.utils.FindFileConsoleUtil;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public class ApplicationInit {
    private static final String DEFAULT_FOLDER = "media";
    private static final String PROPERTIES = "ShowFormattedText.properties";
    private static final String ERROR_MESSAGE = String.format(
            "This application crashed! Please check file \"ProjectName\"/%1$s \n" +
                    "this file may be contain next parameters: \n" +
                    "com.example.ShowTextApp.fontName = %2$s type \n" +
                    "com.example.ShowTextApp.windowWidth = %3$s type \n" +
                    "com.example.ShowTextApp.windowHeight = %3$s type \n" +
                    "com.example.ShowTextApp.maxSymbols = %3$s type \n",
            PROPERTIES, "String", "positive integer");

    public static int[] resolution = new int[2];
    public static String fontName;
    public static int maxSymbols;
    public static int someWordsCount;
    public static Path fileUrl;

    public static FormatTextController getMainController() throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try (InputStream inputProperties = loader.getResourceAsStream(PROPERTIES)) {
            Properties properties = new Properties();
            properties.load(inputProperties);
            fontName = properties.getProperty("fontName");
            resolution[0] = Integer.parseInt(properties.getProperty("windowWidth"));
            resolution[1] = Integer.parseInt(properties.getProperty("windowHeight"));
            maxSymbols = Integer.parseInt(properties.getProperty("maxSymbols"));
            someWordsCount = Integer.parseInt(properties.getProperty("someWordsCount"));

            FindFileConsoleUtil consoleUtil = new FindFileConsoleUtil();
            Path findFile = consoleUtil.getFileUrl(DEFAULT_FOLDER);
            if (findFile != null) {
                fileUrl = findFile;
            } else {
                System.out.println("File not found");
                System.exit(0);
            }
            return new FormatTextController(fileUrl, resolution, fontName, maxSymbols, someWordsCount);
        } catch (Exception e) {
            throw new Exception(ERROR_MESSAGE);
        }
    }
}
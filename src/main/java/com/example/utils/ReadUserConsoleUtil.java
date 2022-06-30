package com.example.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ReadUserConsoleUtil {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static Path getFileUrl(String defaultFileUrl) throws IOException {
        System.out.println("Please enter absolute (full) path to read file:");
        Path inputString = Paths.get(bufferedReader.readLine());
        if (inputString.isAbsolute()) {
            return findFile(inputString);
        } else {
            System.out.printf("Sorry, you enter incorrect path.\n" +
                    "But you can try to select file in the default folder: %s\n" +
                    "Enter Y confirm:", defaultFileUrl);
            String newInput = bufferedReader.readLine();
            String onlyConfirm = "[YyДд]";
            if (newInput.matches(onlyConfirm)) {
                return findFile(Paths.get(defaultFileUrl));
            }
        }
        return null;
    }

    private static Path findFile(Path inputUrl) throws IOException {
        if (Files.isRegularFile(inputUrl)) {
            return inputUrl;
        } else if (Files.isDirectory(inputUrl)) {
            List<Path> paths = Files.walk(inputUrl, 1).collect(Collectors.toList());
            ListIterator<Path> pathsIterator = paths.listIterator();
            while (pathsIterator.hasNext()) {
                System.out.println("index: " + (pathsIterator.nextIndex()) + " path: " + pathsIterator.next());
            }
            System.out.println("It's directory! Please enter index number for read path:");
            String newInput = bufferedReader.readLine();
            String onlyDigits = "[+]?\\d+";
            if (newInput.matches(onlyDigits)) {
                int index = Integer.parseInt(newInput);
                if (index >= 0 && index < paths.size()) {
                    return findFile(paths.get(index));
                } else {
                    System.out.println("Input wrong index");
                    return findFile(inputUrl);
                }
            }
        }
        return null;
    }
}

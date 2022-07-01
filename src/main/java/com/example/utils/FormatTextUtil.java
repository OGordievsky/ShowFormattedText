package com.example.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FormatTextUtil {

    public static List<String> cutTextLines(List<String> textLines, int maxSymbols) {
        List<String> result = new ArrayList<>();
        for (String line : textLines) {
            if (line.length() <= maxSymbols) {
                result.add(line + '\n');
            } else {
                result.addAll(cutString(line, maxSymbols));
            }
        }
        return result;
    }

    public static List<String> cutString(String line, int maxSymbols) {
        List<String> result = new ArrayList<>();
        if (line.length() > maxSymbols) {
            String cutStr = line.substring(0, maxSymbols + 1);
            int indexEndStr = cutStr.indexOf('\n') > 0 ? cutStr.indexOf('\n') : cutStr.lastIndexOf(' ');
            if (indexEndStr > 0) {
                result.add(line.substring(0, indexEndStr));
                indexEndStr++;
            } else {
                indexEndStr = maxSymbols;
                result.add(line.substring(0, maxSymbols));
            }
            result.addAll(cutString(line.substring(indexEndStr), maxSymbols));
        } else {
            result.add(line);
        }
        return result;
    }

    public static List<String> formatLines(List<String> textLines, int maxSymbols){
        return cutTextLines(textLines, maxSymbols).stream().map(line-> line + '\n').collect(Collectors.toList());
    }
}
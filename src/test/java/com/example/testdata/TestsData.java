package com.example.testdata;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TestsData {
    public static final Path FILE_TEST = Paths.get("src/test/java/com/example/testdata/testFile.txt");
    public static final String TEST_PROPERTIES =  "test.properties";

    public static String[] listFromFile = new String[]{
            "12 123 12 1 12 12 123 1234 12345 123456 1234567 12345678 123456789 1234567890 1234 12345678",
            "У лукоморья дуб зелёный;",
            "Златая цепь на дубе том:",
            "И днём и ночью кот учёный",
            "Всё ходит по цепи кругом;",
            "Two roads diverged in a yellow wood,",
            "And sorry I could not travel both",
            "And be one traveler, long I stood",
            "And looked down one as far as I could",
            "To where it bent in the undergrowth."
    };

    public static String[] cutList20 = new String[]{
            "12 123 12 1 12 12\n",
            "123 1234 12345\n",
            "123456 1234567\n",
            "12345678 123456789\n",
            "1234567890 1234\n",
            "12345678901234567890\r",
            "12345678901234567890\r",
            "12345678901234567890\r",
            "123456789012\n",
            "123 12\n",
            "1 12\n",
            "12\n",
            "123 1234 12345\n",
            "123456 1234567\n",
            "12345678 123456789\n",
            "1234567890 1234\n",
            "12345678\n",
            "12345678901234567890\r",
            "12345678901234567890\r",
            "12345678901234567890\n"
    };

    public static String[] formatList12 = new String[]{
            "123456789012\n",
            "345678901234\n",
            "567890123456\n",
            "789012345678\n",
            "901234567890\n",
            "Словами в\n",
            "исходном\n",
            "тексте\n",
            "считаются\n",
            "символы,\n",
            "ограниченные\n",
            "пробелами и \n",
            "переводами\n",
            "строк.\n"
    };



    public static String veryLongText = "12 123 12 1 12 12 123 1234 12345 123456 1234567 12345678 123456789 1234567890 1234 1234567890" +
            "123456789012345678901234567890123456789012345678901234567890" +
            "12\n123 12\n1 12\n12\n123 1234 12345 123456 1234567 12345678 123456789 1234567890 1234 12345678";

    public static String longtext = "123456789012345678901234567890123456789012345678901234567890";
    public static String text = "123456789012345678901234567890123456789012345678901234567890 Словами в исходном тексте считаются символы, ограниченные пробелами и \nпереводами строк.";

    public static List<String> getList(String... strings){
        List<String> stringList = new ArrayList<>();
        stringList.addAll(Arrays.asList(strings));
        return stringList;
    }
}

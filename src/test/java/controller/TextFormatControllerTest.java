package controller;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TextFormatControllerTest {


    @Test
    public void  cutStringTest() {
        String text = "12 123 12 1 12 12 123 1234 12345 123456 1234567 12345678 123456789 1234567890 1234 12345678";
        String longtext = "123456789012345678901234567890123456789012345678901234567890";
        String veryLongText = "Программа должна показывать содержи123456789012345678901234567" +
                "мое текстового файла в окне произвольного размера. Показываемый текст должен " +
                "быть отформатирован по левому краю окна. Слова, не помещающиеся на одной строке " +
                "следует целиком переносить на следующую строку";
        String veryLong = "Программа\n должна\n показывать \nсодержи123456789012345678901234567" +
                "мое текстового файла\n в\n окне произвольного размера.\n Показываемый текст должен " +
                "быть отформатирован по левому краю окна. Слова, не помещающиеся на одной строке " +
                "следует целиком переносить на следующую строку";
        String shStr1 = "12345678901234567890";
        String shStr2 = "123456789012345678901";
        String shStr3 = "1234567890123456789";

        TextFormatController formatController = new TextFormatController("D:\\projects\\ShowFormattedText\\media\\text.txt", 20);

        List<String> result1 = formatController.cutString(longtext);
        System.out.println(result1);
        List<String> result2 = formatController.cutString(text);
        System.out.println(result2);
        List<String> result3 = formatController.cutString(veryLongText);
        System.out.println(result3);
        List<String> result4 = formatController.cutString(veryLong);
        System.out.println(result4);
        List<String> result5 = formatController.cutString(shStr1);
        System.out.println(result5);
        List<String> result6 = formatController.cutString(shStr2);
        System.out.println(result6);
        List<String> result7 = formatController.cutString(shStr3);
        System.out.println(result7);



    }
}
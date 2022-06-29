package controller;

import model.GetFileData;
import model.TextFileModel;
import view.FormatTextFrame;

import java.util.ArrayList;
import java.util.List;

public class TextFormatController {
    private FormatTextFrame frame;
    GetFileData fileModel;
    private int maxSymbols;

    public TextFormatController(String fileUrl, int maxSymbols) {
        this.maxSymbols = maxSymbols;
        this.fileModel = new TextFileModel(fileUrl);
        this.frame = new FormatTextFrame();
    }


    List<String> getFormatText(List<String> text, int maxSymbols) {
        List<String> result = new ArrayList<>();
        for (String line : text) {
            if (line.length() <= maxSymbols) {
                result.add(line);
            } else {
                result.addAll(cutString(line));
            }
        }
        return result;
    }

    public List<String> cutString(String line) {
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
            result.addAll(cutString(line.substring(indexEndStr)));

        } else {
            result.add(line);
        }
        return result;
    }

    public void init() {
        List<String> strings = getFormatText(fileModel.getTextLines(), this.maxSymbols);
        frame.showTextWindow(strings);
    }
}

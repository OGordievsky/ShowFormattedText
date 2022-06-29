package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextFileModel extends AbstractFileModel {

    public TextFileModel(String url) {
        super(url);
    }

    @Override
    public List<String> getTextLines() {
        try {
            return Files.readAllLines(Paths.get(this.fileUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

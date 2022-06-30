package com.example.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextFileModel extends AbstractFileModel {

    public TextFileModel(Path url) {
        super(url);
    }

    @Override
    public List<String> getTextLines() {
        try {
            return Files.readAllLines(this.fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
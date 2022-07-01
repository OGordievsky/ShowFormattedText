package com.example.model;

import com.example.testdata.TestsData;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;

public class TextFileModelTest {

    @Test
    public void getTextLines() {
        TextFileModel textFileModel = new TextFileModel(TestsData.FILE_TEST);
        Assert.assertArrayEquals(TestsData.listFromFile, textFileModel.getTextLines().toArray());
    }

    @Test(expected = Exception.class)
    public void getEmptyLines() {
        TextFileModel textFileModel = new TextFileModel(Paths.get("a:/notfile.txt"));
        String[] emptyList = new String[2];
        Assert.assertArrayEquals(TestsData.listFromFile, textFileModel.getTextLines().toArray());
    }

}
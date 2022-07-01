package com.example.controller;

import com.example.model.GetFileData;
import com.example.model.TextFileModel;
import com.example.utils.FormatTextUtil;
import com.example.utils.ReadPropertiesUtil;
import com.example.utils.ReadUserConsoleUtil;
import com.example.view.FormatTextFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Path;
import java.util.Properties;

public class FormatTextController {
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

    private static int[] resolution = new int[2];
    private static String fontName;
    private static int maxSymbols;
    private static int someWordsCount;
    private static Path fileUrl;

    {
        try {
            Properties properties = ReadPropertiesUtil.getProperties(PROPERTIES, ERROR_MESSAGE);
            ReadUserConsoleUtil consoleUtil = new ReadUserConsoleUtil();
            fontName = properties.getProperty("fontName");
            resolution[0] = Integer.parseInt(properties.getProperty("windowWidth"));
            resolution[1] = Integer.parseInt(properties.getProperty("windowHeight"));
            maxSymbols = Integer.parseInt(properties.getProperty("maxSymbols"));
            someWordsCount = Integer.parseInt(properties.getProperty("someWordsCount"));
            Path findFile = consoleUtil.getFileUrl(DEFAULT_FOLDER);
            if (findFile!= null){
                fileUrl = findFile;
            } else {
                System.out.println("File not found");
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private GetFileData fileModel;
    private FormatTextFrame frame;

    public FormatTextController() {
        this.fileModel = new TextFileModel(fileUrl);
        this.frame = new FormatTextFrame(fontName, maxSymbols, someWordsCount);
        frame.setSize(resolution[0], resolution[1]);
    }

    public void init() {
//        frame.setContent(FormatTextUtil.cutTextLines(fileModel.getTextLines(), maxSymbols));
        frame.setContent(FormatTextUtil.formatLines(fileModel.getTextLines(), maxSymbols));
        initFrameListeners();
    }

    private void initFrameListeners() {
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        this.frame.addKeyListener(new KeyAdapter()
         {
            int scrollLines = 1;
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        frame.scroll(scrollLines);
                        break;
                    case KeyEvent.VK_DOWN:
                        frame.scroll(-scrollLines);
                        break;
                }
            }
        });
    }

    public GetFileData getFileModel() {
        return fileModel;
    }

    public FormatTextFrame getFrame() {
        return frame;
    }
}
package com.example.controller;

import com.example.model.GetFileData;
import com.example.model.TextFileModel;
import com.example.utils.FormatTextUtil;
import com.example.view.FormatTextFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Path;

public class FormatTextController {

    private GetFileData fileModel;
    private FormatTextFrame frame;

    public FormatTextController(Path fileUrl,int[] resolution, String fontName, int maxSymbols, int someWordsCount ) {
        this.fileModel = new TextFileModel(fileUrl);
        this.frame = new FormatTextFrame(fontName, maxSymbols, someWordsCount);
        frame.setSize(resolution[0], resolution[1]);
    }
    public void start() {
        frame.setContent(FormatTextUtil.cutTextLines(fileModel.getTextLines(), frame.getPanel().getMaxSymbols()));
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
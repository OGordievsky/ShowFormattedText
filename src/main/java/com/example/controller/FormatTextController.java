package com.example.controller;

import com.example.util.FormatTextUtil;
import com.example.model.GetFileData;
import com.example.model.TextFileModel;
import com.example.view.FTextFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Path;
import java.util.List;

public class FormatTextController {
    private FTextFrame frame;
    private GetFileData fileModel;
    private int maxSymbols;


    public FormatTextController(Path fileUrl, String fontName, int[] resolution, int maxSymbols, int someWordsCount) {
        this.maxSymbols = maxSymbols;
        this.fileModel = new TextFileModel(fileUrl);
        this.frame = new FTextFrame(fontName, maxSymbols, someWordsCount);
        frame.setSize(resolution[0], resolution[1]);
        initFrameListeners();
    }

    private void initFrameListeners() {
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        this.frame.addKeyListener(new KeyListener() {
            int scrollLines = 1;

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        frame.scroll(scrollLines);
                        break;
                    case KeyEvent.VK_DOWN:
                        frame.scroll(-scrollLines);
                        break;
                    default:
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public void init() {
        List<String> strings = FormatTextUtil.cutTextLines(fileModel.getTextLines(), maxSymbols);
        frame.showTextPanel(strings);
    }
}

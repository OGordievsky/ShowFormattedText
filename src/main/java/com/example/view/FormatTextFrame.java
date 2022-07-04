package com.example.view;

import com.example.view.panel.FormatTextPanel;

import java.awt.*;
import java.util.List;

public class FormatTextFrame extends Frame {
    FormatTextPanel panel;

    public FormatTextFrame(String fontName, int maxSymbols, int someWordsCount) {
        this.panel = new FormatTextPanel(fontName, maxSymbols, someWordsCount);
        this.panel.setFocusable(false);
        this.add(panel);
        this.setVisible(true);
    }

    public void setContent(List<String> Content) {
         panel.setContent(Content);
    }

    public void scroll(int lines) {
        this.panel.scroll(lines);
        this.panel.revalidate();
        this.panel.repaint();
    }

    public FormatTextPanel getPanel() {
        return panel;
    }
}
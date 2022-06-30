package com.example.view;

import java.awt.*;
import java.util.List;

public class FTextFrame extends Frame {
    List<String> stringList;
    String fontName;
    int maxSymbols;
    int someWords;
    Panel panel;
    private int scrollPos = 1;
    private int rightBorder = 1;

    public FTextFrame(String fontName, int maxSymbols, int someWords) {
        this.maxSymbols = maxSymbols;
        this.someWords = someWords;
        this.fontName = fontName;
        this.panel = new FormatTextPanel();
        this.add(panel);
        this.setVisible(true);
    }

    public void showTextPanel(List<String> stringList) {
        this.stringList = stringList;
    }

    public void scroll(int pos) {
        this.scrollPos = Math.min(Math.max(this.scrollPos + pos, -stringList.size()), 1);
        this.panel.revalidate();
        this.panel.repaint();
    }

    private class FormatTextPanel extends Panel {

        @Override
        public void paint(Graphics g) {
            paintFormatText(g);
        }

        private void paintFormatText(Graphics g) {
            int defaultFontSize = (int) (this.getWidth() / (maxSymbols / 2 + rightBorder));
            Font[] fonts = new Font[]{
                    new Font(fontName, Font.PLAIN, defaultFontSize),
                    new Font(fontName, Font.PLAIN, (int) (defaultFontSize * 0.75)) //"Arial"
            };

            int countWords = 1;
            for (int i = 0; i < stringList.size(); i++) {
                int xPos = 0;
                String[] words = stringList.get(i).split("\\b");
                for (String word : words) {
                    if (word.matches("\\S+")) {
                        countWords++;
                    }
                    Font font = fonts[(countWords / someWords) % 2];
                    g.setFont(font);
                    g.drawString(word, xPos, getFontMetrics(fonts[0]).getHeight() * (i + scrollPos));
                    xPos += getFontMetrics(font).stringWidth(word);
                }
            }
        }
    }
}
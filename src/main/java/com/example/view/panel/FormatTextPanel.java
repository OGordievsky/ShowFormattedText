package com.example.view.panel;

import java.awt.*;
import java.util.List;

public class FormatTextPanel extends AbstractScrollPanel implements TextContent {
    private String fontName;
    private int maxSymbols;
    private int someWords;

    public FormatTextPanel(String fontName, int maxSymbols, int someWords) {
        super( 1, 0, 1);
        this.fontName = fontName;
        this.maxSymbols = maxSymbols != 0 ? maxSymbols : 1;
        this.someWords = someWords != 0 ? someWords : 1;
    }

    @Override
    public void scroll(int lines) {
        this.scrollPos += lines;
    }

    @Override
    public void paint(Graphics g) {
        List<String> stringList = textContent;
        int fontSize = (this.getWidth() / (maxSymbols / 2 + rightBorder));
        Font[] fonts = new Font[]{
                new Font(fontName, Font.PLAIN, fontSize),
                new Font(fontName, Font.PLAIN, (int) (fontSize * 0.75))
        };
        int fontHeight = getFontMetrics(fonts[0]).getHeight();
        scrollPos = Math.min(Math.max(scrollPos, (this.getHeight() / fontHeight - textContent.size())), 1);

        int countWords = 0;
        for (int i = 0; i < textContent.size(); i++) {
            int xPos = leftBorder;
            String line = textContent.get(i);
            StringBuilder word = new StringBuilder();
            for (char ch : line.toCharArray()) {
                word.append(ch);
                if (ch == ' ' || ch == '\n') {
                    xPos = paintWord(g, fonts, fontHeight, countWords, i, xPos, word);
                    countWords++;
                } else if ( ch == '\r') {
                    xPos = paintWord(g, fonts, fontHeight, countWords, i, xPos, word);
                }
            }
        }
    }

    private int paintWord(Graphics g, Font[] fonts, int fontHeight, int countWords, int i, int xPos, StringBuilder word) {
        Font font = fonts[(countWords / someWords) % fonts.length];
        g.setFont(font);
        g.drawString(word.toString(), xPos, fontHeight * (i + scrollPos));
        xPos += getFontMetrics(font).stringWidth(word.toString());
        word.setLength(0);
        return xPos;
    }

    public String getFontName() {
        return fontName;
    }

    public int getMaxSymbols() {
        return maxSymbols;
    }

    public int getSomeWords() {
        return someWords;
    }
}

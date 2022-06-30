package com.example.view.panel;

import java.awt.*;

public class FormatTextPanel extends AbstractScrollPanel implements TextContent {
    private String fontName;
    private int rightBorder;
    private int maxSymbols;
    private int someWords;

    public FormatTextPanel(String fontName, int maxSymbols, int someWords) {
        super( 1);
        this.fontName = fontName;
        this.rightBorder = 1;
        this.maxSymbols = maxSymbols != 0 ? maxSymbols : 1;
        this.someWords = someWords != 0 ? someWords : 1;
    }


    @Override
    public void scroll(int lines) {
        this.scrollPos += lines;
    }

    @Override
    public void paint(Graphics g) {
        int fontSize = (this.getWidth() / (maxSymbols / 2 + rightBorder));
        Font[] fonts = new Font[]{
                new Font(fontName, Font.PLAIN, fontSize),
                new Font(fontName, Font.PLAIN, (int) (fontSize * 0.75))
        };
        int fontHeight = getFontMetrics(fonts[0]).getHeight();
        scrollPos = Math.min(Math.max(scrollPos, (this.getHeight() / fontHeight - textContent.size())), 1);

        int countWords = 1;
        for (int i = 0; i < textContent.size(); i++) {
            int xPos = 0;
            String[] words = textContent.get(i).split("\\b");
            for (String word : words) {
                String anyWord = "[a-zA-Zа-яА-Я]+";
                if (word.matches(anyWord)) {
                    countWords++;
                }
                Font font = fonts[(countWords / someWords) % 2];
                g.setFont(font);
                g.drawString(word, xPos, fontHeight * (i + scrollPos));
                xPos += getFontMetrics(font).stringWidth(word);
            }
        }
    }

    public void setRightBorder(int rightBorder) {
        this.rightBorder = rightBorder;
    }
}

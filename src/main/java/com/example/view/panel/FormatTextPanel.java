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
            /*
            //like how it works, but not correct for task
            String[] words = textContent.get(i).split("\\b");
            for (String word : words) {
                String anyWord = "[a-zA-Zа-яА-Я]+";
                if (word.matches(anyWord)) {
                    countWords++;
                }
                Font font = fonts[(countWords / someWords) % fonts.length];
                g.setFont(font);
                g.drawString(word, xPos, fontHeight * (i + scrollPos));
                xPos += getFontMetrics(font).stringWidth(word);
            }
             */
            String line = textContent.get(i);
            StringBuilder word = new StringBuilder();
            for (char ch : line.toCharArray()) {
                word.append(ch);
                if (ch == ' ' || ch == '\n') {
                    countWords++;
                    Font font = fonts[(countWords / someWords) % fonts.length];
                    g.setFont(font);
                    g.drawString(word.toString(), xPos, fontHeight * (i + scrollPos));
                    xPos += getFontMetrics(font).stringWidth(word.toString());
                    word.setLength(0);
                }
            }
        }
    }

    public void setRightBorder(int rightBorder) {
        this.rightBorder = rightBorder;
    }
}

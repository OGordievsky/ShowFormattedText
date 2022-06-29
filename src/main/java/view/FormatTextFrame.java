package view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class FormatTextFrame extends Frame {
    List<String> stringList;

    public FormatTextFrame() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void showTextWindow(List<String> strings) {
        this.stringList = strings;
        FormatTextFrame frame = new FormatTextFrame();
        frame.setSize(400, 300);
        Panel panel = new TextPanel();
        frame.add(panel);
        frame.setVisible(true);
    }

    private class TextPanel extends Panel {


        @Override
        public void paint(Graphics g) {
            int defaultFontSize = (int) (this.getWidth()/11);
            int countWords = 1;

            Font[] fonts = new Font[]{
                    new Font("Arial", Font.PLAIN, defaultFontSize),
                    new Font("Arial", Font.PLAIN, defaultFontSize),
                    new Font("Arial", Font.PLAIN, (int) (defaultFontSize * 0.8)),
                    new Font("Arial", Font.PLAIN, (int) (defaultFontSize * 0.8))
            };

            for (int i = 0; i < stringList.size(); i++) {
                int xPos = 0;
                String[] words = stringList.get(i).split("\\b");
                for (String word: words){
                    if (word.matches("\\S+")){
                        countWords++;
                    }
                    Font font = fonts[(countWords)%4];
                    g.setFont(font);
                    g.drawString(word, xPos, getFontMetrics(fonts[0]).getHeight() * (i + 1));
                    xPos += getFontMetrics(font).stringWidth(word);
                }
            }
        }
    }
}

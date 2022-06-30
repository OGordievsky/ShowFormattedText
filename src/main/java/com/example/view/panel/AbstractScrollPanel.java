package com.example.view.panel;

import java.awt.*;

public abstract class AbstractScrollPanel extends Panel {
    int scrollPos;

    AbstractScrollPanel(int scrollPos) {
        this.scrollPos = scrollPos;
    }

    public abstract void scroll(int lines);
}
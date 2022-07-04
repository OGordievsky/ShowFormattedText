package com.example.view.panel;

import java.awt.*;

public abstract class AbstractScrollPanel extends Panel {
    protected int scrollPos;
    protected int rightBorder;
    protected int leftBorder;

    AbstractScrollPanel(int rightBorder, int leftBorder, int scrollPos) {
        this.rightBorder = rightBorder;
        this.leftBorder = leftBorder;
        this.scrollPos = scrollPos;
    }

    public abstract void scroll(int lines);

    public int getRightBorder() {
        return rightBorder;
    }

    public int getLeftBorder() {
        return leftBorder;
    }

    public int getScrollPos(){
        return this.scrollPos;
    }

    public void setScrollPos(int scrollPos) {
        this.scrollPos = scrollPos;
    }

    public void setRightBorder(int rightBorder) {
        this.rightBorder = rightBorder;
    }

    public void setLeftBorder(int leftBorder) {
        this.leftBorder = leftBorder;
    }
}
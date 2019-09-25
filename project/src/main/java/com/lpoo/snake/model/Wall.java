package com.lpoo.snake.Model;

public class Wall extends Element {
    private boolean horizontal;
    private int thickness;
    private int length;

    public Wall(Position pos, int length, int thickness, boolean horizontal) {
        super(pos);
        this.horizontal = horizontal;
        this.thickness = thickness;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getThickness() {
        return thickness;
    }

    public boolean isHorizontal() {
        return horizontal;
    }
}

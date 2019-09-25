package com.lpoo.snake.Model;

public class BigApple extends Element {

    private int timeForEnd;
    private boolean active;

    public BigApple(Position pos) {
        super(pos);
        timeForEnd = -1;
        active = false;
    }

    public boolean isActive() {
        return active;
    }

    public int getTimeForEnd() {
        return timeForEnd;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setTimeForEnd(int timeForEnd) {
        this.timeForEnd = timeForEnd;
    }

    public void subTimeForEnd() {
        this.timeForEnd -= 1;
    }
}

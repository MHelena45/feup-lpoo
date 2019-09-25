package com.lpoo.snake.Model;

public class Obstacle extends Element {

    private boolean active, black;

    public Obstacle(Position position) {
        super(position);
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }
}

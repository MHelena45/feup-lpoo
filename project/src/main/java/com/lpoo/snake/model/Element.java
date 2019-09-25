package com.lpoo.snake.Model;

import java.util.LinkedList;

public class Element {

    protected Position position;

    Element(Position pos) {
        position = pos;
    }

    public Position getPosition() {
        return position;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public void setPosition(Position pos) {
        this.position = pos;
    }

    public static boolean collision(Element e1, Element e2) {
        if (e1.getPosition().equals(e2.getPosition()))
            return true;
        return false;
    }

    public static boolean collision(Element e, LinkedList<Position> pos) {
        for (Position p : pos) {
            if (p.equals(e.getPosition()))
                return true;
        }
        return false;
    }
}

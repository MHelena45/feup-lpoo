package com.lpoo.snake.Model;

public class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position pos) {
        this.x = pos.x;
        this.y = pos.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void positionSum(Position pos) {
        this.x += pos.x;
        this.y += pos.y;
    }

    public static Position getRandomPosition(int offset, int width, int height) {
        int horizontalMax = width - offset - 1;
        int verticalMax = height - offset - 1;
        int min = offset;

        int randomX = (int) (Math.random() * (horizontalMax - min) + min);
        int randomY = (int) (Math.random() * (verticalMax - min) + min);
        return new Position(randomX, randomY);
    }

    public static Position getRandomDirection() {
        int randomNumber = (int) (Math.random() * 20 + 1);
        int xDirection = 0, yDirection = 0;
        if (randomNumber > 10)
            xDirection = (randomNumber > 15) ? 1 : -1;
        else
            yDirection = (randomNumber > 5) ? 1 : -1;
        return new Position(xDirection, yDirection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (getClass() != o.getClass())
            return false;

        Position p = (Position) o;
        return x == p.getX() && y == p.getY();
    }
}

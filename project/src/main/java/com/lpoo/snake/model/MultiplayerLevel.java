package com.lpoo.snake.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MultiplayerLevel implements Level {
    private Element apple;
    private BigApple bigApple;
    private List<Wall> walls;
    private List<Element> elements;
    private Snake snake1;
    private Snake snake2;
    private final int snakeSize = 6;
    private int wallSize;
    private int width;
    private int height;

    public MultiplayerLevel(int width, int height, int wallSize) throws IOException {
        this.width = width;
        this.height = height;
        this.wallSize = wallSize;
        elements = new ArrayList<>();
        buildElements();
    }

    public Snake getSnake1() {
        return snake1;
    }

    public Snake getSnake2() {
        return snake2;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public BigApple getBigApple() {
        return bigApple;
    }

    public Element getApple() {
        return apple;
    }

    public void buildElements() {
        snake1 = ElementFactory.getSnakeRandom(width, height, snakeSize, wallSize);
        elements.add(snake1);

        snake2 = ElementFactory.getSnakeRandom(width, height, snakeSize, wallSize);
        elements.add(snake2);

        apple = ElementFactory.getElementRandom("Element", wallSize, width, height);
        elements.add(apple);

        bigApple = (BigApple) ElementFactory.getElement("BigApple", new Position(15, 15));
        elements.add(bigApple);

        walls = ElementFactory.getWalls(width, height, wallSize);
        elements.addAll(walls);
    }

    private boolean checkNormalCollision(Snake snake) throws IOException {
        if (snake.hasEatenSelf() || snake.outOfBounds(width, height, wallSize))
            return true;

        if (Element.collision(snake, apple)) {
            snake.grow(20);
            apple.setPosition(Position.getRandomPosition(wallSize, width, height));
        }

        if (Element.collision(snake, bigApple) && bigApple.getTimeForEnd() > 0) {
            bigApple.setTimeForEnd(-1);
            snake.grow(40);
        }
        return false;
    }

    public boolean checkCollision() throws IOException {
        if (checkNormalCollision(snake1) || checkNormalCollision(snake2))
            return true;

        if (Element.collision(snake1, snake2) || Element.collision(snake1, snake2.tail())
                || Element.collision(snake2, snake1.tail())) // Temporary, different points for different
                                                             // collisions?
            return true;

        return false;
    }

    public void update() throws IOException {
        bigApple.subTimeForEnd();
        snake1.update();
        snake2.update();
    }

    public void spawnBigApple() {
        bigApple.setActive(true);
        bigApple.setPosition(Position.getRandomPosition(wallSize, width, height));
        bigApple.setTimeForEnd(20);
    }
}

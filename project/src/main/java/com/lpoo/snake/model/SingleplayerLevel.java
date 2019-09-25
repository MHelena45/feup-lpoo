package com.lpoo.snake.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SingleplayerLevel implements Level {
    private Element apple;
    private BigApple bigApple;
    private Snake snake;
    private Obstacle obstacle;
    private final int snakeSize = 6;
    private int wallSize;
    private List<Element> elements;
    private List<Wall> walls;
    private List<Obstacle> obstacles;
    private int width;
    private int height;

    public SingleplayerLevel(int width, int height, int wallSize) {
        this.width = width;
        this.height = height;
        this.wallSize = wallSize;
        elements = new ArrayList<>();
        obstacles = new ArrayList<>();
        buildElements();
    }

    public Snake getSnake() {
        return snake;
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

    private void buildElements() {
        snake = ElementFactory.getSnakeRandom(width, height, snakeSize, wallSize);
        elements.add(snake);

        apple = ElementFactory.getElementRandom("Element", wallSize, width, height);
        elements.add(apple);

        bigApple = (BigApple) ElementFactory.getElement("BigApple", new Position(15, 15));
        elements.add(bigApple);

        walls = ElementFactory.getWalls(width, height, wallSize);
        elements.addAll(walls);

        obstacle = (Obstacle) ElementFactory.getElementRandom("Obstacle", wallSize, width, height);
        obstacles.add(obstacle);
    }

    public boolean checkCollision() throws IOException {
        // Snake head colission with self or bounds
        if (snake.hasEatenSelf() || snake.outOfBounds(width, height, wallSize))
            return true;
        // Snake collision with apple
        if (Element.collision(snake, apple)) {
            snake.grow(20);
            apple.setPosition(Position.getRandomPosition(wallSize, width, height));
        }
        // Snake collision with big apple
        if (Element.collision(snake, bigApple) && bigApple.getTimeForEnd() > 0) {
            bigApple.setActive(false);
            bigApple.setTimeForEnd(-1);
            snake.grow(40);
        }
        // Snake collision with obstacles
        for (Obstacle obstacle : obstacles) {
            /* test if snake collide with any part of the snake */
            if (obstacle.isActive()
                    && (Element.collision(snake, obstacle) || Element.collision(obstacle, snake.tail()))) {
                return true;
            }
        }
        return false;
    }

    public void update() {
        snake.update();
    }

    public void addObstacle() {
        obstacles.add((Obstacle) ElementFactory.getElementRandom("Obstacle", wallSize, width, height));
    }

    public void spawnBigApple() {
        bigApple.setActive(true);
        bigApple.setPosition(Position.getRandomPosition(wallSize, width, height));
        bigApple.setTimeForEnd(20);
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public Obstacle getLast() {
        return obstacles.get(obstacles.size() - 1);
    }
}

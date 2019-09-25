package com.lpoo.snake.Model;

import java.util.ArrayList;
import java.util.List;

public class ElementFactory {
    public static Element getElement(String type, Position pos) {

        switch (type) {
        case "BigApple":
            return new BigApple(pos);
        case "Element":
            return new Element(pos);
        case "Obstacle":
            return new Element(pos);
        default:
            return new Element(new Position(0, 0));
        }
    }

    public static Element getElementRandom(String type, int wallSize, int width, int height) {
        Position randomPos = Position.getRandomPosition(wallSize, width, height);
        switch (type) {
        case "BigApple":
            return new BigApple(randomPos);
        case "Apple":
            return new Element(randomPos);
        case "Obstacle":
            return new Obstacle(randomPos);
        default:
            return new Element(randomPos);
        }
    }

    public static Snake getSnakeRandom(int width, int height, int snakeSize, int gameSize) {
        Snake snake = null;
        Position initialSnakePos = Position.getRandomPosition(gameSize + snakeSize, width, height);
        try {
            snake = new Snake(initialSnakePos, snakeSize, Position.getRandomDirection());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return snake;
    }

    public static List<Wall> getWalls(int width, int height, int gameSize) {
        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(new Position(0, 0), width, gameSize, true));
        walls.add(new Wall(new Position(0, 0), height, gameSize, false));
        walls.add(new Wall(new Position(0, height - gameSize), width, gameSize, true));
        walls.add(new Wall(new Position(width - gameSize, 0), height, gameSize, false));
        return walls;
    }
}

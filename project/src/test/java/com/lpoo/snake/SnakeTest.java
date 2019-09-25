package com.lpoo.snake;

import com.lpoo.snake.Controller.Timer;
import com.lpoo.snake.Model.commands.*;
import org.junit.Before;
import org.junit.Test;
import com.lpoo.snake.Model.*;

import static com.lpoo.snake.Controller.Lanterna.LGameController.getGame;
import static org.junit.Assert.assertEquals;

public class SnakeTest {
    Position snakePosition;
    Position snakeDirection;
    RightCommand rightCommand = new RightCommand();
    LeftCommand leftCommand = new LeftCommand();
    DownCommand downCommand = new DownCommand();

    @Before
    public void setUp() {
        snakePosition = new Position(10, 10);
        snakeDirection = Position.getRandomDirection();

    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorException() throws Exception {
        Position direction = new Position(5, -3);
        new Snake(snakePosition, 4, direction);
    }

    @Test
    public void constructor() {
        try {
            Position direction = new Position(5, -3);
            new Snake(snakePosition, 4, direction);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Direction values must be between 1 and -1");
        }
    }

    @Test
    public void score() {
        Snake snake = new Snake(snakePosition, 5, snakeDirection);
        assertEquals(0, snake.getScore());
    }

    @Test
    public void update() {
        Snake snake = new Snake(snakePosition, 5, snakeDirection);
        assertEquals(snakePosition.getX() , snake.head().getX());
        assertEquals(snakePosition.getY() , snake.head().getY());
        snake.update();
        Timer gameTimer = new Timer(1000 / (4 + getGame().getLevel() * 3));
        if(gameTimer.IsUpdateTime()) {
        assertEquals(snakePosition.getX() + snakeDirection.getX(), snake.head().getX());
        assertEquals(snakePosition.getY() + snakeDirection.getY(), snake.head().getY());}
    }

    @Test
    public void grow() {
        Snake snake = new Snake(snakePosition, 5, snakeDirection);
        snake.grow(20);
        snake.update();
        assertEquals(6, snake.size());
    }

    @Test
    public void hasEatenSelf() {
        UpCommand upCommand = new UpCommand();
        Position dir = new Position(1, 0);
        Snake snake = new Snake(snakePosition, 20, dir);
        snake.update();
        assertEquals(false, snake.hasEatenSelf());
        upCommand.execute(snake);
        snake.update();
        assertEquals(false, snake.hasEatenSelf());
        leftCommand.execute(snake);
        snake.update();
        assertEquals(false, snake.hasEatenSelf());
        downCommand.execute(snake);
        snake.update();
        assertEquals(true, snake.hasEatenSelf());
    }

    @Test
    public void outOfBounds() {
        Snake snake = new Snake(snakePosition, 20, snakeDirection);
        rightCommand.execute(snake);
        /*
         * assertEquals(true, snake.outOfBounds(11, 20)); assertEquals(true,
         * snake.outOfBounds(11, 21)); assertEquals(false, snake.outOfBounds(12, 20));
         */
    }

}

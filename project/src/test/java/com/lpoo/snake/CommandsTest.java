package com.lpoo.snake;

import com.lpoo.snake.Controller.Timer;
import com.lpoo.snake.Model.commands.*;
import com.lpoo.snake.Model.*;
import org.junit.Before;
import org.junit.Test;

import static com.lpoo.snake.Controller.Lanterna.LGameController.getGame;
import static org.junit.Assert.assertEquals;

public class CommandsTest {
    Position snakePosition;
    Position snakeDirection;
    RightCommand rightCommand = new RightCommand();
    LeftCommand leftCommand = new LeftCommand();
    UpCommand upCommand = new UpCommand();
    DownCommand downCommand = new DownCommand();

    @Before
    public void setUp() {
        snakePosition = new Position(10, 10);
        snakeDirection = Position.getRandomDirection();
    }

    @Test
    public void moveUp() {
        Position dir1 = new Position(1, 0);
        Snake snake1 = new Snake(snakePosition, 5, dir1);
        assertEquals(snakePosition.getX(), snake1.getPosition().getX());
        assertEquals(snakePosition.getY() , snake1.getPosition().getY());
        assertEquals(true, upCommand.execute(snake1));
        Timer gameTimer = new Timer(1000 / (4 + getGame().getLevel() * 3));
        if(gameTimer.IsUpdateTime())
            assertEquals(snakePosition.getY() + 1, snake1.getPosition().getY());
        Position dir = new Position(0, 1);
        Snake snake = new Snake(snakePosition, 5, dir);
        assertEquals(false, upCommand.execute(snake));
        Position dir2 = new Position(0, -1);
        Snake snake2 = new Snake(snakePosition, 5, dir2);
        assertEquals(false, upCommand.execute(snake2));
        Position dir3 = new Position(-1, 0);
        Snake snake3 = new Snake(snakePosition, 5, dir3);
        assertEquals(true, upCommand.execute(snake3));
    }

    @Test
    public void moveDown() {
        Position dir1 = new Position(1, 0);
        Snake snake1 = new Snake(snakePosition, 5, dir1);
        assertEquals(true, downCommand.execute(snake1));
        Timer gameTimer = new Timer(1000 / (4 + getGame().getLevel() * 3));
        if(gameTimer.IsUpdateTime()){
            assertEquals(snakePosition.getX(), snake1.getPosition().getX());
            assertEquals(snakePosition.getY() + 1, snake1.getPosition().getY());
        }
        Position dir = new Position(0, 1);
        Snake snake = new Snake(snakePosition, 5, dir);
        assertEquals(false, downCommand.execute(snake));
        assertEquals(snakePosition.getX(), snake.getPosition().getX());
        Position dir2 = new Position(0, -1);
        Snake snake2 = new Snake(snakePosition, 5, dir2);
        assertEquals(false, downCommand.execute(snake2));
        Position dir3 = new Position(-1, 0);
        Snake snake3 = new Snake(snakePosition, 5, dir3);
        assertEquals(true, downCommand.execute(snake3));
    }

    @Test
    public void moveLeft() {
        Position dir = new Position(0, 1);
        Snake snake = new Snake(snakePosition, 5, dir);
        snake.update();
        assertEquals(true, leftCommand.execute(snake));
        Timer gameTimer = new Timer(1000 / (4 + getGame().getLevel() * 3));
        if(gameTimer.IsUpdateTime()){
            assertEquals(snakePosition.getX() - 1, snake.getPosition().getX());
            assertEquals(snakePosition.getY(), snake.getPosition().getY());
        }
        assertEquals(snakePosition.getY(), snake.getPosition().getY());
        Position dir1 = new Position(1, 0);
        Snake snake1 = new Snake(snakePosition, 5, dir1);
        assertEquals(false, leftCommand.execute(snake1));
        Position dir2 = new Position(0, -1);
        Snake snake2 = new Snake(snakePosition, 5, dir2);
        assertEquals(true, leftCommand.execute(snake2));
        Position dir3 = new Position(-1, 0);
        Snake snake3 = new Snake(snakePosition, 5, dir3);
        assertEquals(false, leftCommand.execute(snake3));
    }

    @Test
    public void moveRight() {
        Position dir = new Position(0, 1);
        Snake snake = new Snake(snakePosition, 5, dir);
        assertEquals(true, rightCommand.execute(snake));
        Timer gameTimer = new Timer(1000 / (4 + getGame().getLevel() * 3));
        if(gameTimer.IsUpdateTime()) {
            assertEquals(snakePosition.getX() + 1, snake.getPosition().getX());
            assertEquals(snakePosition.getY(), snake.getPosition().getY());
        }
        Position dir1 = new Position(1, 0);
        Snake snake1 = new Snake(snakePosition, 5, dir1);
        assertEquals(false, rightCommand.execute(snake1));
        Position dir2 = new Position(0, -1);
        Snake snake2 = new Snake(snakePosition, 5, dir2);
        assertEquals(true, rightCommand.execute(snake2));
        Position dir3 = new Position(-1, 0);
        Snake snake3 = new Snake(snakePosition, 5, dir3);
        assertEquals(false, rightCommand.execute(snake3));
    }

    @Test
    public void move() {
        Position dir = new Position(1, 0);
        Snake snake = new Snake(snakePosition, 5, dir);
        assertEquals(true, upCommand.execute(snake));
        Timer gameTimer = new Timer(1000 / (4 + getGame().getLevel() * 3));
        if(gameTimer.IsUpdateTime())
            assertEquals(snakePosition.getY()- 1 , snake.head().getY());
        leftCommand.execute(snake);
        gameTimer.resetTimer();
        if(gameTimer.IsUpdateTime())
            assertEquals(snakePosition.getX() -1 , snake.head().getX());
        downCommand.execute(snake);
        gameTimer.resetTimer();
        if(gameTimer.IsUpdateTime())
            assertEquals(snakePosition.getY() + 1, snake.head().getY());
        rightCommand.execute(snake);
        gameTimer.resetTimer();
        if(gameTimer.IsUpdateTime())
            assertEquals(snakePosition.getX() +1, snake.head().getX());
    }

}

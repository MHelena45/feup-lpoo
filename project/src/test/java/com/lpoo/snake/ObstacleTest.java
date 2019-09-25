package com.lpoo.snake;

import com.lpoo.snake.Controller.Timer;
import com.lpoo.snake.Model.Obstacle;
import com.lpoo.snake.Model.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObstacleTest {
    Position pos = new Position(10, 10);
    Obstacle obstacle = new Obstacle(pos);

    @Test
    public void TestCoords() {
        assertEquals(10, obstacle.getPosition().getX());
        assertEquals(10, obstacle.getPosition().getY());
    }

    @Test
    public void TestSetCoods() {
        Position pos = new Position(5, 9);
        obstacle.setPosition(pos);
        assertEquals(pos, obstacle.getPosition());
    }

    @Test
    public void TestisActivite() {
        Timer obstacletimeForFixed = new Timer(10000);
        assertEquals(false, obstacle.isActive());
        while (obstacletimeForFixed.IsUpdateTime()) {
        }
        assertEquals(false, obstacle.isActive());
    }

    @Test
    public void TestgetActivite() {
        obstacle.setActive(true);
        assertEquals(true, obstacle.isActive());
    }
}

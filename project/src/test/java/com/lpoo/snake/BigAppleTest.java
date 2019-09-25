package com.lpoo.snake;

import org.junit.Test;
import com.lpoo.snake.Model.*;
import static org.junit.Assert.assertEquals;

public class BigAppleTest {
    BigApple bigApple = new BigApple(new Position(6, 3));

    @Test
    public void TestCoords() {
        assertEquals(6, bigApple.getPosition().getX());
        assertEquals(3, bigApple.getPosition().getY());
    }

    @Test
    public void TestSetCoods() {
        Position pos = new Position(5, 9);
        bigApple.setPosition(pos);
        assertEquals(pos, bigApple.getPosition());
    }
}

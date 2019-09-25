package com.lpoo.snake;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.lpoo.snake.Model.*;

public class PositionTest {
    Position position = new Position(2, 3);

    @Test
    public void TestCoords() {
        assertEquals(2, position.getX());
        assertEquals(3, position.getY());
    }

    @Test
    public void TestSetCoords() {
        position.setX(1);
        position.setY(5);
        assertEquals(1, position.getX());
        assertEquals(5, position.getY());
    }

    @Test
    public void TestPositionSum() {
        int x = position.getX();
        int y = position.getY();
        Position pos = new Position(1, 1);
        position.positionSum(pos);
        assertEquals(x + 1, position.getX());
        assertEquals(y + 1, position.getY());
    }

    @Test
    public void TestEquality() {
        Position position1 = new Position(2, 3);
        assertEquals(position1, position);
    }
}

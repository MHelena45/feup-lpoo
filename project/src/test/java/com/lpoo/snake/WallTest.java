package com.lpoo.snake;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.lpoo.snake.Model.*;

public class WallTest {
    Wall wall = new Wall(new Position(7, 3), 4, 5, true);

    @Test
    public void gettersTest() {
        assertEquals(7, wall.getPosition().getX());
        assertEquals(3, wall.getPosition().getY());
        assertEquals(4, wall.getLength());
        assertEquals(5, wall.getThickness());
        boolean horizontal = wall.isHorizontal();
        assertEquals(true, horizontal);
    }
}

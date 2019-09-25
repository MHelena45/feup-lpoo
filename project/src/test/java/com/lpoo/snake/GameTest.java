package com.lpoo.snake;

import com.lpoo.snake.Controller.Lanterna.LGameController;
import org.junit.Test;

public class GameTest {
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHeight() throws Exception {
        LGameController g = LGameController.getGame();
        g.init(80, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidwidth() throws Exception {
        LGameController g = LGameController.getGame();
        g.init(0, 24);
    }
}

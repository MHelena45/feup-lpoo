package com.lpoo.snake;

import com.lpoo.snake.Controller.Lanterna.LGameController;
import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MenuLevelTest {

    @Test
    public void level() throws IOException {
        LGameController g = LGameController.getGame();
        g.init(80, 24);
        assertEquals(1, g.getLevel());
    }
}

package com.lpoo.snake;

import com.lpoo.snake.Controller.Lanterna.Menus.LMenuLevel;
import com.lpoo.snake.Controller.Lanterna.Menus.LMenuMain;
import com.lpoo.snake.Controller.Lanterna.LGameController;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class StateTest {

    @Test
    public void changeStates() throws IOException {
        LGameController g = LGameController.getGame();
        g.init(80, 24);
        LMenuMain menuMain = new LMenuMain(80, 24);
        assertEquals(menuMain, g.getState());
        LMenuLevel menuLevel = new LMenuLevel(80, 24);
        g.changeState(menuLevel);
        assertEquals(menuLevel, g.getState());
    }
}

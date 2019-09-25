package com.lpoo.snake.Controller.Lanterna.Menus;

import com.googlecode.lanterna.gui2.*;
import com.lpoo.snake.Controller.Lanterna.*;

import java.io.IOException;

import static com.lpoo.snake.Controller.Lanterna.LGameController.getGame;

public class LMenuPause extends LMenuState {
    LState level;

    public LMenuPause(int width, int height, LState level) throws IOException {
        super(width, height);
        this.level = level;
        buildMenu();
    }

    public void buildMenu() throws IOException {
        LGameController game = getGame();
        Panel horizontalPanel = build("Pause Menu");
        panel = new Panel();
        // Single Player Button
        panel.addComponent(new Button("Return to the game", () -> {
            game.changeState(level);
            menu.close();
        }));
        // Exit Button
        panel.addComponent(new Button("Exit", () -> {
            try {
                game.changeState(new LMenuMain(width, height));
            } catch (IOException e) {
                e.printStackTrace();
            }
            menu.close();
        }));

        horizontalPanel.addComponent(panel);
        menu.setComponent(horizontalPanel);
    }

}

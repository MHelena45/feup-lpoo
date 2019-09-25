package com.lpoo.snake.Controller.Lanterna.Menus;

import com.googlecode.lanterna.gui2.*;
import com.lpoo.snake.Controller.Lanterna.*;

import java.io.IOException;

import static com.lpoo.snake.Controller.Lanterna.LGameController.getGame;

public class LMenuMain extends LMenuState {

    public LMenuMain(int width, int height) throws IOException {
        super(width, height);
        buildMenu();
    }

    public void buildMenu() throws IOException {
        LGameController game = getGame();
        Panel horizontalPanel = build("MenuMain");
        panel = new Panel();
        // Single Player Button
        panel.addComponent(new Button("SinglePlayer", () -> {
            try {
                game.changeState(new LSingleplayerState(width, height, 7));
            } catch (IOException e) {
                e.printStackTrace();
            }
            menu.close();
        }));
        // Multi Player Button
        panel.addComponent(new Button("MultiPlayer", () -> {
            try {
                game.changeState(new LMultiplayerState(width, height, 5));
            } catch (IOException e) {
                e.printStackTrace();
            }
            menu.close();
        }));
        // Options Button
        panel.addComponent(new Button("Change Level", () -> {
            try {
                game.changeState(new LMenuLevel(width, height));
            } catch (IOException e) {
                e.printStackTrace();
            }
            menu.close();
        }));
        // Help Button
        panel.addComponent(new Button("Help", () -> {
            try {
                game.changeState(new LMenuHelp(width, height));
            } catch (IOException e) {
                e.printStackTrace();
            }
            menu.close();
        }));
        // Score Button
        panel.addComponent(new Button("High Scores", () -> {
            try {
                game.changeState(new LMenuBestScores(width, height));
            } catch (IOException e) {
                e.printStackTrace();
            }
            menu.close();
        }));
        // Exit Button
        panel.addComponent(new Button("Exit", () -> System.exit(0)));
        horizontalPanel.addComponent(panel);
        menu.setComponent(horizontalPanel);

    }
}

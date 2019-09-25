package com.lpoo.snake.Controller.Lanterna.Menus;

import com.googlecode.lanterna.gui2.*;
import com.lpoo.snake.Controller.Lanterna.*;
import java.io.IOException;
import static com.lpoo.snake.Controller.Lanterna.LGameController.getGame;

public class LMenuGameOver extends LMenuState {
    private String scoreText;

    public LMenuGameOver(int width, int height, String score) throws IOException {
        super(width, height);
        scoreText = score;
        buildMenu();
    }

    public void buildMenu() {
        Panel horizontalPanel = build("Game over");
        panel = new Panel();

        // Single Player Button
        panel.addComponent(new Button("Play Again", () -> {
            try {
                getGame().changeState(new LMenuMain(width, height));
            } catch (IOException e) {
                e.printStackTrace();
            }
            menu.close();
        }));
        // Exit Button
        panel.addComponent(new Button("Exit", () -> System.exit(0)));
        panel.addComponent(new Label("Score : " + scoreText));
        horizontalPanel.addComponent(panel);
        menu.setComponent(horizontalPanel);
    }
}

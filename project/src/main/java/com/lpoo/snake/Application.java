package com.lpoo.snake;

import java.io.IOException;

import com.lpoo.snake.Controller.GameController;
import com.lpoo.snake.Controller.Lanterna.LGameController;
import com.lpoo.snake.Controller.Swing.SGameController;

public class Application {
    public static void main(String[] args) {
        String systemType;
        if (args.length < 1)
            systemType = "Lanta";
        else
            systemType = args[0];

        GameController g;
        try {
            if (systemType.equalsIgnoreCase("Lanterna")) {
                g = LGameController.getGame();
                g.init(80, 24);
            } else {
                g = SGameController.getGame();
                g.init(700, 700);
            }
            g.run();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }
}

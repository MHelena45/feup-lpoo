package com.lpoo.snake.Model.commands;

import com.lpoo.snake.Model.Command;
import com.lpoo.snake.Model.Snake;

public class UpCommand implements Command {
    /*
     * Changes the direction of the snake and moves it. Graphic coordinates, so Y
     * increases as the snake goes down.
     */
    public boolean execute(Snake snake) {
        if (snake.getDirection().getY() == 0) {
            snake.getDirection().setX(0);
            snake.getDirection().setY(-1);
            snake.update();
            return true;
        }
        return false;
    }

}

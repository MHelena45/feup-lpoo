package com.lpoo.snake.Model.commands;

import com.lpoo.snake.Model.Command;
import com.lpoo.snake.Model.Snake;

public class RightCommand implements Command {
    public boolean execute(Snake snake) {
        if (snake.getDirection().getX() == 0) {
            snake.getDirection().setX(1);
            snake.getDirection().setY(0);
            snake.update();
            return true;
        }
        return false;
    }
}

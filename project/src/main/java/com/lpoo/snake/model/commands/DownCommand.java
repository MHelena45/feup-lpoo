package com.lpoo.snake.Model.commands;

import com.lpoo.snake.Model.Command;
import com.lpoo.snake.Model.Snake;

public class DownCommand implements Command {
    public boolean execute(Snake snake) {
        if (snake.getDirection().getY() == 0) {
            snake.getDirection().setX(0);
            snake.getDirection().setY(1);
            snake.update();
            return true;
        }
        return false;
    }
}

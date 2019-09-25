package com.lpoo.snake.Controller.Swing;

import java.awt.event.KeyEvent;
import java.io.IOException;

import com.lpoo.snake.Model.Snake;
import com.lpoo.snake.Model.commands.*;

public abstract class SState {

    protected int width;
    protected int height;
    static DownCommand downCommand;
    static UpCommand upCommand;
    static LeftCommand leftCommand;
    static RightCommand rightCommand;

    public SState(int width, int height) {
        this.width = width;
        this.height = height;
        downCommand = new DownCommand();
        upCommand = new UpCommand();
        leftCommand = new LeftCommand();
        rightCommand = new RightCommand();
    }

    public abstract void draw();

    public abstract void update() throws IOException;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    static boolean processArrowKey(KeyEvent key, Snake snake) {
        switch (key.getKeyCode()) {
        case KeyEvent.VK_UP: {
            return upCommand.execute(snake);
        }
        case KeyEvent.VK_DOWN: {
            return downCommand.execute(snake);
        }
        case KeyEvent.VK_LEFT: {
            return leftCommand.execute(snake);
        }
        case KeyEvent.VK_RIGHT: {
            return rightCommand.execute(snake);
        }
        default:
            break;
        }
        return false;
    }

    static boolean processCharKey(KeyEvent key, Snake snake, int score) {
        switch (key.getKeyCode()) {
        case KeyEvent.VK_W: {
            return upCommand.execute(snake);
        }
        case KeyEvent.VK_S: {
            return downCommand.execute(snake);
        }
        case KeyEvent.VK_A: {
            return leftCommand.execute(snake);
        }
        case KeyEvent.VK_D: {
            return rightCommand.execute(snake);
        }
        default:
            break;
        }
        return false;
    }
}

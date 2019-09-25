package com.lpoo.snake.Controller.Lanterna;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.lpoo.snake.Model.commands.*;
import com.lpoo.snake.Model.Snake;

import java.io.IOException;

public abstract class LState {
    protected int width;
    protected int height;
    static DownCommand downCommand;
    static UpCommand upCommand;
    static LeftCommand leftCommand;
    static RightCommand rightCommand;

    LState(int width, int height) {
        this.width = width;
        this.height = height;
        downCommand = new DownCommand();
        upCommand = new UpCommand();
        leftCommand = new LeftCommand();
        rightCommand = new RightCommand();
    }

    public abstract void draw(TextGraphics graphics) throws IOException;

    public abstract void update(KeyStroke key) throws IOException;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    static boolean processArrowKey(KeyStroke key, Snake snake) {
        switch (key.getKeyType()) {
        case ArrowUp: {
            return upCommand.execute(snake);
        }
        case ArrowDown: {
            return downCommand.execute(snake);
        }
        case ArrowLeft: {
            return leftCommand.execute(snake);
        }
        case ArrowRight: {
            return rightCommand.execute(snake);
        }
        default:
            break;
        }
        return false;
    }

    static boolean processCharKey(KeyStroke key, Snake snake) {
        switch (key.getCharacter()) {
        case 'w': {
            return upCommand.execute(snake);
        }
        case 'a': {
            return leftCommand.execute(snake);
        }
        case 's': {
            return downCommand.execute(snake);
        }
        case 'd': {
            return rightCommand.execute(snake);
        }
        default:
            break;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (getClass() != o.getClass())
            return false;

        LState state = (LState) o;
        return (this.height == state.getHeight()) && (this.width == state.getWidth());

    }
}

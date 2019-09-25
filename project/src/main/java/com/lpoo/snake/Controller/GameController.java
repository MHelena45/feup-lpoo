package com.lpoo.snake.Controller;

import java.io.IOException;

public interface GameController {
    void run() throws IOException;

    void init(int width, int height) throws IOException, IllegalArgumentException;
}

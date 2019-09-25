package com.lpoo.snake.Model;

import java.io.IOException;

public interface Level {
    boolean checkCollision() throws IOException;

    void update() throws IOException;
}

package com.lpoo.snake.View.Lanterna;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.lpoo.snake.Model.*;

public class LSingleplayerRenderer implements LRenderer {

    private SingleplayerLevel sp;

    public LSingleplayerRenderer(SingleplayerLevel singleplayer) {
        this.sp = singleplayer;
    }

    public void draw(TextGraphics graphics) {
        LRenderer.drawBackground(graphics, sp.getWidth(), sp.getHeight(), "#305030");

        // Draw Walls
        for (Wall wall : sp.getWalls())
            LRenderer.drawWall(graphics, wall, "#000044");

        // Draw Snake
        Snake snake = sp.getSnake();
        LRenderer.drawSnake(graphics, snake, "#006600", "#33FF33");

        // Draw Big Apple
        BigApple bigapple = sp.getBigApple();
        if (bigapple.isActive())
            LRenderer.drawBigApple(graphics, bigapple, "#FF0000");

        // Draw Apple
        LRenderer.drawApple(graphics, sp.getApple(), "#FF0000");
        LRenderer.drawScore(graphics, snake.getScore(), 2, 2, "");

        // Draw Obstacle
        for (Obstacle obstacle1 : sp.getObstacles()) {
            if (obstacle1.isActive())
                LRenderer.drawObstacle(graphics, obstacle1, "#000099");
            else if (!obstacle1.getBlack())
                LRenderer.drawObstacle(graphics, obstacle1, "#999000");
        }
    }
}

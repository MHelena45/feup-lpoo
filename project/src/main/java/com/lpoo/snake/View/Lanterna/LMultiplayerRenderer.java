package com.lpoo.snake.View.Lanterna;

import com.googlecode.lanterna.graphics.TextGraphics;

import com.lpoo.snake.Model.*;

public class LMultiplayerRenderer implements LRenderer {

    private MultiplayerLevel mp;

    public LMultiplayerRenderer(MultiplayerLevel multiplayer) {
        this.mp = multiplayer;
    }

    public void draw(TextGraphics graphics) {
        LRenderer.drawBackground(graphics, mp.getWidth(), mp.getHeight(), "#305030");

        // Draw Walls
        for (Wall wall : mp.getWalls())
            LRenderer.drawWall(graphics, wall, "#000044");

        // Draw Snakes
        Snake snake1 = mp.getSnake1();
        LRenderer.drawSnake(graphics, snake1, "#006600", "#33FF33");
        Snake snake2 = mp.getSnake2();
        LRenderer.drawSnake(graphics, snake2, "#000066", "#3333FF");

        // Draw Big Apple
        BigApple bigapple = mp.getBigApple();
        if (bigapple.isActive())
            LRenderer.drawBigApple(graphics, bigapple, "#FF0000");

        // Draw Apple
        LRenderer.drawApple(graphics, mp.getApple(), "#FF0000");
        LRenderer.drawScore(graphics, snake1.getScore(), 0, 2, "Player1 ");
        LRenderer.drawScore(graphics, snake2.getScore(), 50, 2, "Player2 ");
    }

}

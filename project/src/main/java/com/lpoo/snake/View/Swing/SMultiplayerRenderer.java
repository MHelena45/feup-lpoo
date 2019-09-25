package com.lpoo.snake.View.Swing;

import com.lpoo.snake.Model.BigApple;
import com.lpoo.snake.Model.Element;
import com.lpoo.snake.Model.MultiplayerLevel;
import com.lpoo.snake.Model.Wall;

import javax.swing.*;
import java.awt.*;

public class SMultiplayerRenderer extends JPanel implements SRenderer {
    static final long serialVersionUID = 100000;
    private MultiplayerLevel mp;

    public SMultiplayerRenderer(MultiplayerLevel multiplayer) {
        this.mp = multiplayer;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        SRenderer.drawBackground(g2d, mp.getWidth() * 20, mp.getHeight() * 10, new Color(48, 80, 48));

        for (Wall wall : mp.getWalls())
            SRenderer.drawWall(g2d, wall, new Color(0, 0, 51));

        SRenderer.drawSnake(g2d, mp.getSnake1(), new Color(0, 68, 0), new Color(51, 255, 51));
        SRenderer.drawSnake(g2d, mp.getSnake2(), new Color(0, 0, 68), new Color(51, 51, 255));

        Element apple = mp.getApple();
        SRenderer.drawApple(g2d, apple, new Color(255, 0, 0));

        BigApple bigapple = mp.getBigApple();
        if (bigapple.isActive())
            SRenderer.drawBigApple(g2d, bigapple, new Color(255, 0, 0));

        SRenderer.drawScore(g2d, mp.getSnake1().getScore(), "Player 1 : ", 35);
        SRenderer.drawScore(g2d, mp.getSnake2().getScore(), "Player 2 : ", 60);
    }
}

package com.lpoo.snake.View.Swing;

import java.awt.*;

import javax.swing.*;

import com.lpoo.snake.Model.*;

public class SSingleplayerRenderer extends JPanel implements SRenderer {
    static final long serialVersionUID = 100000;
    private SingleplayerLevel sp;

    public SSingleplayerRenderer(SingleplayerLevel singleplayer) {
        this.sp = singleplayer;
    }

    public void paintComponent(Graphics g) {
        removeAll();
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        SRenderer.drawBackground(g2d, sp.getWidth() * 20, sp.getHeight() * 10, new Color(48, 80, 48));

        for (Wall wall : sp.getWalls())
            SRenderer.drawWall(g2d, wall, new Color(0, 0, 51));

        SRenderer.drawSnake(g2d, sp.getSnake(), new Color(0, 68, 0), new Color(51, 255, 51));

        Element apple = sp.getApple();
        SRenderer.drawApple(g2d, apple, new Color(255, 0, 0));

        BigApple bigapple = sp.getBigApple();
        if (bigapple.isActive())
            SRenderer.drawBigApple(g2d, bigapple, new Color(255, 0, 0));

        // Draw Obstacle
        for (Obstacle obstacle1 : sp.getObstacles()) {
            if (obstacle1.isActive())
                SRenderer.drawObstacle(g2d, obstacle1, new Color(0, 0, 153));
            else if (!obstacle1.getBlack())
                SRenderer.drawObstacle(g2d, obstacle1, new Color(153, 144, 0));
        }

        SRenderer.drawScore(g2d, sp.getSnake().getScore(), "", 50);
    }
}

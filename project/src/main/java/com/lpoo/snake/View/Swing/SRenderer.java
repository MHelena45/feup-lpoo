package com.lpoo.snake.View.Swing;

import com.lpoo.snake.Controller.Swing.SGameController;
import com.lpoo.snake.Model.*;

import javax.swing.*;
import java.awt.*;

public interface SRenderer {

    void paintComponent(Graphics g);

    static void drawBackground(Graphics2D g, int width, int height, Color color) {
        g.setColor(color);
        g.fillRect(0, 0, width, height);
    }

    static void drawScore(int score, String identifier) {
        String scoreText = identifier + "score ";
        String scre = String.valueOf(score);
        JLabel scoreLabel = new JLabel(scoreText + scre);
        scoreLabel.setForeground(new Color(255, 255, 255));
        JFrame frame = SGameController.getGame().getJFrame();
        frame.getContentPane().add(scoreLabel);
    }

    static void drawSnake(Graphics2D g, Snake snake, Color backColor, Color foreColor) {
        g.setBackground(backColor);
        g.setColor(foreColor);
        g.fillOval(snake.head().getX() * 10, snake.head().getY() * 10, 10, 10);

        for (Position position : snake.tail())
            g.fillOval(position.getX() * 10, position.getY() * 10, 10, 10);
    }

    static void drawScore(Graphics2D g, int score, String identifier, int y) {
        g.setColor(new Color(255, 255, 255));
        String scoreText = identifier + "score " + String.valueOf(score);
        g.drawString(scoreText, 70, y);
    }

    static void drawWall(Graphics2D g, Wall wall, Color color) {

        g.setColor(color);
        if (wall.isHorizontal())
            g.fillRect(wall.getX() * 10, wall.getY() * 10, wall.getLength() * 10, wall.getThickness() * 10);
        else
            g.fillRect(wall.getX() * 10, wall.getY() * 10, wall.getThickness() * 10, wall.getLength() * 10);
    }

    static void drawApple(Graphics2D g, Element apple, Color color) {
        g.setColor(color);
        g.fillOval(apple.getPosition().getX() * 10, apple.getPosition().getY() * 10, 10, 10);
    }

    static void drawObstacle(Graphics2D g, Obstacle obstacle, Color color) {
        g.setColor(color);
        g.fillRect(obstacle.getX() * 10, obstacle.getY() * 10, 10, 10);
    }

    static void drawBigApple(Graphics2D g, BigApple bigapple, Color color) {
        g.setColor(color);
        g.fillRect(bigapple.getX() * 10, bigapple.getY() * 10, 10, 10);

        // Progress bar
        g.setColor(new Color(255, 255, 255));
        g.fillRect(210, 30, 10, 20);

        g.setColor(new Color(0, 0, 0));
        g.fillRect(210, 30, bigapple.getTimeForEnd(), 20);

        g.setColor(new Color(0, 15, 255));
        g.drawString(String.valueOf(bigapple.getTimeForEnd()), 420, 30);
    }
}

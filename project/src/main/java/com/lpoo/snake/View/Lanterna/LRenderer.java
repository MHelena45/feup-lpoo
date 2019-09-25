package com.lpoo.snake.View.Lanterna;

import com.lpoo.snake.Model.*;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public interface LRenderer {

    void draw(TextGraphics graphics);

    static void drawBackground(TextGraphics graphics, int width, int height, String Color) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(Color));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
    }

    static void drawScore(TextGraphics graphics, int score, int width, int height, String identifier) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        String scoreText = identifier + "score";
        graphics.putString(new TerminalPosition(width, height), scoreText);
        String scre = String.valueOf(score);
        graphics.putString(new TerminalPosition(scoreText.length() + width + 1, height), scre);
    }

    static void drawSnake(TextGraphics graphics, Snake snake, String backColor, String foreColor) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(backColor));
        graphics.setForegroundColor(TextColor.Factory.fromString(foreColor));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(snake.head().getX(), snake.head().getY()), "\u25CD");

        for (Position position : snake.tail()) {
            graphics.putString(new TerminalPosition(position.getX(), position.getY()), "\u25CF");
        }
    }

    static void drawWall(TextGraphics graphics, Wall wall, String color) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        if (wall.isHorizontal())
            graphics.fillRectangle(new TerminalPosition(wall.getX(), wall.getY()),
                    new TerminalSize(wall.getLength(), wall.getThickness()), ' ');
        else
            graphics.fillRectangle(new TerminalPosition(wall.getX(), wall.getY()),
                    new TerminalSize(wall.getThickness(), wall.getLength()), ' ');

    }

    static void drawBigApple(TextGraphics graphics, BigApple bigapple, String color) {
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(bigapple.getX(), bigapple.getY()), "\uf8ff");
        // Progress bar
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(21, 3), new TerminalSize(20, 1), ' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(21, 3), new TerminalSize(bigapple.getTimeForEnd(), 1), ' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000FFF"));
        graphics.putString(new TerminalPosition(42, 3), String.valueOf(bigapple.getTimeForEnd()));

    }

    static void drawApple(TextGraphics graphics, Element apple, String color) {
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(apple.getPosition().getX(), apple.getPosition().getY()), "\u25c9");
    }

    static void drawObstacle(TextGraphics graphics, Obstacle obstacle, String color) {
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(obstacle.getX(), obstacle.getY()), "\u2b1b");
    }
}

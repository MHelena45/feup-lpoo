package com.lpoo.snake.Controller.Lanterna.Menus;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.lpoo.snake.Controller.Lanterna.*;
import com.lpoo.snake.Controller.Timer;
import com.lpoo.snake.Controller.Score;
import com.lpoo.snake.View.Lanterna.LRenderer;

import java.io.*;

import static com.lpoo.snake.Controller.Lanterna.LGameController.getGame;

public class LMenuScore extends LMenuState {
    Score bestScores;
    private int score;
    private int player;
    private Timer timeToEnd;

    public LMenuScore(int width, int height, int score, int player) {
        super(width, height);
        this.score = score;
        this.player = player;
        timeToEnd = new Timer(4000);
        buildMenu();
    }

    public void buildMenu() {
        bestScores = new Score();
        draw(getGame().getScreen().newTextGraphics());
    }

    public void draw(TextGraphics graphics) {
        String sco = String.valueOf(score);
        LRenderer.drawBackground(graphics, width, height, "#0001FF");
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(12, 6), "Game Over");
        graphics.putString(new TerminalPosition(12, 9), "The Score was " + sco);
        if (this.player > 0) {
            if (this.player == 3) {
                graphics.putString(new TerminalPosition(12, 12), "Got tied !");
            } else {
                String pla = String.valueOf(player);
                graphics.putString(new TerminalPosition(12, 12), "Player " + pla + " Win !");
            }
            graphics.putString(new TerminalPosition(12, 15), "Best Score :" + bestScores.getMbestScore());
        } else {
            graphics.putString(new TerminalPosition(12, 15), "Best Score :" + bestScores.getSbestScore());
        }

        graphics.putString(new TerminalPosition(12, 19), "Press 'q' to leave ");
        if (timeToEnd.IsUpdateTime()) {
            try {
                String scoreText = String.valueOf(score);
                getGame().changeState(new LMenuGameOver(width, height, scoreText));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

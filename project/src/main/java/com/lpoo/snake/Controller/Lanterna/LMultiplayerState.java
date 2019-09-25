package com.lpoo.snake.Controller.Lanterna;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.lpoo.snake.Controller.Timer;
import com.lpoo.snake.Controller.Lanterna.Menus.LMenuPause;
import com.lpoo.snake.Controller.Lanterna.Menus.LMenuScore;
import com.lpoo.snake.Model.*;
import com.lpoo.snake.View.Lanterna.LMultiplayerRenderer;

import static com.lpoo.snake.Controller.Lanterna.LGameController.getGame;

import java.io.IOException;

public class LMultiplayerState extends LState {

    private MultiplayerLevel mplevel;
    private LMultiplayerRenderer mprenderer;

    private Timer gameTimer;
    private Timer bigAppleTimer;
    private Timer secondsTimer;

    public LMultiplayerState(int width, int height, int wallSize) throws IOException {
        super(width, height);
        mplevel = new MultiplayerLevel(width, height, wallSize);
        mprenderer = new LMultiplayerRenderer(mplevel);
        gameTimer = new Timer(1000 / (4 + getGame().getLevel() * 3)); // divider in moves per second
        bigAppleTimer = new Timer(60000);
        secondsTimer = new Timer(1000);
    }

    public void update(KeyStroke key) throws IOException {
        processKey(key);
        if (gameTimer.IsUpdateTime()) {
            mplevel.update();
            checkCollision();
        }

        if (bigAppleTimer.IsUpdateTime())
            mplevel.spawnBigApple();

        if (secondsTimer.IsUpdateTime())
            mplevel.getBigApple().subTimeForEnd();
    }

    public void draw(TextGraphics graphics) {
        mprenderer.draw(graphics);
    }

    private void processKey(KeyStroke key) throws IOException {
        if (key == null)
            return;

        if (key.getKeyType() != KeyType.Character) {
            if (LState.processArrowKey(key, mplevel.getSnake1())) {
                checkCollision();
                gameTimer.resetTimer();
            }
        } else if (key.getKeyType() == KeyType.Character) {
            if (key.getCharacter() == 'p')
                getGame().changeState(new LMenuPause(width, height, this));
            else if (LState.processCharKey(key, mplevel.getSnake2())) {
                checkCollision();
                gameTimer.resetTimer();
            }
        }
    }

    private void checkCollision() throws IOException {
        if (mplevel.checkCollision()) {
            if (mplevel.getSnake1().getScore() > mplevel.getSnake2().getScore())
                getGame().changeState(new LMenuScore(width, height, mplevel.getSnake1().getScore(), 1));
            else if (mplevel.getSnake1().getScore() < mplevel.getSnake2().getScore())
                getGame().changeState(new LMenuScore(width, height, mplevel.getSnake2().getScore(), 2));
            else
                getGame().changeState(new LMenuScore(width, height, mplevel.getSnake2().getScore(), 3));
        }

    }
}

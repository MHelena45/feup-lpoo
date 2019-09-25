package com.lpoo.snake.Controller.Lanterna;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.lpoo.snake.Controller.Timer;
import com.lpoo.snake.Controller.Lanterna.Menus.LMenuPause;
import com.lpoo.snake.Controller.Lanterna.Menus.LMenuScore;
import com.lpoo.snake.Model.*;
import com.lpoo.snake.View.Lanterna.LSingleplayerRenderer;

import static com.lpoo.snake.Controller.Lanterna.LGameController.getGame;

import java.io.IOException;

public class LSingleplayerState extends LState {

    private SingleplayerLevel splevel;
    private LSingleplayerRenderer sprenderer;
    private Timer gameTimer;
    private Timer bigAppleTimer;
    private Timer secondsTimer;
    private Timer obstacletimeForNew;
    private Timer obstaclevisible;
    private Timer obstacletimeForFixed;

    public LSingleplayerState(int width, int height, int wallSize) throws IOException {
        super(width, height);
        gameTimer = new Timer(1000 / (4 + getGame().getLevel() * 3)); // divider in moves per second
        bigAppleTimer = new Timer(60000);
        secondsTimer = new Timer(1000);
        splevel = new SingleplayerLevel(width, height, wallSize);
        sprenderer = new LSingleplayerRenderer(splevel);
        obstacletimeForFixed = new Timer(10500);
        obstacletimeForNew = new Timer(50000);
        obstaclevisible = new Timer(200);
    }

    public void update(KeyStroke key) throws IOException {
        processKey(key);
        if (gameTimer.IsUpdateTime()) {
            splevel.update();
            if (splevel.checkCollision())
                getGame().changeState(new LMenuScore(width, height, splevel.getSnake().getScore(), 0));
        }

        if (bigAppleTimer.IsUpdateTime())
            splevel.spawnBigApple();

        if (secondsTimer.IsUpdateTime())
            splevel.getBigApple().subTimeForEnd();

        if (obstacletimeForNew.IsUpdateTime()) {
            splevel.addObstacle();
            obstacletimeForFixed.resetTimer();
        }
        if (obstacletimeForFixed.IsUpdateTime())
            splevel.getLast().setActive(true);

        if (obstaclevisible.IsUpdateTime())
            splevel.getLast().setBlack(!splevel.getLast().getBlack());
    }

    public void draw(TextGraphics graphics) {
        sprenderer.draw(graphics);
    }

    private void processKey(KeyStroke key) throws IOException {
        if (key == null)
            return;

        if (key.getKeyType() != KeyType.Character) {
            if (LState.processArrowKey(key, splevel.getSnake())) {
                if (splevel.checkCollision())
                    getGame().changeState(new LMenuScore(width, height, splevel.getSnake().getScore(), 0));
                gameTimer.resetTimer();
            }
        } else {
            if (key.getCharacter() == 'p')
                getGame().changeState(new LMenuPause(width, height, this));
        }
    }
}

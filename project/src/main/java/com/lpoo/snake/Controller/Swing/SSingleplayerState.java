package com.lpoo.snake.Controller.Swing;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import com.lpoo.snake.Controller.Swing.Menus.SMenuGameOver;
import com.lpoo.snake.Model.SingleplayerLevel;
import com.lpoo.snake.View.Swing.SSingleplayerRenderer;
import com.lpoo.snake.Controller.Timer;
import com.lpoo.snake.Controller.Swing.Menus.SMenuPause;

public class SSingleplayerState extends SState {

    private SingleplayerLevel splevel;
    private SSingleplayerRenderer sprenderer;
    private Timer gameTimer;
    private Timer obstacletimeForNew;
    private Timer obstaclevisible;
    private Timer obstacletimeForFixed;

    public SSingleplayerState(int width, int height, int wallSize) {
        super(width, height);
        splevel = new SingleplayerLevel(width / 10, height / 10, wallSize);
        sprenderer = new SSingleplayerRenderer(splevel);
        sprenderer.addKeyListener(new CustomKeyListener(this));
        gameTimer = new Timer(1000 / (4 + SGameController.getGame().getLevel() * 3)); // divider in moves per second
        obstacletimeForFixed = new Timer(10500);
        obstacletimeForNew = new Timer(50000);
        obstaclevisible = new Timer(200);

    }

    class CustomKeyListener implements KeyListener {
        private SState level;

        CustomKeyListener(SState level) {
            this.level = level;
        }

        public void keyTyped(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
            try {
                if (processArrowKey(e, splevel.getSnake())) {
                    if (splevel.checkCollision())
                        SGameController.getGame()
                                .changeState(new SMenuGameOver(width, height, splevel.getSnake().getScore(), 0));
                    gameTimer.resetTimer();
                }
                if (e.getKeyCode() == KeyEvent.VK_P)
                    SGameController.getGame().changeState(new SMenuPause(width, height, level));

            } catch (IOException ex) {
                System.exit(1);
            }
        }
    }

    public void update() throws IOException {
        JPanel spren = (JPanel) sprenderer;
        spren.setFocusable(true);
        spren.requestFocusInWindow();
        if (gameTimer.IsUpdateTime()) {
            splevel.update();
            if (splevel.checkCollision())
                SGameController.getGame()
                        .changeState(new SMenuGameOver(width, height, splevel.getSnake().getScore(), 0));

            if (obstacletimeForNew.IsUpdateTime()) {
                splevel.addObstacle();
                obstacletimeForFixed.resetTimer();
            }
            if (obstacletimeForFixed.IsUpdateTime())
                splevel.getLast().setActive(true);

            if (obstaclevisible.IsUpdateTime())
                splevel.getLast().setBlack(!splevel.getLast().getBlack());
        }
    }

    public void draw() {
        JPanel spren = (JPanel) sprenderer;
        spren.revalidate();
        spren.repaint();
        JFrame frame = SGameController.getGame().getJFrame();
        frame.add(spren);
    }
}

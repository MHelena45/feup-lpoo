
package com.lpoo.snake.Controller.Swing;

import com.lpoo.snake.Controller.Swing.Menus.SMenuGameOver;
import com.lpoo.snake.Controller.Timer;
import com.lpoo.snake.Model.MultiplayerLevel;
import com.lpoo.snake.View.Swing.SMultiplayerRenderer;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class SMultiplayerState extends SState {
    private MultiplayerLevel mplevel;
    private SMultiplayerRenderer mprenderer;
    private Timer gameTimer;

    public SMultiplayerState(int width, int height, int wallSize) throws IOException {
        super(width, height);
        mplevel = new MultiplayerLevel(width / 10, height / 10, wallSize);
        mprenderer = new SMultiplayerRenderer(mplevel);
        mprenderer.addKeyListener(new CustomKeyListener());
        gameTimer = new Timer(1000 / (4 + SGameController.getGame().getLevel() * 3)); // divider in moves per second

    }

    class CustomKeyListener implements KeyListener {
        public void keyTyped(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
            try {

                if (processArrowKey(e, mplevel.getSnake1())
                        || processCharKey(e, mplevel.getSnake2(), mplevel.getSnake2().getScore())) {
                    if (mplevel.checkCollision()) {
                        over();
                    }
                    gameTimer.resetTimer();
                }

            } catch (IOException ex) {
                System.exit(1);
            }
        }
    }

    private void over() {
        if (mplevel.getSnake1().getScore() > mplevel.getSnake2().getScore())
            SGameController.getGame().changeState(new SMenuGameOver(width, height, mplevel.getSnake1().getScore(), 1));
        else if (mplevel.getSnake1().getScore() < mplevel.getSnake2().getScore())
            SGameController.getGame().changeState(new SMenuGameOver(width, height, mplevel.getSnake2().getScore(), 2));
        else
            SGameController.getGame().changeState(new SMenuGameOver(width, height, mplevel.getSnake2().getScore(), 3));
    }

    public void update() throws IOException {
        JPanel spren = mprenderer;
        spren.setFocusable(true);
        spren.requestFocusInWindow();
        if (gameTimer.IsUpdateTime()) {
            mplevel.update();
            if (mplevel.checkCollision())
                over();
        }

    }

    public void draw() {
        JPanel spren = mprenderer;
        spren.revalidate();
        spren.repaint();
        JFrame frame = SGameController.getGame().getJFrame();
        frame.add(spren);
    }
}

package com.lpoo.snake.Controller.Swing;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.*;
import com.lpoo.snake.Controller.GameController;
import com.lpoo.snake.Controller.Timer;
import com.lpoo.snake.Controller.Swing.Menus.SMenuMain;

public class SGameController implements GameController {
    private static SGameController game = null;
    private JFrame frame;
    private SState state;
    protected int width;
    protected int height;
    private int level;
    private Timer timer;
    private final int fps = 60;

    private SGameController() {
    }

    public void run() throws IOException {
        while (true) {
            state.update();
            if (timer.IsUpdateTime())
                draw();
        }
    }

    public void init(int width, int height) throws IOException, IllegalArgumentException {
        frame = new JFrame("Snake");
        this.width = width;
        this.height = height;
        state = new SMenuMain(width, height);
        timer = new Timer(1000 / fps);
        level = 1;
    }

    public static SGameController getGame() {
        if (game == null)
            game = new SGameController();
        return game;
    }

    public static void makeVisible(Box vbox, int height, int width) {
        Box hbox = Box.createHorizontalBox();
        hbox.add(vbox);
        JFrame frame = SGameController.getGame().getJFrame();
        frame.getContentPane().add(hbox);
    }

    public JFrame getJFrame() {
        return frame;
    }

    private void draw() {
        state.draw();
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    public void changeState(SState state) {
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.repaint();
        this.state = state;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static void addNewLine(Box box, int size) {
        box.add(Box.createRigidArea(new Dimension(0, size)));
    }

}

package com.lpoo.snake.Controller.Swing.Menus;

import javax.swing.*;
import com.lpoo.snake.Controller.Swing.SMultiplayerState;
import com.lpoo.snake.Controller.Swing.SSingleplayerState;
import com.lpoo.snake.Controller.Swing.SState;
import com.lpoo.snake.Controller.Swing.SGameController;

import java.awt.Color;
import java.io.IOException;
import static com.lpoo.snake.Controller.Swing.SGameController.getGame;

public class SMenuMain extends SState {
    private JButton spbutton, mpbutton;
    private JButton hpbutton;
    private JButton opbutton;
    private JButton exbutton;
    private JButton hsbutton;
    private Box vbox;

    public SMenuMain(int width, int height) {
        super(width, height);
        buildMenu();
        addActionListeners();
    }

    private void buildMenu() {
        vbox = Box.createVerticalBox();
        JFrame frame = SGameController.getGame().getJFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.getContentPane().setBackground(new Color(240, 240, 255));
        spbutton = new JButton("SinglePlayer");
        mpbutton = new JButton("Multiplayer");
        hpbutton = new JButton("Change Level");
        opbutton = new JButton("Help");
        hsbutton = new JButton("High Scores");
        exbutton = new JButton("Exit");
        SGameController.addNewLine(vbox, 100);
        vbox.add(new JLabel("SNAKE"));
        SGameController.addNewLine(vbox, 50);
        vbox.add(spbutton);
        SGameController.addNewLine(vbox, 5);
        vbox.add(mpbutton);
        SGameController.addNewLine(vbox, 5);
        vbox.add(hpbutton);
        SGameController.addNewLine(vbox, 5);
        vbox.add(opbutton);
        SGameController.addNewLine(vbox, 5);
        vbox.add(hsbutton);
        SGameController.addNewLine(vbox, 5);
        vbox.add(exbutton);
        SGameController.addNewLine(vbox, 5);
    }

    public void addActionListeners() {
        spbutton.addActionListener(
                actionEvent -> SGameController.getGame().changeState(new SSingleplayerState(width, height, 12)));
        mpbutton.addActionListener(actionEvent -> {
            try {
                SGameController.getGame().changeState(new SMultiplayerState(width, height, 12));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        hpbutton.addActionListener(actionEvent -> SGameController.getGame().changeState(new SMenuLevel(width, height)));
        opbutton.addActionListener(actionEvent -> SGameController.getGame().changeState(new SMenuHelp(width, height)));
        hsbutton.addActionListener(actionEvent -> {
            getGame().changeState(new SMenuBestScores(width, height));
        });
        exbutton.addActionListener(actionEvent -> System.exit(0));
    }

    public void draw() {
        SGameController.makeVisible(vbox, height, width);
    }

    public void update() {
    }
}

package com.lpoo.snake.Controller.Swing.Menus;

import com.lpoo.snake.Controller.Swing.SState;
import com.lpoo.snake.Controller.Swing.SGameController;
import javax.swing.*;
import static com.lpoo.snake.Controller.Swing.SGameController.getGame;

public class SMenuLevel extends SState {
    private JButton leaveButton;
    private Box vbox;
    JRadioButton level1;
    JRadioButton level2;
    JRadioButton level3;
    JRadioButton level4;
    JRadioButton level5;
    JRadioButton level6;
    JRadioButton red;
    JRadioButton Green;
    JRadioButton Cyan;
    JRadioButton Blue;
    JRadioButton Magenta;

    public SMenuLevel(int width, int height) {
        super(width, height);
        buildMenu();
        addActionListeners();
    }

    private void buildMenu() {
        vbox = Box.createVerticalBox();
        SGameController.addNewLine(vbox, 50);
        vbox.add(new JLabel("Choose your level :"));
        level1 = new JRadioButton("1");
        level2 = new JRadioButton("2");
        level3 = new JRadioButton("3");
        level4 = new JRadioButton("4");
        level5 = new JRadioButton("5");
        level6 = new JRadioButton("6");
        red = new JRadioButton("red");
        Green = new JRadioButton("Green");
        Cyan = new JRadioButton("Cyan");
        Blue = new JRadioButton("Blue");
        Magenta = new JRadioButton("Magenta");

        ButtonGroup levels = new ButtonGroup();
        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        levels.add(level5);
        levels.add(level6);
        SGameController.addNewLine(vbox, 10);
        vbox.add(level1);
        vbox.add(level2);
        vbox.add(level3);
        vbox.add(level4);
        vbox.add(level5);
        vbox.add(level6);
        SGameController.addNewLine(vbox, 15);
        leaveButton = new JButton("Back to Main");
        vbox.add(leaveButton);

    }

    public void addActionListeners() {
        leaveButton.addActionListener(actionEvent -> {
            getGame().changeState(new SMenuMain(width, height));
        });
        level1.addActionListener(actionEvent -> {
            getGame().setLevel(1);
        });
        level2.addActionListener(actionEvent -> {
            getGame().setLevel(2);
        });
        level3.addActionListener(actionEvent -> {
            getGame().setLevel(3);
        });
        level4.addActionListener(actionEvent -> {
            getGame().setLevel(4);
        });
        level5.addActionListener(actionEvent -> {
            getGame().setLevel(5);
        });
        level6.addActionListener(actionEvent -> {
            getGame().setLevel(6);
        });
    }

    public void update() {
    }

    @Override
    public void draw() {
        SGameController.makeVisible(vbox, height, width);
    }
}

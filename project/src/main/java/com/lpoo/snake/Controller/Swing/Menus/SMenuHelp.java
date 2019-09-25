package com.lpoo.snake.Controller.Swing.Menus;

import com.lpoo.snake.Controller.Swing.SState;
import com.lpoo.snake.Controller.Swing.SGameController;
import javax.swing.*;
import static com.lpoo.snake.Controller.Swing.SGameController.getGame;

public class SMenuHelp extends SState {
    JButton leaveButton;
    Box vbox;

    public SMenuHelp(int width, int height) {
        super(width, height);
        buildMenu();
        addActionListeners();
    }

    private void buildMenu() {
        vbox = Box.createVerticalBox();
        SGameController.addNewLine(vbox, 50);
        vbox.add(new JLabel("Keys:"));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel("Arrow Up"));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel("Arrow Down"));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel("Arrow Left"));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel("Arrow Right"));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel("In multiplayer, second player Keys are :"));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel("W"));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel("S"));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel("A"));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel("D"));
        leaveButton = new JButton("Leave");
        SGameController.addNewLine(vbox, 15);
        vbox.add(leaveButton);
    }

    public void addActionListeners() {
        leaveButton.addActionListener(actionEvent -> {
            getGame().changeState(new SMenuMain(width, height));
        });
    }

    public void update() {
    }

    @Override
    public void draw() {
        SGameController.makeVisible(vbox, height, width);
    }
}

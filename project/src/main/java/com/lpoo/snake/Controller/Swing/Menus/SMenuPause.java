package com.lpoo.snake.Controller.Swing.Menus;

import com.lpoo.snake.Controller.Swing.SState;
import com.lpoo.snake.Controller.Swing.SGameController;
import javax.swing.*;
import static com.lpoo.snake.Controller.Swing.SGameController.getGame;

public class SMenuPause extends SState {
    private JButton leaveButton, backButton;
    private SState level;
    private Box box;

    public SMenuPause(int width, int height, SState level) {
        super(width, height);
        this.level = level;
        buildMenu();
        addActionListeners();
    }

    private void buildMenu() {
        box = Box.createVerticalBox();
        SGameController.addNewLine(box, 50);
        leaveButton = new JButton("Leave this game");
        backButton = new JButton("Go back to the game");
        box.add(new JLabel("Pause Menu"));
        SGameController.addNewLine(box, 15);
        box.add(backButton);
        SGameController.addNewLine(box, 5);
        box.add(leaveButton);
    }

    public void addActionListeners() {
        backButton.addActionListener(actionEvent -> {
            SGameController.getGame().changeState(level);
        });
        leaveButton.addActionListener(actionEvent -> {
            getGame().changeState(new SMenuMain(width, height));
        });
    }

    public void update() {
    }

    @Override
    public void draw() {
        SGameController.makeVisible(box, height, width);
    }
}

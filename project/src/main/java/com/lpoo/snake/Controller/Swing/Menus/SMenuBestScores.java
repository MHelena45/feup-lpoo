package com.lpoo.snake.Controller.Swing.Menus;

import com.lpoo.snake.Controller.Swing.SState;
import com.lpoo.snake.Controller.Swing.SGameController;
import javax.swing.*;
import java.io.*;
import static com.lpoo.snake.Controller.Swing.SGameController.getGame;

public class SMenuBestScores extends SState {
    private static File file = new File("highscore.txt");
    private String lines[];
    private JButton leaveButton;
    private Box vbox;

    public SMenuBestScores(int width, int height) {
        super(width, height);
        lines = new String[4];
        leaveButton = new JButton("Leave");
        readScores();
        buildMenu();
        addActionListeners();
    }

    private void buildMenu() {
        vbox = Box.createVerticalBox();
        vbox.add(new JLabel("Hight Scores Menu "));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel("SinglePlayer Best Score"));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel(lines[0]));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel(lines[1]));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel(lines[2]));
        SGameController.addNewLine(vbox, 5);
        vbox.add(new JLabel(lines[3]));
        vbox.add(leaveButton);
    }

    public void addActionListeners() {
        leaveButton.addActionListener(actionEvent -> {
            getGame().changeState(new SMenuMain(width, height));
        });
    }

    public void update() {
    }

    public void readScores() {
        FileReader fileReader;
        BufferedReader reader;
        try {
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);

            reader.readLine(); // ignore first line
            for (int i = 0; i < 4; ++i)
                lines[i] = reader.readLine();

            fileReader.close();
            reader.close();
        } catch (IOException e) {
            System.exit(1);
        }
    }

    public void draw() {
        SGameController.makeVisible(vbox, height, width);
    }
}

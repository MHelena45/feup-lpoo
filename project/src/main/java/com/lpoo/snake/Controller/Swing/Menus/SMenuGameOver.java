package com.lpoo.snake.Controller.Swing.Menus;

import com.lpoo.snake.Controller.Swing.SState;
import com.lpoo.snake.Controller.Swing.SGameController;
import com.lpoo.snake.Controller.Score;
import javax.swing.*;
import java.io.IOException;
import static com.lpoo.snake.Controller.Swing.SGameController.getGame;

public class SMenuGameOver extends SState {
    private JButton playAgain, exitButton;
    private int score;
    private int player;
    private Score bestScores;
    private Box box;

    public SMenuGameOver(int width, int height, int score, int player) {
        super(width, height);
        this.player = player;
        bestScores = new Score();
        this.score = score;
        try {
            bestScores.checkScore(this.player, this.score);
        } catch (IOException e) {
            e.printStackTrace();
        }
        box = Box.createVerticalBox();
        buildMenu();
        addActionListeners();
    }

    private void buildMenu() {
        box.add(new JLabel("Game Over"));
        box.add(new JLabel("Your Score was " + String.valueOf(score)));
        if (this.player > 0) {
            if (this.player == 3)
                box.add(new JLabel("Got tied !"));
            else
                box.add(new JLabel("Player " + String.valueOf(player) + " Win !"));
            box.add(new JLabel("Best Score :  " + bestScores.getMbestScore()));
        } else {
            box.add(new JLabel("Best Score :  " + bestScores.getSbestScore()));
        }
        playAgain = new JButton("Play Again");
        exitButton = new JButton("Exit ");
        SGameController.addNewLine(box, 5);
        box.add(playAgain);
        SGameController.addNewLine(box, 5);
        box.add(exitButton);
    }

    public void update() {
    }

    public void addActionListeners() {
        playAgain.addActionListener(actionEvent -> {
            getGame().changeState(new SMenuMain(width, height));
        });

        exitButton.addActionListener(actionEvent -> {
            System.exit(0);
        });
    }

    @Override
    public void draw() {
        SGameController.makeVisible(box, height, width);
    }
}

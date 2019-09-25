package com.lpoo.snake.Controller.Lanterna.Menus;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.lpoo.snake.Controller.Lanterna.LMenuState;
import com.lpoo.snake.View.Lanterna.LRenderer;

import static com.lpoo.snake.Controller.Lanterna.LGameController.getGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LMenuBestScores extends LMenuState {
    private static File file = new File("highscore.txt");

    LMenuBestScores(int width, int height) throws IOException {
        super(width, height);
        gui = new MultiWindowTextGUI(getGame().getScreen());
        buildMenu();
    }

    public void buildMenu() throws IOException {
        draw(getGame().getScreen().newTextGraphics());
    }

    public void draw(TextGraphics graphics) throws IOException {
        LRenderer.drawBackground(graphics, width, height, "#0001FF");
        graphics.enableModifiers(SGR.BOLD);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        int i = 1;
        String data = null;
        graphics.putString(new TerminalPosition(10, i), "HIGH SCORES");
        while ((data = reader.readLine()) != null) {
            i += 2;
            graphics.putString(new TerminalPosition(5, i), data);
        }
        graphics.putString(new TerminalPosition(12, i + 4), "Press 'q' to leave ");
        fileReader.close();
        reader.close();
    }

}

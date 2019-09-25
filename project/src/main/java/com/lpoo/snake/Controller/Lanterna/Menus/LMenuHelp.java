package com.lpoo.snake.Controller.Lanterna.Menus;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.lpoo.snake.Controller.Lanterna.*;
import com.lpoo.snake.View.Lanterna.LRenderer;

import static com.lpoo.snake.Controller.Lanterna.LGameController.getGame;

import java.io.IOException;

public class LMenuHelp extends LMenuState {

    public LMenuHelp(int width, int height) throws IOException {
        super(width, height);
        buildMenu();
    }

    public void buildMenu() {
        draw(getGame().getScreen().newTextGraphics());
    }

    public void draw(TextGraphics graphics) {
        LRenderer.drawBackground(graphics, width, height, "#0001FF");
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(3, 1), "Keys");
        graphics.putString(new TerminalPosition(5, 3), "Arrow Up");
        graphics.putString(new TerminalPosition(5, 5), "Arrow Down");
        graphics.putString(new TerminalPosition(5, 7), "Arrow Left");
        graphics.putString(new TerminalPosition(5, 9), "Arrow Right");
        graphics.putString(new TerminalPosition(3, 12), "In multiplyer, second player Keys");
        graphics.putString(new TerminalPosition(5, 14), "W");
        graphics.putString(new TerminalPosition(5, 16), "S");
        graphics.putString(new TerminalPosition(5, 18), "A");
        graphics.putString(new TerminalPosition(5, 20), "D");
    }
}

package com.lpoo.snake.Controller.Lanterna.Menus;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.lpoo.snake.Controller.Lanterna.LGameController;
import com.lpoo.snake.Controller.Lanterna.LMenuState;
import com.lpoo.snake.View.Lanterna.LRenderer;

import static com.lpoo.snake.Controller.Lanterna.LGameController.getGame;

import java.io.IOException;

public class LMenuLevel extends LMenuState {

    public LMenuLevel(int width, int height) throws IOException {
        super(width, height);
        buildMenu();
    }

    public void buildMenu() throws IOException {
        draw(getGame().getScreen().newTextGraphics());
    }

    public void draw(TextGraphics graphics) throws IOException {
        LGameController game = getGame();
        LRenderer.drawBackground(graphics, width, height, "#000FFF");
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(6, 3), "Level");
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(6, 6), new TerminalSize(9, 2), ' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(6, 6), new TerminalSize(2 + game.getLevel(), 2), ' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000FFF"));
        graphics.putString(new TerminalPosition(16, 7), String.valueOf(game.getLevel() + 1));
        graphics.putString(new TerminalPosition(6, 12), "Arrow Left - decreases level");
        graphics.putString(new TerminalPosition(6, 14), "Arrow Right - increase level");
        graphics.putString(new TerminalPosition(6, 16), "Press 'q' to leave ");
    }

    @Override
    public void update(KeyStroke key) throws IOException {
        LGameController game = getGame();
        if (key == null)
            return;
        if (key.getKeyType() == KeyType.Character) {
            if (key.getCharacter() == 'q') {
                game.changeState(new LMenuMain(width, height));
            }
        }
        if (key.getKeyType() == KeyType.ArrowLeft) {
            if (game.getLevel() > 0)
                game.subLevel();
        }
        if (key.getKeyType() == KeyType.ArrowRight) {
            if (game.getLevel() < 7)
                game.addLevel();
        }

    }

}

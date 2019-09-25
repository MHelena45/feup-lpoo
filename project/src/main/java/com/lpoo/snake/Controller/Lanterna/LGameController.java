package com.lpoo.snake.Controller.Lanterna;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.lpoo.snake.Controller.GameController;
import com.lpoo.snake.Controller.Timer;
import com.lpoo.snake.Controller.Lanterna.Menus.LMenuMain;

import java.io.IOException;

public class LGameController implements GameController {
    private static LGameController game = null;
    private Terminal terminal;
    private Screen screen;
    private Timer timer;
    private LState state;
    private int level;
    private final int fps = 60;

    private LGameController() {
    }

    public void init(int width, int height) throws IOException, IllegalArgumentException {
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen(); // screens must be started
        screen.doResizeIfNecessary(); // resize screen if necessary
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Size is not valid!");
        state = new LMenuMain(width, height);
        timer = new Timer(1000 / fps);
        level = 1;
    }

    public static LGameController getGame() {
        if (game == null)
            game = new LGameController();
        return game;
    }

    public Screen getScreen() {
        return screen;
    }

    private void draw() throws IOException {
        state.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        while (true) {
            state.update(screen.pollInput());
            if (timer.IsUpdateTime())
                draw();
        }
    }

    public void changeState(LState state) {
        this.state = state;
    }

    public LState getState() {
        return state;
    }

    public int getLevel() {
        return level;
    }

    public void addLevel() {
        this.level++;
    }

    public void subLevel() {
        this.level--;
    }
}

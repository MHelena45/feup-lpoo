package com.lpoo.snake.Controller.Lanterna;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.lpoo.snake.Controller.Lanterna.Menus.LMenuMain;
import static com.lpoo.snake.Controller.Lanterna.LGameController.getGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class LMenuState extends LState {
    protected WindowBasedTextGUI gui;
    protected BasicWindow menu;
    protected Panel panel;

    public LMenuState(int width, int height) {
        super(width, height);
        gui = new MultiWindowTextGUI(getGame().getScreen());
    }

    public Panel build(String menuName) {
        menu = new BasicWindow(menuName);
        List<Window.Hint> hints = new ArrayList<>();
        hints.add(Window.Hint.CENTERED);
        menu.setHints(hints);
        Panel horizontalPanel = new Panel();
        horizontalPanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));
        return horizontalPanel;
    }

    public abstract void buildMenu() throws IOException;

    public void update(KeyStroke key) throws IOException {
        if (key == null)
            return;
        if (key.getKeyType() == KeyType.Character) {
            if (key.getCharacter() == 'q') {
                getGame().changeState(new LMenuMain(width, height));
            }
        }
    }

    public void draw(TextGraphics graphics) throws IOException {
        gui.addWindow(menu);
        menu.waitUntilClosed();
    }
}

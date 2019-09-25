package com.lpoo.snake;

import org.junit.Test;
import com.lpoo.snake.Controller.Timer;
import static org.junit.Assert.assertEquals;

public class TimerTest {
    @Test
    public void IsUpdateTime() {
        Timer timer = new Timer(1);
        assertEquals(false, timer.IsUpdateTime());
        timer.resetTimer();
        assertEquals(false, timer.IsUpdateTime());
    }
}

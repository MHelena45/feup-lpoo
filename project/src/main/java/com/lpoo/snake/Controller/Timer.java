package com.lpoo.snake.Controller;

public class Timer {
    private long previousTime;
    private long updateFrequency;

    public Timer(long msUpdateFrequency) {
        this.updateFrequency = msUpdateFrequency;
        previousTime = System.currentTimeMillis();
    }

    public boolean IsUpdateTime() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - previousTime > updateFrequency) {
            previousTime = currentTime;
            return true;
        }
        return false;
    }

    public void resetTimer() {
        previousTime = System.currentTimeMillis();
    }
}

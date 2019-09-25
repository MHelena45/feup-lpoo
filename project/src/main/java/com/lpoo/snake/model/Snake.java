package com.lpoo.snake.Model;

import java.util.LinkedList;

public class Snake extends Element {
    private LinkedList<Position> tail; // every thing that is snake and isn't head is tail
    private Position direction;
    private int score;

    public Snake(Position startingPosition, int initialSize, Position direction) throws IllegalArgumentException {
        // Initial position of the head
        super(startingPosition);
        // Check direction for correct values
        if (Math.abs(direction.getX()) + Math.abs(direction.getY()) > 1)
            throw new IllegalArgumentException("Direction values must be between 1 and -1");
        // Initiate direction and the snake's tail
        this.direction = direction;
        tail = new LinkedList<>();
        for (int i = 1; i < initialSize; ++i) {
            int tailX = direction.getX() * i * -1;
            int tailY = direction.getY() * i * -1;
            tail.add(new Position(head().getX() + tailX, head().getY() + tailY));
        }
        this.score = 0;
    }

    public int size() {
        return tail.size() + 1;
    }

    public Position head() {
        return this.getPosition();
    }

    public LinkedList<Position> tail() {
        return tail;
    }

    public Position getDirection() {
        return direction;
    }

    /*
     * Updates snake by moving the first piece of the tail to the location of the
     * head. The head is moved in the correct direction and the last piece of the
     * tail is removed
     */
    public void update() {
        tail.addFirst(new Position(head()));
        tail.removeLast();
        head().positionSum(direction);
    }

    /*
     * Simply adds another piece to the tail, so that at next update this piece is
     * removed instead of the end piece, causing the snake to grow
     */
    public void grow(int value) {
        tail.addLast(new Position(tail.getLast()));
        score += value;
    }

    /*
     * Checks if the head overlaps with any tail piece, meaning the snake has eaten
     * itself Returns true if an overlap has been found, false otherwise
     */
    public boolean hasEatenSelf() {
        for (Position tailPiece : tail) {
            if (head().equals(tailPiece))
                return true;
        }
        return false;
    }

    /* Checks if snake is out of given bounds */
    public boolean outOfBounds(int width, int height, int gameSize) {
        if (head().getX() < gameSize || head().getY() < gameSize)
            return true;
        if (head().getX() >= width - gameSize || head().getY() >= height - gameSize) {
            return true;
        }
        return false;
    }

    public int getScore() {
        return score;
    }

}

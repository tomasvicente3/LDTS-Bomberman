package pt.up.fe.bomberman.model;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Position getUp() {
        return new Position(x, y - 1);
    }

    public Position getDown() {
        return new Position(x, y + 1);
    }

    public Position getLeft() {
        return new Position(x - 1, y);
    }

    public Position getRight() {
        return new Position(x + 1, y);
    }

    public Position getDirectionalNeighbour(char direction) {
        switch (direction) {
            case 'U':
                return getUp();
            case 'D':
                return getDown();
            case 'L':
                return getLeft();
            case 'R':
                return getRight();
            default:
                return new Position(x, y);
        }
    }

    public Position getRandomNeighbour() {
        int n = (int) (Math.random() * 5);
        switch (n) {
            case 0:
                return getUp();
            case 1:
                return getDown();
            case 2:
                return getLeft();
            case 3:
                return getRight();
            default:
                return new Position(x, y);
        }
    }

    public Position getRandomDirectionalNeighbour(char direction) {
        if (direction == 'U' || direction == 'D')
            return getRandomVerticalNeighbour();
        else if (direction == 'L' || direction == 'R')
            return getRandomHorizontalNeighbour();
        else
            return new Position(x, y);
    }

    private Position getRandomVerticalNeighbour() {
        int n = (int) (Math.random() * 2);
        if (n == 0)
            return getUp();
        else
            return getDown();
    }

    private Position getRandomHorizontalNeighbour() {
        int n = (int) (Math.random() * 2);
        if (n == 0)
            return getLeft();
        else
            return getRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

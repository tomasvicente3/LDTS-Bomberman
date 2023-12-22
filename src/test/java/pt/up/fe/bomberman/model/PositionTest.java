package pt.up.fe.bomberman.model;

import net.jqwik.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PositionTest {
    @Property
    void getUp(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getUp().getX());
        assertEquals(y - 1, position.getUp().getY());
    }

    @Property
    void getDown(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getDown().getX());
        assertEquals(y + 1, position.getDown().getY());
    }

    @Property
    void getLeft(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x - 1, position.getLeft().getX());
        assertEquals(y, position.getLeft().getY());
    }

    @Property
    void getRight(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x + 1, position.getRight().getX());
        assertEquals(y, position.getRight().getY());
    }

    @Property
    void getDirectionalNeighbourUp(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getDirectionalNeighbour('U').getX());
        assertEquals(y - 1, position.getDirectionalNeighbour('U').getY());
    }

    @Property
    void getDirectionalNeighbourDown(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getDirectionalNeighbour('D').getX());
        assertEquals(y + 1, position.getDirectionalNeighbour('D').getY());
    }

    @Property
    void getDirectionalNeighbourLeft(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x - 1, position.getDirectionalNeighbour('L').getX());
        assertEquals(y, position.getDirectionalNeighbour('L').getY());
    }

    @Property
    void getDirectionalNeighbourRight(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x + 1, position.getDirectionalNeighbour('R').getX());
        assertEquals(y, position.getDirectionalNeighbour('R').getY());
    }

    @Property
    void getDirectionalNeighbourNone(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getDirectionalNeighbour('X').getX());
        assertEquals(y, position.getDirectionalNeighbour('X').getY());
    }

    @Property
    void getRandomDirectionalNeighbourUp(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        Position destination = position.getRandomDirectionalNeighbour('U');
        assertEquals(x, destination.getX());
        assertTrue(y - 1 == destination.getY() || y + 1 == destination.getY());
    }

    @Property
    void getRandomDirectionalNeighbourDown(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        Position destination = position.getRandomDirectionalNeighbour('D');
        assertEquals(x, destination.getX());
        assertTrue(y - 1 == destination.getY() || y + 1 == destination.getY());
    }

    @Property
    void getRandomDirectionalNeighbourLeft(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        Position destination = position.getRandomDirectionalNeighbour('L');
        assertTrue(x - 1 == destination.getX() || x + 1 == destination.getX());
        assertEquals(y, destination.getY());
    }

    @Property
    void getRandomDirectionalNeighbourRight(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        Position destination = position.getRandomDirectionalNeighbour('R');
        assertTrue(x - 1 == destination.getX() || x + 1 == destination.getX());
        assertEquals(y, destination.getY());
    }

    @Property
    void getRandomDirectionalNeighbourNone(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        assertEquals(x, position.getDirectionalNeighbour('X').getX());
        assertEquals(y, position.getDirectionalNeighbour('X').getY());
    }

}

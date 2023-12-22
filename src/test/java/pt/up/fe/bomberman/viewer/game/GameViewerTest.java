package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.*;

import java.io.IOException;
import java.util.Arrays;

public class GameViewerTest {
    private GameViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        Arena arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);

        arena.setBomberman(new Bomberman(1, 1));
        arena.setBombs(Arrays.asList(new Bomb(1, 2, 0, 0), new Bomb(2, 2, 0, 0)));
        arena.setFlames(Arrays.asList(new Flame(1, 3, 0, 'H'), new Flame(2, 3, 0, 'V'), new Flame(3, 3, 0, 'C')));
        arena.setObstacles(Arrays.asList(new Obstacle(1, 4), new Obstacle(2, 4), new Obstacle(3, 4), new Obstacle(4, 4)));
        arena.setWalls(Arrays.asList(new Wall(1, 5), new Wall(2, 5), new Wall(3, 5), new Wall(4, 5), new Wall(5, 5)));
        arena.setEnemies(Arrays.asList(new Enemy(1, 8, Enemy.TYPE.BALLOOM), new Enemy(2, 8, Enemy.TYPE.ONEAL), new Enemy(3, 8, Enemy.TYPE.DOLL), new Enemy(4, 8, Enemy.TYPE.MINVO), new Enemy(5, 8, Enemy.TYPE.KONDORIA), new Enemy(6, 8, Enemy.TYPE.OVAPI), new Enemy(7, 8, Enemy.TYPE.PASS), new Enemy(8, 8, Enemy.TYPE.PONTAM)));
        arena.setPowerups(Arrays.asList(new Powerup(1, 7, Powerup.EFFECT.BOMBS), new Powerup(2, 7, Powerup.EFFECT.FLAMES), new Powerup(3, 7, Powerup.EFFECT.SPEED), new Powerup(4, 7, Powerup.EFFECT.WALLPASS), new Powerup(5, 7, Powerup.EFFECT.HEALTH), new Powerup(6, 7, Powerup.EFFECT.BOMBPASS), new Powerup(7, 7, Powerup.EFFECT.FLAMEPASS)));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

    @Test
    void drawBomberman() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(1, 1), '!', "#64A4FF");
    }

    @Test
    void drawBombs() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(1, 2), 'c', "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(2, 2), 'c', "#000000");
    }

    @Test
    void drawFlames() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(1, 3), 'a', "#FF4500");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(2, 3), 'b', "#FF4500");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(3, 3), 's', "#FF4500");
    }

    @Test
    void drawObstacles() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(1, 4), '?', "#C9C9C9");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(2, 4), '?', "#C9C9C9");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(3, 4), '?', "#C9C9C9");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(4, 4), '?', "#C9C9C9");
    }

    @Test
    void drawWalls() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(1, 5), ';', "#C9C9C9");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(2, 5), ';', "#C9C9C9");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(3, 5), ';', "#C9C9C9");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(4, 5), ';', "#C9C9C9");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(5, 5), ';', "#C9C9C9");
    }

    @Test
    void drawEnemies() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(1, 8), ':', "#FA732C");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(2, 8), 'n', "#0000FF");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(3, 8), 'o', "#FF0000");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(4, 8), 'u', "#FA732C");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(5, 8), 't', "#0000FF");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(6, 8), 'v', "#FF0000");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(7, 8), 'w', "#FA732C");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(8, 8), 'x', "#FF0000");
    }

    @Test
    void drawPowerups() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(1, 7), 'e', "#F7EF8A");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(2, 7), 'd', "#F7EF8A");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(3, 7), 'f', "#F7EF8A");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(4, 7), 'p', "#F7EF8A");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(5, 7), 'g', "#F7EF8A");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(6, 7), 'r', "#F7EF8A");
        Mockito.verify(gui, Mockito.times(1)).drawElement(new Position(7, 7), 'q', "#F7EF8A");
    }
}

package pt.up.fe.bomberman.controller.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.*;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BombControllerTest {
    private BombController controller;
    private Bomb bomb;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        controller = new BombController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void explodeBomb() throws IOException {
        bomb = new Bomb(10, 10, 0, 1);
        arena.addBomb(bomb);
        controller.step(game, GUI.ACTION.NONE, 2000);
        List<Flame> flames = Arrays.asList(new Flame(10, 10, 2000, 'C'), new Flame(10, 9, 2000, 'V'), new Flame(10, 11, 2000, 'V'), new Flame(9, 10, 2000, 'H'), new Flame(11, 10, 2000, 'H'));
        assertEquals(flames.size(), arena.getFlames().size());
        for (int i = 0; i < flames.size(); i++) {
            Flame expected = flames.get(i);
            Flame actual = arena.getFlames().get(i);
            assertEquals(expected.getPosition(), actual.getPosition());
            assertEquals(expected.getTime(), actual.getTime());
            assertEquals(expected.getType(), actual.getType());
        }
    }

    @Test
    void explodeBombBomberman() throws IOException {
        bomb = new Bomb(10, 10, 0, 1);
        arena.addBomb(bomb);
        arena.setBomberman(new Bomberman(9, 10));
        controller.step(game, GUI.ACTION.NONE, 2000);
        List<Flame> flames = Arrays.asList(new Flame(10, 10, 2000, 'C'), new Flame(10, 9, 2000, 'V'), new Flame(10, 11, 2000, 'V'), new Flame(9, 10, 2000, 'H'), new Flame(11, 10, 2000, 'H'));
        assertEquals(flames.size(), arena.getFlames().size());
        for (int i = 0; i < flames.size(); i++) {
            Flame expected = flames.get(i);
            Flame actual = arena.getFlames().get(i);
            assertEquals(expected.getPosition(), actual.getPosition());
            assertEquals(expected.getTime(), actual.getTime());
            assertEquals(expected.getType(), actual.getType());
        }
    }

    @Test
    void explodeBombBombs() throws IOException {
        bomb = new Bomb(10, 10, 0, 2);
        arena.addBomb(bomb);
        arena.addBomb(new Bomb(10, 9, 1000, 1));
        arena.addBomb(new Bomb(10, 11, 1000, 2));
        arena.addBomb(new Bomb(9, 10, 1000, 3));
        arena.addBomb(new Bomb(11, 10, 1000, 4));
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertEquals(1, arena.getFlames().size());
        Flame expected = new Flame(10, 10, 2000, 'C');
        Flame actual = arena.getFlames().get(0);
        assertEquals(expected.getPosition(), actual.getPosition());
        assertEquals(expected.getTime(), actual.getTime());
        assertEquals(expected.getType(), actual.getType());
    }

    @Test
    void explodeBombObstacles() throws IOException {
        bomb = new Bomb(10, 10, 0, 3);
        arena.addBomb(bomb);
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(10, 9), new Obstacle(10, 11), new Obstacle(9, 10), new Obstacle(11, 10));
        arena.setObstacles(obstacles);
        controller.step(game, GUI.ACTION.NONE, 2000);
        List<Flame> flames = Arrays.asList(new Flame(10, 10, 2000, 'C'), new Flame(10, 9, 2000, 'V'), new Flame(10, 11, 2000, 'V'), new Flame(9, 10, 2000, 'H'), new Flame(11, 10, 2000, 'H'));
        assertEquals(flames.size(), arena.getFlames().size());
        for (int i = 0; i < flames.size(); i++) {
            Flame expected = flames.get(i);
            Flame actual = arena.getFlames().get(i);
            assertEquals(expected.getPosition(), actual.getPosition());
            assertEquals(expected.getTime(), actual.getTime());
            assertEquals(expected.getType(), actual.getType());
        }
    }

    @Test
    void explodeBombWalls() throws IOException {
        bomb = new Bomb(10, 10, 0, 4);
        arena.addBomb(bomb);
        List<Wall> walls = Arrays.asList(new Wall(10, 9), new Wall(10, 11), new Wall(9, 10), new Wall(11, 10));
        arena.setWalls(walls);
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertEquals(1, arena.getFlames().size());
        Flame expected = new Flame(10, 10, 2000, 'C');
        Flame actual = arena.getFlames().get(0);
        assertEquals(expected.getPosition(), actual.getPosition());
        assertEquals(expected.getTime(), actual.getTime());
        assertEquals(expected.getType(), actual.getType());
    }

    @Test
    void explodeBombEnemies() throws IOException {
        bomb = new Bomb(10, 10, 0, 1);
        arena.addBomb(bomb);
        List<Enemy> enemies = Arrays.asList(new Enemy(10, 9, Enemy.TYPE.BALLOOM), new Enemy(10, 11, Enemy.TYPE.ONEAL), new Enemy(9, 10, Enemy.TYPE.DOLL), new Enemy(11, 10, Enemy.TYPE.MINVO));
        arena.setEnemies(enemies);
        controller.step(game, GUI.ACTION.NONE, 2000);
        List<Flame> flames = Arrays.asList(new Flame(10, 10, 2000, 'C'), new Flame(10, 9, 2000, 'V'), new Flame(10, 11, 2000, 'V'), new Flame(9, 10, 2000, 'H'), new Flame(11, 10, 2000, 'H'));
        assertEquals(flames.size(), arena.getFlames().size());
        for (int i = 0; i < flames.size(); i++) {
            Flame expected = flames.get(i);
            Flame actual = arena.getFlames().get(i);
            assertEquals(expected.getPosition(), actual.getPosition());
            assertEquals(expected.getTime(), actual.getTime());
            assertEquals(expected.getType(), actual.getType());
        }
    }

    @Test
    void explodeBombPowerups() throws IOException {
        bomb = new Bomb(10, 10, 0, 2);
        arena.addBomb(bomb);
        List<Powerup> powerups = Arrays.asList(new Powerup(10, 9, Powerup.EFFECT.BOMBS), new Powerup(10, 11, Powerup.EFFECT.FLAMES), new Powerup(9, 10, Powerup.EFFECT.SPEED), new Powerup(11, 10, Powerup.EFFECT.WALLPASS));
        arena.setPowerups(powerups);
        controller.step(game, GUI.ACTION.NONE, 2000);
        assertEquals(1, arena.getFlames().size());
        Flame expected = new Flame(10, 10, 2000, 'C');
        Flame actual = arena.getFlames().get(0);
        assertEquals(expected.getPosition(), actual.getPosition());
        assertEquals(expected.getTime(), actual.getTime());
        assertEquals(expected.getType(), actual.getType());
    }
}

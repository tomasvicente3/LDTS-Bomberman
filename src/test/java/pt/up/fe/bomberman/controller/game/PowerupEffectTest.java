package pt.up.fe.bomberman.controller.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerupEffectTest {
    private BombermanController controller;
    private Bomberman bomberman;
    private Powerup powerup;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        bomberman = new Bomberman(4, 5);
        arena.setBomberman(bomberman);
        controller = new BombermanController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void getBombs() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.BOMBS);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertEquals(2, bomberman.getBombs());
    }

    @Test
    void useBombs() {
        assertEquals(0, arena.getBombs().size());
        bomberman.setBombs(2);
        controller.step(game, GUI.ACTION.SPACE, 500);
        assertEquals(1, arena.getBombs().size());
        controller.step(game, GUI.ACTION.RIGHT, 1000);
        controller.step(game, GUI.ACTION.SPACE, 1500);
        assertEquals(2, arena.getBombs().size());
    }

    @Test
    void getFlames() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.FLAMES);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertEquals(2, bomberman.getFlames());
    }

    @Test
    void useFlames() {
        controller.step(game, GUI.ACTION.SPACE, 0);
        assertEquals(1, arena.getBombs().size());
        assertEquals(1, arena.getBombs().get(0).getFlames());
        arena.setBombs(new ArrayList<>());
        bomberman.setFlames(2);
        controller.step(game, GUI.ACTION.SPACE, 1000);
        assertEquals(1, arena.getBombs().size());
        assertEquals(2, arena.getBombs().get(0).getFlames());
    }

    @Test
    void getSpeed() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.SPEED);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertEquals(2, bomberman.getSpeed());
    }

    @Test
    void getWallpass() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.WALLPASS);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertTrue(bomberman.canWallpass());
    }

    @Test
    void useWallpass() {
        arena.setObstacles(List.of(new Obstacle(5, 5)));
        controller.step(game, GUI.ACTION.RIGHT, 500);
        assertEquals(new Position(4, 5), bomberman.getPosition());
        bomberman.setWallpass(true);
        controller.step(game, GUI.ACTION.RIGHT, 1000);
        assertEquals(new Position(5, 5), bomberman.getPosition());
    }

    @Test
    void getHealth() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.HEALTH);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertEquals(2, bomberman.getHp());
    }

    @Test
    void useHealth() {
        arena.setEnemies(List.of(new Enemy(5, 5, Enemy.TYPE.BALLOOM)));
        controller.step(game, GUI.ACTION.RIGHT, 500);
        assertEquals(0, bomberman.getHp());
        controller.step(game, GUI.ACTION.LEFT, 1000);
        bomberman.setHp(2);
        controller.step(game, GUI.ACTION.RIGHT, 1500);
        assertEquals(1, bomberman.getHp());
    }

    @Test
    void getBombpass() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.BOMBPASS);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertTrue(bomberman.canBombpass());
    }

    @Test
    void useBombpass() {
        arena.setBombs(List.of(new Bomb(5, 5, 0, 0)));
        controller.step(game, GUI.ACTION.RIGHT, 500);
        assertEquals(new Position(4, 5), bomberman.getPosition());
        bomberman.setBombpass(true);
        controller.step(game, GUI.ACTION.RIGHT, 1000);
        assertEquals(new Position(5, 5), bomberman.getPosition());
    }

    @Test
    void getFlamepass() {
        powerup = new Powerup(5, 5, Powerup.EFFECT.FLAMEPASS);
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(powerup);
        arena.setPowerups(powerups);
        controller.moveBombermanRight();
        assertTrue(bomberman.canFlamepass());
    }

    @Test
    void useFlamepass() {
        arena.setFlames(List.of(new Flame(5, 5, 100, 'C')));
        controller.step(game, GUI.ACTION.RIGHT, 150);
        controller.step(game, GUI.ACTION.LEFT, 200);
        assertEquals(0, bomberman.getHp());
        bomberman.setHp(1);
        bomberman.setFlamepass(true);
        controller.step(game, GUI.ACTION.RIGHT, 250);
        assertEquals(1, bomberman.getHp());
    }
}

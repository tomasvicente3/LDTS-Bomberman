package pt.up.fe.bomberman.model.game.arena;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.elements.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
    }

    @Test
    void addBomb() {
        arena.addBomb(new Bomb(1, 1, 0, 0));
        assertEquals(1, arena.getBombs().size());
    }

    @Test
    void addFlame() {
        arena.addFlame(new Flame(1, 1, 0, 'C'));
        assertEquals(1, arena.getFlames().size());
    }

    @Test
    void isBombTrue() {
        arena.addBomb(new Bomb(1, 1, 0, 0));
        assertTrue(arena.isBomb(new Position(1, 1)));
    }

    @Test
    void isBombFalse() {
        arena.addBomb(new Bomb(2, 2, 0, 0));
        assertFalse(arena.isBomb(new Position(1, 1)));
    }

    @Test
    void isFlameTrue() {
        arena.addFlame(new Flame(1, 1, 0, 'C'));
        assertTrue(arena.isFlame(new Position(1, 1)));
    }

    @Test
    void isFlameFalse() {
        arena.addFlame(new Flame(2, 2, 0, 'C'));
        assertFalse(arena.isFlame(new Position(1, 1)));
    }

    @Test
    void isObstacleTrue() {
        arena.setObstacles(List.of(new Obstacle(1, 1)));
        assertTrue(arena.isObstacle(new Position(1, 1)));
    }

    @Test
    void isObstacleFalse() {
        arena.setObstacles(List.of(new Obstacle(2, 2)));
        assertFalse(arena.isObstacle(new Position(1, 1)));
    }

    @Test
    void isWallTrue() {
        arena.setWalls(List.of(new Wall(1, 1)));
        assertTrue(arena.isWall(new Position(1, 1)));
    }

    @Test
    void isWallFalse() {
        arena.setWalls(List.of(new Wall(2, 2)));
        assertFalse(arena.isWall(new Position(1, 1)));
    }

    @Test
    void isPowerupTrue() {
        arena.setPowerups(Arrays.asList(new Powerup(1, 7, Powerup.EFFECT.BOMBS), new Powerup(2, 7, Powerup.EFFECT.FLAMES), new Powerup(3, 7, Powerup.EFFECT.SPEED), new Powerup(4, 7, Powerup.EFFECT.WALLPASS), new Powerup(5, 7, Powerup.EFFECT.HEALTH), new Powerup(6, 7, Powerup.EFFECT.BOMBPASS), new Powerup(7, 7, Powerup.EFFECT.FLAMEPASS)));
        assertTrue(arena.isPowerup(new Position(1, 7)));
        assertTrue(arena.isPowerup(new Position(2, 7)));
        assertTrue(arena.isPowerup(new Position(3, 7)));
        assertTrue(arena.isPowerup(new Position(4, 7)));
        assertTrue(arena.isPowerup(new Position(5, 7)));
        assertTrue(arena.isPowerup(new Position(6, 7)));
        assertTrue(arena.isPowerup(new Position(7, 7)));
    }

    @Test
    void isPowerupFalse() {
        arena.setPowerups(Arrays.asList(new Powerup(1, 7, Powerup.EFFECT.BOMBS), new Powerup(2, 7, Powerup.EFFECT.FLAMES), new Powerup(3, 7, Powerup.EFFECT.SPEED), new Powerup(4, 7, Powerup.EFFECT.WALLPASS), new Powerup(5, 7, Powerup.EFFECT.HEALTH), new Powerup(6, 7, Powerup.EFFECT.BOMBPASS), new Powerup(7, 7, Powerup.EFFECT.FLAMEPASS)));
        assertFalse(arena.isPowerup(new Position(1, 8)));
        assertFalse(arena.isPowerup(new Position(2, 8)));
        assertFalse(arena.isPowerup(new Position(3, 8)));
        assertFalse(arena.isPowerup(new Position(4, 8)));
        assertFalse(arena.isPowerup(new Position(5, 8)));
        assertFalse(arena.isPowerup(new Position(6, 8)));
        assertFalse(arena.isPowerup(new Position(7, 8)));
    }

    @Test
    void getPowerup() {
        arena.setPowerups(Arrays.asList(new Powerup(1, 7, Powerup.EFFECT.BOMBS), new Powerup(2, 7, Powerup.EFFECT.FLAMES), new Powerup(3, 7, Powerup.EFFECT.SPEED), new Powerup(4, 7, Powerup.EFFECT.WALLPASS), new Powerup(5, 7, Powerup.EFFECT.HEALTH), new Powerup(6, 7, Powerup.EFFECT.BOMBPASS), new Powerup(7, 7, Powerup.EFFECT.FLAMEPASS)));
        assertEquals(Powerup.EFFECT.BOMBS, arena.getPowerup(new Position(1, 7)).getEffect());
        assertEquals(Powerup.EFFECT.FLAMES, arena.getPowerup(new Position(2, 7)).getEffect());
        assertEquals(Powerup.EFFECT.SPEED, arena.getPowerup(new Position(3, 7)).getEffect());
        assertEquals(Powerup.EFFECT.WALLPASS, arena.getPowerup(new Position(4, 7)).getEffect());
        assertEquals(Powerup.EFFECT.HEALTH, arena.getPowerup(new Position(5, 7)).getEffect());
        assertEquals(Powerup.EFFECT.BOMBPASS, arena.getPowerup(new Position(6, 7)).getEffect());
        assertEquals(Powerup.EFFECT.FLAMEPASS, arena.getPowerup(new Position(7, 7)).getEffect());
    }

    @Test
    void removeObstacle() {
        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Obstacle(1, 1));
        arena.setObstacles(obstacles);
        arena.removeObstacle(new Position(1, 1));
        assertEquals(0, arena.getObstacles().size());
    }

    @Test
    void removeEnemy() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(1, 8, Enemy.TYPE.BALLOOM));
        enemies.add(new Enemy(2, 8, Enemy.TYPE.ONEAL));
        enemies.add(new Enemy(3, 8, Enemy.TYPE.DOLL));
        enemies.add(new Enemy(4, 8, Enemy.TYPE.MINVO));
        enemies.add(new Enemy(5, 8, Enemy.TYPE.KONDORIA));
        enemies.add(new Enemy(6, 8, Enemy.TYPE.OVAPI));
        enemies.add(new Enemy(7, 8, Enemy.TYPE.PASS));
        enemies.add(new Enemy(8, 8, Enemy.TYPE.PONTAM));
        arena.removeEnemy(new Position(1, 8));
        arena.removeEnemy(new Position(2, 8));
        arena.removeEnemy(new Position(3, 8));
        arena.removeEnemy(new Position(4, 8));
        arena.removeEnemy(new Position(5, 8));
        arena.removeEnemy(new Position(6, 8));
        arena.removeEnemy(new Position(7, 8));
        arena.removeEnemy(new Position(8, 8));
        assertEquals(0, arena.getEnemies().size());
    }

    @Test
    void removePowerup() {
        List<Powerup> powerups = new ArrayList<>();
        powerups.add(new Powerup(1, 7, Powerup.EFFECT.BOMBS));
        powerups.add(new Powerup(2, 7, Powerup.EFFECT.FLAMES));
        powerups.add(new Powerup(3, 7, Powerup.EFFECT.SPEED));
        powerups.add(new Powerup(4, 7, Powerup.EFFECT.WALLPASS));
        powerups.add(new Powerup(5, 7, Powerup.EFFECT.HEALTH));
        powerups.add(new Powerup(6, 7, Powerup.EFFECT.BOMBPASS));
        powerups.add(new Powerup(7, 7, Powerup.EFFECT.FLAMEPASS));
        arena.removePowerup(new Position(1, 7));
        arena.removePowerup(new Position(2, 7));
        arena.removePowerup(new Position(3, 7));
        arena.removePowerup(new Position(4, 7));
        arena.removePowerup(new Position(5, 7));
        arena.removePowerup(new Position(6, 7));
        arena.removePowerup(new Position(7, 7));
        assertEquals(0, arena.getPowerups().size());
    }
}

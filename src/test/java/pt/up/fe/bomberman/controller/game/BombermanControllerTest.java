package pt.up.fe.bomberman.controller.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombermanControllerTest {
    private BombermanController controller;
    private Bomberman bomberman;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        bomberman = new Bomberman(10, 10);
        arena.setBomberman(bomberman);
        controller = new BombermanController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void moveBombermanUpEmpty() {
        controller.moveBombermanUp();
        assertEquals(new Position(10, 9), bomberman.getPosition());
    }

    @Test
    void moveBombermanUpBomb() {
        arena.setBombs(List.of(new Bomb(10, 9, 0, 0)));
        controller.moveBombermanUp();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanUpObstacle() {
        arena.setObstacles(List.of(new Obstacle(10, 9)));
        controller.moveBombermanUp();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanUpFlame() {
        arena.setFlames(List.of(new Flame(10, 9, 0, 'C')));
        controller.moveBombermanUp();
        assertEquals(new Position(10, 9), bomberman.getPosition());
        assertEquals(0, bomberman.getHp());
    }

    @Test
    void moveBombermanUpWall() {
        arena.setWalls(List.of(new Wall(10, 9)));
        controller.moveBombermanUp();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanUpEnemy() {
        arena.setEnemies(List.of(new Enemy(10, 9, Enemy.TYPE.BALLOOM)));
        controller.moveBombermanUp();
        assertEquals(new Position(10, 9), bomberman.getPosition());
        assertEquals(0, bomberman.getHp());
    }

    @Test
    void moveBombermanDownEmpty() {
        controller.moveBombermanDown();
        assertEquals(new Position(10, 11), bomberman.getPosition());
    }

    @Test
    void moveBombermanDownBomb() {
        arena.setBombs(List.of(new Bomb(10, 11, 0, 0)));
        controller.moveBombermanDown();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanDownFlame() {
        arena.setFlames(List.of(new Flame(10, 11, 0, 'C')));
        controller.moveBombermanDown();
        assertEquals(new Position(10, 11), bomberman.getPosition());
        assertEquals(0, bomberman.getHp());
    }

    @Test
    void moveBombermanDownObstacle() {
        arena.setObstacles(List.of(new Obstacle(10, 11)));
        controller.moveBombermanDown();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanDownWall() {
        arena.setWalls(List.of(new Wall(10, 11)));
        controller.moveBombermanDown();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanDownEnemy() {
        arena.setEnemies(List.of(new Enemy(10, 11, Enemy.TYPE.ONEAL)));
        controller.moveBombermanDown();
        assertEquals(new Position(10, 11), bomberman.getPosition());
        assertEquals(0, bomberman.getHp());
    }

    @Test
    void moveBombermanLeftEmpty() {
        controller.moveBombermanLeft();
        assertEquals(new Position(9, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanLeftBomb() {
        arena.setBombs(List.of(new Bomb(9, 10, 0, 0)));
        controller.moveBombermanLeft();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanLeftFlame() {
        arena.setFlames(List.of(new Flame(9, 10, 0, 'C')));
        controller.moveBombermanLeft();
        assertEquals(new Position(9, 10), bomberman.getPosition());
        assertEquals(0, bomberman.getHp());
    }

    @Test
    void moveBombermanLeftObstacle() {
        arena.setObstacles(List.of(new Obstacle(9, 10)));
        controller.moveBombermanLeft();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanLeftWall() {
        arena.setWalls(List.of(new Wall(9, 10)));
        controller.moveBombermanLeft();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanLeftEnemy() {
        arena.setEnemies(List.of(new Enemy(9, 10, Enemy.TYPE.MINVO)));
        controller.moveBombermanLeft();
        assertEquals(new Position(9, 10), bomberman.getPosition());
        assertEquals(0, bomberman.getHp());
    }

    @Test
    void moveBombermanRightEmpty() {
        controller.moveBombermanRight();
        assertEquals(new Position(11, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanRightBomb() {
        arena.setBombs(List.of(new Bomb(11, 10, 0, 0)));
        controller.moveBombermanRight();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanRightFlame() {
        arena.setFlames(List.of(new Flame(11, 10, 0, 'C')));
        controller.moveBombermanRight();
        assertEquals(new Position(11, 10), bomberman.getPosition());
        assertEquals(0, bomberman.getHp());
    }

    @Test
    void moveBombermanRightObstacle() {
        arena.setObstacles(List.of(new Obstacle(11, 10)));
        controller.moveBombermanRight();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanRightWall() {
        arena.setWalls(List.of(new Wall(11, 10)));
        controller.moveBombermanRight();
        assertEquals(new Position(10, 10), bomberman.getPosition());
    }

    @Test
    void moveBombermanRightEnemy() {
        arena.setEnemies(List.of(new Enemy(11, 10, Enemy.TYPE.DOLL)));
        controller.moveBombermanRight();
        assertEquals(new Position(11, 10), bomberman.getPosition());
        assertEquals(0, bomberman.getHp());
    }

    @Test
    void canCreateBombEmpty() {
        controller.step(game, GUI.ACTION.SPACE, 0);
        assertEquals(1, arena.getBombs().size());
        controller.step(game, GUI.ACTION.SPACE, 1000);
        assertEquals(1, arena.getBombs().size());
    }

    @Test
    void canCreateBombBomb() {
        arena.setBombs(List.of(new Bomb(10, 10, 0, 1)));
        controller.step(game, GUI.ACTION.SPACE, 1000);
        assertEquals(1, arena.getBombs().size());
    }

    @Test
    void canCreateBombObstacle() {
        arena.setObstacles(List.of(new Obstacle(10, 10)));
        controller.step(game, GUI.ACTION.SPACE, 1000);
        assertEquals(0, arena.getBombs().size());
    }

    @Test
    void canCreateBombWall() {
        arena.setWalls(List.of(new Wall(10, 10)));
        controller.step(game, GUI.ACTION.SPACE, 1000);
        assertEquals(0, arena.getBombs().size());
    }

    @Test
    void canCreateBombEnemy() {
        arena.setEnemies(List.of(new Enemy(10, 10, Enemy.TYPE.BALLOOM)));
        controller.step(game, GUI.ACTION.SPACE, 1000);
        assertEquals(1, arena.getBombs().size());
    }

    @Test
    void canCreateBombPowerup() {
        arena.setPowerups(List.of(new Powerup(10, 10, Powerup.EFFECT.BOMBS)));
        controller.step(game, GUI.ACTION.SPACE, 1000);
        assertEquals(0, arena.getBombs().size());
    }
}

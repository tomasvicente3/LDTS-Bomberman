package pt.up.fe.bomberman.controller.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.game.arena.Arena;
import pt.up.fe.bomberman.model.game.elements.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyControllerTest {
    private EnemyController controller;
    private Arena arena;
    private Game game;
    private Bomberman bomberman;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        controller = new EnemyController(arena);
        game = Mockito.mock(Game.class);
        bomberman = new Bomberman(1, 1);
        arena.setBomberman(bomberman);
    }

    @Test
    void moveEnemyEmpty() throws IOException {
        Enemy enemy = new Enemy(10, 10, Enemy.TYPE.BALLOOM);
        arena.setEnemies(List.of(enemy));
        controller.step(game, GUI.ACTION.NONE, 1000);
        Position position = enemy.getPosition();
        assertTrue(position.equals(new Position(10, 10)) || position.equals(new Position(10, 9)) || position.equals(new Position(10, 11)) || position.equals(new Position(9, 10)) || position.equals(new Position(11, 10)));
    }

    @Test
    void moveEnemyBomberman() throws IOException {
        Enemy enemy = new Enemy(10, 10, Enemy.TYPE.BALLOOM);
        enemy.setDirection('R');
        arena.setEnemies(List.of(enemy));
        arena.setWalls(Arrays.asList(new Wall(9, 10), new Wall(10, 9), new Wall(10, 11)));
        bomberman.setPosition(new Position(11, 10));
        for (int i = 0; i < 1000; i++)
            controller.step(game, GUI.ACTION.NONE, i);
        assertEquals(0, bomberman.getHp());
    }

    @Test
    void moveEnemyBomb() throws IOException {
        Enemy enemy = new Enemy(10, 10, Enemy.TYPE.BALLOOM);
        arena.setEnemies(List.of(enemy));
        arena.setBombs(Arrays.asList(new Bomb(11, 10, 0, 0), new Bomb(9, 10, 0, 0), new Bomb(10, 9, 0, 0), new Bomb(10, 11, 0, 0)));
        for (int i = 0; i < 1000; i++)
            controller.step(game, GUI.ACTION.NONE, i);
        assertEquals(new Position(10, 10), enemy.getPosition());
    }

    @Test
    void moveEnemyObstacle() throws IOException {
        Enemy enemy = new Enemy(10, 10, Enemy.TYPE.BALLOOM);
        arena.setEnemies(List.of(enemy));
        arena.setObstacles(Arrays.asList(new Obstacle(11, 10), new Obstacle(9, 10), new Obstacle(10, 9), new Obstacle(10, 11)));
        for (int i = 0; i < 1000; i++)
            controller.step(game, GUI.ACTION.NONE, i);
        assertEquals(new Position(10, 10), enemy.getPosition());
    }

    @Test
    void moveEnemyWall() throws IOException {
        Enemy enemy = new Enemy(10, 10, Enemy.TYPE.BALLOOM);
        arena.setEnemies(List.of(enemy));
        arena.setWalls(Arrays.asList(new Wall(11, 10), new Wall(9, 10), new Wall(10, 9), new Wall(10, 11)));
        for (int i = 0; i < 1000; i++)
            controller.step(game, GUI.ACTION.NONE, i);
        assertEquals(new Position(10, 10), enemy.getPosition());
    }

    @Test
    void moveEnemyEnemy() throws IOException {
        Enemy enemy = new Enemy(10, 10, Enemy.TYPE.BALLOOM);
        Enemy enemy1 = new Enemy(11, 10, Enemy.TYPE.ONEAL);
        Enemy enemy2 = new Enemy(9, 10, Enemy.TYPE.DOLL);
        Enemy enemy3 = new Enemy(10, 9, Enemy.TYPE.MINVO);
        Enemy enemy4 = new Enemy(10, 11, Enemy.TYPE.PASS);
        arena.setEnemies(Arrays.asList(enemy, enemy1, enemy2, enemy3, enemy4));
        arena.setWalls(Arrays.asList(new Wall(9, 9), new Wall(11, 11), new Wall(9, 11), new Wall(11, 9), new Wall(10, 8), new Wall(10, 12), new Wall(8, 10), new Wall(12, 10)));
        for (int i = 0; i < 1000; i++)
            controller.step(game, GUI.ACTION.NONE, i);
        assertEquals(new Position(10, 10), enemy.getPosition());
        assertEquals(new Position(11, 10), enemy1.getPosition());
        assertEquals(new Position(9, 10), enemy2.getPosition());
        assertEquals(new Position(10, 9), enemy3.getPosition());
        assertEquals(new Position(10, 11), enemy4.getPosition());
    }
}

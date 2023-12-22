package pt.up.fe.bomberman.controller.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.Arena;

import pt.up.fe.bomberman.model.game.elements.Bomberman;
import pt.up.fe.bomberman.model.game.elements.Enemy;
import pt.up.fe.bomberman.model.game.elements.Flame;
import pt.up.fe.bomberman.model.game.elements.Obstacle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlameControllerTest {
    private FlameController controller;
    private Bomberman bomberman;
    private List<Flame> flames;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        bomberman = new Bomberman(10, 10);
        arena.setBomberman(bomberman);
        controller = new FlameController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void decreaseBombermanHp() throws IOException {
        flames = List.of(new Flame(10, 10, 0, 'C'));
        arena.setFlames(flames);
        controller.step(game, GUI.ACTION.NONE, 0);
        assertEquals(0, bomberman.getHp());
    }

    @Test
    void removeObstacle() throws IOException {
        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Obstacle(5, 5));
        arena.setObstacles(obstacles);
        assertEquals(1, arena.getObstacles().size());
        flames = List.of(new Flame(5, 5, 0, 'C'));
        arena.setFlames(flames);
        controller.step(game, GUI.ACTION.NONE, 0);
        assertEquals(0, arena.getObstacles().size());
    }

    @Test
    void removeEnemy() throws IOException {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(5, 5, Enemy.TYPE.BALLOOM));
        arena.setEnemies(enemies);
        assertEquals(1, arena.getEnemies().size());
        flames = List.of(new Flame(5, 5, 0, 'C'));
        arena.setFlames(flames);
        controller.step(game, GUI.ACTION.NONE, 0);
        assertEquals(0, arena.getEnemies().size());
    }
}

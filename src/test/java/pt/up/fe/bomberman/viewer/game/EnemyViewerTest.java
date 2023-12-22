package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Enemy;

public class EnemyViewerTest {
    private Enemy enemy;
    private EnemyViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        viewer = new EnemyViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElementBalloom() {
        enemy = new Enemy(10, 10, Enemy.TYPE.BALLOOM);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), ':', "#FA732C");
    }

    @Test
    void drawElementOneal() {
        enemy = new Enemy(10, 10, Enemy.TYPE.ONEAL);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 'n', "#0000FF");
    }

    @Test
    void drawElementDoll() {
        enemy = new Enemy(10, 10, Enemy.TYPE.DOLL);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 'o', "#FF0000");
    }

    @Test
    void drawElementMinvo() {
        enemy = new Enemy(10, 10, Enemy.TYPE.MINVO);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 'u', "#FA732C");
    }

    @Test
    void drawElementKondoria() {
        enemy = new Enemy(10, 10, Enemy.TYPE.KONDORIA);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 't', "#0000FF");
    }

    @Test
    void drawElementOvapi() {
        enemy = new Enemy(10, 10, Enemy.TYPE.OVAPI);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 'v', "#FF0000");
    }

    @Test
    void drawElementPass() {
        enemy = new Enemy(10, 10, Enemy.TYPE.PASS);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 'w', "#FA732C");
    }

    @Test
    void drawElementPontan() {
        enemy = new Enemy(10, 10, Enemy.TYPE.PONTAM);
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(enemy.getPosition(), 'x', "#FF0000");
    }

}

package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Bomberman;

public class BombermanViewerTest {
    private Bomberman bomberman;
    private BombermanViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        bomberman = new Bomberman(10, 10);
        viewer = new BombermanViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElementUp() {
        bomberman.setDirection('U');
        viewer.draw(bomberman, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(bomberman.getPosition(), '"', "#64A4FF");
    }

    @Test
    void drawElementDown() {
        bomberman.setDirection('D');
        viewer.draw(bomberman, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(bomberman.getPosition(), '!', "#64A4FF");
    }

    @Test
    void drawElementLeft() {
        bomberman.setDirection('L');
        viewer.draw(bomberman, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(bomberman.getPosition(), ',', "#64A4FF");
    }

    @Test
    void drawElementRight() {
        bomberman.setDirection('R');
        viewer.draw(bomberman, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(bomberman.getPosition(), '.', "#64A4FF");
    }

}

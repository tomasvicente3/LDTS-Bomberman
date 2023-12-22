package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Flame;

public class FlameViewerTest {
    private Flame flame;
    private FlameViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        viewer = new FlameViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElementHorizontal() {
        flame = new Flame(10, 10, 0, 'H');
        viewer.draw(flame, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(flame.getPosition(), 'a', "#FF4500");
    }

    @Test
    void drawElementVertical() {
        flame = new Flame(10, 10,0,'V');
        viewer.draw(flame, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(flame.getPosition(), 'b', "#FF4500");
    }

    @Test
    void drawElementCentral() {
        flame = new Flame(10, 10, 0, 'C');
        viewer.draw(flame, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(flame.getPosition(), 's', "#FF4500");
    }

}

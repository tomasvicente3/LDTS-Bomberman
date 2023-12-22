package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Obstacle;

public class ObstacleViewerTest {
    private Obstacle obstacle;
    private ObstacleViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        obstacle = new Obstacle(10, 10);
        viewer = new ObstacleViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(obstacle, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(obstacle.getPosition(), '?', "#C9C9C9");
    }

}

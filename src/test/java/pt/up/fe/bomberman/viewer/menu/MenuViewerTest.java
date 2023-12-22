package pt.up.fe.bomberman.viewer.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.menu.Menu;

import java.io.IOException;

public class MenuViewerTest {
    private MenuViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp(){
        Menu menu = new Menu();
        gui = Mockito.mock(GUI.class);
        viewer = new MenuViewer(menu);
    }

    @Test
    void drawText() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 5), "MENU", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 7), "START", "#FFD700");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 8), "EASY", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 9),"EXIT", "#FFFFFF");
    }
}

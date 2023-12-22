package pt.up.fe.bomberman.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.menu.Menu;

import java.io.IOException;

public class MenuControllerTest {
    private MenuController controller;
    private Menu menu;

    private Game game;

    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        menu = Mockito.mock(Menu.class);
        controller = new MenuController(menu);
    }

    @Test
    void stepUp() throws IOException {
        controller.step(game, GUI.ACTION.UP, 0);
        Mockito.verify(menu, Mockito.times(1)).previousOption();
    }

    @Test
    void stepDown() throws IOException {
        controller.step(game, GUI.ACTION.DOWN, 0);
        Mockito.verify(menu, Mockito.times(1)).nextOption();
    }

    @Test
    void stepRightUnselectedLevel() throws IOException {
        controller.step(game, GUI.ACTION.RIGHT, 0);
        Mockito.verify(menu, Mockito.times(0)).nextLevel();
    }

    @Test
    void stepLeftUnselectedLevel() throws IOException {
        controller.step(game, GUI.ACTION.LEFT, 0);
        Mockito.verify(menu, Mockito.times(0)).nextLevel();
    }
}

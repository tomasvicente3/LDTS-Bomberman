package pt.up.fe.bomberman.controller.menu;

import pt.up.fe.bomberman.Game;
import pt.up.fe.bomberman.controller.Controller;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.arena.LoaderArenaBuilder;
import pt.up.fe.bomberman.model.menu.Menu;
import pt.up.fe.bomberman.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousOption();
                break;
            case DOWN:
                getModel().nextOption();
                break;
            case LEFT:
                if (getModel().isSelectedLevel())
                    getModel().previousLevel();
                break;
            case RIGHT:
                if (getModel().isSelectedLevel())
                    getModel().nextLevel();
                break;
            case ENTER:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder(getModel().getCurrentLevel()).createArena()));
        }
    }
}

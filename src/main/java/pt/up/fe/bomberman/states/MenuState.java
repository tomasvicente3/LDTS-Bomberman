package pt.up.fe.bomberman.states;

import pt.up.fe.bomberman.controller.Controller;
import pt.up.fe.bomberman.controller.menu.MenuController;
import pt.up.fe.bomberman.model.menu.Menu;
import pt.up.fe.bomberman.viewer.Viewer;
import pt.up.fe.bomberman.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }
    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}

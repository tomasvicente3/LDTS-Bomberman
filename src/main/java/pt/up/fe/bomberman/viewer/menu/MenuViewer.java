package pt.up.fe.bomberman.viewer.menu;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.Position;
import pt.up.fe.bomberman.model.menu.Menu;
import pt.up.fe.bomberman.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "MENU", "#FFFFFF");
        for (int i = 0; i < getModel().getNumberOptions(); i++)
            gui.drawText(new Position(5, 7 + i), getModel().getOption(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}

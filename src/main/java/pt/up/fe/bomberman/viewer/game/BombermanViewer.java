package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Bomberman;

public class BombermanViewer implements ElementViewer<Bomberman> {
    @Override
    public void draw(Bomberman bomberman, GUI gui) {
        switch (bomberman.getDirection()) {
            case 'U':
                gui.drawElement(bomberman.getPosition(), '"', "#64A4FF");
                break;
            case 'D':
                gui.drawElement(bomberman.getPosition(), '!', "#64A4FF");
                break;
            case 'L':
                gui.drawElement(bomberman.getPosition(), ',', "#64A4FF");
                break;
            case 'R':
                gui.drawElement(bomberman.getPosition(), '.', "#64A4FF");
                break;
        }
    }

}

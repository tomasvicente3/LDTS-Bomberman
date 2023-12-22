package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Flame;

public class FlameViewer implements ElementViewer<Flame> {
    @Override
    public void draw(Flame flame, GUI gui) {
        if (flame.getType() == 'H')
            gui.drawElement(flame.getPosition(),'a', "#FF4500");
        else if (flame.getType() == 'V')
            gui.drawElement(flame.getPosition(),'b', "#FF4500");
        else if (flame.getType() == 'C')
            gui.drawElement(flame.getPosition(),'s', "#FF4500");
    }

}

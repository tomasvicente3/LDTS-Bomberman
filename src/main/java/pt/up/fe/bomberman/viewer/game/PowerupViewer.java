package pt.up.fe.bomberman.viewer.game;

import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Powerup;

public class PowerupViewer implements ElementViewer<Powerup> {
    @Override
    public void draw(Powerup powerup, GUI gui) {
        if (powerup.getEffect() == Powerup.EFFECT.BOMBS) gui.drawElement(powerup.getPosition(),'e', "#F7EF8A");
        else if (powerup.getEffect() == Powerup.EFFECT.FLAMES) gui.drawElement(powerup.getPosition(),'d', "#F7EF8A");
        else if (powerup.getEffect() == Powerup.EFFECT.SPEED) gui.drawElement(powerup.getPosition(),'f', "#F7EF8A");
        else if (powerup.getEffect() == Powerup.EFFECT.WALLPASS) gui.drawElement(powerup.getPosition(),'p', "#F7EF8A");
        else if (powerup.getEffect() == Powerup.EFFECT.HEALTH) gui.drawElement(powerup.getPosition(),'g', "#F7EF8A");
        else if (powerup.getEffect() == Powerup.EFFECT.BOMBPASS) gui.drawElement(powerup.getPosition(),'r', "#F7EF8A");
        else if (powerup.getEffect() == Powerup.EFFECT.FLAMEPASS) gui.drawElement(powerup.getPosition(),'q', "#F7EF8A");
    }

}

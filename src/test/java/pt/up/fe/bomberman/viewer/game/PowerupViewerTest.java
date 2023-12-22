package pt.up.fe.bomberman.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.bomberman.gui.GUI;
import pt.up.fe.bomberman.model.game.elements.Powerup;

public class PowerupViewerTest {
    private Powerup powerup;
    private PowerupViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        viewer = new PowerupViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElementBombs() {
        powerup = new Powerup(10,10, Powerup.EFFECT.BOMBS);
        viewer.draw(powerup, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(powerup.getPosition(), 'e', "#F7EF8A");
    }

    @Test
    void drawElementFlames() {
        powerup = new Powerup(10,10, Powerup.EFFECT.FLAMES);
        viewer.draw(powerup, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(powerup.getPosition(), 'd', "#F7EF8A");
    }

    @Test
    void drawElementSpeed() {
        powerup = new Powerup(10,10, Powerup.EFFECT.SPEED);
        viewer.draw(powerup, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(powerup.getPosition(), 'f', "#F7EF8A");
    }

    @Test
    void drawElementWallpass() {
        powerup = new Powerup(10,10, Powerup.EFFECT.WALLPASS);
        viewer.draw(powerup, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(powerup.getPosition(), 'p', "#F7EF8A");
    }

    @Test
    void drawElementHealth() {
        powerup = new Powerup(10,10, Powerup.EFFECT.HEALTH);
        viewer.draw(powerup, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(powerup.getPosition(), 'g', "#F7EF8A");
    }

    @Test
    void drawElementBombpass() {
        powerup = new Powerup(10,10, Powerup.EFFECT.BOMBPASS);
        viewer.draw(powerup, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(powerup.getPosition(), 'r', "#F7EF8A");
    }

    @Test
    void drawElementFlamepass() {
        powerup = new Powerup(10,10, Powerup.EFFECT.FLAMEPASS);
        viewer.draw(powerup, gui);
        Mockito.verify(gui, Mockito.times(1)).drawElement(powerup.getPosition(), 'q', "#F7EF8A");
    }
}

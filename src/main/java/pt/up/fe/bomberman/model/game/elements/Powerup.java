package pt.up.fe.bomberman.model.game.elements;

public class Powerup extends Element {
    public enum EFFECT {BOMBS, FLAMES, SPEED, WALLPASS, HEALTH, BOMBPASS, FLAMEPASS}
    private final EFFECT effect;

    public Powerup(int x, int y, EFFECT effect) {
        super(x, y);
        this.effect = effect;
    }

    public EFFECT getEffect() {
        return effect;
    }
}

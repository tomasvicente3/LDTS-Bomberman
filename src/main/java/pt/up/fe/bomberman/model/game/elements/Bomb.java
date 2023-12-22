package pt.up.fe.bomberman.model.game.elements;

public class Bomb extends Element {
    private final long time;
    private final int flames;

    public Bomb(int x, int y, long time, int flames) {
        super(x, y);
        this.time = time;
        this.flames = flames;
    }

    public long getTime() {
        return time;
    }
    public int getFlames() {
        return flames;
    }
}
